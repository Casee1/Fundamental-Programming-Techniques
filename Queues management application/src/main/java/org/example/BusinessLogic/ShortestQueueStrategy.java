package org.example.BusinessLogic;

import org.example.Model.Server;
import org.example.Model.Task;

import java.util.List;

public class ShortestQueueStrategy implements Strategy {

    private Server server;

    public synchronized int dispatchTask(List<Server> servers, Task task){
        int minQueue = 999999999;
        int position = 0;
        int i=0;
        for(Server currentServer: servers){
            if(currentServer.getTasks().size() < minQueue){
                minQueue = currentServer.getTasks().size();
                server = currentServer;
                position = i;
            }
            i++;
        }
        server.addTask(task);
        return position;
    }
}
