package eHealth_GUI;

import JDBC.Connect;
import Location.location;
import com.google.maps.errors.ApiException;
import com.toedter.components.JSpinField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Objects;

/**
 * <h1>Registration GUI</h1>
 * This class provides the registration interface for our patients, aswell as our doctors.
 * @author Maximilian Rabe
 *
 *
 */


public class Healthcare_Registration extends JFrame
{

    JFrame frame_register = new JFrame();

    private JLabel opHour;
    private JLabel cloHour;
    private JSpinField openHour;
    private JSpinField closeHour;
    private JTextField username;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField address;
    private JTextField birthday;
    private JTextField mailAddress;
    private JTextField password;
    private JTextField nameofinsurance;
    private JComboBox comboBox;
    private JLabel lblTheNameOf;
    private JLabel lblbirtday;
    private JRadioButton rdbtnPublic;
    private JRadioButton rdbtnPrivate;
    private JComboBox combobox_specificationF;
    private JTextField preIll;
    private Label lblspeF;
    private Label lblpreIll;
    private String typeOfInsurance;
    private int specialFieldIndex;
    private String specialField;

    ButtonGroup group_pub = new ButtonGroup();
    ButtonGroup group_prv = new ButtonGroup();


    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Healthcare_Registration window = new Healthcare_Registration();
                    window.frame_register.setVisible(true);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Healthcare_Registration()
    {
        initilaize();
    }

    private void initilaize()
    {
        frame_register.setBounds(50, 50, 750, 650);
        frame_register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(100  , 100, 100, 100));
        frame_register.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblusername.setBounds(50, 10, 81, 52);
        frame_register.getContentPane().add(lblusername);

        username = new JTextField();
        username.setBounds(50, 50, 250, 25);
        frame_register.getContentPane().add(username);
        username.setColumns(10);


        JLabel lblfirstName = new JLabel("First Name");
        lblfirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblfirstName.setBounds(50, 90, 81, 52);
        frame_register.getContentPane().add(lblfirstName);

        firstName = new JTextField();
        firstName.setBounds(50, 130, 250, 25);
        frame_register.getContentPane().add(firstName);
        firstName.setColumns(10);

        JLabel lbllastName = new JLabel("Last Name");
        lbllastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbllastName.setBounds(50, 170, 81, 52);
        frame_register.getContentPane().add(lbllastName);

        lastName = new JTextField();
        lastName.setBounds(50, 210, 250, 25);
        frame_register.getContentPane().add(lastName);
        lastName.setColumns(10);

        JLabel lbladdresse = new JLabel("Address");
        lbladdresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbladdresse.setBounds(50, 250, 81, 52);
        frame_register.getContentPane().add(lbladdresse);

        address = new JTextField();
        address.setBounds(50, 290, 250, 25);
        frame_register.getContentPane().add(address);
        address.setColumns(10);

        lblbirtday = new JLabel("Birthdate");
        lblbirtday.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblbirtday.setBounds(400, 10, 81, 52);
        frame_register.getContentPane().add(lblbirtday);
        lblbirtday.setVisible(false);

        birthday = new JTextField();
        birthday.setBounds(400, 50, 250, 25);
        frame_register.getContentPane().add(birthday);
        birthday.setColumns(10);
        birthday.setVisible(false);

        JLabel lbleMail = new JLabel("E-Mail Address");
        lbleMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbleMail.setBounds(50, 330, 120, 52);
        frame_register.getContentPane().add(lbleMail);

        mailAddress = new JTextField();
        mailAddress.setBounds(50, 370, 250, 25);
        frame_register.getContentPane().add(mailAddress);
        birthday.setColumns(10);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblpassword.setBounds(50, 410, 81, 52);
        frame_register.getContentPane().add(lblpassword);

        password = new JTextField();
        password.setBounds(50, 450, 250, 25);
        frame_register.getContentPane().add(password);
        password.setColumns(10);

        JLabel lbldocOrpat = new JLabel("Please select:");
        lbldocOrpat.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbldocOrpat.setBounds(50, 490, 100, 52);
        frame_register.getContentPane().add(lbldocOrpat);

        String ChooseDocOrPatient[] = {"-","Patient", "Doctor"};

        comboBox = new JComboBox(ChooseDocOrPatient);
        comboBox.setBounds(50, 530, 113, 22);
        frame_register.getContentPane().add(comboBox);

        lblTheNameOf = new JLabel("Name of your Insurance");
        lblTheNameOf.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTheNameOf.setBounds(400, 250, 250, 52);
        contentPane.add(lblTheNameOf);
        lblTheNameOf.setVisible(false);

        nameofinsurance = new JTextField();
        nameofinsurance.setBounds(400, 290, 250, 25);
        contentPane.add(nameofinsurance);
        nameofinsurance.setColumns(10);
        nameofinsurance.setVisible(false);

        rdbtnPublic = new JRadioButton("public");
        rdbtnPublic.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnPublic.setBounds(400, 370, 100, 25);
        contentPane.add(rdbtnPublic);
        group_pub.add(rdbtnPublic);
        rdbtnPublic.setVisible(false);

        rdbtnPrivate = new JRadioButton("private");
        rdbtnPrivate.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnPrivate.setBounds(500, 370, 100, 25);
        contentPane.add(rdbtnPrivate);
        group_prv.add(rdbtnPrivate);
        rdbtnPrivate.setVisible(false);

        enum spec {Pediatrician,
            General,
            Cardiologist,
            Pulmonologist,
            Orthopedist,
            Dentist,
            Physiotherapist,
            Allergist,
            Dermatologist,}

        lblspeF = new Label("Specification");
        lblspeF.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblspeF.setBounds(400, 23, 100, 25);
        frame_register.getContentPane().add(lblspeF);
        lblspeF.setVisible(false);

        combobox_specificationF = new JComboBox(spec.values());
        combobox_specificationF.setBounds(400, 50, 250, 25);
        frame_register.getContentPane().add(combobox_specificationF);
        combobox_specificationF.setVisible(false);

        preIll = new JTextField();
        preIll.setBounds(400, 130, 250, 100);
        frame_register.getContentPane().add(preIll);
        preIll.setColumns(10);
        preIll.setVisible(false);

        opHour = new JLabel("Opening Hour");
        opHour.setFont(new Font("Tahoma", Font.PLAIN, 8));
        opHour.setBounds(400, 170, 81, 52);
        frame_register.getContentPane().add(opHour);
        opHour.setVisible(false);

        openHour = new JSpinField();
        openHour.setBounds(400, 210, 40, 19);
        frame_register.getContentPane().add(openHour);
        openHour.setVisible(false);

        cloHour = new JLabel("Closing Hour");
        cloHour.setFont(new Font("Tahoma", Font.PLAIN, 8));
        cloHour.setBounds(460, 170, 81, 52);
        frame_register.getContentPane().add(cloHour);
        cloHour.setVisible(false);

        closeHour = new JSpinField();
        closeHour.setBounds(460, 210, 40, 19);
        frame_register.getContentPane().add(closeHour);
        closeHour.setVisible(false);

        lblpreIll = new Label("Pre-existing illness");
        lblpreIll.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblpreIll.setBounds(400, 90, 150, 52);
        frame_register.getContentPane().add(lblpreIll);
        lblpreIll.setVisible(false);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        registerButton.setBounds(400, 450, 127, 34);
        frame_register.getContentPane().add(registerButton);

        JButton cancelbutton = new JButton("Cancel");
        cancelbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cancelbutton.setBounds(400, 520, 127, 34);
        frame_register.getContentPane().add(cancelbutton);

        cancelbutton.addActionListener(e -> frame_register.dispose());




       comboBox.addActionListener(e -> {
           if(Objects.requireNonNull(comboBox.getSelectedItem()).toString().equals("Patient"))
           {
               nameofinsurance.setVisible(true);
               lblTheNameOf.setVisible(true);
               rdbtnPrivate.setVisible(true);
               rdbtnPublic.setVisible(true);
               lblbirtday.setVisible(true);
               birthday.setVisible(true);
               lblspeF.setVisible(false);
               lblpreIll.setVisible(true);
               lblspeF.setVisible(false);
               combobox_specificationF.setVisible(false);
               preIll.setVisible(true);

           }
           else if(comboBox.getSelectedItem().toString().equals("Doctor"))
           {
               nameofinsurance.setVisible(false);
               lblTheNameOf.setVisible(false);
               rdbtnPrivate.setVisible(false);
               rdbtnPublic.setVisible(false);
               lblbirtday.setVisible(false);
               birthday.setVisible(false);
               lblspeF.setVisible(true);
               lblpreIll.setVisible(false);
               lblspeF.setVisible(true);
               combobox_specificationF.setVisible(true);
               preIll.setVisible(false);
               closeHour.setVisible(true);
               openHour.setVisible(true);
               opHour.setVisible(true);
               cloHour.setVisible(true);
           }
           }
       );

        registerButton.addActionListener(arg0 -> {

        if(!username.getText().equals("admin") && !password.getText().equals("admin")){
            if(Objects.requireNonNull(comboBox.getSelectedItem()).toString().equals("Patient"))
            {
                try {
                    if(Connect.usernameOrEmailExists(username.getText(), mailAddress.getText()))
                    {

                    Connect.insertnewPatient(firstName.getText(), lastName.getText(), username.getText() ,location.checkUmlaut(address.getText()), birthday.getText(), preIll.getText(), mailAddress.getText(), password.getText(), nameofinsurance.getText(), typeOfInsurance);
                    frame_register.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame_register, "Username or Email already exists.");
                    }
                } catch (IOException | InterruptedException | ApiException e) {
                    e.printStackTrace();
                }
            }

            else if(comboBox.getSelectedItem().toString().equals("Doctor"))
            {
                if(Connect.usernameOrEmailExists(username.getText(), mailAddress.getText()))
                {
                    switch (combobox_specificationF.getSelectedIndex()){
                        case 0:
                            specialField = "Pediatrician";
                            break;
                        case 1:
                            specialField = "General";
                            break;
                        case 2:
                            specialField = "Cardiologist";
                            break;
                        case 3:
                            specialField = "Pulmonologist";
                            break;
                        case 4:
                            specialField = "Orthopedist";
                            break;
                        case 5:
                            specialField ="Dentist";
                            break;
                        case 6:
                            specialField = "Physiotherapist";
                        case 7:
                            specialField ="Allergist";
                        case 8:
                            specialField = "Dermatologist";
                        default:
                            break;
                    }
                    try
                    {
                        Connect.insertNewDoc(firstName.getText(), lastName.getText(), username.getText(), location.checkUmlaut(address.getText()), specialField,  mailAddress.getText(), password.getText(), openHour.getValue(), closeHour.getValue());
                        frame_register.dispose();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(frame_register, "Username or Email already exists.");
                }


            }

        }
        });


    }
    }




