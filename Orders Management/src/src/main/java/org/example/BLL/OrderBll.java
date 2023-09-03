package org.example.BLL;

import org.example.DAO.OrderDAO;
import org.example.DAO.ProductDAO;
import org.example.Model.Order;
import org.example.Model.Product;
import org.example.View.OrderView;
import org.example.validators.OrderClientValidator;
import org.example.validators.Validator;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Business logic layer for handling order operations.
 */
public class OrderBll {
    private List<Validator<Order>> validators;
    private OrderDAO orderDAO;
    private ProductDAO productDAO;
    public OrderView orderView = new OrderView();

    /**
     * Constructs a new OrderBLL object.
     */
    public OrderBll() {
        validators = new ArrayList<>();
        validators.add(new OrderClientValidator());
        orderDAO = new OrderDAO();
        productDAO = new ProductDAO();
    }

    /**
     * Inserts a new order.
     *
     * @param order The order to insert.
     * @throws IllegalArgumentException If the order is not valid according to the defined validators.
     */
    public void insertOrder(Order order) throws IllegalAccessException {
        Product product = new ProductDAO().findById(order.getIdProduct(),"idProduct");
        for(Validator<Order> validator : validators ) {
            validator.validate(order);
        }
        if(product.getQuantity() < order.getQuantity())
        {
            orderView.showInfoMessage("Bad quantity");
        }
        else
        {
            product.setQuantity(product.getQuantity()-order.getQuantity());
            orderDAO.insert(order);
            productDAO.update(product, order.getIdProduct(), "idProduct");
        }

    }

    /**
     * Retrieves all orders.
     *
     * @return A list of all orders.
     */
    public List<Order> findAllOrder() {
        return orderDAO.findAll();
    }

    /**
     * Creates a JTable representation of orders.
     *
     * @param orders The list of orders.
     * @return The JTable object representing the orders.
     */
    public JTable orderTable(ArrayList<Order> orders) {
        return orderDAO.jTable(orders);
    }
}
