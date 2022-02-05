package eHealth_GUI;

import JDBC.Connect;
import Users.Patient;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.CookieHandler;
import java.sql.ResultSet;
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

        patientList.addListSelectionListener(e ->
        {
            if (!e.getValueIsAdjusting())
            {
                if (!change)
                {
                    change = true;
                    doctorList.clearSelection();
                    result = patientList.getSelectedValue().toString();
                    System.out.println(result);
                    change = false;

                    deleteProfile.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Connect.deleteDoctor(result);
                        }
                    });


                    editProfile.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                Patient patient = null;
                                ResultSet rs = Connect.getPatient(result);
                                if(rs.next())
                                {
                                    String _firstname = rs.getString(2);
                                    String _lastName = rs.getString(3);
                                    String _loc = rs.getString(9);
                                    String _birthday = rs.getString(5);
                                    String _healthinfo = rs.getString(10);
                                    String _insurance = rs.getString(11);
                                    String _insuranceType = rs.getString(12);
                                    String _mailAddress = rs.getString(5);
                                    float _lng = rs.getFloat(13);
                                    float _lat = rs.getFloat(14);
                                    String _pw = "";
                                    patient = new Patient(_firstname, _lastName, _loc, _birthday, _healthinfo, _mailAddress, _pw, _insurance, _insuranceType, _lng, _lat);
                                }

                                Edit_Profile pat = new Edit_Profile(patient);
                                pat.frame_edit.setVisible(true);

                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }

                        }
                    });
                }

            }

        });

        doctorList.addListSelectionListener(e ->
        {
            if (!e.getValueIsAdjusting()) {
                if (!change) {
                    change = true;
                    patientList.clearSelection();
                    result = doctorList.getSelectedValue().toString();

                    deleteProfile.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Connect.deleteDoctor(result);
                        }
                    });


                    editProfile.addActionListener(e1 -> {
                        try {
                            ResultSet rs = Connect.getDoctor(result);
                            while(rs.next()){
                                System.out.println(rs);}
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                    });

                    System.out.println(result);
                    change = false;
                }
            }

        });


    }
}
