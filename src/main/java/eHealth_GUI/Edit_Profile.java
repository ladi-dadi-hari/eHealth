package eHealth_GUI;

import JDBC.Connect;
import Location.location;
import Users.Patient;
import com.google.maps.errors.ApiException;
import com.toedter.components.JSpinField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * <h1>Edit Profile page</h1>
 *
 * On this page the user can edit his profile information.
 * To write it to the database, the user has to validate his password.
 *
 * @author  logic: Harris Nuhanovic
 *          GUI: mainly Maximilian Rabe (see Healthcare_Registration.java)
 *
 */


public class Edit_Profile extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    Edit_Profile edit = new Edit_Profile("Dr Stone");
                    edit.frame_edit.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public JFrame frame_edit = new JFrame();



    //private JTextField username;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField address;
    private JTextField birthday;
    private JTextField mailAddress;
    private JTextField nameofinsurance;
    private JLabel lblbirtday;
    private JTextField password1;
    private JTextField password2;
    private JLabel lblTheNameOf;
    private Label lblpreIll;
    private JTextField preIll;
    private String typeOfInsurance;
    private JRadioButton rdbtnPublic;
    private JRadioButton rdbtnPrivate;
    private JLabel lblspeF;
    private JComboBox combobox_specificationF;
    private JLabel opHour;
    private JLabel cloHour;
    private JSpinField closeHour;
    private JSpinField openHour;

    ButtonGroup group_pub = new ButtonGroup();
    ButtonGroup group_prv = new ButtonGroup();


    private JPanel contentPane;

    public Edit_Profile(Patient patient) {
        initialize(patient);
    }

    public Edit_Profile(String username) throws SQLException {

        ResultSet rs = Connect.getDoctor(username);
        String first = "";
        String last = "";
        String user = username;
        String add = "";
        String spec = "";
        String mail = "";
        int opening = 0;
        int closing = 0;

        if(rs.next())
        {
            first = rs.getString(2);
            last = rs.getString(3);
            add = rs.getString(5);
            spec = rs.getString(6);
            mail = rs.getString(7);
            opening = rs.getInt(12);
            closing = rs.getInt(13);
        }

        initialize(first, last, user, add, spec, mail, opening, closing);}

    private void initialize(Patient patient) {

        frame_edit.setBounds(100, 100, 750, 650);
        frame_edit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        contentPane = new JPanel();
        frame_edit.setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


        JLabel lblusername = new JLabel("Username: " + patient.getUsername());
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblusername.setBounds(50, 20, 300, 52);
        frame_edit.getContentPane().add(lblusername);


        JLabel lblfirstName = new JLabel("First Name");
        lblfirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblfirstName.setBounds(50, 90, 81, 52);
        frame_edit.getContentPane().add(lblfirstName);

        firstName = new JTextField(patient.getFirstName());
        firstName.setBounds(50, 130, 250, 25);
        frame_edit.getContentPane().add(firstName);
        firstName.setColumns(10);
        Objects.requireNonNull(firstName);


        JLabel lbllastName = new JLabel("Last Name");
        lbllastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbllastName.setBounds(50, 170, 81, 52);
        frame_edit.getContentPane().add(lbllastName);

        lastName = new JTextField(patient.getLastName());
        lastName.setBounds(50, 210, 250, 25);
        frame_edit.getContentPane().add(lastName);
        lastName.setColumns(10);
        Objects.requireNonNull(lastName);



        JLabel lbladdresse = new JLabel("Address");
        lbladdresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbladdresse.setBounds(50, 250, 81, 52);
        frame_edit.getContentPane().add(lbladdresse);

        address = new JTextField(patient.getLocation());
        address.setBounds(50, 290, 250, 25);
        frame_edit.getContentPane().add(address);
        address.setColumns(10);
        Objects.requireNonNull(address);


        lblbirtday = new JLabel("Birthdate");
        lblbirtday.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblbirtday.setBounds(400, 10, 81, 52);
        frame_edit.getContentPane().add(lblbirtday);
        lblbirtday.setVisible(true);

        birthday = new JTextField(patient.getBirthday());
        birthday.setBounds(400, 50, 250, 25);
        frame_edit.getContentPane().add(birthday);
        birthday.setColumns(10);
        birthday.setVisible(true);
        Objects.requireNonNull(birthday);


        JLabel lbleMail = new JLabel("E-Mail Address");
        lbleMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbleMail.setBounds(50, 330, 120, 52);
        frame_edit.getContentPane().add(lbleMail);

        mailAddress = new JTextField(patient.getMailAddress());
        mailAddress.setBounds(50, 370, 250, 25);
        frame_edit.getContentPane().add(mailAddress);
        birthday.setColumns(10);
        Objects.requireNonNull(mailAddress);


        JLabel lblpassword = new JLabel("verify Password");
        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblpassword.setBounds(50, 410, 150, 52);
        frame_edit.getContentPane().add(lblpassword);

        password1 = new JPasswordField();
        password1.setBounds(50, 450, 250, 25);
        frame_edit.getContentPane().add(password1);
        password1.setColumns(10);
        Objects.requireNonNull(password1);

        password2 = new JPasswordField();
        password2.setBounds(50, 500, 250, 25);
        frame_edit.getContentPane().add(password2);
        password2.setColumns(10);
        Objects.requireNonNull(password2);


        lblTheNameOf = new JLabel("Name of your Insurance");
        lblTheNameOf.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTheNameOf.setBounds(400, 250, 250, 52);
        contentPane.add(lblTheNameOf);
        lblTheNameOf.setVisible(true);

        nameofinsurance = new JTextField(patient.getInsurance());
        nameofinsurance.setBounds(400, 290, 250, 25);
        contentPane.add(nameofinsurance);
        nameofinsurance.setColumns(10);
        nameofinsurance.setVisible(true);
        Objects.requireNonNull(nameofinsurance);

        rdbtnPublic = new JRadioButton("public", true);
        rdbtnPublic.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnPublic.setBounds(400, 370, 100, 25);
        contentPane.add(rdbtnPublic);
        group_pub.add(rdbtnPublic);
        rdbtnPublic.setVisible(true);

        rdbtnPrivate = new JRadioButton("private");
        rdbtnPrivate.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnPrivate.setBounds(500, 370, 100, 25);
        contentPane.add(rdbtnPrivate);
        group_prv.add(rdbtnPrivate);
        rdbtnPrivate.setVisible(true);

        preIll = new JTextField(patient.getHealthInfo());
        preIll.setBounds(400, 130, 250, 100);
        frame_edit.getContentPane().add(preIll);
        preIll.setColumns(10);
        preIll.setVisible(true);

        lblpreIll = new Label("Pre-existing illness");
        lblpreIll.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblpreIll.setBounds(400, 90, 150, 52);
        frame_edit.getContentPane().add(lblpreIll);
        lblpreIll.setVisible(true);


        JButton editButton = new JButton("Edit Profile");
        editButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        editButton.setBounds(400, 450, 127, 34);
        frame_edit.getContentPane().add(editButton);

        JButton cancelbutton = new JButton("Cancel");
        cancelbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cancelbutton.setBounds(400, 520, 127, 34);
        frame_edit.getContentPane().add(cancelbutton);

        cancelbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame_edit.dispose();
                Healthcare_Entry entry = new Healthcare_Entry(patient);
                entry.setVisible(true);

            }
        });

        rdbtnPrivate.addActionListener(e -> {
            if(rdbtnPrivate.isSelected())
            {
                typeOfInsurance = "private";
                group_pub.clearSelection();

            }
        });

        rdbtnPublic.addActionListener(e -> {
            if (rdbtnPublic.isSelected()) {
                typeOfInsurance = "public";
                group_prv.clearSelection();
            }
        });


        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (password1.getText().length() == 0) {

                    JOptionPane.showMessageDialog(frame_edit, "To edit your account, you have to validate your password!");
                    frame_edit.setVisible(true);
                    return;

                } else if (!Objects.equals(password1.getText(), password2.getText())) {

                    JOptionPane.showMessageDialog(frame_edit, "Passwords do not match!");
                    frame_edit.setVisible(true);
                    return;

                } else if ((firstName.getText().length() == 0) || (lastName.getText().length() == 0) || (address.getText().length() == 0) || (mailAddress.getText().length() == 0) || (birthday.getText().length() == 0) || (nameofinsurance.getText().length() == 0)) {

                    JOptionPane.showMessageDialog(frame_edit, "All fields have to be filled out!");
                    frame_edit.setVisible(true);
                    return;

                } else if (Connect.emailExists(mailAddress.getText()) && (Objects.equals(patient.getMailAddress(), mailAddress.getText()))) {

                    frame_edit.setVisible(false);

                    //Check_PW check = new Check_PW();
                    //check.frame_checkPW.setVisible(true);

                    try {
                        Connect.deletePatient(patient.getUsername());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        Connect.insertnewPatient(firstName.getText(), lastName.getText(), patient.getUsername(), location.checkUmlaut(address.getText()), birthday.getText(), preIll.getText(), mailAddress.getText(), password1.getText(), nameofinsurance.getText(), typeOfInsurance);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    } catch (ApiException ex) {
                        ex.printStackTrace();
                    }
                    frame_edit.dispose();

                    patient.logOutPat(patient);

                    JOptionPane.showMessageDialog(frame_edit, "Account information edited. Please login again.");

                    Healthcare_Login login = new Healthcare_Login();
                    login.frame.setVisible(true);

                    return;

                } else if (Connect.emailExists(mailAddress.getText())) {

                    JOptionPane.showMessageDialog(frame_edit, "This mail address already exists. Please try another one");
                    frame_edit.setVisible(true);
                    return;

                } else {

                    frame_edit.setVisible(false);


                    try {
                        Connect.deletePatient(patient.getUsername());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        Connect.insertnewPatient(firstName.getText(), lastName.getText(), patient.getUsername(), location.checkUmlaut(address.getText()), birthday.getText(), preIll.getText(), mailAddress.getText(), password1.getText(), nameofinsurance.getText(), typeOfInsurance);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    } catch (ApiException ex) {
                        ex.printStackTrace();
                    }
                    frame_edit.dispose();

                    patient.logOutPat(patient);

                    JOptionPane.showMessageDialog(frame_edit, "Account information edited. Login with your new credentials.");

                    Healthcare_Login login = new Healthcare_Login();
                    login.frame.setVisible(true);

                    return;

                }


            }


        });
    }


    /**
     * This method uses another constructor to initialize the Jframe frame_edit,
     * since it was needed to split the edit_profile functionality between the doctor and the patient.
     * The functionality stays the same as in the other initialize method in the edit_profile class.
     *
     * @param first
     * @param last
     * @param username
     * @param add
     * @param specF
     * @param mail
     * @param opening
     * @param closing
     * @author Maximilian Rabe
     */

    private void initialize(String first, String last, String username,  String add, String specF, String mail, int opening, int closing) {

        frame_edit.setBounds(100, 100, 750, 650);
        frame_edit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        contentPane = new JPanel();
        frame_edit.setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


        JLabel lblusername = new JLabel("Username: " + username);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblusername.setBounds(50, 20, 300, 52);
        frame_edit.getContentPane().add(lblusername);


        JLabel lblfirstName = new JLabel("First Name");
        lblfirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblfirstName.setBounds(50, 90, 81, 52);
        frame_edit.getContentPane().add(lblfirstName);

        firstName = new JTextField(first);
        firstName.setBounds(50, 130, 250, 25);
        frame_edit.getContentPane().add(firstName);
        firstName.setColumns(10);
        Objects.requireNonNull(firstName);


        JLabel lbllastName = new JLabel("Last Name");
        lbllastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbllastName.setBounds(50, 170, 81, 52);
        frame_edit.getContentPane().add(lbllastName);

        lastName = new JTextField(last);
        lastName.setBounds(50, 210, 250, 25);
        frame_edit.getContentPane().add(lastName);
        lastName.setColumns(10);
        Objects.requireNonNull(lastName);


        JLabel lbladdresse = new JLabel("Address");
        lbladdresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbladdresse.setBounds(50, 250, 81, 52);
        frame_edit.getContentPane().add(lbladdresse);

        address = new JTextField(add);
        address.setBounds(50, 290, 250, 25);
        frame_edit.getContentPane().add(address);
        address.setColumns(10);
        Objects.requireNonNull(address);


        JLabel lbleMail = new JLabel("E-Mail Address");
        lbleMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbleMail.setBounds(50, 330, 120, 52);
        frame_edit.getContentPane().add(lbleMail);

        mailAddress = new JTextField(mail);
        mailAddress.setBounds(50, 370, 250, 25);
        frame_edit.getContentPane().add(mailAddress);
        Objects.requireNonNull(mailAddress);


        JLabel lblpassword = new JLabel("verify Password");
        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblpassword.setBounds(50, 410, 150, 52);
        frame_edit.getContentPane().add(lblpassword);

        password1 = new JPasswordField();
        password1.setBounds(50, 450, 250, 25);
        frame_edit.getContentPane().add(password1);
        password1.setColumns(10);
        Objects.requireNonNull(password1);

        password2 = new JPasswordField();
        password2.setBounds(50, 500, 250, 25);
        frame_edit.getContentPane().add(password2);
        password2.setColumns(10);
        Objects.requireNonNull(password2);

        enum spec {
            General,
            Dermatologist,
            Orthopedist,
            Allergist};

        lblspeF = new JLabel("Specification");
        lblspeF.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblspeF.setBounds(400, 23, 100, 25);
        frame_edit.getContentPane().add(lblspeF);

        combobox_specificationF = new JComboBox(spec.values());
        switch (specF)
        {
            case "General":
                combobox_specificationF.setSelectedIndex(0);
                break;
            case "Dermatologist":
                combobox_specificationF.setSelectedIndex(1);
                break;
            case "Orthopedist":
                combobox_specificationF.setSelectedIndex(2);
                break;
            case "Allergist":
                combobox_specificationF.setSelectedIndex(3);
                break;
        }
        combobox_specificationF.setBounds(400, 50, 250, 25);
        frame_edit.getContentPane().add(combobox_specificationF);

        opHour = new JLabel("Opening Hour");
        opHour.setFont(new Font("Tahoma", Font.PLAIN, 8));
        opHour.setBounds(400, 170, 81, 52);
        frame_edit.getContentPane().add(opHour);

        openHour = new JSpinField();
        openHour.setValue(opening);
        openHour.setBounds(400, 210, 40, 19);
        frame_edit.getContentPane().add(openHour);

        cloHour = new JLabel("Closing Hour");
        cloHour.setFont(new Font("Tahoma", Font.PLAIN, 8));
        cloHour.setBounds(460, 170, 81, 52);
        frame_edit.getContentPane().add(cloHour);

        closeHour = new JSpinField();
        closeHour.setValue(closing);
        closeHour.setBounds(460, 210, 40, 19);
        frame_edit.getContentPane().add(closeHour);


        JButton editButton = new JButton("Edit Profile");
        editButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        editButton.setBounds(400, 450, 127, 34);
        frame_edit.getContentPane().add(editButton);

        JButton cancelbutton = new JButton("Cancel");
        cancelbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cancelbutton.setBounds(400, 520, 127, 34);
        frame_edit.getContentPane().add(cancelbutton);

        cancelbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame_edit.dispose();

            }
        });


        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (password1.getText().length() == 0) {

                    JOptionPane.showMessageDialog(frame_edit, "To edit your account, you have to validate your password!");
                    frame_edit.setVisible(true);
                    return;

                } else if (!Objects.equals(password1.getText(), password2.getText())) {

                    JOptionPane.showMessageDialog(frame_edit, "Passwords do not match!");
                    frame_edit.setVisible(true);
                    return;

                } else if ((firstName.getText().length() == 0) || (lastName.getText().length() == 0) || (address.getText().length() == 0) || (mailAddress.getText().length() == 0)) {

                    JOptionPane.showMessageDialog(frame_edit, "All fields have to be filled out!");
                    frame_edit.setVisible(true);
                    return;

                } else if (Connect.emailExists(mailAddress.getText())) {

                    JOptionPane.showMessageDialog(frame_edit, "This mail address already exists. Please try another one");
                    frame_edit.setVisible(true);
                    return;

                } else {

                    frame_edit.setVisible(false);

                    Connect.deleteDoctor(username);

                    try {
                        Connect.insertNewDoc(firstName.getText(), lastName.getText(), username, location.checkUmlaut(address.getText()), combobox_specificationF.getSelectedItem().toString() ,mailAddress.getText(), password1.getText(), openHour.getValue(), closeHour.getValue());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    frame_edit.dispose();

                    JOptionPane.showMessageDialog(frame_edit, "Account information edited.");

                    return;


                }


            }


        });
    }


}



