package model.event.comparators;

import model.event.Event;

import java.util.Comparator;

public class ComparatorByDate implements Comparator<Event> {

    /**
     *
     * @param e1 the first object to be compared
     * @param e2 the second object to be compared
     * @return results of comparison
     */
    @Override
    public int compare(Event e1, Event e2) {
        return e1.getDateTime().compareTo(e2.getDateTime());
    }
}
