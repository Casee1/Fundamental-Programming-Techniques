package org.example.Model;

public class Task implements Comparable<Task> {
    private int arrivalTime;
    private int serviceTime;
    private int id;

    public Task(int arrivalTime, int serviceTime, int id) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.id = id;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getId() {
        return id;
    }

    public synchronized String toString() {
        return "(" + id + ", " + arrivalTime + ", " + serviceTime + "); ";
    }


    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public int compareTo(Task o) {
        if (o.arrivalTime < this.arrivalTime) {
            return 1;
        } else if (o.arrivalTime > this.arrivalTime) {
            return -1;
        } else {
            return 0;
        }
    }
}
