package org.example.GUI;

import org.example.BusinessLogic.SelectionPolicy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SimulationFrame extends JFrame {

    private final JFrame simulationSetUp = new JFrame("Simulation SetUp");
    private JButton startButton = new JButton("Start");
    private final JTextField minArrivalTime = new JTextField();
    private final JTextField maxArrivalTime = new JTextField();
    private final JTextField minServiceTime = new JTextField();
    private final JTextField maxServiceTime = new JTextField();
    private final JTextField queue = new JTextField();
    private final JTextField timeLimit = new JTextField();
    private final JTextField numberOfClients = new JTextField();
    private final JLabel minArrivalLabel = new JLabel("Minimum arrival time: ");
    private final JLabel maxArrivalLabel = new JLabel("Maximum arrival time: ");
    private final JLabel maxServiceLabel = new JLabel("Maximum service time: ");
    private final JLabel minServiceLabel = new JLabel("Minimum service time: ");
    private final JLabel queueLabel = new JLabel("Number of queues: ");
    private final JLabel numberOfClientsLabel = new JLabel("Number of clients: ");
    private final JLabel timeLimitLabel = new JLabel("Time Limit: ");
    JComboBox strategyComboBox;
    private final JLabel title = new JLabel("Inputs: ");
    private final JLabel comboBoxLabel = new JLabel("Strategy: ");
    private ArrayList<JLabel> queueList;
    private static final JTextArea results = new JTextArea(1000000, 1000000);
    private final JScrollPane scrollPane = new JScrollPane(results);
    private boolean startApplication = false;


    public SimulationFrame() {
        simulationSetUp.setBounds(0, 100, 1200, 1200);
        simulationSetUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the background color of the content pane to black
        simulationSetUp.getContentPane().setBackground(Color.BLACK);

        title.setForeground(Color.WHITE);
        timeLimitLabel.setForeground(Color.WHITE);
        queueLabel.setForeground(Color.WHITE);
        minArrivalLabel.setForeground(Color.WHITE);
        minServiceLabel.setForeground(Color.WHITE);
        maxArrivalLabel.setForeground(Color.WHITE);
        maxServiceLabel.setForeground(Color.WHITE);
        numberOfClientsLabel.setForeground(Color.WHITE);
        comboBoxLabel.setForeground(Color.WHITE);

        title.setBounds(95, 10, 185, 30);
        numberOfClients.setBounds(215, 50, 100, 25);
        numberOfClientsLabel.setBounds(30, 40, 140, 40);
        queueLabel.setBounds(30, 95, 135, 25);
        queue.setBounds(215, 95, 100, 25);
        minArrivalLabel.setBounds(30, 205, 145, 30);
        minArrivalTime.setBounds(215, 210, 100, 25);
        maxArrivalLabel.setBounds(30, 260, 145, 30);
        maxArrivalTime.setBounds(215, 265, 100, 25);
        minServiceLabel.setBounds(30, 315, 145, 35);
        minServiceTime.setBounds(215, 325, 100, 25);
        maxServiceLabel.setBounds(30, 370, 155, 30);
        maxServiceTime.setBounds(215, 375, 100, 25);
        timeLimit.setBounds(215, 150, 100, 25);
        timeLimitLabel.setBounds(30, 150, 170, 25);
        startButton.setBounds(120, 435, 150, 45);

        strategyComboBox = new JComboBox<SelectionPolicy>();
        comboBoxLabel.setBounds(350, 315, 141, 22);
        strategyComboBox.addItem("SHORTEST_QUEUE");
        strategyComboBox.addItem("SHORTEST_TIME");
        strategyComboBox.setBounds(420, 315, 141, 22);

        results.setBounds(600, 268, 875, 412);
        results.setEditable(false);
        scrollPane.setBounds(600,268,875,412);

        // Add the components to the content pane instead of the JFrame
        simulationSetUp.getContentPane().setLayout(null);
        simulationSetUp.getContentPane().add(title);
        simulationSetUp.getContentPane().add(numberOfClientsLabel);
        simulationSetUp.getContentPane().add(numberOfClients);
        simulationSetUp.getContentPane().add(queueLabel);
        simulationSetUp.getContentPane().add(queue);
        simulationSetUp.getContentPane().add(minArrivalLabel);
        simulationSetUp.getContentPane().add(minArrivalTime);
        simulationSetUp.getContentPane().add(maxArrivalLabel);
        simulationSetUp.getContentPane().add(maxArrivalTime);
        simulationSetUp.getContentPane().add(minServiceLabel);
        simulationSetUp.getContentPane().add(minServiceTime);
        simulationSetUp.getContentPane().add(maxServiceLabel);
        simulationSetUp.getContentPane().add(maxServiceTime);
        simulationSetUp.getContentPane().add(timeLimitLabel);
        simulationSetUp.getContentPane().add(timeLimit);
        simulationSetUp.getContentPane().add(startButton);
        simulationSetUp.getContentPane().add(comboBoxLabel);
        simulationSetUp.getContentPane().add(strategyComboBox);
        simulationSetUp.getContentPane().add(scrollPane);

        simulationSetUp.setVisible(true);
    }


    public void addQueueLabel() {
        int sizeOfQueue = Math.abs(Integer.parseInt(getQueue()));
        queueList = new ArrayList<>(sizeOfQueue);
        for (int i = 0; i < sizeOfQueue; i++) {
            JLabel queue = new JLabel();
            queue.setBounds(10, (106 + i * 16), 780, 14);
            queueList.add(queue);
        }
        for (Object label : queueList) {
            simulationSetUp.getContentPane().add((Component) label);
        }
    }

    public String getMinArrivalTime() {
        return minArrivalTime.getText();
    }

    public String getMaxArrivalTime() {
        return maxArrivalTime.getText();
    }

    public String getMinServiceTime() {
        return minServiceTime.getText();
    }

    public String getMaxServiceTime() {
        return maxServiceTime.getText();
    }

    public String getQueue() {
        return queue.getText();
    }

    public String getTimeLimit() {
        return timeLimit.getText();
    }

    public String getNumberOfClients() {
        return numberOfClients.getText();
    }

    public JComboBox getComboBox() {
        return strategyComboBox;
    }

    public static JTextArea getResults() {
        return results;
    }

    public void addStartButtonListener(ActionListener action){
        startButton.addActionListener(action);
    }

    public synchronized void start(boolean start){
        startApplication = start;
    }

    public synchronized boolean isStartApplication() {
        return startApplication;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public ArrayList<JLabel> getQueueList(){
        return queueList;
    }

}

