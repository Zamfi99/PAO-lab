package pao.tickets.models;

public class Ticket {
    private Event event;
    private Integer ticketNumber;

    public Ticket(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
