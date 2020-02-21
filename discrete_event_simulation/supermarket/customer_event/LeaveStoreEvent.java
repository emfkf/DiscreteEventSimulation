package discrete_event_simulation.supermarket.customer_event;

import discrete_event_simulation.Main;
import discrete_event_simulation.event_simulation.Event;
import discrete_event_simulation.event_simulation.EventSimulation;
import discrete_event_simulation.supermarket.Customer;

public class LeaveStoreEvent extends Event {

    private Customer customer;

    public LeaveStoreEvent(Customer customer) {
        super(EventSimulation.getCurrentTime() + customer.getTimeSpentInCheckout());
        customer.setLeaveStoreTime(getTime() + 1);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        System.out.println("LeaveStoreEvent{time: " + getTime() + ", customer: " + customer.getNumber() + "}");
        Main.EVENT_WRITER.write(this.toString());
        if (customer.isBuyingAnything()) {
            customer.getCheckout().endServingCustomer(customer);
        }
        return null;
    }

    @Override
    public String toString() {
        String str = super.toString() + ",Leave Store," + customer.getNumber();
        if (customer.isBuyingAnything()) {
            str = super.toString() + ",Leave Store," + customer.getNumber() + "," + customer.getCheckout().getNumber()
                    + "," + customer.getCheckout().queueSize();
        }
        return str;
    }

}
