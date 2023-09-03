package org.example.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * View class for the first page of the application.
 * Extends JFrame to create a window with buttons for managing clients, orders, and products.
 */
public class FirstPageView extends JFrame {
    private final JButton clientButton = new JButton("Client");
    private final JButton orderButton = new JButton("Order");
    private final JButton productButton = new JButton("Product");

    /**
     * Constructs the FirstPageView.
     * Sets up the window and button positions.
     */
    public FirstPageView() {
        this.setBounds(0, 100, 1200, 1200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.getContentPane().setLayout(null);

        clientButton.setBounds(120, 435, 150, 45);
        clientButton.setBackground(Color.WHITE);

        orderButton.setBounds(420, 435, 150, 45);
        orderButton.setBackground(Color.WHITE);

        productButton.setBounds(720, 435, 150, 45);
        productButton.setBackground(Color.WHITE);

        this.getContentPane().add(clientButton);
        this.getContentPane().add(orderButton);
        this.getContentPane().add(productButton);

        this.setVisible(true);
    }

    /**
     * Sets the ActionListener for the product button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void productButtonListener(ActionListener actionListener) {
        productButton.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the client button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void clientButtonListener(ActionListener actionListener) {
        clientButton.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the order button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void orderButtonListener(ActionListener actionListener) {
        orderButton.addActionListener(actionListener);
    }
}
