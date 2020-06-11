package pao.tickets.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    public static Connection conn = null;

    public static Connection instance() {
        if (conn == null) {
            try {
                String url = "jdbc:sqlite:/Users/zamfiracostin-andrei/Desktop/PAO - facultate/identifier.sqlite";
                conn = DriverManager.getConnection(url);

            } catch (SQLException e) {
                conn = null;
                System.out.println(e.getMessage());
            }
        }
        return conn;
    }

    public static void initialize() {
        Connection connection = instance();
        String buyer = "CREATE TABLE IF NOT EXISTS buyer " +
                "(uuid integer PRIMARY KEY AUTOINCREMENT, " +
                "firstName text NOT NULL, " +
                "lastName text NOT NULL, " +
                "balance integer DEFAULT 0, " +
                "tickets text)";
        String seller = "CREATE TABLE IF NOT EXISTS seller " +
                "(uuid integer PRIMARY KEY AUTOINCREMENT, " +
                "firstName text NOT NULL, " +
                "lastName text NOT NULL, " +
                "events text)";

        String ticket = "CREATE TABLE IF NOT EXISTS ticket " +
                "(id integer PRIMARY KEY AUTOINCREMENT, " +
                "event integer NOT NULL)";

        String event = "CREATE TABLE IF NOT EXISTS event " +
                "(id integer PRIMARY KEY AUTOINCREMENT, " +
                "location integer, " +
                "date datetime, " +
                "eventName string, " +
                "capacity integer, " +
                "ticketsSelled integer, " +
                "price integer)";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(buyer);
            stmt.execute(seller);
            stmt.execute(ticket);
            stmt.execute(event);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
