package org.example.View;

import org.example.BusinessLogic.PolynomialController;
import org.example.Model.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {
    private final static JPanel panel = new JPanel();
    private final static JTextField firstPolynomial = new JTextField();
    private final static JLabel firstPolynomialLabel = new JLabel("First polynomial:");
    private final static JTextField secondPolynomial = new JTextField();
    private final static JLabel secondPolynomialLabel = new JLabel("Second polynomial:");
    private final static JTextField result = new JTextField();
    private final static JLabel resultLabel = new JLabel("Result:");
    private final static JButton addButton = new JButton("ADDITION");
    private final static JButton substractButton = new JButton("SUBTRACT");
    private final static JButton multiplicationButton = new JButton("MULTIPLICATION");
    private final static JButton divisionButton = new JButton("DIVISION");
    private final static JButton derivateButton = new JButton("DERIVATE");
    private final static JButton integrationButton = new JButton("INTEGRATION");

    public void addAdditionButton() {
        addButton.setLocation(10, 810);
        addButton.setSize(25, 25);
        addButton.setBackground(Color.gray);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial();
                Polynomial polynomial2 = new Polynomial();
                Polynomial add = new Polynomial();
                try {
                    polynomial1.BuildPolynomial(firstPolynomial.getText());
                    polynomial2.BuildPolynomial(secondPolynomial.getText());
                    add = PolynomialController.Addition(polynomial1, polynomial2);
                    result.setText(add.toString());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(addButton);
    }


    public void addSubsButton() {
        substractButton.setLocation(50, 810);
        substractButton.setSize(25, 25);
        substractButton.setBackground(Color.gray);
        substractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial();
                Polynomial polynomial2 = new Polynomial();
                Polynomial diff = new Polynomial();
                try {
                    polynomial1.BuildPolynomial(firstPolynomial.getText());
                    polynomial2.BuildPolynomial(secondPolynomial.getText());
                    diff = PolynomialController.Substract(polynomial1, polynomial2);
                    result.setText(diff.toString());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(substractButton);
    }

    public void addMultiplicationButton() {
        multiplicationButton.setLocation(90, 810);
        multiplicationButton.setSize(25, 25);
        multiplicationButton.setBackground(Color.gray);
        multiplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial();
                Polynomial polynomial2 = new Polynomial();
                Polynomial multiply = new Polynomial();
                try {
                    polynomial1.BuildPolynomial(firstPolynomial.getText());
                    polynomial2.BuildPolynomial(secondPolynomial.getText());
                    multiply = PolynomialController.Multiply(polynomial1, polynomial2);
                    result.setText(multiply.toString());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(multiplicationButton);
    }

    public void addDivisionButton() {
        divisionButton.setLocation(90, 810);
        divisionButton.setSize(25, 25);
        divisionButton.setBackground(Color.gray);
        divisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial();
                Polynomial polynomial2 = new Polynomial();
                Polynomial divide = new Polynomial();
                try {
                    polynomial1.BuildPolynomial(firstPolynomial.getText());
                    polynomial2.BuildPolynomial(secondPolynomial.getText());
                    divide = PolynomialController.Division(polynomial1, polynomial2);
                    result.setText(divide.toString());
                    int k = 1;

                    Polynomial remainder = new Polynomial();
                    if (k == 1) {
                        remainder = PolynomialController.Remainder(polynomial1, polynomial2);
                        if (!remainder.onlyZero()) {
                            result.setText(result.getText() + " Remainder: " + remainder.toString());
                        }
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(divisionButton);
    }


    public void addDerivateButton() {
        derivateButton.setLocation(10, 850);
        derivateButton.setSize(25, 25);
        derivateButton.setBackground(Color.gray);
        derivateButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial();
                polynomial1.BuildPolynomial(firstPolynomial.getText());
                Polynomial derive = new Polynomial();
                try {
                    derive = PolynomialController.Derivate(polynomial1);
                    result.setText(derive.toString());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(derivateButton);
    }


    public void addIntegrationButton() {
        integrationButton.setLocation(50, 850);
        integrationButton.setSize(25, 25);
        integrationButton.setBackground(Color.gray);
        integrationButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial();
                polynomial1.BuildPolynomial(firstPolynomial.getText());
                Polynomial integration = new Polynomial();
                try {
                    integration = PolynomialController.Integration(polynomial1);
                    result.setText(integration.toString() + " +c");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(integrationButton);
    }

    public void addFirstPolynomial() {
        firstPolynomialLabel.setLocation(170, 330);
        firstPolynomialLabel.setSize(150, 150);
        firstPolynomialLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPolynomialLabel.setBackground(Color.gray);
        panel.add(firstPolynomialLabel);
        firstPolynomial.setLocation(10, 330);
        firstPolynomial.setSize(150, 50);
        panel.add(firstPolynomial);
    }

    public void addSecondPolynomial() {
        secondPolynomialLabel.setLocation(170, 490);
        secondPolynomialLabel.setSize(150, 150);
        secondPolynomialLabel.setHorizontalAlignment(SwingConstants.CENTER);
        secondPolynomialLabel.setBackground(Color.gray);
        panel.add(secondPolynomialLabel);
        secondPolynomial.setLocation(10, 490);
        secondPolynomial.setSize(150, 50);
        panel.add(secondPolynomial);
    }

    public void addResultPolynomial() {
        resultLabel.setLocation(170, 490);
        resultLabel.setSize(150, 150);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setBackground(Color.gray);
        panel.add(resultLabel);
        result.setLocation(10, 490);
        result.setSize(150, 50);
        panel.add(result);
    }

    public void View() {
        setTitle("Polynomial calculator");
        setSize(400, 500);
        setBackground(Color.white);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setBounds(0, 0, 40, 50);
        panel.setBackground(Color.white);
        panel.setLayout(new GridLayout(8, 2, 10, 20));

        addFirstPolynomial();
        addSecondPolynomial();
        addResultPolynomial();
        addAdditionButton();
        addSubsButton();
        addMultiplicationButton();
        addDivisionButton();
        addDerivateButton();
        addIntegrationButton();
        add(panel);

        setVisible(true);

    }

    public Interface() {

    }
}


