package calendar;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;
import JDBC.Connect;

import javax.mail.MessagingException;

import static Email.SendEmailClass.SendEmail;

/**
 * <h1>Appointment </h1>
 * The "Appointment"-Class implements the functionality to store an appointment inside the applications database and creating a reminder for that appointment.
 * @author Max Endres
 * @version 1.0
 *
 *
 */

public class Appointment {

    public static void main(String[] args) {

        LocalDateTime irgendwann = LocalDateTime.of(2022,  1, 17, 19, 56);
        Appointment id1 = new Appointment(irgendwann, 1 );
    }

    Appointment(LocalDateTime appointmentDate, int index){
        this.appDate = appointmentDate;
        setReminder(this.appDate, index);
        System.out.println("Appointment created.");
    }

    /**
     * This method is used to set a reminder. After calculations have been processed, it starts a Timer with a TimerTask, defined in another class.
     * @param appDate_ This is the date from which the reminder will be calculated. Type: LocalDateTime
     * @param index_ This integer defines when the reminder should be sent, taken from the dropdown menu.
     * @return nothing
     */

    /**
     * Plan is to fetch the patient and doctor Mailadresses, to insert this new appointment straight into the database
     * @param appDate_
     * @param index_
     */
    public static LocalDateTime setReminder(LocalDateTime appDate_, int index_) {

        LocalDateTime _appDate = appDate_;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime reminderDate = null;

        if(index_== 0) {
            reminderDate = _appDate.minus(1, ChronoUnit.WEEKS);
        }
        else if(index_ == 1) {
            reminderDate = _appDate.minus(3, ChronoUnit.DAYS);
        }
        else if(index_ == 2) {
            reminderDate = _appDate.minus(1, ChronoUnit.HOURS);
        }
        else {
            reminderDate = _appDate.minus(10, ChronoUnit.MINUTES);
        }

        now = now.truncatedTo(ChronoUnit.MINUTES);
        long delay = now.until(reminderDate, ChronoUnit.MILLIS);

        System.out.println("Reminder Date: "+ reminderDate);
        System.out.println("Now: " + now);
        System.out.println("Delay: "+ delay);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    SendEmail("can.dechert@gmx.de", "Appointment Reminder", "You have an Appointment one the " + _appDate + " at ");
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                this.cancel();
            }
        };

        timer.schedule(task, delay);
        return reminderDate;
    }


    private int userId;
    private LocalDateTime appDate = null;

}
