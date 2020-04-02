package pao.tickets.models;

import java.util.*;

public class Seller extends UserIdentity {

    private List<Event> events;

    /**
     * Constructor
     *  @param firstName String
     * @param lastName  String
     */
    public Seller(String firstName, String lastName) {
        super(firstName, lastName);
        this.events = new ArrayList<Event>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEvents() {
        return events;
    }
}
