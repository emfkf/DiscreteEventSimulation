package discrete_event_simulation;

import discrete_event_simulation.event_simulation.EventSimulation;
import discrete_event_simulation.supermarket.Customer;
import discrete_event_simulation.supermarket.SuperMarket;

import java.util.ArrayList;

public class Main {

    public static final EventWriter EVENT_WRITER = new EventWriter("data.csv");

    public static void main(String[] args) {
        EVENT_WRITER.write("Time Since Start,Event Type,Customer,Checkout,Queue Amount");
        System.out.println("Time Since Start,Event Type, Customer, Checkout,Queue Amount");
        SuperMarket superMarket = new SuperMarket(3, 20);
        startSimulation(superMarket);
        ArrayList<Integer> timeSpentInQueue = new ArrayList<Integer>();
        for (Customer customer : superMarket.getCustomers()) {
            timeSpentInQueue.add(customer.getTimeSpentInQueue());
        }
        printQueueStatistics(timeSpentInQueue);
    }

    private static void startSimulation(SuperMarket superMarket) {
        EventSimulation eventSimulation = EventSimulation.getInstance();
        eventSimulation.setup(superMarket.getInitialEvents());
        eventSimulation.run();

    }

    public static void printQueueStatistics(ArrayList<Integer> timeSpentInQueue) {
        int sum = 0;
        int longest = 0;
        int shortest = 1000;
        for (Integer i : timeSpentInQueue) {
            sum += i;
            if (i > longest) {
                longest = i;
            }
            if (i < shortest) {
                shortest = i;
            }
        }
        int average = sum / timeSpentInQueue.size();
        System.out.println("Average: " + average);
        System.out.println("Longest: " + longest);
        System.out.println("Shortest: " + shortest);
    }

}
