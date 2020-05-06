package pao.tickets;

import pao.tickets.models.*;
import pao.tickets.services.FileHandler;
import pao.tickets.services.FileManager;
import pao.tickets.services.UserService;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        UserService.initialize();

        Buyer buyer = UserService.addBuyer("Popescu", "sIons");
        Seller seller = UserService.addSeller("Ionescu", "Pop");
        Location location = UserService.addLocation(47, "Progresului", "Curtea de Arges", "Romania");
        Date date = UserService.addDate("2020-05-30 20:15");
        Event event = UserService.addEvent(location, date, "Eveniment 1", 300, 15);

        UserService.close();
    }
}
