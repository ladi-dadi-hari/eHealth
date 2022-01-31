package eHealth_GUI;

import JDBC.Connect;
import JDBC.Connect.*;
import Users.Patient;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Check_PW extends JFrame {

    public static void main(String[] args) {
        Check_PW check = new Check_PW();
        check.frame_checkPW.setVisible(true);
    }

    public JFrame frame_checkPW;
    private JTextField username;
    private JTextField password;


    public Check_PW() {
        initialize();
    }

    private void initialize() {

        frame_checkPW = new JFrame();
        frame_checkPW.setBounds(100, 100, 531, 467);
        frame_checkPW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_checkPW.getContentPane().setLayout(null);

        JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("To edit account info please verify your credentials.");
        lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewJgoodiesLabel.setBounds(100, 55, 500, 58);
        frame_checkPW.getContentPane().add(lblNewJgoodiesLabel);

        JLabel lblNewLabel = new JLabel("Username:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(109, 132, 81, 52);
        frame_checkPW.getContentPane().add(lblNewLabel);

        JLabel lblPasswort = new JLabel("Password:");
        lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPasswort.setBounds(109, 195, 89, 52);
        frame_checkPW.getContentPane().add(lblPasswort);

        username = new JTextField();
        username.setBounds(200, 132, 152, 34);
        frame_checkPW.getContentPane().add(username);
        username.setColumns(10);

        password = new JPasswordField();
        password.setColumns(10);
        password.setBounds(200, 206, 152, 34);
        frame_checkPW.getContentPane().add(password);

        JButton verifyButton = new JButton("Edit profile");
        verifyButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        verifyButton.setBounds(200, 286, 127, 34);
        frame_checkPW.getContentPane().add(verifyButton);

        verifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String u_username = username.getText();
                String u_pwd = password.getText();
                boolean exists_patient = false;

                final String sqlFetchHash_patient = "SELECT password FROM Users.patient WHERE patient_username=?";
                final String sqlFetchSalt_patient = "SELECT salt FROM Users.patient WHERE patient_username=?";


                try {
                    exists_patient = Connect.validateData(u_username, u_pwd, sqlFetchHash_patient, sqlFetchSalt_patient);

                    if (exists_patient == true) {

                            frame_checkPW.dispose();

                            JOptionPane.showMessageDialog(frame_checkPW, "Profile information is edited. Please login with new credentials");

                            return;


                        } else{
                            JOptionPane.showMessageDialog(frame_checkPW, "Verification not Successfull, please try again");
                        }

                    }catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                }


            });

    }



}

