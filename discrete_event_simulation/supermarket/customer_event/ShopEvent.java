package discrete_event_simulation.supermarket.customer_event;

import discrete_event_simulation.Main;
import discrete_event_simulation.event_simulation.Event;
import discrete_event_simulation.event_simulation.EventSimulation;
import discrete_event_simulation.supermarket.Checkout;
import discrete_event_simulation.supermarket.Customer;

public class ShopEvent extends Event {

    private Customer customer;

    ShopEvent(Customer customer) {
        super(EventSimulation.getCurrentTime() + customer.getTimeSpentShopping());
        this.customer = customer;
    }

    @Override
    public Event happen() {
        Checkout checkout = customer.getSuperMarket().getCheckouts()[0];
        if (customer.cares()) {
            checkout = customer.getSuperMarket().getShortestQueue();
        }
        checkout.addCustomer(customer);
        customer.setCheckout(checkout);
        System.out.println("ShoppingEvent{time: " + getTime() + ", customer: " + customer.getNumber() + "}");
        Main.EVENT_WRITER.write(this.toString());
        return new EnterQueueEvent(customer);
    }

    @Override
    public String toString() {
        return super.toString() + ",Finished Shopping," + customer.getNumber() + ","
                + customer.getCheckout().getNumber() + "," + customer.getCheckout().queueSize();
    }

}
