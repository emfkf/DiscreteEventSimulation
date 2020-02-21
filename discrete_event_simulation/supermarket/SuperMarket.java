package discrete_event_simulation.supermarket;

import discrete_event_simulation.event_simulation.Event;
import discrete_event_simulation.supermarket.customer_event.EnterStoreEvent;

import java.util.ArrayList;
import java.util.List;

public class SuperMarket {

    private Checkout[] checkouts;
    private List<Customer> customers;
    private List<Event> initialEvents;

    public SuperMarket(int numberOfCheckouts, int numberOfCustomers) {
        if (numberOfCheckouts < 1) {
            numberOfCheckouts = 1;
        }
        checkouts = new Checkout[numberOfCheckouts];
        for (int i = 0; i < numberOfCheckouts; i++) {
            checkouts[i] = new Checkout(i);
        }
        customers = new ArrayList<>();
        initialEvents = new ArrayList<>();
        for (int i = 0; i < numberOfCustomers; i++) {
            Customer customer = new Customer(this, i);
            initialEvents.add(new EnterStoreEvent(customer));
            customers.add(customer);
        }
    }

    public List<Event> getInitialEvents() {
        return initialEvents;
    }

    public Checkout getShortestQueue() {
        Checkout shortestQueue = checkouts[0];
        for (int i = 1; i < checkouts.length; i++) {
            Checkout compared = checkouts[i];
            if (compared.queueSize() < shortestQueue.queueSize()) {
                shortestQueue = compared;
            }
        }
        return shortestQueue;
    }

    public Checkout[] getCheckouts() {
        return checkouts;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
