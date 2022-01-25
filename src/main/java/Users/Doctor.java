package Users;

import Hashing.Hashing;
import JDBC.Connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
/**
 * <h1> Doctor Account</h1>
 * This class has functionality to insert a new registered Doctor into the database with all required informations (mail, specialField, PW ...).
 *
 *
 * @author: Max Endres
 */
public class Doctor extends Users.User {

    public static void main(String[] args) throws Exception {
        //creates the table 'user'
        Connect.createTableDoctor();

        //Constructor calls methods "Connect.insertNewDoc" and "createTableTimeslot"
        //Values like 'name' should be passed in from GUI
        //Doctor a = new Doctor("Doc19", "NachName113", "mail5@Mailing.con","1234567", "München", Specialfield.General, 10, 16);

    }



    /**
     * Login constructor
     */
    Doctor(){}

    /**
     * The constructor parameter values are provided throug user input via the GUI.
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
            String salt = Hashing.getSalt();

            this.firstName = fName;
            this.lastName  = lName;
            this.mailAdress = mailAdd;
            this.pw = Hashing.doHashing(pw, salt);
            this.location = loc;
            this.specF = sF;
            this.healthproblem = healthproblem;
            this.isDoc = 1;
            this.openingHour = opHour;
            this.closingHour = clHour;
            String specString  = this.specF.toString();


            //this.createTableTimeslot();
            this.id = Connect.insertNewDoc(this.firstName, this.lastName, this.mailAdress,salt, this.pw, this.location, specString,this.healthproblem, this.isDoc, this.openingHour, this.closingHour);
            //System.out.println("Account created. ID = " + id);


        }catch(Exception e) {System.out.println(e);}
    }



    //Methods
    //Get

    public String getfName() {
        return this.firstName;
    }

    public String getlName () {
        return this.lastName;
    }

    public String getMailAdd() {
        return this.mailAdress;
    }

    public String getLocation () {
        return this.location;
    }

    public int getID() {
        return this.id;
    }


    //Set
    public void setfName(String _fn) {
        this.firstName = _fn;
    }

    public void setlName (String _ln) {
        this.lastName = _ln;
    }

    public void setMailAdd(String _mail) {
        this.mailAdress = _mail;
    }

    public void setLocation (String _loc) {
        this.location = _loc;
    }

    public void setID(int _id) {
        this.id = _id;
    }










    //Attributes
    private String firstName = null;
    private String lastName = null;
    private String mailAdress = null;
    private String location = null;
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
    Children,
    General,
    Heart,
    Lung,
    Teeth;
}
    private Specialfield specF = null;
}
