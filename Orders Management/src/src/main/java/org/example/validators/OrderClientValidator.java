package org.example.validators;

import org.example.DAO.AbstractDAO;
import org.example.Model.Order;

import java.util.NoSuchElementException;

/**
 * Validator for validating the quantity of an order.
 */
public class OrderClientValidator implements Validator<Order> {

    /**
     * Validates the quantity of the specified order.
     *
     * @param order The order to validate.
     * @throws IllegalAccessException If the quantity is less than or equal to 0.
     */
    public void validate(Order order) {
        if (order.getQuantity() <= 0) {
            throw new IllegalArgumentException("The Order Quantity limit is not respected!");
        }
    }
}
