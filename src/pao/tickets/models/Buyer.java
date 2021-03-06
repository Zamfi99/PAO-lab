package pao.tickets.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Buyer class
 */
public class Buyer extends UserIdentity {

    private Integer balance;
    private List<Ticket> tickets;

    /**
     * Constructor
     *
     * @param firstName String
     * @param lastName  String
     */
    public Buyer(String firstName, String lastName) {
        super(firstName, lastName);
        this.balance = 0;
        this.tickets = new ArrayList<Ticket>();
    }

    public Integer getBalance() {
        return balance;
    }

    public void addMoney(Integer amount) {
        this.balance += amount;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void setBalance(Integer amount) {
        this.balance -= amount;
    }

    public String outputForCSV() {
        return this.getUuid() + "," + this.getFirstName() + "," + this.getLastName() + "," + this.getBalance() + "\n";
    }

    public String toSQL() {
        return "'" + this.getFirstName() + "'" +  "," + "'" +  this.getLastName() + "'" +  "," + this.getBalance();
    }

    public static Buyer createNewObject(String line) {
        String[] object_data = line.split(",");
        Buyer buyer = new Buyer(object_data[1], object_data[2]);
        buyer.setBalance(Integer.parseInt(object_data[3]));
        return buyer;
    }
}
