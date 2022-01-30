package eHealth_GUI;

import JDBC.Connect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin_Page extends JFrame {


    JFrame frame_admin = new JFrame();

    JList patientList;
    JList doctorList;
    JButton editProfile;
    JButton deleteProfile;
    
    
    JPanel content;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin_Page window = new Admin_Page();
                    window.frame_admin.setVisible(true);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Admin_Page()
    {
        initilaize();
    }

    private void initilaize()
    {

        frame_admin.setBounds(50, 50, 750, 650);
        frame_admin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        content = new JPanel();
        content.setBorder(new EmptyBorder(100  , 100, 100, 100));
        frame_admin.setContentPane(content);
        content.setLayout(null);

        String[] patient = {"Hallo", "Ja", "m", "m"};

        patientList = new JList(patient);
        JScrollPane scroll_patient = new JScrollPane(patientList);
        scroll_patient.setBounds(50, 50, 300, 300);


        frame_admin.getContentPane().add(scroll_patient);

        doctorList = new JList(patient);
        JScrollPane scroll_doc = new JScrollPane(doctorList);
        scroll_doc.setBounds(400, 50, 300, 300);
        frame_admin.getContentPane().add(scroll_doc);

        editProfile = new JButton("Edit profile");
        editProfile.setBounds(400,400,100,50);
        frame_admin.getContentPane().add(editProfile);

        deleteProfile = new JButton("Delete Profile");
        deleteProfile.setBounds(200,400,100,50);
        frame_admin.getContentPane().add(deleteProfile);

        editProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        deleteProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                }
            }
        );



    }
}
