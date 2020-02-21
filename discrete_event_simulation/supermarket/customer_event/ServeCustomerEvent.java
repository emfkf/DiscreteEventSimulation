package discrete_event_simulation.supermarket.customer_event;

import discrete_event_simulation.Main;
import discrete_event_simulation.event_simulation.Event;
import discrete_event_simulation.event_simulation.EventSimulation;
import discrete_event_simulation.supermarket.Checkout;
import discrete_event_simulation.supermarket.Customer;

public class ServeCustomerEvent extends Event {

    private Customer customer;

    public ServeCustomerEvent(Customer customer) {
        super(EventSimulation.getCurrentTime() + 1);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        customer.setTimeSpentInCheckout((customer.getNumberOfProducts() * Checkout.PROD_DURATION) + Checkout.PAY_DURATION);
        System.out.println("ServeCustomerEvent{time: " + getTime() + ", customer: " + customer.getNumber() + "}");
        Main.EVENT_WRITER.write(this.toString());
        return new LeaveStoreEvent(customer);
    }

    @Override
    public String toString() {
        return super.toString() + ",Check Out," + customer.getNumber() + "," + customer.getCheckout().getNumber()
                + "," + customer.getCheckout().queueSize();
    }
}
