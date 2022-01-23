package JDBC;

import Hashing.Hashing;

import java.sql.*;

public class Connect {

    static final String DB_URL = "jdbc:mysql://localhost:3306/Users";
    static final String USER = "root";
    static final String AUTH_STRING ="****";




    public static void create_user (String _firstName, String _lastName, String _adress, String _birthday, String _healthInfo, String _mailAdress, String _salt, String _pw, String _insurance, String _insuranceType, boolean _isDoc){


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
        boolean isDoc = _isDoc;


        String sql_Insert = "INSERT INTO Users.Users (firstName, lastName, adress, birthday, healthInfo, mailAdress, salt, pw_hash, insurance, insuranceType, isDoc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


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
            createNewUser.setBoolean(11, isDoc);

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

        String inputPassword = password;

        String passwordHash = null;
        String salt = null;

        String sqlFetchHash = "SELECT pw_hash FROM Users.Users WHERE mailAdress=?";
        String sqlFetchSalt = "SELECT salt FROM Users.Users WHERE mailAdress=?";

        try {

            Connection con = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);

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

}
