package org.example.DAO;

import org.example.Connection.ConnectionFactory;
import org.example.Model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**

 This class represents the data access object (DAO) for handling Bill operations.
 */
public class BillDAO extends AbstractDAO<Bill>{

    /**
     * Retrieves a list of Bill objects from the database.
     *
     * @return A list of Bill objects.
     */
    public List<Bill> find() {
        List<Bill> bills = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append("FROM schooldb.");
        sb.append("bill");
        String query = sb.toString();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                Float price = resultSet.getFloat(2);
                String clientName = resultSet.getString(3);
                String productName = resultSet.getString(4);
                Bill bill = new Bill(id, price, clientName, productName);
                bills.add(bill);
            }
            return bills;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "bill" + "DAO:find " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}
