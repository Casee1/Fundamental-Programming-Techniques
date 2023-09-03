package org.example.DAO;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.example.Connection.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Abstract Data Access Object class providing common database operations.
 *
 * @param <T> The type of the entity to be accessed.
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Creates the SELECT query to retrieve a record by a specific field.
     *
     * @param field The field to filter the query by.
     * @return The generated SELECT query.
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE ").append(field).append(" = ?");
        return sb.toString();
    }

    /**
     * Creates the DELETE query to delete a record by a specific field.
     *
     * @param field The field to filter the query by.
     * @return The generated DELETE query.
     */
    private String createDeleteQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE ").append(field).append(" = ?");
        return sb.toString();
    }

    /**
     * Creates the UPDATE query to update a record by a specific ID and column.
     *
     * @param t    The entity containing the updated values.
     * @param id   The ID of the record to update.
     * @param coll The column to filter the query by.
     * @return The generated UPDATE query.
     * @throws IllegalAccessException If accessing the entity's fields is not allowed.
     */
    private String createUpdateQuery(T t, int id, String coll) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE schooldb.");
        sb.append(type.getSimpleName().toLowerCase());
        sb.append(" SET ");
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(t) instanceof Integer) {
                sb.append(field.getName()).append(" = ").append(field.get(t));
                sb.append(",");
            } else if (field.get(t) instanceof String) {
                sb.append(field.getName()).append(" = '").append(field.get(t)).append("'");
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" WHERE ").append(coll).append(" = ?");
        return sb.toString();
    }

    /**
     * Creates the INSERT query to insert a new record.
     *
     * @param t The entity containing the values to insert.
     * @return The generated INSERT query.
     * @throws IllegalAccessException If accessing the entity's fields is not allowed.
     */
    private String createInsertQuery(T t) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO schooldb.");
        sb.append(type.getSimpleName().toLowerCase());
        sb.append(" (");

        List<Object> values = new ArrayList<>();

        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            sb.append(field.getName());
            sb.append(",");
            values.add(field.get(t));
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append(") VALUES (");

        for (int i = 0; i < values.size(); i++) {
            sb.append("?");
            sb.append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append(");");

        return sb.toString();
    }

    /**
     * Creates the SELECT query to retrieve all records.
     *
     * @return The generated SELECT query.
     */
    private String createSelectAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM schooldb.");
        sb.append(type.getSimpleName().toLowerCase());
        return sb.toString();
    }

    /**
     * Retrieves all records of the entity type.
     *
     * @return A list of all records.
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Deletes a record from the database based on the specified field and ID.
     *
     * @param field    The field name to filter the delete operation.
     * @param idclient The ID value to filter the delete operation.
     */
    public void delete(String field, int idclient){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery(field);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,idclient);
            statement.executeUpdate();

        }catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        }finally {;
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Retrieves an entity by its ID.
     *
     * @param idclient The ID of the entity to retrieve.
     * @return The retrieved entity, or null if not found.
     */

    public T findById(int idclient, String field ) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(field);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, idclient);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
    /**
     * Creates a list of entities from a ResultSet.
     *
     * @param resultSet The ResultSet containing the data.
     * @return A list of entities created from the ResultSet.
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException |
                 InvocationTargetException | SQLException | IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Inserts a new entity into the database.
     *
     * @param t The entity to insert.
     * @return The inserted entity.
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            String query = createInsertQuery(t);
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            int parameterIndex = 1;
            for (Field field : t.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object fieldValue = field.get(t);
                statement.setObject(parameterIndex, fieldValue);
                parameterIndex++;
            }

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Object generatedId = generatedKeys.getObject(1);
                Field idField = t.getClass().getDeclaredField("id"); // Assuming 'id' is the name of the ID field
                idField.setAccessible(true);
                idField.set(t, generatedId);
            }

        } catch (SQLException | IllegalAccessException | NoSuchFieldException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return t;
    }

    /**
     * Updates an existing entity in the database.
     *
     * @param t    The entity with the updated values.
     * @param id   The ID of the entity to update.
     * @param coll The column to filter the update by.
     * @return The updated entity.
     * @throws IllegalAccessException If accessing the entity's fields is not allowed.
     */
    public T update(T t,int id,String coll) throws IllegalAccessException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            String query = createUpdateQuery(t,id,coll);
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(connection);
            ConnectionFactory.close(statement);
        }
        return t;
    }
    /**
     * Creates a JTable from a list of entities.
     *
     * @param data The list of entities to display in the JTable.
     * @return A JTable populated with the data from the entities.
     */

    public JTable jTable (ArrayList<T> data){
        Field[] fields = data.get(0).getClass().getDeclaredFields();
        ArrayList<String> columnsName = new ArrayList<>();
        for (Field field : fields){
            field.setAccessible(true);
            columnsName.add(field.getName());
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(columnsName.toArray());
        for (T t : data){
            ArrayList<Object> objects = new ArrayList<>();
            Field[] objFields = t.getClass().getDeclaredFields();
            for (Field field : objFields){
                field.setAccessible(true);
                try {
                    objects.add(field.get(t));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            defaultTableModel.addRow(objects.toArray());
        }
        return new JTable(defaultTableModel);
    }
}


