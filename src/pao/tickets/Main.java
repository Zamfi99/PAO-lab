package pao.tickets;

import pao.tickets.models.*;
import pao.tickets.services.Connect;
import pao.tickets.services.FileHandler;
import pao.tickets.services.FileManager;
import pao.tickets.services.UserService;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException {
        Connect.initialize();
        UserService.initialize();

        Buyer buyer = UserService.addBuyer("Popescu", "sIons");
        Seller seller = UserService.addSeller("Ionescu", "Pop");

        UserService.close();
    }
}
