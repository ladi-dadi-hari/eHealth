package eHealth_GUI;

import JDBC.Connect;


import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.table.TableModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import static JDBC.Connect.confirmAppointment;

public class Manage_Appointment_doc extends JFrame {

    private JPanel contentPane;
    private JLabel lbDate;
    private JLabel lbDate1;
    private JLabel lbTime1;
    private JLabel lbName1;
    private JLabel lbHealthP1;
    private JLabel lbMail1;
    private JLabel lbDate2;
    private JLabel lbDate3;
    private JLabel lbDate4;
    private JLabel lbTime2;
    private JLabel lbTime3;
    private JLabel lbTime4;
    private JLabel lbName2;
    private JLabel lbName3;
    private JLabel lbName4;
    private JLabel lbHealthP2;
    private JLabel lbHealthP3;
    private JLabel lbHealthP4;
    private JCheckBox checkBox4;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JLabel lbMail2;
    private JLabel lbMail3;
    private JLabel lbMail4;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Manage_Appointment_doc frame = new Manage_Appointment_doc("doctormailing");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Manage_Appointment_doc(String doctorMail) throws SQLException {
        ResultSet appointments = JDBC.Connect.getAppointments(doctorMail);

        JTable resTab =  new JTable();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 859, 421);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnOK1 = new JButton("Confirm");
        btnOK1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    appointments.absolute(1);
                    confirmAppointment(appointments.getString(6), appointments.getDate(2));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnOK1.setBounds(655, 58, 85, 21);
        contentPane.add(btnOK1);

        JButton btnCancel1 = new JButton("Cancel");
        btnCancel1.setBounds(750, 58, 85, 21);
        contentPane.add(btnCancel1);


        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(750, 332, 85, 21);
        contentPane.add(btnExit);

        lbDate = new JLabel("Date");
        lbDate.setFont(new Font("Tahoma", Font.BOLD, 13));
        lbDate.setBounds(10, 24, 45, 13);
        contentPane.add(lbDate);

        JLabel lbTime = new JLabel("Time");
        lbTime.setFont(new Font("Tahoma", Font.BOLD, 13));
        lbTime.setBounds(103, 24, 45, 13);
        contentPane.add(lbTime);

        JLabel lbName = new JLabel("Name");
        lbName.setFont(new Font("Tahoma", Font.BOLD, 13));
        lbName.setBounds(192, 24, 75, 13);
        contentPane.add(lbName);

        JLabel lbHealthProblem = new JLabel("Healthproblems");
        lbHealthProblem.setFont(new Font("Tahoma", Font.BOLD, 13));
        lbHealthProblem.setBounds(277, 24, 112, 13);
        contentPane.add(lbHealthProblem);

        JLabel lbMail = new JLabel("Mailaddress");
        lbMail.setFont(new Font("Tahoma", Font.BOLD, 13));
        lbMail.setBounds(428, 24, 85, 13);
        contentPane.add(lbMail);

        //Move to first row in ResultSet
            appointments.absolute(1);


            lbDate1 = new JLabel("");
            lbDate1.setFont(new Font("Tahoma", Font.PLAIN, 8));
            setLbDate1Text(appointments.getDate(2).toString());
            lbDate1.setBounds(10, 66, 83, 13);
            contentPane.add(lbDate1);

            lbTime1 = new JLabel("");
            lbTime1.setFont(new Font("Tahoma", Font.PLAIN, 8));
            setLbTime1Text(appointments.getTime(3).toString());
            lbTime1.setBounds(103, 66, 79, 13);
            contentPane.add(lbTime1);

            lbName1 = new JLabel("");
            lbName1.setFont(new Font("Tahoma", Font.PLAIN, 8));
            setLbName1Text(appointments.getString(4));
            lbName1.setBounds(192, 66, 75, 13);
            contentPane.add(lbName1);

            lbHealthP1 = new JLabel("");
            lbHealthP1.setHorizontalAlignment(SwingConstants.LEFT);
            lbHealthP1.setVerticalAlignment(SwingConstants.TOP);
            lbHealthP1.setFont(new Font("Tahoma", Font.PLAIN, 8));
            setLbHealthP1Text(appointments.getString(5));
            lbHealthP1.setBounds(277, 67, 112, 40);
            contentPane.add(lbHealthP1);

            lbMail1 = new JLabel("");
            lbMail1.setFont(new Font("Tahoma", Font.PLAIN, 8));
            setLbMail1Text(appointments.getString(6));
            lbMail1.setBounds(428, 66, 101, 13);
            contentPane.add(lbMail1);

            checkBox1 = new JCheckBox("");
            checkBox1.setBounds(589, 58, 32, 21);
            setCheckBox1Selected(appointments.getBoolean(7));
            contentPane.add(checkBox1);

            //Move to second row
           // appointments.absolute(2);
            //appointments.next();

            lbDate2 = new JLabel("");
            lbDate2.setFont(new Font("Tahoma", Font.PLAIN, 8));
            if(appointments.isLast()){}
            else {
                appointments.next();
                setLbDate2Text(appointments.getDate(2).toString());
                lbDate2.setBounds(10, 132, 83, 13);
                contentPane.add(lbDate2);

                lbTime2 = new JLabel("");
                lbTime2.setFont(new Font("Tahoma", Font.PLAIN, 8));
                setLbTime2Text(appointments.getTime(3).toString());
                lbTime2.setBounds(103, 132, 79, 13);
                contentPane.add(lbTime2);

                lbName2 = new JLabel("");
                lbName2.setFont(new Font("Tahoma", Font.PLAIN, 8));
                setLbName2Text(appointments.getString(4));
                lbName2.setBounds(192, 132, 75, 13);
                contentPane.add(lbName2);

                lbHealthP2 = new JLabel("");
                lbHealthP2.setHorizontalAlignment(SwingConstants.LEFT);
                lbHealthP2.setVerticalAlignment(SwingConstants.TOP);
                lbHealthP2.setFont(new Font("Tahoma", Font.PLAIN, 8));
                setLbHealthP2Text(appointments.getString(5));
                lbHealthP2.setBounds(277, 133, 112, 40);
                contentPane.add(lbHealthP2);

                lbMail2 = new JLabel("");
                lbMail2.setFont(new Font("Tahoma", Font.PLAIN, 8));
                setLbMail2Text(appointments.getString(6));
                lbMail2.setBounds(428, 132, 101, 13);
                contentPane.add(lbMail2);

                checkBox2 = new JCheckBox("");
                checkBox2.setBounds(589, 124, 32, 21);
                setCheckBox2Selected(appointments.getBoolean(7));
                contentPane.add(checkBox2);

                JButton btnOK2 = new JButton("Confirm");
                btnOK2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        try {
                            appointments.absolute(2);
                            confirmAppointment(appointments.getString(6), appointments.getDate(2));
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                btnOK2.setBounds(655, 124, 85, 21);
                contentPane.add(btnOK2);

                JButton btnCancel2 = new JButton("Cancel");
                btnCancel2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    }
                });
                btnCancel2.setBounds(750, 124, 85, 21);
                contentPane.add(btnCancel2);
            }


            //Move to 3rd row

            lbDate3 = new JLabel("");
            lbDate3.setFont(new Font("Tahoma", Font.PLAIN, 8));
            if(appointments.isLast()){}
            else {
                appointments.next();
                setLbDate3Text(appointments.getDate(2).toString());

                lbDate3.setBounds(10, 205, 83, 13);
                contentPane.add(lbDate3);

                lbTime3 = new JLabel("");
                lbTime3.setFont(new Font("Tahoma", Font.PLAIN, 8));
                setLbTime3Text(appointments.getTime(3).toString());

                lbTime3.setBounds(103, 205, 79, 13);
                contentPane.add(lbTime3);

                lbName3 = new JLabel("");
                lbName3.setFont(new Font("Tahoma", Font.PLAIN, 8));
                setLbName3Text(appointments.getString(4));
                lbName3.setBounds(192, 205, 75, 13);
                contentPane.add(lbName3);

                lbHealthP3 = new JLabel("");
                lbHealthP3.setHorizontalAlignment(SwingConstants.LEFT);
                lbHealthP3.setVerticalAlignment(SwingConstants.TOP);
                lbHealthP3.setFont(new Font("Tahoma", Font.PLAIN, 8));
                setLbHealthP3Text(appointments.getString(5));
                lbHealthP3.setBounds(277, 206, 112, 40);
                contentPane.add(lbHealthP3);

                lbMail3 = new JLabel("");
                lbMail3.setFont(new Font("Tahoma", Font.PLAIN, 8));
                setLbMail3Text(appointments.getString(6));
                lbMail3.setBounds(428, 205, 101, 13);
                contentPane.add(lbMail3);

                checkBox3 = new JCheckBox("");
                checkBox3.setBounds(589, 197, 32, 21);
                setCheckBox3Selected(appointments.getBoolean(7));
                contentPane.add(checkBox3);

                JButton btnOK3 = new JButton("Confirm");
                btnOK3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        try {
                            appointments.absolute(3);
                            confirmAppointment(appointments.getString(6), appointments.getDate(2));
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                btnOK3.setBounds(655, 197, 85, 21);
                contentPane.add(btnOK3);

                JButton btnCancel3 = new JButton("Cancel");
                btnCancel3.setBounds(750, 197, 85, 21);
                contentPane.add(btnCancel3);
            }


            //Move to 4th row

            lbDate4 = new JLabel("");
            lbDate4.setFont(new Font("Tahoma", Font.PLAIN, 8));
            if(appointments.isLast()){}
            else {
                appointments.next();
                setLbDate4Text(appointments.getDate(2).toString());
                lbDate4.setBounds(10, 280, 83, 13);
                contentPane.add(lbDate4);

                lbTime4 = new JLabel("");
                lbTime4.setFont(new Font("Tahoma", Font.PLAIN, 8));
                setLbTime4Text(appointments.getTime(3).toString());
                lbTime4.setBounds(103, 280, 79, 13);
                contentPane.add(lbTime4);

                lbName4 = new JLabel("");
                lbName4.setFont(new Font("Tahoma", Font.PLAIN, 8));
                setLbName4Text(appointments.getString(4));
                lbName4.setBounds(192, 280, 75, 13);
                contentPane.add(lbName4);

                lbHealthP4 = new JLabel("");
                lbHealthP4.setHorizontalAlignment(SwingConstants.LEFT);
                lbHealthP4.setVerticalAlignment(SwingConstants.TOP);
                setLbHealthP4Text(appointments.getString(5));
                lbHealthP4.setFont(new Font("Tahoma", Font.PLAIN, 8));
                lbHealthP4.setBounds(277, 281, 112, 40);
                contentPane.add(lbHealthP4);

                lbMail4 = new JLabel("");
                lbMail4.setFont(new Font("Tahoma", Font.PLAIN, 8));
                setLbMail4Text(appointments.getString(6));
                lbMail4.setBounds(428, 280, 101, 13);
                contentPane.add(lbMail4);

                checkBox4 = new JCheckBox("");
                setCheckBox4Selected(appointments.getBoolean(7));
                checkBox4.setBounds(589, 272, 32, 21);
                contentPane.add(checkBox4);

                JLabel lbConfirmend = new JLabel("Confirmend");
                lbConfirmend.setBounds(589, 24, 60, 13);
                contentPane.add(lbConfirmend);

                JButton btnOK4 = new JButton("Confirm");
                btnOK4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        try {
                            appointments.absolute(4);
                            confirmAppointment(appointments.getString(6), appointments.getDate(2));
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                btnOK4.setBounds(655, 272, 85, 21);
                contentPane.add(btnOK4);

                JButton btnCancel4 = new JButton("Cancel");
                btnCancel4.setBounds(750, 272, 85, 21);
                contentPane.add(btnCancel4);


            }

    }
    public String getLbDateText() {
        return lbDate.getText();
    }
    public void setLbDateText(String text) {
        lbDate.setText(text);
    }
    public String getLbDate1Text() {
        return lbDate1.getText();
    }
    public void setLbDate1Text(String text_1) {
        lbDate1.setText(text_1);
    }

    public String getLbTime1Text() {
        return lbTime1.getText();
    }
    public void setLbTime1Text(String text_2) {
        lbTime1.setText(text_2);
    }
    public String getLbName1Text() {
        return lbName1.getText();
    }
    public void setLbName1Text(String text_3) {
        lbName1.setText(text_3);
    }
    public String getLblNewLabel_3Text() {
        return lbHealthP1.getText();
    }
    public void setLblNewLabel_3Text(String text_4) {
        lbHealthP1.setText(text_4);
    }
    public String getLbMail1Text() {
        return lbMail1.getText();
    }
    public void setLbMail1Text(String text_5) {
        lbMail1.setText(text_5);
    }
    public String getLbDate2Text() {
        return lbDate2.getText();
    }
    public void setLbDate2Text(String text_6) {
        lbDate2.setText(text_6);
    }
    public String getLbDate3Text() {
        return lbDate3.getText();
    }
    public void setLbDate3Text(String text_7) {
        lbDate3.setText(text_7);
    }
    public String getLbDate4Text() {
        return lbDate4.getText();
    }
    public void setLbDate4Text(String text_8) {
        lbDate4.setText(text_8);
    }
    public String getLbTime2Text() {
        return lbTime2.getText();
    }
    public void setLbTime2Text(String text_9) {
        lbTime2.setText(text_9);
    }
    public String getLbTime3Text() {
        return lbTime3.getText();
    }
    public void setLbTime3Text(String text_10) {
        lbTime3.setText(text_10);
    }
    public String getLbTime4Text() {
        return lbTime4.getText();
    }
    public void setLbTime4Text(String text_11) {
        lbTime4.setText(text_11);
    }
    public String getLbName2Text() {
        return lbName2.getText();
    }
    public void setLbName2Text(String text_12) {
        lbName2.setText(text_12);
    }
    public String getLbName3Text() {
        return lbName3.getText();
    }
    public void setLbName3Text(String text_13) {
        lbName3.setText(text_13);
    }
    public String getLbName4Text() {
        return lbName4.getText();
    }
    public void setLbName4Text(String text_14) {
        lbName4.setText(text_14);
    }
    public String getLbHealthP1Text() {
        return lbHealthP1.getText();
    }
    public void setLbHealthP1Text(String text_15) {
        lbHealthP1.setText(text_15);
    }
    public String getLbHealthP2Text() {
        return lbHealthP2.getText();
    }
    public void setLbHealthP2Text(String text_16) {
        lbHealthP2.setText(text_16);
    }
    public String getLbHealthP3Text() {
        return lbHealthP3.getText();
    }
    public void setLbHealthP3Text(String text_17) {
        lbHealthP3.setText(text_17);
    }
    public String getLbHealthP4Text() {
        return lbHealthP4.getText();
    }
    public void setLbHealthP4Text(String text_18) {
        lbHealthP4.setText(text_18);
    }
    public boolean getCheckBox1Selected() {
        return checkBox1.isSelected();
    }
    public void setCheckBox1Selected(boolean selected) {
        checkBox1.setSelected(selected);
    }
    public boolean getCheckBox2Selected() {
        return checkBox2.isSelected();
    }
    public void setCheckBox2Selected(boolean selected_1) {
        checkBox2.setSelected(selected_1);
    }
    public boolean getCheckBox3Selected() {
        return checkBox3.isSelected();
    }
    public void setCheckBox3Selected(boolean selected_2) {
        checkBox3.setSelected(selected_2);
    }
    public boolean getCheckBox4Selected() {
        return checkBox4.isSelected();
    }
    public void setCheckBox4Selected(boolean selected_3) {
        checkBox4.setSelected(selected_3);
    }
    public String getLbMail2Text() {
        return lbMail2.getText();
    }
    public void setLbMail2Text(String text_19) {
        lbMail2.setText(text_19);
    }
    public String getLbMail3Text() {
        return lbMail3.getText();
    }
    public void setLbMail3Text(String text_20) {
        lbMail3.setText(text_20);
    }
    public String getLbMail4Text() {
        return lbMail4.getText();
    }
    public void setLbMail4Text(String text_21) {
        lbMail4.setText(text_21);
    }
}
