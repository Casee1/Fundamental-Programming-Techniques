package org.example.BusinessLogic;

import org.example.Model.Server;
import org.example.Model.Task;

import java.util.List;

public class TimeStrategy implements Strategy {

    private Server server;

    public synchronized int dispatchTask(List<Server> servers, Task task){
        int minTime = 999999999;
        int position = 0;
        for(int i=0;i<servers.size();i++){
            int value = servers.get(i).getWaitingPeriod().intValue();
            if(value < minTime){
                position = i;
                minTime = value;
            }
        }
        servers.get(position).addTask(task);
        return position;
    }
}
