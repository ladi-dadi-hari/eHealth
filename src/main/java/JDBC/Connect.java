package JDBC;

import Location.location;
import Hashing.Hashing;
import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.List;

/**
 * <h1>Connect Class</h1>
 * This class contains all methods required to communicate with the MySQL Database, using the JDBC driver.
 * To run these methods properly on a local machine, the String "AUTH_STRING" needs to be set to the individual
 * password of the local database.
 *
 * @author: Harris Nuhanovic, Max Endres
 */

public class Connect {

    static final String DB_URL = "jdbc:mysql://localhost:3306/Users";
    static final String USER = "root";
    static final String AUTH_STRING ="****";

    public static void main(String[] args) throws Exception {
        createTableDoctor();
        createTablePatient();
    }

    public static boolean usernameOrEmailExists(String _username, String _email)
    {
        String sql_select = "SELECT patient_username, patient_mailAddress, doctor_username, doctor_mailAddress FROM doctor, patient WHERE patient_username=? OR patient_mailAddress=? OR doctor_username=? OR doctor_mailAddress=?";
        try
        {
            Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);
            PreparedStatement getEmailandUsername = con.prepareStatement(sql_select);

            getEmailandUsername.setString(1, _username);
            getEmailandUsername.setString(2, _email);
            getEmailandUsername.setString(3, _username);
            getEmailandUsername.setString(4, _email);



            ResultSet rs = getEmailandUsername.executeQuery();

            if(rs.next())
            {
                return false;
            }
            else
            {
              return true;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }



    public static void insertnewPatient (String _firstName, String _lastName, String _username, String _address, String _birthday, String _healthInfo, String _mailAdress, String _pw, String _insurance, String _insuranceType) throws IOException, InterruptedException, ApiException {

        location loc = new location();
        List<Float> lat_lng = loc.getLocInfo(_address);

        String firstName = _firstName;
        String lastName = _lastName;
        String usern = _username;
        String adress = _address;
        String birthday = _birthday;
        String healthInfo = _healthInfo;
        String mailAdress = _mailAdress;
        String salt = Hashing.getSalt();
        String pw = Hashing.doHashing(_pw, salt);
        String insurance = _insurance;
        String insuranceType = _insuranceType;
        float lat = lat_lng.get(0);
        float lng = lat_lng.get(1);



        String sql_Insert = "INSERT INTO Users.patient " +
                "(firstName, " +
                "lastName, " +
                "patient_username," +
                "patient_mailAddress, " +
                "birthday,  " +
                "salt, " +
                "password, " +
                "address, " +
                "healthproblem, " +
                "insurance, insuranceType, " +
                "longitude, latitude) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?)";


        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);

            PreparedStatement createNewUser = con.prepareStatement(sql_Insert);

            System.out.println("\nManipulating records in Table...\n");

            createNewUser.setString(1, firstName);
            createNewUser.setString(2, lastName);
            createNewUser.setString(3, usern);
            createNewUser.setString(4, mailAdress);
            createNewUser.setString(5, birthday);
            createNewUser.setString(6, salt);
            createNewUser.setString(7, pw);
            createNewUser.setString(8, adress);
            createNewUser.setString(9, healthInfo);
            createNewUser.setString(10, insurance);
            createNewUser.setString(11, insuranceType);
            createNewUser.setFloat(12, lng);
            createNewUser.setFloat(13, lat);

            createNewUser.executeUpdate();

            System.out.println("Insertion of user succesfull");
        }

        catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static boolean validateData (String mailAdress, String password, String _sqlFetchHash, String _sqlFetchSalt) throws SQLException {

        String inputPassword = password;

        String passwordHash = null;
        String salt = null;

        String sqlFetchHash = _sqlFetchHash;
        String sqlFetchSalt = _sqlFetchSalt;


        try {

            Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);

            PreparedStatement stHash = con.prepareStatement(sqlFetchHash);
            PreparedStatement stSalt = con.prepareStatement(sqlFetchSalt);


            stHash.setString(1, mailAdress);
            stSalt.setString(1, mailAdress);


            ResultSet rs = stHash.executeQuery();



                if (rs.next()) {

                    String pw = rs.getString("password");
                    passwordHash = pw;

                }
                else{return false;}

                ResultSet rs1 = stSalt.executeQuery();

                if (rs1.next()) {

                    salt = rs1.getString("salt");

                }

                inputPassword = Hashing.doHashing(inputPassword, salt);


                System.out.println(inputPassword);
                System.out.println(passwordHash);

                if (passwordHash.equals(inputPassword)) {

                    return true;

                } else {
                    return false;
                }


                /**
                 * TODO
                 * if Statement: fetch isDOC when true call loginDoc when false call loginPatient
                 * fetch attributes by mailAdress and write into variables
                 * call constructor and pass variables
                 * return object
                 **/


        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public static boolean validateData_doc (String mailAdress, String password) throws SQLException {

        String inputPassword = password;

        String passwordHash = null;
        String salt = null;

        String sqlFetchHash = "SELECT password FROM Users.doctor WHERE doctor_mailAddress=?";
        String sqlFetchSalt = "SELECT salt FROM Users.doctor WHERE doctor_mailAddress=?";

        try {

            Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);

            PreparedStatement stHash = con.prepareStatement(sqlFetchHash);
            PreparedStatement stSalt = con.prepareStatement(sqlFetchSalt);

            stHash.setString(1, mailAdress);
            stSalt.setString(1, mailAdress);


            ResultSet rs = stHash.executeQuery();

            if (rs.next()) {

                String pw = rs.getString("password");
                passwordHash = pw;

            }

            else{return false;}

            ResultSet rs1 = stSalt.executeQuery();

            if (rs1.next()) {

                salt = rs1.getString("salt");

            }

            inputPassword = Hashing.doHashing(inputPassword, salt);

            System.out.println(inputPassword);
            System.out.println(passwordHash);

            if (passwordHash.equals(inputPassword)) {

                return true;

            }

            else return false;


            /**
             * TODO
             * if Statement: fetch isDOC when true call loginDoc when false call loginPatient
             * fetch attributes by mailAdress and write into variables
             * call constructor and pass variables
             * return object
             **/

        }

        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }


    /**
     * This method inserts the created appointment into the table "appointment".
     * The parameter values are provided by the user over the GUI.
     * @param _time
     * @param _date
     * @param _patientMail
     * @param _doctorMail
     * @throws Exception
     *
     * @author: Max Endres
     */
    public static void insertAppointment(Time _time, Date _date, String _patientMail, String _doctorMail) throws Exception {
        //Time time = Time.valueOf(LocalTime)
        String location = "Dort";
        String healthprob = "Corona-rona";
        Time time = _time;
        Date date = _date;
        String patMail = _patientMail;
        String docMail = _doctorMail;
        String sql_insert = "INSERT INTO appointment (date, time, patientMail, doctorMail, location, healthproblem) VALUES (?, ?, ?, ?, ?, ?)";

        Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);


        PreparedStatement insertApp = con.prepareStatement(sql_insert);
        insertApp.setDate(1, date);
        insertApp.setTime(2, time);
        insertApp.setString(3, patMail);
        insertApp.setString(4, docMail);
        insertApp.setString(5, location);
        insertApp.setString(6, healthprob);

        insertApp.executeUpdate();

        System.out.println("Appoint insert successfull!");
    }

    /**
     * This method creates the table "appointment" where all information regarding appointments are stored.
     * It is called every time a new appointment is created to check if the table exists.
     * @throws Exception
     *
     * @author: Max Endres
     */
    public static void createTableAppointment() throws Exception{

        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS appointment(ID int NOT NULL AUTO_INCREMENT, date DATE, time TIME, patientMail VARCHAR(255), doctorMail VARCHAR(255), location VARCHAR(255), healthproblem VARCHAR(255), PRIMARY KEY (ID))");
            create.executeUpdate();

        }catch(Exception e) {System.out.println(e);
        }
        finally {System.out.println("Table appointment created");
        }
    }

    /**
     * This method is called when a new doctor registers in our system.
     * It takes the parameter values from the GUI and passes them to an SQL statement.
     * This statement then stores the data in the database and returns the latest created ID Key to this object.
     * @param _fName
     * @param _lName
     * @param _mailAdd
     * @param _loc
     * @param _specF
     * @return id Int
     * @throws Exception
     *
     * @author: Max Endres
     */
    public static int insertNewDoc(String _fName, String _lName, String _username, String _address, String _specF, String _mailAdd, String _pw) throws Exception{

        location loc = new location();
        List<Float> lat_lng = loc.getLocInfo(_address);

        String fName = _fName;
        String lName = _lName;
        String usern = _username;
        String address = _address;
        String specF = _specF;
        String mailAdd = _mailAdd;
        String salt = Hashing.getSalt();
        String password = Hashing.doHashing(_pw, salt);
        float lat = lat_lng.get(0);
        float lng = lat_lng.get(1);

        String sql_Insert = "INSERT INTO Users.doctor (firstName, " +
                "lastName, " +
                "doctor_username, " +
                "address, " +
                "specF, " +
                "doctor_mailAddress, " +
                "salt, password, " +
                "longitude, " +
                "latitude) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);

        PreparedStatement insertDoc = conn.prepareStatement(sql_Insert, Statement.RETURN_GENERATED_KEYS);
        insertDoc.setString(1, fName);
        insertDoc.setString(2,  lName);
        insertDoc.setString(3, usern);
        insertDoc.setString(4, address);
        insertDoc.setString(5, specF);
        insertDoc.setString(6, mailAdd);
        insertDoc.setString(7, salt);
        insertDoc.setString(8, password);
        insertDoc.setFloat(9, lng);
        insertDoc.setFloat(10, lat);

        insertDoc.executeUpdate();
        ResultSet rs = insertDoc.getGeneratedKeys();
        rs.first();

        int id = rs.getInt(1);
        System.out.println("ID: " + id);
        return id;

    }

    /**
     * This method is called in the constructor of Doctor. It checks, wether a table "doctor" already exists in the database.
     * If it doesn't exist, it will be created with all the columns.
     * @throws Exception
     *
     * @author: Max Endres
     */
    public static void createTableDoctor()
    {

        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS doctor(ID int NOT NULL AUTO_INCREMENT, firstName VARCHAR(255), lastName VARCHAR(255), doctor_username VARCHAR(255), address VARCHAR(255), specF VARCHAR(255), doctor_mailAddress VARCHAR(255),salt VARCHAR(255) , password VARCHAR(255), longitude float, latitude float, PRIMARY KEY (ID))");
            create.executeUpdate();

        }catch(Exception e) {System.out.println(e);
        }
        finally {System.out.println("Table doctor created");
        }
    }

    public static void createTablePatient()
    {

        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS patient(ID int NOT NULL AUTO_INCREMENT, firstName VARCHAR(255), lastName VARCHAR(255), patient_username VARCHAR(255), patient_mailAddress VARCHAR(255), birthday VARCHAR(255), salt VARCHAR(255) , password VARCHAR(255), address VARCHAR(255), healthproblem VARCHAR(255), insurance VARCHAR(255), insuranceType VARCHAR(255), longitude float, latitude float,  PRIMARY KEY (ID))");
            create.executeUpdate();

        }catch(Exception e) {System.out.println(e);
        }
        finally {System.out.println("Table patient created");
        }

    }


    /**
     * This method creates 12 tables, one for each month.
     * The amount of time slots is calculated by using the opening and closing time the specific doctor. Each time slot has the length of 30 minutes.
     * @throws Exception
     *
     * @author: Max Endres
     */
    public void createTableTimeslot(int closingHour, int openingHour) throws Exception{
        //Connection con = Connect.getConnection();
        Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);
        LocalDate heute = LocalDate.now();
        int a = heute.get(ChronoField.MONTH_OF_YEAR);
        //int end = 13-heute.get(ChronoField.DAY_OF_MONTH);
        for(int i = a ; i <= 12; i++) {

            String month = null;
            if(i == 1) {
                month = "januar";
            }
            else if (i == 2) {
                month = "februar";
            }
            else if (i == 3){
                month = "march";
            }
            else if (i==4) {
                month = "april";
            }
            else if (i == 5) {
                month = "may";
            }
            else if (i == 6) {
                month = "june";
            }
            else if (i == 7) {
                month = "july";
            }
            else if (i == 8) {
                month = "august";
            }
            else if (i == 9) {
                month = "september";
            }
            else if (i == 10) {
                month = "october";
            }
            else if (i == 11) {
                month = "november";
            }
            else if (i == 12) {
                month = "dezember";
            }


            int clHour = closingHour;
            int opHour = openingHour;


            try {

                PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS "+month+"(slot_ID int NOT NULL AUTO_INCREMENT, date DATE, timeslot TIME,  PRIMARY KEY (slot_ID))");
                create.executeUpdate();

                //set heute to first day of the current month
                heute = heute.withDayOfMonth(1);

                //iterate through every day of current month
                for (int j = 0; j< heute.lengthOfMonth(); j++) {


                    //Set start time to opHour
                    LocalTime start = LocalTime.of(opHour, 00);

                    //Iterate through time slots, size 30 minutes
                    for(int z = 1; z <= (clHour - opHour)*2; z++) {
                        Date date = Date.valueOf(heute);
                        Time time = Time.valueOf(start);

                        //this String will be executet as SQL-Statement
                        String sql_Statement = "INSERT INTO "+month+" (date, timeslot) VALUES (?,?)";
                        PreparedStatement post = con.prepareStatement(sql_Statement);
                        post.setDate(1, date);
                        post.setTime(2, time);

                        post.executeUpdate();


                        //Erhöhe Uhrzeit um 30 Minuten
                        start = start.plusMinutes(30);

                    }
                    LocalDate end = heute.withDayOfMonth(heute.lengthOfMonth());

                    //check if heute reached end of month
                    if(heute.getDayOfMonth()== end.get(ChronoField.DAY_OF_MONTH)) {
                        continue;
                    }
                    else {
                        heute = heute.plusDays(1);
                    }
                }

            }catch(Exception e) {System.out.println(e);
            }
            finally {System.out.println("Table \""+month+"\" created");
            }

            //increase month of heute with 1
            heute = heute.plusMonths(1);
        }
    }
}
