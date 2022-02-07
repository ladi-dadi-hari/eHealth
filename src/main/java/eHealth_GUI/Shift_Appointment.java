package eHealth_GUI;

import java.awt.EventQueue;

import javax.swing.*;

import Users.Patient;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JCalendar;
import java.awt.GridLayout;

import com.toedter.components.JSpinField;
import java.awt.Font;
import JDBC.Connect;
import java.sql.Connection;
import java.sql.Time;
import java.util.Timer;
import Users.Doctor;
import JDBC.Connect;

import static JDBC.Connect.getDoctorByMail;

/**
 * <h1> Graphical user interface for making an appointment</h1>
 * This class provides the GUI for making an appointment. Using an OpenSource library for picking a certain Date (com.toedter.calendar.JDateChooser) and two JSpinField (com.toedter.components.JSpinField) objects to choose the hour and time.
 * In addition, the user can choose from a drop down menu, displayed by a JComboBox, four different reminder times.
 * After clicking the button "Send", an object from the class "Appointment" will be created, calling the constructor with the parameters chosen from the GUI.
 *
 * @author Max Endres
 *
 */

public class Shift_Appointment {

    public JFrame frmAppointment = new JFrame();

    private JDateChooser dateChooser;
    private JSpinField hour;
    private JSpinField minute;
    private JLabel lbTime;
    private JLabel lbHour;
    private JLabel lblNewLabel;
    private Date date;
    private LocalTime time;


    /**
     * Create the application.
     * patient_mail + Doc_Mail for constructor to initialize
     */
    public Shift_Appointment(Patient patient, Date _oldDate) throws SQLException {
        initialize(patient, _oldDate);
    }

    /**
     * Initialize the contents of the frame.
     * This method is called in the constructor, defining the behavior of this window when opened.
     */
    public void initialize(Patient patient, Date _oldDate) throws SQLException {


        frmAppointment.setTitle("Appointment");
        frmAppointment.setBounds(100, 100, 394, 326);
        frmAppointment.getContentPane().setLayout(null);

        Date heute = new Date();
        JLabel lbChooseDate = new JLabel("Choose date:");


        dateChooser = new JDateChooser(heute);
        dateChooser.getCalendarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        dateChooser.setBounds(109, 59, 129, 19);
        frmAppointment.getContentPane().add(dateChooser);


        lbChooseDate.setBounds(104, 37, 93, 13);
        frmAppointment.getContentPane().add(lbChooseDate);

        JButton btnSend = new JButton("Send");


        hour = new JSpinField();
        hour.setBounds(10, 130, 50, 19);
        frmAppointment.getContentPane().add(hour);

        minute = new JSpinField();
        minute.setBounds(65, 130, 50, 19);
        frmAppointment.getContentPane().add(minute);

        lbTime = new JLabel("Time:");
        lbTime.setBounds(10, 108, 45, 13);
        frmAppointment.getContentPane().add(lbTime);

        lbHour = new JLabel("Hours");
        lbHour.setFont(new Font("Tahoma", Font.ITALIC, 8));
        lbHour.setBounds(10, 150, 45, 13);
        frmAppointment.getContentPane().add(lbHour);

        lblNewLabel = new JLabel("Minutes");
        lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 8));
        lblNewLabel.setBounds(58, 150, 45, 13);
        frmAppointment.getContentPane().add(lblNewLabel);

        JButton btnCancel = new JButton("Cancel");
        /**
         * Close the application
         @param none
         */
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmAppointment.setVisible(false);

            }
        });
        btnCancel.setBounds(230, 224, 85, 21);
        frmAppointment.getContentPane().add(btnCancel);

        btnSend.setBounds(32, 224, 85, 21);
        frmAppointment.getContentPane().add(btnSend);

        /**
         * Set values of the JSpinField to the opening and closing hour of the chosen doctor
         */

        setMinuteMaximum(59);
        setMinuteMinimum(00);

        /**
         * This method take the input from DateChooser as type Date and the time values from JSpinField as type LocalTime.
         * First it converts the Date object to a LocalDate object, merging it together with the LocalTime object into a LocalDateTime object.
         * This new LocalDateTime object is passed together with the chosen index to the constructor of Appointment, setting up a reminder.
         * @see LocalDateTime
         * @see LocalDate
         * @see Date
         * @see Time
         */
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                date = dateChooser.getDate();

                time = LocalTime.of(hour.getValue(), minute.getValue());
                LocalDate pickedDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                java.sql.Date sqlDate = java.sql.Date.valueOf(pickedDate);
                Time sqlTime = Time.valueOf(time);


                try {
                    frmAppointment.setVisible(false);
                    JOptionPane.showMessageDialog(frmAppointment, "Appointment shifted!");
                    Connect.shiftAppointment(sqlDate, sqlTime, patient.getMailAddress(), (java.sql.Date) _oldDate);
                    Healthcare_Entry entry = new Healthcare_Entry(patient);
                    entry.setVisible(true);

                    return;
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }


    /**
     * @return String This returns the Date as String
     */
    public String getDateChooserDateFormatString() {

        return dateChooser.getDateFormatString();
    }

    /**
     * Set the initial date displayed when opening the window first.
     * In this application it shows the date of today.
     */
    public void setDateChooserDateFormatString(String dateFormatString) {

        dateChooser.setDateFormatString(dateFormatString);
    }


    /**
     * sets the maximum value of the JSpinField "Hour".
     * In this application, it represents the hour when the doctor is closing.
     *
     * @param maximum
     */
    public void setHourMaximum(int maximum) {
        hour.setMaximum(maximum);
    }

    /**
     * get the minute entered into the JSpinField
     *
     * @return int Returns the minute
     */
    public int getMinuteMaximum() {
        return minute.getMaximum();
    }

    /**
     * sets the maximum value of the JSpinField "Minute".
     * In this application, it represents the hour when the doctor is closing.
     *
     * @param maximum_1
     */
    public void setMinuteMaximum(int maximum_1) {
        minute.setMaximum(maximum_1);
    }

    /**
     * @return Integer Minute
     */
    public int getMinuteMinimum() {
        return minute.getMinimum();
    }

    /**
     * Minimum is set to 0 in this application.
     *
     * @param minimum
     */
    public void setMinuteMinimum(int minimum) {
        minute.setMinimum(minimum);
    }

    public int getHourMinimum() {
        return hour.getMinimum();
    }

    /**
     * Minimum represents the time when doctor is opening.
     *
     * @param minimum_1
     */
    public void setHourMinimum(int minimum_1) {
        hour.setMinimum(minimum_1);
    }
}




