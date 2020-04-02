package pao.tickets.models;

/**
 * User Identity base class
 */
public class UserIdentity {
    protected static Integer _uuids = 0;

    protected Integer uuid;
    protected String firstName;
    protected String lastName;

    /**
     * Constructor
     *
     * @param firstName String
     * @param lastName String
     */
    public UserIdentity(String firstName, String lastName)
    {
        UserIdentity._uuids += 1;
        this.uuid = UserIdentity._uuids;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
