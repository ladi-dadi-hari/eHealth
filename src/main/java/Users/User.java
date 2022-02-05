package Users;

/**
 * <h1> User class <h1/>
 *
 * The User class is the super class of Patient and Doctor.
 * It Contains shared attributes and methods.
 * Since it is an abstract class, no object can be instantiated.
 *
 * @author Max Endres, Harris Nuhanovic
 *
 */


public abstract class User {

    protected String firstName = null;
    protected String lastName = null;
    protected String location = null;
    protected String mailAddress = null;
    protected String pw = null;



    /* Getters & setters */

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

}
