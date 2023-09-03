package org.example.BusinessLogic;

import org.example.Model.Server;
import org.example.Model.Task;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private static int totalTime = 0;
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Server> getServers() {
        return servers;
    }


    public Scheduler(int maxNoServers, int maxTaskPerServer) {
        servers = new ArrayList<>(maxNoServers);
        for (int i = 0; i < maxNoServers; i++) {
            Server server = new Server(maxTaskPerServer);
            Thread thread = new Thread(server);
            this.servers.add(server);
            thread.start();
        }
    }

    public void changeStrategy(SelectionPolicy selectionPolicy){
        if(selectionPolicy == SelectionPolicy.SHORTEST_QUEUE){
            strategy = new ShortestQueueStrategy();
        }
        else if(selectionPolicy == SelectionPolicy.SHORTEST_TIME){
            strategy = new TimeStrategy();
        }
    }
    public synchronized int dispatchTask(Task task) {
        return strategy.dispatchTask(servers, task);
    }

}
