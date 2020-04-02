package pao.tickets.services;

import pao.tickets.models.*;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class UserService {
    public static List<Buyer> buyers = Collections.emptyList();
    public static List<Seller> sellers = Collections.emptyList();
    public static List<Event> events = Collections.emptyList();

    public static Buyer addBuyer(String firstName, String lastName)
    {
        Buyer buyer = new Buyer(firstName, lastName);
//        buyers.add(buyer);

        return buyer;
    }

    public static String buyTicket(Buyer buyer, Event event) {
        if (buyer.getBalance() >= event.getPrice()) {
            if (event.getCapacity() > event.getTicketsSelled()) {
                Ticket ticket = new Ticket(event);
                event.incrementTicketsSold();
                ticket.setTicketNumber(event.getTicketsSelled());
                buyer.addTicket(ticket);
                buyer.setBalance(event.getPrice());
                return "Biletul a fost cumparat cu succes";
            }

            return "Nu mai sunt locuri disponibile";

        }

        return "Nu aveti destui bani pentru a cumpara un bilet";
    }

    public static String buyTickets(Buyer buyer, Event event, Integer tickets) {
        if (buyer.getBalance() >= event.getPrice() * tickets) {
            if (event.getCapacity() >= event.getTicketsSelled() + tickets) {
                for (int i = 0; i < tickets; i++) {
                    Ticket ticket = new Ticket(event);
                    event.incrementTicketsSold();
                    ticket.setTicketNumber(event.getTicketsSelled());
                    buyer.addTicket(ticket);
                    buyer.setBalance(event.getPrice());
                }
                return "Biletele au fost cumparate cu succes";
            }

            return "Nu mai sunt locuri disponibile";

        }

        return "Nu aveti destui bani pentru a cumpara biletele";
    }

    public static Seller addSeller(String firstName, String lastName)
    {
        Seller seller = new Seller(firstName, lastName);
//        sellers.add(seller);

        return seller;
    }

    public static void addEventForSeller(Seller seller, Event event)
    {
        seller.addEvent(event);
    }

    public static Date createDate(String date) throws ParseException {
        return new Date(date);
    }

    public static Location createLocation(Integer street_number, String street_name, String city, String country) {
        return new Location(street_number,street_name, city, country);
    }

    public static Event createEvent(Location location, Date date, String eventName, Integer capacity, Integer price) {
        Event event = new Event(location, date, eventName, capacity, price);
//        events.add(event);
        return event;
    }

    public static List<Event> getEvents(Seller seller) {
//        return events;
        return seller.getEvents();
    }

    public static void listBuyerTickets(Buyer buyer) {
        for (Ticket ticket : buyer.getTickets()) {
            System.out.println("Event name: " + ticket.getEvent().getEventName() + ", location: " + ticket.getEvent().getLocation().getLocation() + ", date: " + ticket.getEvent().getDate().getDate());
        }
    }
}
