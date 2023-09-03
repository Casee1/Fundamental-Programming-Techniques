package org.example.BusinessLogic;

import org.example.Model.Server;
import org.example.Model.Task;

import java.util.List;

public interface Strategy {
    public int dispatchTask(List<Server> servers, Task task);

}
