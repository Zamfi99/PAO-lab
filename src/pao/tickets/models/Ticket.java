package pao.tickets.models;

public class Ticket {
    private Event event;
    private Integer id;

    public Ticket(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer toSQL() {
        return this.event.getId();
    }
}
