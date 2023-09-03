package org.example.Model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;

    public Server(int maxTaskPerServer) {
        tasks = new ArrayBlockingQueue<Task>(maxTaskPerServer);
        waitingPeriod = new AtomicInteger(0);
    }



    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }


    public void addTask(Task newTask) {
        tasks.add(newTask);
        waitingPeriod.addAndGet(newTask.getServiceTime());
    }

    public void run() {
        while (true) {
            if (!tasks.isEmpty()) {
                Task currentTasks = tasks.peek();
                currentTasks=tasks.peek();
                if(currentTasks != null){
                    try {
                        Thread.sleep(1000 * currentTasks.getServiceTime());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                waitingPeriod.addAndGet(-currentTasks.getServiceTime());
            }else{
                System.out.println("Finished");
                break;
            }
        }
    }

    public String toString() {
        return "Server{" + "tasks=" + tasks + ", waitingPeriod=" + waitingPeriod + '}';
    }


}
