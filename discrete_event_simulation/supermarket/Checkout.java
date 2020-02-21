package discrete_event_simulation.supermarket;

import discrete_event_simulation.event_simulation.EventSimulation;
import discrete_event_simulation.supermarket.customer_event.ServeCustomerEvent;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

    public static final int PROD_DURATION = 2;
    public static final int PAY_DURATION = 10;

    private EventSimulation eventSimulation;
    private int number;
    private List<Customer> customers;
    private boolean active;

    public Checkout(int number) {
        this.eventSimulation = EventSimulation.getInstance();
        this.number = number;
        this.customers = new ArrayList<>();
        this.active = false;
    }

    public void serveNextCustomer() {
        eventSimulation.addEvent(new ServeCustomerEvent(customers.get(0)));
        active = true;
    }

    public void endServingCustomer(Customer customer) {
        customers.remove(customer);
        if (!customers.isEmpty()) {
            Customer nextCustomer = customers.get(0);
            nextCustomer.setTimeSpentInQueue(customer.getLeaveStoreTime() - nextCustomer.getEnterQueueTime());
            serveNextCustomer();
        } else {
            active = false;
        }
    }

    public int queueSize() {
        return customers.size();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean isActive() {
        return active;
    }

    public int getNumber() {
        return number;
    }

}
