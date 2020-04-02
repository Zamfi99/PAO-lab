package pao.tickets.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {
    private java.util.Date date;
    public static final String pattern = "yyyy-MM-dd HH:mm";

    public Date(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        this.date = dateFormat.parse(date);
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
