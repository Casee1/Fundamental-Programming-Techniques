package org.example.GUI;

import org.example.BusinessLogic.SimulationManager;
import org.example.GUI.SimulationFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private SimulationFrame simulationFrame;

    public Controller(SimulationFrame view) {
        simulationFrame = view;

        simulationFrame.addStartButtonListener(new RunListener());
    }

    class RunListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int inputNrOfClients = 0;
            int inputNrOfQueues = 0;
            int inputSimulationTime = 0;
            int inputMinArrivalTime = 0;
            int inputMaxArrivalTime = 0;
            int inputMinServiceTime = 0;
            int inputMaxServiceTime = 0;
            String choose = " ";
            try {
                inputNrOfClients = Integer.parseInt(simulationFrame.getNumberOfClients());
                inputNrOfQueues = Integer.parseInt(simulationFrame.getQueue());
                inputSimulationTime = Integer.parseInt(simulationFrame.getTimeLimit());
                inputMinArrivalTime = Integer.parseInt(simulationFrame.getMinArrivalTime());
                inputMaxArrivalTime = Integer.parseInt(simulationFrame.getMaxArrivalTime());
                inputMinServiceTime = Integer.parseInt(simulationFrame.getMinServiceTime());
                inputMaxServiceTime = Integer.parseInt(simulationFrame.getMaxServiceTime());
                choose = (String) simulationFrame.getComboBox().getSelectedItem();


                SimulationManager simulationManager = new SimulationManager(inputNrOfClients, inputSimulationTime, inputNrOfQueues,inputMinArrivalTime, inputMaxArrivalTime, inputMinServiceTime, inputMaxServiceTime, choose);
                Thread thread = new Thread(simulationManager);
                thread.start();


            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null, "BAD INPUT");
            }
        }
    }

}