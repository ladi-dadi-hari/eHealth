package calendar;


import java.util.Date;
import java.util.TimerTask;

public class ReminderTimer extends TimerTask{


    public static void main (String []args ) {

    }

    public void run() {

        System.out.println("Appointment Reminder!");


        this.cancel();
    }

}
