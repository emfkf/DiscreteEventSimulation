package discrete_event_simulation.event_simulation;

import discrete_event_simulation.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class EventSimulation {

    private static final EventSimulation theSimulation = new EventSimulation();

    private PriorityQueue<Event> eventPriorityQueue;
    private int clock;
    private Random random;

    private EventSimulation() {
        eventPriorityQueue = new PriorityQueue<>(new EventTimeComparator());
        random = new Random(42);
    }

    public static EventSimulation getInstance() {
        return theSimulation;
    }

    public static int getCurrentTime() {
        return theSimulation.clock;
    }

    public static int nextInt(int min, int max) {
        return min + theSimulation.random.nextInt(max - min);
    }

    public void setup(List<Event> initialEvents) {
        eventPriorityQueue.addAll(initialEvents);
    }

    public void addEvent(Event event) {
        if (event != null) {
            eventPriorityQueue.add(event);
        }
    }

    public void run() {
        while (!eventPriorityQueue.isEmpty()) {
            Event event = eventPriorityQueue.poll();
            clock = event.getTime();
            addEvent(event.happen());
        }
        Main.EVENT_WRITER.save();
    }

}
