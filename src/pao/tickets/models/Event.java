package pao.tickets.models;

import java.text.ParseException;

public class Event extends BaseEvent {

    private Location location;
    private Date date;

    private String eventName;
    private Integer capacity;
    private Integer ticketsSelled;
    private Integer price;


    public Event(Location location, Date date, String eventName, Integer capacity, Integer price) {
        super();
        this.location = location;
        this.date = date;
        this.eventName = eventName;
        this.capacity = capacity;
        this.ticketsSelled = 0;
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public String getEventName() {
        return eventName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getTicketsSelled() {
        return ticketsSelled;
    }

    public Date getDate() {
        return date;
    }

    public Integer getPrice() {
        return price;
    }

    public void incrementTicketsSold() {
        ticketsSelled += 1;
    }

    public String outputForCSV() {
        return this.getId().toString() + "," + this.getLocation().getLocation() + "," + this.getDate().getDate() + "," + this.getEventName() + "," + this.getCapacity() + "," + this.getTicketsSelled() + "," + this.getPrice() + "\n";
    }

    public static Event createNewObject(String line) throws ParseException {
        String[] object_data = line.split(",");
        Location location = new Location(Integer.parseInt(object_data[1]), object_data[2], object_data[3], object_data[4]);
        Date date = new Date(object_data[5]);
        return new Event(location, date, object_data[6], Integer.parseInt(object_data[7]), Integer.parseInt(object_data[8]));
    }
}
