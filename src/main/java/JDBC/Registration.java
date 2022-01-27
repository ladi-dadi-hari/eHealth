package JDBC;

import java.sql.*;

import static JDBC.Connect.DB_URL;
import static JDBC.Connect.USER;
import static JDBC.Connect.AUTH_STRING;

public class Registration {



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


}
