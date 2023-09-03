package org.example.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View class for managing clients.
 * Extends JFrame to create a window with input fields and buttons for adding, deleting, editing, and viewing clients.
 */
public class ClientsView extends JFrame {

    private final JButton addClientButton = new JButton("Add");
    private final JButton deleteClientButton = new JButton("Delete");
    private final JButton editClientButton = new JButton("Edit");
    private final JButton backButton = new JButton("Back");
    private final JButton viewAllButton = new JButton("View all");
    private final JTextField id = new JTextField();
    private final JTextField name = new JTextField();
    private final JTextField age = new JTextField();
    private final JTextField email = new JTextField();
    private final JTextField address = new JTextField();
    private final JLabel idLabel = new JLabel("Id: ");
    private final JLabel nameLabel = new JLabel("Name: ");
    private final JLabel ageLabel = new JLabel("Age: ");
    private final JLabel emailLabel = new JLabel("E-mail: ");
    private final JLabel addressLabel = new JLabel("Address");
    private final JTextArea textArea;
    private final JScrollPane scroll;


    /**
     * Constructs the ClientsView.
     * Sets up the window and initializes the components.
     */
    public ClientsView() {
        this.setBounds(0, 100, 1200, 1200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);

        // Set up label positions and styles
        idLabel.setForeground(Color.WHITE);
        idLabel.setBounds(30, 10, 140, 25);

        // Set up input field positions
        id.setBounds(215, 0, 100, 25);

        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(30, 40, 140, 25);

        name.setBounds(215, 50, 100, 25);

        ageLabel.setForeground(Color.WHITE);
        ageLabel.setBounds(30, 95, 100, 25);

        age.setBounds(215, 95, 100, 25);

        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(30, 205, 145, 30);

        email.setBounds(215, 210, 100, 25);

        addressLabel.setForeground(Color.WHITE);
        addressLabel.setBounds(30, 260, 145, 30);

        address.setBounds(215, 265, 100, 25);

        // Set up button positions
        addClientButton.setBounds(950, 435, 150, 45);
        deleteClientButton.setBounds(950, 485, 150, 45);
        editClientButton.setBounds(950, 545, 150, 45);
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
        this.getContentPane().add(ageLabel);
        this.getContentPane().add(age);
        this.getContentPane().add(emailLabel);
        this.getContentPane().add(email);
        this.getContentPane().add(addressLabel);
        this.getContentPane().add(address);
        this.getContentPane().add(addClientButton);
        this.getContentPane().add(deleteClientButton);
        this.getContentPane().add(editClientButton);
        this.getContentPane().add(viewAllButton);
        this.getContentPane().add(backButton);
        this.getContentPane().add(scroll);
    }

    /**
     * Retrieves the name entered in the name text field.
     *
     * @return The name.
     */
    public String getName() {
        return name.getText();
    }

    /**
     * Retrieves the age entered in the age text field.
     *
     * @return The age.
     */
    public int getAge() {
        return Integer.parseInt(age.getText());
    }

    /**
     * Retrieves the email entered in the email text field.
     *
     * @return The email.
     */
    public String getEmail() {
        return email.getText();
    }

    /**
     * Retrieves the address entered in the address text field.
     *
     * @return The address.
     */
    public String getAddress() {
        return address.getText();
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
     * Sets the ActionListener for the add client button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void addAddButtonListener(ActionListener actionListener) {
        addClientButton.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the delete client button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void addDeleteButtonListener(ActionListener actionListener) {
        deleteClientButton.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the edit client button.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void addEditButtonListener(ActionListener actionListener) {
        editClientButton.addActionListener(actionListener);
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