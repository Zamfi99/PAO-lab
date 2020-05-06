package pao.tickets.services;

import pao.tickets.models.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class UserService {
    public static FileWriter logger;
    public static List<Object> buyers = Collections.emptyList();
    public static List<Object> sellers = Collections.emptyList();
    public static List<Object> events = Collections.emptyList();
    public static List<Object> dates = Collections.emptyList();
    public static List<Object> locations = Collections.emptyList();

    public static void initialize() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        /**
         * auto-increment
         */
        buyers = FileManager.instance(Buyer.class).read();
        sellers = FileManager.instance(Seller.class).read();
        events = FileManager.instance(Event.class).read();
        dates = FileManager.instance(Date.class).read();
        locations = FileManager.instance(Location.class).read();
        handleLogger();
    }

    public static void handleLogger() throws IOException {
        File file = new File("Logger.csv");
        if (!file.exists()) {
            file.createNewFile();
        }

        logger = new FileWriter("Logger.csv", true);
    }

    public static void writeLog(String action) throws IOException {
        logger
                .append(action)
                .append(",")
                .append(String.valueOf((new Timestamp(System.currentTimeMillis())).getTime()))
                .append("\n");
    }

    public static void close() throws IOException {
        FileManager.closeFiles();
        logger.close();
    }

    public static Buyer addBuyer(String firstName, String lastName) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Buyer buyer = new Buyer(firstName, lastName);
        buyers.add(buyer);
        FileHandler buyerHandler = FileManager.instance(Buyer.class);
        buyerHandler.write(buyer);
        writeLog("addBuyer");
        return buyer;
    }

    public static Date addDate(String dateString) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, ParseException {
        Date date = new Date(dateString);
        dates.add(date);
        FileHandler dateHandler = FileManager.instance(Date.class);
        dateHandler.write(date);
        writeLog("addDate");
        return date;
    }

    public static Location addLocation(Integer street_number, String street_name, String city, String country) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Location location = new Location(street_number, street_name, city, country);
        locations.add(location);
        FileHandler locationHandler = FileManager.instance(Location.class);
        locationHandler.write(location);
        writeLog("addLocation");
        return location;
    }

    public static Event addEvent(Location location, Date date, String eventName, Integer capacity, Integer price) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, ParseException {
        Event event = new Event(location, date, eventName, capacity, price);
        events.add(event);
        FileHandler eventHandler = FileManager.instance(Event.class);
        eventHandler.write(event);
        writeLog("addEvent");
        return event;
    }

    public static String buyTicket(Buyer buyer, Event event) throws IOException {
        writeLog("buyTicket");
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

    public static String buyTickets(Buyer buyer, Event event, Integer tickets) throws IOException {
        writeLog("buyTickets");
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

    public static Seller addSeller(String firstName, String lastName) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Seller seller = new Seller(firstName, lastName);
        sellers.add(seller);
        FileHandler sellerHandler = FileManager.instance(Seller.class);
        sellerHandler.write(seller);
        writeLog("addSeller");
        return seller;
    }

    public static void addEventForSeller(Seller seller, Event event) throws IOException {
        seller.addEvent(event);
        writeLog("addEventForSeller");
    }

    public static List<Event> getEvents(Seller seller) throws IOException {
//        return events;

        writeLog("getEvents");
        return seller.getEvents();
    }

    public static void listBuyerTickets(Buyer buyer) throws IOException {
        writeLog("listBuyerTickets");
        for (Ticket ticket : buyer.getTickets()) {
            System.out.println("Event name: " + ticket.getEvent().getEventName() + ", location: " + ticket.getEvent().getLocation().getLocation() + ", date: " + ticket.getEvent().getDate().getDate());
        }
    }
}
