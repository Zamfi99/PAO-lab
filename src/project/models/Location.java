package pao.tickets.models;

public class Location {
    private Integer street_number;
    private String street_name;
    private String city;
    private String country;

    public Location(Integer street_number, String street_name, String city, String country) {
        this.street_number = street_number;
        this.street_name = street_name;
        this.city = city;
        this.country = country;
    }

    public Integer getStreet_number() {
        return street_number;
    }

    public void setStreet_number(Integer street_number) {
        this.street_number = street_number;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return this.street_name + " " + this.street_number + ", " + this.city + ", " + this.country;
    }
}
