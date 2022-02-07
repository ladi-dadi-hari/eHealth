package Users;

import Hashing.Hashing;


/**
 * <h1> Patient class <h1/>
 *
 * Patient class is a child class of the superclass User. The derived class extends the User class and adds several necessary functions and attributes, seen below.
 *
 * @author Harris Nuhanovic
 */


public class Patient extends Users.User {



    // Attributes

    private String birthday = null;
    private String healthInfo = null;
    private String insurance = null;
    private String insuranceType = null;
    private int isDoc = 0;
    private float longitude = 0;
    private float latitude = 0;


    // Login Constructor

    public Patient(String firstName, String lastName, String location, String birthday, String healthInfo, String mailAddress, String pw, String insurance, String insuranceType, float longitude, float latitude) {

        /**
         * The user inputs the data via the Healthcare_Login screen.
         *
         *
         *
         * @param birthday String
         * @param healthInfo String
         * @param insurance String
         * @param insuranceType String
         * @param isDoc int
         * @param username String
         * @param longitude float
         * @param latitude float
         *
         *
         * @author Harris Nuhanovic
         */

        String salt = Hashing.getSalt();

        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.birthday = birthday;
        this.healthInfo = healthInfo;
        this.mailAddress = mailAddress;
        this.pw = Hashing.doHashing(pw, salt);
        this.insurance = insurance;
        this.insuranceType = insuranceType;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public Patient(){}

    /**
     *
     * <h1> logOutPat <h1/>
     * When calling this function, all attributes in the patient object get set to NULL.
     *
     * @param patient
     * @author: Harris Nuhanovic
     */

    public void logOutPat (Patient patient){

        patient.setFirstName(null);
        patient.setLastName(null);
        patient.setUsername(null);
        patient.setMailAddress(null);
        patient.setBirthday(null);
        patient.setLocation(null);
        patient.setHealthInfo(null);
        patient.setInsurance(null);
        patient.setInsuranceType(null);

        System.out.println("object patient is null");

    }


    /* getters & setters */


    /**
     * <h1> setMailAdress<h1/>
     * @param mail
     */

    public void setMailAddress(String mail){
        this.mailAddress = mail;
    }

    /**
     * <h1> setUsername<h1/>
     * @param usname
     */

    public void setUsername(String usname){
        this.username = usname;
    }

    /**
     * <h1> setLongitude<h1/>
     * @param longitude
     */

    public void setLongitude(float longitude){
        this.longitude = longitude;
    }

    /**
     * <h1> setLatitude<h1/>
     * @param latitude
     */

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * <h1> getBirthday <h1/>
     */

    public String getBirthday() {
        return birthday;
    }

    /**
     * <h1> setBirthday <h1/>
     * @param birthday
     */

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * <h1> getHealthInfo <h1/>
     */

    public String getHealthInfo() {
        return healthInfo;
    }

    /**
     * <h1> setHealthInfo <h1/>
     * @param healthInfo
     */

    public void setHealthInfo(String healthInfo) {
        this.healthInfo = healthInfo;
    }

    /**
     * <h1> getInsurance <h1/>
     */

    public String getInsurance() {
        return insurance;
    }

    /**
     * <h1> setInsurance <h1/>
     * @param insurance
     */

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    /**
     * <h1> setInsuranceType <h1/>
     * @param insuranceType
     */

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    /**
     * <h1> getMailAddress <h1/>
     */

    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * <h1> getUsername <h1/>
     */

    public String getUsername() {
        return username;
    }

    /**
     * <h1> getLatitude <h1/>
     */

    public float getLatitude() {
        return latitude;
    }

    /**
     * <h1> getLongitude <h1/>
     */

    public float getLongitude() {
        return longitude;
    }

}
