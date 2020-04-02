package pao.tickets.models;

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
}
