package org.example.BusinessLogic;

import org.example.GUI.Controller;
import org.example.GUI.SimulationFrame;
import org.example.Model.Task;

import java.io.*;
import java.util.*;

public class SimulationManager implements Runnable {
    private final SelectionPolicy selectionPolicy;
    public int timeLimit = 0;
    public int maxArrivalTime = 0;
    public int minArrivalTime = 0;
    public int minServiceTime = 0;
    public int maxServiceTime = 0;
    public int numberOfClients = 0;
    public int numberOfServers = 0;
    public int averageServiceTime = 0;
    public int waitingTime = 0;
    private Scheduler scheduler;
    private List<Task> generatedTasks;

    public SimulationManager(int numberOfClients, int timeLimit,int nrOfServers, int minArrivalTime, int maxArrivalTime, int minServiceTime, int maxServiceTime, String selectionPolicy) {
        this.numberOfClients = numberOfClients;
        this.maxArrivalTime = maxArrivalTime;
        this.minArrivalTime = minArrivalTime;
        this.minServiceTime = minServiceTime;
        this.maxServiceTime = maxServiceTime;
        this.numberOfServers = nrOfServers;
        this.timeLimit = timeLimit;
        this.selectionPolicy = SelectionPolicy.valueOf(selectionPolicy);
        generatedTasks = generateNRandomTasks(numberOfClients);
        scheduler = new Scheduler(numberOfServers, numberOfClients);
        scheduler.changeStrategy(SelectionPolicy.valueOf(selectionPolicy));
    }

    public List<Task> generateNRandomTasks(int numberOfClients) {
        Random random = new Random();
        int rangeOfServiceTime = maxServiceTime - minServiceTime;
        int rangeOfArrivalTime = maxArrivalTime - minArrivalTime;
        List<Task> tasks = new ArrayList<Task>();

        for (int i = 0; i < numberOfClients; i++) {
            int serviceTime = random.nextInt(rangeOfServiceTime) + minServiceTime;
            int ID = i;
            int arrivalTime = random.nextInt(rangeOfArrivalTime) + minArrivalTime;
            Task task = new Task(arrivalTime, serviceTime, ID);
            averageServiceTime += serviceTime;
            tasks.add(task);
        }

        tasks.sort(Comparator.naturalOrder());

        StringJoiner results = new StringJoiner("");
        for (Task task : tasks) {
            SimulationFrame.getResults().append(task.toString());
        }

        SimulationFrame.getResults().append("\n");

        return tasks;
    }



    @Override
    public void run() {
        FileWriter file = null;
        try {
            file = new FileWriter("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        waitingTime = 0;
        PrintWriter printWriter = new PrintWriter(file);
        int currentTime = 0;
        int maximum = -1;
        int peakHour = -1;
        printWriter.println(generatedTasks);
        while (currentTime < timeLimit) {
            printWriter.println("Current time: " + currentTime);
            SimulationFrame.getResults().append("Current time: " + currentTime + "\n");
            int nbc = 0;

            for (int i = 0; i < generatedTasks.size(); i++) {
                if (generatedTasks.get(i).getArrivalTime() == currentTime) {
                    int n = scheduler.dispatchTask(generatedTasks.get(i));
                    int j = 0;
                    if (scheduler.getServers().get(n).getTasks().size() > 1) {
                        for (Task t : scheduler.getServers().get(n).getTasks()) {
                            if (j > scheduler.getServers().get(n).getTasks().size() - 2) {
                                break;
                            }
                            System.out.println(t);
                            waitingTime += t.getServiceTime();
                            j++;

                        }
                        System.out.println();
                        generatedTasks.remove(i--);
                    }
                }
            }

            for (int i = 0; i < scheduler.getServers().size(); i++) {
                String string = scheduler.getServers().get(i).getTasks().toString();
                SimulationFrame.getResults().append("Queue" + (i + 1) + ":");
                SimulationFrame.getResults().append(string + "\n");
                printWriter.println("Queue" + (i + 1));
                printWriter.println(string);
            }

            for (int i = 0; i < scheduler.getServers().size(); i++) {
                if (scheduler.getServers().get(i).getTasks().peek() != null) {
                    int server = scheduler.getServers().get(i).getTasks().peek().getServiceTime();
                    if (server > 1) {
                        scheduler.getServers().get(i).getTasks().peek().setServiceTime(server - 1);
                    } else if (server == 1) {
                        scheduler.getServers().get(i).getTasks().remove();
                    }
                }
            }
            for (int i = 0; i < scheduler.getServers().size(); i++) {
                if (scheduler.getServers().get(i).getTasks().size() > 0) {
                    nbc = nbc + scheduler.getServers().get(i).getTasks().size();
                }
            }
            if (nbc > maximum) {
                maximum = nbc;
                peakHour = currentTime;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentTime++;
        }

        SimulationFrame.getResults().append("Average Service Time is:" + (float) averageServiceTime / numberOfClients + "\n");
        SimulationFrame.getResults().append("Waiting Time is:" + (float) waitingTime / numberOfClients + "\n");
        SimulationFrame.getResults().append("Peak Hour is " + (peakHour));
        SimulationFrame.getResults().append("\n");
        printWriter.println("Average Service Time is:" + (float) averageServiceTime / numberOfClients);
        printWriter.println("Waiting Time is:" + (float) averageServiceTime / numberOfClients / numberOfServers);
        printWriter.println("Peak Hour is " + peakHour);
        printWriter.close();

        String filename = "log.txt";
        String content = SimulationFrame.getResults().getText();
        writeToFile(filename, content);
    }

    public void writeToFile(String filename, String content) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws InterruptedException {
        SimulationFrame simulationFrame = new SimulationFrame();
        Controller controller = new Controller(simulationFrame);
        //SimulationManager simulationManager = new SimulationManager(4,60,2,2,30,2,4,"SHORTEST_TIME");
        //Thread thread = new Thread(simulationManager);
        //thread.start();
        //thread.join();
        //simulationManager = new SimulationManager(4,60,2,2,30,2,4,"SHORTEST_QUEUE");
        //thread = new Thread(simulationManager);
        //thread.start();
        //thread.join();

    }

}