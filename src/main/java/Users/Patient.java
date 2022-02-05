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


    /* Login Constructor */

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
     * When calling this function, all attributes in the patient object get set to NULL.
     * Afterwards the garbage collector gets called. Through this,
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

        System.out.println("object patient deleted");

    }


    /* getters & setters */

    public void setMailAddress(String mail){
        this.mailAddress = mail;
    }
    public void setUsername(String usname){
        this.username = usname;
    }

    public void setLongitude(float longitude){
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(String healthInfo) {
        this.healthInfo = healthInfo;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getUsername() {
        return username;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

}
