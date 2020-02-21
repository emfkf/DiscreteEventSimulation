package discrete_event_simulation.supermarket.customer_event;

import discrete_event_simulation.Main;
import discrete_event_simulation.event_simulation.Event;
import discrete_event_simulation.event_simulation.EventSimulation;
import discrete_event_simulation.supermarket.Customer;

public class EnterQueueEvent extends Event {

    private Customer customer;

    EnterQueueEvent(Customer customer) {
        super(EventSimulation.getCurrentTime() + 1);
        customer.setEnterQueueTime(EventSimulation.getCurrentTime() + 1);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        String toLog = "EnterQueueEvent{time: " + getTime() + ", customer: " + customer.getNumber() + "}";
        System.out.println(toLog);
        Main.EVENT_WRITER.write(this.toString());
        if (!customer.getCheckout().isActive()) {
            customer.getCheckout().serveNextCustomer();
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + ",Enter Queue," + customer.getNumber() + "," +  customer.getCheckout().getNumber()
                + "," + customer.getCheckout().queueSize();
    }

}
