package Users;

import Hashing.Hashing;
import JDBC.Connect;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;


/**
 * <h1> Doctor Account</h1>
 * This class has functionality to insert a new registered Doctor into the database with all required informations (mail, specialField, PW ...).
 * All necessary set and get methods are included as well.
 *
 * @author: Max Endres
 */
public class Doctor extends Users.User {
    /**
     * Login constructor
     */
    public Doctor(){}

    /**
     * Registration constructor.
     * The constructor parameter values are provided through user input via the GUI.
     * They are instantly assigned to the created object and even the password is never saved in plain text since it gets directly hashed before saving it.
     *
     * @param fName String First Name
     * @param lName	String Last Name
     * @param mailAdd String E-Mailaddress
     * @param loc String physical location/address of the doctor
     * @param sF Enum-value with the special health field
     * @param opHour Int opening hour of the doctor
     * @param clHour Int closing hour of the doctor
     */
    Doctor(String fName, String lName, String mailAdd, String pw, String loc, Specialfield sF, String healtproblem, int opHour, int clHour)
    {
        try {
            JDBC.Connect.createTableDoctor();
            String salt = Hashing.getSalt();

            this.firstName = fName;
            this.lastName  = lName;
            this.mailAddress = mailAdd;
            this.pw = Hashing.doHashing(pw, salt);
            this.location = loc;
            this.specF = sF;
            this.healthproblem = healthproblem;
            this.isDoc = 1;
            this.openingHour = opHour;
            this.closingHour = clHour;
            String specString  = this.specF.toString();


            //this.createTableTimeslot();
           // this.id = Connect.insertNewDoc(this.firstName, this.lastName, this.mailAdress,salt, this.pw, this.location, specString,this.healthproblem, this.isDoc, this.openingHour, this.closingHour);
            //System.out.println("Account created. ID = " + id);


        }catch(Exception e) {System.out.println(e);}
    }


    //Methods
    //Get

    /**
     *
     * @return firstName Returns first name as String
     */
    public String getfName() {
        return this.firstName;
    }

    /**
     *
     * @return lastName Returns last name as String
     */
    public String getlName () {
        return this.lastName;
    }

    /**
     *
     * @return location Returns location as String.
     */
    public String getLocation () {
        return this.location;
    }

    /**
     *
     * @return id Returns the id as int
     */
    public int getID() {
        return this.id;
    }

    /**
     *
     * @return username Returns the username as String
     */
    public String getUname(){
        return this.username;
    }

    /**
     *
     * @return openingHour Returns the opening hour of the doctor as int
     */
    public int getOpeningHour(){
        return this.openingHour;
    }
    /**
     *
     * @return closingHour Returns the closing hour of the doctor as int
     */
    public int getClosingHour(){
        return this.closingHour;
    }


    //Set

    /**
     * Sets the username of the specific doctor
     * @param uname Username to be set
     */
    public void setUsername(String uname){
        this.username = uname;
    }
    /**
     * Sets the opening hour of the specific doctor
     * @param opH OpeningHour
     */
    public void setOpeningHour(int opH)
    {
        this.openingHour = opH;
    }
    /**
     * Sets the closing hour of the specific doctor
     * @param clH closing Hour to be set
     */
    public void setClosingHour(int clH){
        this.closingHour = clH;
    }









    //Attributes

    private int isDoc = 1;
    private String[] specString = new String[5];
    private String healthproblem = null;
    private int id;
    private int closingHour;
    private int openingHour;

/**
 * List of special health fields a doctor can choose to be found in a search by the patient.
 *
 *
 */
    enum Specialfield {
    General,
    Allergist,
    Orthopedist,
    Dermatologist;
}
    private Specialfield specF = null;
}
