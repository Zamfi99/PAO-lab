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

    public String outputForCSV() {
        return this.getUuid() + "," + this.getFirstName() + "," + this.getLastName() + "\n";
    }

    public static Seller createNewObject(String line) {
        String[] object_data = line.split(",");
        Seller seller = new Seller(object_data[1], object_data[2]);
        return seller;
    }
}
