package discrete_event_simulation.supermarket.customer_event;

import discrete_event_simulation.Main;
import discrete_event_simulation.event_simulation.Event;
import discrete_event_simulation.event_simulation.EventSimulation;
import discrete_event_simulation.supermarket.Customer;

public class EnterStoreEvent extends Event {

    private Customer customer;

    public EnterStoreEvent(Customer customer) {
        super(customer.getEnterStoreTime());
        this.customer = customer;
    }

    @Override
    public Event happen() {
        Main.EVENT_WRITER.write(this.toString());
        System.out.println("EnterStoreEvent{time: " + getTime() + ", customer: " + customer.getNumber() + "}");
        if (EventSimulation.nextInt(1, 10) == 1) {
            customer.setTimeSpentInCheckout(EventSimulation.nextInt(20, 300));
            return new LeaveStoreEvent(customer);
        }
        customer.shop();
        return new ShopEvent(customer);
    }

    @Override
    public String toString() {
        return super.toString() + ",Enter Store," + customer.getNumber();
    }

}
