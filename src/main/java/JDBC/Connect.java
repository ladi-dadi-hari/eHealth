package JDBC;


import Hashing.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
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
    static final String AUTH_STRING ="rootadmin";




    public static void insertNewPatient(String _firstName, String _lastName, String _adress, String _birthday, String _healthInfo, String _mailAdress, String _salt, String _pw, String _insurance, String _insuranceType, int _isDoc){


        String firstName = _firstName;
        String lastName = _lastName;
        String adress = _adress;
        String birthday = _birthday;
        String healthInfo = _healthInfo;
        String mailAdress = _mailAdress;
        String salt = _salt;
        String pw = _pw;
        String insurance = _insurance;
        String insuranceType = _insuranceType;
        int isDoc = _isDoc;


        String sql_Insert = "INSERT INTO Users.Patient (firstName, lastName, adress, birthday, healthInfo, mailAdress, salt, pw_hash, insurance, insuranceType, isDoc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);

            PreparedStatement createNewUser = con.prepareStatement(sql_Insert);

            System.out.println("\nManipulating records in Table...\n");

            createNewUser.setString(1, firstName);
            createNewUser.setString(2, lastName);
            createNewUser.setString(3, adress);
            createNewUser.setString(4, birthday);
            createNewUser.setString(5, healthInfo);
            createNewUser.setString(6, mailAdress);
            createNewUser.setString(7, salt);
            createNewUser.setString(8, pw);
            createNewUser.setString(9, insurance);
            createNewUser.setString(10, insuranceType);
            createNewUser.setInt(11, isDoc);

            createNewUser.executeUpdate();

            System.out.println("Insertion of user succesfull");
        }

        catch (SQLException e) {
            System.out.println(e);
        }

        //finally {
        //    System.out.println("Insertion of user successfull");
        //}



    }

    public static boolean validateData (String mailAdress, String password) throws SQLException {

        Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);
        int isDoc = 0;

        try {

            String sqlFetchisDoc = "SELECT isDoc FROM Users.Patient WHERE mailAdress=?";

            PreparedStatement stIsDoc = con.prepareStatement(sqlFetchisDoc);

            stIsDoc.setString(1, mailAdress);

            ResultSet rsIsDoc = stIsDoc.executeQuery();


            if (rsIsDoc.next()) {

                String isDoc_ = rsIsDoc.getString("isDoc");
                int _isDoc_ = Integer.parseInt(isDoc_);
                isDoc = _isDoc_;

            }
        }

        catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        String inputPassword = password;

        String passwordHash = null;
        String salt = null;


        if (isDoc == 0) {


            String sqlFetchHash = "SELECT pw_hash FROM Users.Patient WHERE mailAdress=?";
            String sqlFetchSalt = "SELECT salt FROM Users.Patient WHERE mailAdress=?";

            try {

                PreparedStatement stHash = con.prepareStatement(sqlFetchHash);
                PreparedStatement stSalt = con.prepareStatement(sqlFetchSalt);

                stHash.setString(1, mailAdress);
                stSalt.setString(1, mailAdress);


                ResultSet rs = stHash.executeQuery();

                if (rs.next()) {

                    String pw = rs.getString("pw_hash");
                    passwordHash = pw;

                }

                ResultSet rs1 = stSalt.executeQuery();

                if (rs1.next()) {

                    salt = rs1.getString("salt");

                }

                inputPassword = Hashing.doHashing(inputPassword, salt);

                System.out.println(inputPassword);
                System.out.println(passwordHash);

                if (passwordHash.equals(inputPassword)) {

                    return true;

                } else return false;

            }


            catch (SQLException throwables) {
                throwables.printStackTrace();
            }



            /**
             * TODO
             * if Statement: fetch isDOC when true call loginDoc when false call loginPatient
             * fetch attributes by mailAdress and write into variables
             * call constructor and pass variables
             * return object
             **/

        }

        else {

            String sqlFetchHash = "SELECT pw_hash FROM Users.Doctor WHERE mailAdress=?";
            String sqlFetchSalt = "SELECT salt FROM Users.Doctor WHERE mailAdress=?";

            try {

                PreparedStatement stHash = con.prepareStatement(sqlFetchHash);
                PreparedStatement stSalt = con.prepareStatement(sqlFetchSalt);

                stHash.setString(1, mailAdress);
                stSalt.setString(1, mailAdress);


                ResultSet rs = stHash.executeQuery();

                if (rs.next()) {

                    String pw = rs.getString("pw_hash");
                    passwordHash = pw;

                }

                ResultSet rs1 = stSalt.executeQuery();

                if (rs1.next()) {

                    salt = rs1.getString("salt");

                }

                inputPassword = Hashing.doHashing(inputPassword, salt);

                System.out.println(inputPassword);
                System.out.println(passwordHash);

                if (passwordHash.equals(inputPassword)) {

                    return true;

                } else return false;

            }


            catch (SQLException throwables) {
                throwables.printStackTrace();
            }

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
    public static int insertNewDoc(String _fName, String _lName, String _mailAdd,String _salt, String _pw, String _loc, String _specF, String _healtproblem, int _isDoc, int _opHour, int _clHour) throws Exception{
        String fName = _fName;
        String lName = _lName;
        String mailAdd = _mailAdd;
        String salt = _salt;
        String pw = _pw;
        String loc = _loc;
        String specF = _specF;
        String healtproblem = _healtproblem;
        int isDoc = _isDoc;
        int opHour = _opHour;
        int clHour = _clHour;

        String sql_Insert = "INSERT INTO Users.doctor (firstName, lastName, mailAddress, salt, pwHash, location, specF, healthproblem, isDoc, opHour, clHour) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?,?)";


        Connection conn = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);


        PreparedStatement insertDoc = conn.prepareStatement(sql_Insert, Statement.RETURN_GENERATED_KEYS);
        insertDoc.setString(1, fName);
        insertDoc.setString(2,  lName);
        insertDoc.setString(3, mailAdd);
        insertDoc.setString(4, salt);
        insertDoc.setString(5, pw);
        insertDoc.setString(6, loc);
        insertDoc.setString(7, specF);
        insertDoc.setString(8, null);
        insertDoc.setInt(9, 1);
        insertDoc.setInt(10, opHour);
        insertDoc.setInt(11, clHour);


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
    public static void createTableDoctor() throws Exception{

        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Doctor(ID int NOT NULL AUTO_INCREMENT, firstName VARCHAR(255), lastName VARCHAR(255), mailAddress VARCHAR(255), pwHash VARCHAR(550), salt VARCHAR(255), location VARCHAR(255), specF VARCHAR(255), healthproblem VARCHAR(255), isDoc TINYINT, opHour INT(100), clHour INT (100), PRIMARY KEY (`ID`));");
            create.executeUpdate();

        }catch(Exception e) {System.out.println(e);

        }
        finally {System.out.println("Table Users.Doctor created");
        }
    }


    /**
     * This method creates 12 tables, one for each month.
     * The amount of time slots is calculated by using the opening and closing time the specific doctor. Each time slot has the length of 30 minutes.
     * Not used in our application because we decided for a different software design.
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
