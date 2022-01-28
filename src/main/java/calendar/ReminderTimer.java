package calendar;


import Email.SendEmailClass;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.TimerTask;

import static Email.SendEmailClass.SendEmail;

public class ReminderTimer extends TimerTask{


    public static void main (String []args ) {

    }
    @Override
    public void run () {

        try {
            SendEmail("can.dechert@gmx.de", "Appointment Reminder", "You have an Appointment");
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        this.cancel();
    }
}
