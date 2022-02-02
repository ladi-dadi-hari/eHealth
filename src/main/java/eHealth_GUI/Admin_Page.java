package eHealth_GUI;

import JDBC.Connect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Admin_Page extends JFrame {


    JFrame frame_admin = new JFrame();


    JList patientList;
    JList doctorList;
    JButton editProfile;
    JButton deleteProfile;
    List<String> users = new ArrayList<>();
    int i = 0;
    boolean change = false;
    String result;


    JPanel content;

    public String[] doctorResults() {

        final String docs_sql = "SELECT doctor_username FROM Users.doctor";
        try {
            users = Connect.getAllUsers(docs_sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] doctors = new String[users.size()];

        for (i = 0; i < users.size(); i++) {
            String docResult = String.valueOf(users.get(i));

            //remove brackets:
            docResult = docResult.replace("[", "");
            docResult = docResult.replace("]", "");

            doctors[i] = docResult;
        }
        return doctors;
    }

    public String[] patientsResults(){

        final String pats_sql = "SELECT patient_username FROM Users.patient";
        try
        {
            users = Connect.getAllUsers(pats_sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        String[] patients = new String[users.size()];

        for (i = 0; i < users.size(); i++)
        {
            String patResults = String.valueOf(users.get(i));

            //remove brackets:
            patResults = patResults.replace("[", "");
            patResults = patResults.replace("]", "");

            patients[i] = patResults;
        }
         return patients;
    }


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

    public Admin_Page(){
        initilaize();
    }

    private void initilaize() {

        frame_admin.setBounds(50, 50, 750, 650);
        frame_admin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        content = new JPanel();
        content.setBorder(new EmptyBorder(100, 100, 100, 100));
        frame_admin.setContentPane(content);
        content.setLayout(null);

        patientList = new JList(patientsResults());

        JScrollPane scroll_patient = new JScrollPane(patientList);
        scroll_patient.setBounds(50, 50, 300, 300);

        frame_admin.getContentPane().add(scroll_patient);

        doctorList = new JList(doctorResults());
        JScrollPane scroll_doc = new JScrollPane(doctorList);
        scroll_doc.setBounds(400, 50, 300, 300);
        frame_admin.getContentPane().add(scroll_doc);

        editProfile = new JButton("Edit profile");
        editProfile.setBounds(400, 400, 100, 50);
        frame_admin.getContentPane().add(editProfile);

        deleteProfile = new JButton("Delete Profile");
        deleteProfile.setBounds(200, 400, 100, 50);
        frame_admin.getContentPane().add(deleteProfile);

        patientList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting())
                {
                    if (!change)
                    {
                        change = true;
                        doctorList.clearSelection();
                        result = patientList.getSelectedValue().toString();
                        System.out.println(result);
                        change = false;
                    }

                }
        }
        });

        doctorList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (!change) {
                        change = true;
                        patientList.clearSelection();
                        result = doctorList.getSelectedValue().toString();
                        System.out.println(result);
                        change = false;
                    }
                }
                deleteProfile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Connect.deleteDoctor(result);
                    }
                });
            }
        });

        deleteProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connect.deletePatient(result);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        editProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

    }
}
