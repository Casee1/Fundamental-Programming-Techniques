package org.example.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * View class for managing products.
 * Extends JFrame to create a window with input fields and buttons for adding, deleting, editing, and viewing products.
 */
public class ProductView extends JFrame {

    private final JButton addProductButton = new JButton("Add");
    private final JButton deleteProductButton = new JButton("Delete");
    private final JButton editProductButton = new JButton("Edit");
    private final JButton backButton = new JButton("Back");
    private final JButton viewAllButton = new JButton("View all");
    private final JTextField id = new JTextField();
    private final JTextField name = new JTextField();
    private final JTextField quantity = new JTextField();
    private final JTextField price = new JTextField();
    private final JLabel idLabel = new JLabel("Id: ");
    private final JLabel nameLabel = new JLabel("Name: ");
    private final JLabel priceLabel = new JLabel("Price: ");
    private final JLabel quantityLabel = new JLabel("Quantity: ");
    private final JTextArea textArea;
    private final JScrollPane scroll;

    /**
     * Constructs the ProductView.
     * Sets up the window and initializes the components.
     */
    public ProductView() {
        this.setBounds(0, 100, 1200, 1200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);

        // Set up label positions and styles
        idLabel.setForeground(Color.WHITE);
        idLabel.setBounds(30, 10, 100, 25);

        // Set up input field positions
        id.setBounds(215, 0, 100, 25);

        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(30, 40, 140, 25);

        name.setBounds(215, 50, 100, 25);

        priceLabel.setForeground(Color.WHITE);
        priceLabel.setBounds(30, 95, 100, 25);

        price.setBounds(215, 95, 100, 25);

        quantityLabel.setForeground(Color.WHITE);
        quantityLabel.setBounds(30, 205, 145, 30);

        quantity.setBounds(215, 210, 100, 25);

        // Set up button positions
        addProductButton.setBounds(950, 435, 150, 45);
        deleteProductButton.setBounds(950, 485, 150, 45);
        editProductButton.setBounds(950, 545, 150, 45);
        viewAllButton.setBounds(950, 605, 150, 45);
        backButton.setBounds(950, 645, 150, 45);

        // Set up scrollable text area
        textArea = new JTextArea();
        textArea.setBounds(120, 363, 791, 266);
        scroll = new JScrollPane(textArea);
        scroll.setBounds(120, 363, 791, 266);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getViewport().setBackground(Color.WHITE);
        this.getContentPane().add(scroll);

        // Set up the layout and add components to the content pane
        this.getContentPane().setLayout(null);
        this.getContentPane().add(idLabel);
        this.getContentPane().add(id);
        this.getContentPane().add(nameLabel);
        this.getContentPane().add(name);
        this.getContentPane().add(priceLabel);
        this.getContentPane().add(price);
        this.getContentPane().add(quantityLabel);
        this.getContentPane().add(quantity);
        this.getContentPane().add(addProductButton);
        this.getContentPane().add(deleteProductButton);
        this.getContentPane().add(editProductButton);
        this.getContentPane().add(backButton);
        this.getContentPane().add(viewAllButton);
        this.getContentPane().add(scroll);
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
     * Retrieves the price entered in the price text field.
     *
     * @return The price.
     */
    public float getPrice() {
        return Float.parseFloat(price.getText());
    }

    /**
     * Retrieves the name entered in the name text field.
     *
     * @return The name.
     */
    @Override
    public String getName() {
        return name.getText();
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
     * Sets the ActionListener for the add product button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void addAddButtonListener(ActionListener actionListener) {
        addProductButton.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the delete product button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void addDeleteButtonListener(ActionListener actionListener) {
        deleteProductButton.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the edit product button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void addEditButtonListener(ActionListener actionListener) {
        editProductButton.addActionListener(actionListener);
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
}
