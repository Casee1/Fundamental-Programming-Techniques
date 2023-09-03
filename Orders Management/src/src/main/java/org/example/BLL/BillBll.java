package org.example.BLL;

import org.example.DAO.BillDAO;
import org.example.Model.Bill;
import org.example.Model.Order;
import org.example.Model.Product;
import org.example.View.OrderView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**

 This class represents the business logic layer for handling Bill operations.
 */
public class BillBll {

    private BillDAO billDAO;
    private Product product = new Product();
    private Order order = new Order();
    private OrderView orderView = new OrderView();

    /**
     * Constructs a BillBll object and initializes the BillDAO.
     */
    public BillBll() {
        billDAO = new BillDAO();
    }

    /**
     * Inserts a Bill object into the database.
     *
     * @param bill The Bill object to be inserted.
     */
    public void insertBill(Bill bill) {
        if(product.getQuantity() < order.getQuantity())
        {
            orderView.showInfoMessage("Bad quantity");
        }
        else
        {
            billDAO.insert(bill);
        }
    }

    /**
     * Creates a JTable representation of a list of Bill objects.
     *
     * @param bills The list of Bill objects.
     * @return A JTable representing the bills.
     */
    public JTable tableBill(ArrayList<Bill> bills) {
        return billDAO.jTable(bills);
    }

    /**
     * Retrieves a list of Bill objects from the database.
     *
     * @return A list of Bill objects.
     */
    public List<Bill> findBill() {
        return billDAO.find();
    }
}