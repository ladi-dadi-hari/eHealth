package eHealth_GUI;

import JDBC.Connect;
import com.google.maps.errors.ApiException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class Healthcare_Register extends JFrame
{

    JFrame frame_register = new JFrame();


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
    private JTextField specificationF;
    private JTextField healthproblem;
    private Label lblspeF;
    private Label lblHP;
    private String typeOfInsurance;

    ButtonGroup group_pub = new ButtonGroup();
    ButtonGroup group_prv = new ButtonGroup();


    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Healthcare_Register window = new Healthcare_Register();
                    window.frame_register.setVisible(true);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Healthcare_Register()
    {
        initilaize();
    }

    private void initilaize()
    {
        frame_register.setBounds(50, 50, 750, 650);
        frame_register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        lblTheNameOf.setBounds(400, 90, 250, 52);
        contentPane.add(lblTheNameOf);
        lblTheNameOf.setVisible(false);

        nameofinsurance = new JTextField();
        nameofinsurance.setBounds(400, 130, 250, 25);
        contentPane.add(nameofinsurance);
        nameofinsurance.setColumns(10);
        nameofinsurance.setVisible(false);

        rdbtnPublic = new JRadioButton("public");
        rdbtnPublic.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnPublic.setBounds(400, 170, 100, 25);
        contentPane.add(rdbtnPublic);
        group_pub.add(rdbtnPublic);
        rdbtnPublic.setVisible(false);

        rdbtnPrivate = new JRadioButton("private");
        rdbtnPrivate.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnPrivate.setBounds(500, 170, 100, 25);
        contentPane.add(rdbtnPrivate);
        group_prv.add(rdbtnPrivate);
        rdbtnPrivate.setVisible(false);

        lblspeF = new Label("Specification");
        lblspeF.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblspeF.setBounds(400, 23, 100, 25);
        frame_register.getContentPane().add(lblspeF);
        lblspeF.setVisible(false);

        specificationF = new JTextField();
        specificationF.setBounds(400, 50, 250, 25);
        frame_register.getContentPane().add(specificationF);
        specificationF.setColumns(10);
        specificationF.setVisible(false);

        lblHP = new Label("Health Problems");
        lblHP.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblHP.setBounds(400, 90, 110, 25);
        frame_register.getContentPane().add(lblHP);
        lblHP.setVisible(false);

        healthproblem = new JTextField();
        healthproblem.setBounds(400, 130, 250, 25);
        frame_register.getContentPane().add(healthproblem);
        healthproblem.setColumns(10);
        healthproblem.setVisible(false);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        registerButton.setBounds(400, 370, 127, 34);
        frame_register.getContentPane().add(registerButton);

        JButton cancelbutton = new JButton("Cancel");
        cancelbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cancelbutton.setBounds(400, 440, 127, 34);
        frame_register.getContentPane().add(cancelbutton);

        cancelbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_register.dispose();
            }
        });


        rdbtnPrivate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rdbtnPrivate.isSelected())
                {
                    typeOfInsurance = "private";
                    group_pub.clearSelection();

                }
            }
        });

        rdbtnPublic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rdbtnPublic.isSelected())
                {
                    typeOfInsurance = "public";
                    group_prv.clearSelection();
                }
            }
        });

       comboBox.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(comboBox.getSelectedItem().toString().equals("Patient"))
               {
                   nameofinsurance.setVisible(true);
                   lblTheNameOf.setVisible(true);
                   rdbtnPrivate.setVisible(true);
                   rdbtnPublic.setVisible(true);
                   lblbirtday.setVisible(true);
                   birthday.setVisible(true);
                   lblspeF.setVisible(false);
                   lblHP.setVisible(false);
                   lblspeF.setVisible(false);
                   specificationF.setVisible(false);
                   healthproblem.setVisible(false);

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
                   lblHP.setVisible(true);
                   lblspeF.setVisible(true);
                   specificationF.setVisible(true);
                   healthproblem.setVisible(true);
               }
               }

           }
       );

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {


                if(comboBox.getSelectedItem().toString().equals("Patient"))
                {
                    try {
                        if(Connect.usernameOrEmailExists(username.getText(), mailAddress.getText()))
                        {
                        Connect.insertnewPatient(firstName.getText(), lastName.getText(), username.getText() ,address.getText(), birthday.getText(), "ay", mailAddress.getText(), password.getText(), nameofinsurance.getText(), typeOfInsurance);
                        frame_register.dispose();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(frame_register, "Username or Email already exists.");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }
                }

                else if(comboBox.getSelectedItem().toString().equals("Doctor"))
                {
                    if(Connect.usernameOrEmailExists(username.getText(), mailAddress.getText()))
                    {
                        try
                        {
                            Connect.insertNewDoc(firstName.getText(), lastName.getText(), username.getText(),address.getText(), specificationF.getText(),  mailAddress.getText(), password.getText());
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




