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
    protected String username = null;



    /* Getters & setters */

    /**
     * <h1> getFirstName <h1/>
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * <h1> setFirstName <h1/>
     * @param firstName
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * <h1> getLastName <h1/>
     * @return
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * <h1> setLastName <h1/>
     * @param lastName
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * <h1> getLocation <h1/>
     * @return
     */

    public String getLocation() {
        return location;
    }

    /**
     * <h1> setLocation <h1/>
     * @param location
     */

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * <h1> getMailAdress <h1/>
     * @return
     */

    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * <h1> setMailAddress <h1/>
     * @param mailAddress
     */

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

}
