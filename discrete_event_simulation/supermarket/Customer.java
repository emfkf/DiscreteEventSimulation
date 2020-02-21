package discrete_event_simulation.supermarket;

import discrete_event_simulation.event_simulation.EventSimulation;

public class Customer {

    private static final int MIN_PRODUCTS = 1;
    private static final int MAX_PRODUCTS = 100;

    private static final int MIN_TIME_SPENT_SHOPPING = 60;
    private static final int MAX_TIME_SPENT_SHOPPING = 1200;

    private SuperMarket superMarket;
    private Checkout checkout;
    private int number;
    private boolean buyingAnything;
    private int numberOfProducts;
    private int enterStoreTime;
    private int enterQueueTime;
    private int leaveStoreTime;
    private int timeSpentShopping;

    public int getTimeSpentInQueue() {
        return timeSpentInQueue;
    }

    private int timeSpentInQueue;
    private int timeSpentInCheckout;


    public Customer(SuperMarket superMarket, int number) {
        this.superMarket = superMarket;
        this.number = number;
        enterStoreTime = number;
        buyingAnything = false;
    }

    public void shop() {
        numberOfProducts = EventSimulation.nextInt(MIN_PRODUCTS, MAX_PRODUCTS);
        timeSpentShopping = EventSimulation.nextInt(MIN_TIME_SPENT_SHOPPING, MAX_TIME_SPENT_SHOPPING);
        timeSpentInQueue = 1;
        buyingAnything = true;
    }

    public SuperMarket getSuperMarket() {
        return superMarket;
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBuyingAnything() {
        return buyingAnything;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public int getEnterStoreTime() {
        return enterStoreTime;
    }

    public int getTimeSpentShopping() {
        return timeSpentShopping;
    }

    public void setTimeSpentInQueue(int timeSpentInQueue) {
        this.timeSpentInQueue = timeSpentInQueue;
    }

    public void setTimeSpentInCheckout(int timeSpentInCheckout) {
        this.timeSpentInCheckout = timeSpentInCheckout;
    }

    public int getTimeSpentInCheckout() {
        return timeSpentInCheckout;
    }

    public int getEnterQueueTime() {
        return enterQueueTime;
    }

    public void setEnterQueueTime(int enterQueueTime) {
        this.enterQueueTime = enterQueueTime;
    }

    public int getLeaveStoreTime() {
        return leaveStoreTime;
    }

    public void setLeaveStoreTime(int leaveStoreTime) {
        this.leaveStoreTime = leaveStoreTime;
    }

    public boolean cares() {
        return EventSimulation.nextInt(1, 10) != 1;
    }

}
