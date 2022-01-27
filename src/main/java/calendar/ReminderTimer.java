package calendar;


import java.util.Date;
import java.util.TimerTask;

public class ReminderTimer extends TimerTask{


    public static void main (String []args ) {

    }
    @Override
    public void run () {

        System.out.println("Reminder");


        this.cancel();
    }
}
