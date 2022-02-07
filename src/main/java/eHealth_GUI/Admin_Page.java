package eHealth_GUI;

import JDBC.Connect;
import Users.Doctor;
import Users.Patient;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Admin Page GUI + Functionality</h1>
 * This class contains all of the GUI elements and funtionalities used by the admin.
 * The admin is able to select every single user in our system, select him/her and delete or edit the selected user.
 * The selection is done through two JLists, one for the doctor and one for the patients, since there aren't any other user types, except the admin himself/herself.
 */


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

    /**
     * This functions allows each JList to be filled with every doctor existing in our system.
     * By simply passing an SQL Statement, to the method getAllUsers, which only selects the doctors and not the patients.
     * Since we didn't implement a way to differentiate between patient and doctor, after they have been
     * returned as an ResultSet from the database, we simply split the methods into two one for all doctors and one for all patients.
     * @return String Array with every doctor found in our database
     */

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

    /**
     * This method has the same functionality as the doctorResults method above, but for the patients.
     * @return String Array containing all patients in our database.
     */
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

    /**
     * The method initialize contains all our GUI elements used for the admin page.
     * It displays all existing user in our system, split into two JLists. One JList contains all patients and the other one contains all doctors.
     * The admin can then select one user, and press either the JButton editProfile or the other JButton deleteProfile.
     */

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

        /**
         * For the both JLists it is necessary to have two boolean call ups.
         * One boolean call up is to avoid that the selected user gets put twice into the result String.
         * This happens, because the ListSelectionListener has two call ups, when something is selected from a JLIst.
         * One happens, when the admin clicks on a user, the name of the user gets stored and the other one happens when the press of the mouse is released.
         * The other boolean call up gets shared between both JLists, so there can't be two selected users at the same time.
         */
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
