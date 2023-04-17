package model.planner;

import model.event.Event;

import java.io.Serializable;
import java.util.ArrayList;

public class Planner implements Writable {
    ArrayList<Event> eventList;

    public Planner() {
        this.eventList = new ArrayList<>();
    }

    /**
     * Adds event to this planner
     *
     * @param event the event to be added
     */
    public void add(Event event) {
        this.eventList.add(event);
    }

    /**
     * Returns this planner's eventList
     * @return this planner's eventList
     */
    public ArrayList<Event> getEventList() {
        return this.eventList;
    }
}
