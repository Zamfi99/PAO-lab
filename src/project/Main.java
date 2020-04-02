package pao.tickets;

import pao.tickets.models.*;
import pao.tickets.services.UserService;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        Buyer buyer = UserService.addBuyer("Popescu", "Ion");
        Seller seller = UserService.addSeller("Ionescu", "Pop");

        Date date = UserService.createDate("2020-05-30 20:15");
        Location location = UserService.createLocation(244, "Bulevardul Iuliu Maniu", "Bucuresti", "Romania");
        Event event = UserService.createEvent(location, date, "Eveniment 1", 300, 15);
        seller.addEvent(event);

        System.out.println(UserService.buyTicket(buyer, event));
        buyer.addMoney(100);
        System.out.println(UserService.buyTickets(buyer, event, 10));
        buyer.addMoney(200);
        System.out.println(UserService.buyTickets(buyer, event, 3));
        UserService.listBuyerTickets(buyer);
        System.out.println(UserService.buyTickets(buyer, event, 100));
    }
}
