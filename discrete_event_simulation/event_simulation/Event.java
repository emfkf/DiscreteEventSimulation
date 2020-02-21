package discrete_event_simulation.event_simulation;

public abstract class Event {

    int time;

    public Event(int time) {
        this.time = time;
    }

    protected int getTime() {
        return time;
    }

    public abstract Event happen();

    private String secondsToTimeString(int seconds) {
        int hours = 0;
        int minutes = 0;
        while (seconds >= 60) {
            seconds -= 60;
            minutes++;
            if (minutes >= 60) {
                minutes -= 60;
                hours++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        if (hours >= 10) {
            sb.append(hours);
        } else {
            sb.append("0").append(hours);
        }
        sb.append(":");
        if (minutes >= 10) {
            sb.append(minutes);
        } else {
            sb.append("0").append(minutes);
        }
        sb.append(":");
        if (seconds >= 10) {
            sb.append(seconds);
        } else {
            sb.append("0").append(seconds);
        }
        sb.append("\"");
        return sb.toString();
    }

    @Override
    public String toString() {
        return secondsToTimeString(getTime());
    }

}
