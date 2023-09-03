package org.example.View;

import org.example.BLL.ClientBLL;
import org.example.BLL.ProductBll;
import org.example.Model.Client;
import org.example.Model.Product;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * View class for managing orders.
 * Extends JFrame to create a window with input fields and buttons for adding and viewing orders.
 */
public class OrderView extends JFrame {
    private final JButton addOrderButton = new JButton("Add");
    private final JButton backButton = new JButton("Back");
    private final JButton viewAllButton = new JButton("View all");
    private final JTextField id = new JTextField();
    private final JTextField quantity = new JTextField();
    private final JLabel idLabel = new JLabel("Id: ");
    private final JLabel idClientLabel = new JLabel("idClient: ");
    private final JLabel idProductLabel = new JLabel("idProduct: ");
    private final JLabel quantityLabel = new JLabel("Quantity: ");
    private final JTextArea textArea;
    private final JScrollPane scroll;
    private final JComboBox clientComboBox;
    private final JComboBox productComboBox;
    private ClientBLL clientBLL = new ClientBLL();
    private ProductBll productBll = new ProductBll();
    private final JButton billButton = new JButton("Bill");

    /**
     * Constructs the OrderView.
     * Sets up the window and initializes the components.
     */
    public OrderView() {
        this.setBounds(0, 100, 1200, 1200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);

        // Set up label positions and styles
        idLabel.setForeground(Color.WHITE);
        idLabel.setBounds(30, 10, 140, 25);

        // Set up input field positions
        id.setBounds(215, 0, 100, 25);

        idClientLabel.setForeground(Color.WHITE);
        idClientLabel.setBounds(30, 40, 140, 25);

        idProductLabel.setForeground(Color.WHITE);
        idProductLabel.setBounds(30, 95, 100, 25);

        quantityLabel.setForeground(Color.WHITE);
        quantityLabel.setBounds(30, 205, 145, 30);

        quantity.setBounds(215,210,100,25);

        // Set up button positions
        addOrderButton.setBounds(950, 435, 150, 45);
        viewAllButton.setBounds(950, 605, 150, 45);
        backButton.setBounds(950, 685, 150, 45);
        billButton.setBounds(950,550,150,45);

        // Set up scrollable text area
        textArea = new JTextArea();
        textArea.setBounds(120, 363, 791, 266);
        scroll = new JScrollPane(textArea);
        scroll.setBounds(120, 363, 791, 266);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getViewport().setBackground(Color.WHITE);
        this.getContentPane().add(scroll);

        // Set up client combo box
        clientComboBox = new JComboBox<>();
        List<Client> clientList = new ArrayList<>();
        clientList.addAll(clientBLL.findAllClient());
        for (Client client : clientList) {
            clientComboBox.addItem(client.getIdClient());
        }
        clientComboBox.setBounds(215, 50, 100, 25);
        this.getContentPane().add(clientComboBox);

        // Set up product combo box
        productComboBox = new JComboBox<>();
        List<Product> productList = new ArrayList<>();
        productList.addAll(productBll.findAllProduct());
        for (Product product : productList) {
            productComboBox.addItem(product.getIdProduct());
        }
        productComboBox.setBounds(215, 95, 100, 25);
        this.getContentPane().add(productComboBox);


        // Set up the layout and add components to the content pane
        this.getContentPane().setLayout(null);
        this.getContentPane().add(idLabel);
        this.getContentPane().add(id);
        this.getContentPane().add(idClientLabel);
        this.getContentPane().add(idProductLabel);
        this.getContentPane().add(quantityLabel);
        this.getContentPane().add(quantity);
        this.getContentPane().add(addOrderButton);
        this.getContentPane().add(backButton);
        this.getContentPane().add(viewAllButton);
        this.getContentPane().add(billButton);
        this.getContentPane().add(scroll);
    }

    /**
     * Retrieves the selected client from the client combo box.
     *
     * @return The selected client.
     */
    public JComboBox getClientComboBox() {
        return clientComboBox;
    }

    /**
     * Retrieves the selected product from the product combo box.
     *
     * @return The selected product.
     */
    public JComboBox getProductComboBox() {
        return productComboBox;
    }

    /**
     * Retrieves the quantity entered in the quantity text field.
     *
     * @return The quantity.
     */
    public int getQuantity() {
        return Integer.parseInt(quantity.getText());
    }

    /**
     * Retrieves the ID entered in the ID text field.
     *
     * @return The ID.
     */
    public int getId() {
        return Integer.parseInt(id.getText());
    }

    /**
     * Retrieves the scroll pane.
     *
     * @return The scroll pane.
     */
    public JScrollPane getScroll() {
        return scroll;
    }

    /**
     * Sets the ActionListener for the add order button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void addAddButtonListener(ActionListener actionListener) {
        addOrderButton.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the view all button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void addViewAllButtonListener(ActionListener actionListener) {
        viewAllButton.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the back button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void addBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
    /**
     * Sets the ActionListener for the bill button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void addBillButtonListener(ActionListener actionListener) {
        billButton.addActionListener(actionListener);
    }

    public void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    }
}
