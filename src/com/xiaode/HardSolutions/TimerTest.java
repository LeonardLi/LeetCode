package com.xiaode.HardSolutions;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xiaode on 3/23/17.
 */
public class TimerTest {
    Timer timer  = new Timer();
    public static void main(String[] args) {
        System.out.println("Now: "+ new Date());
        Calendar calendarRef = Calendar.getInstance();
        calendarRef.add(Calendar.SECOND, 10);
        Date runDate = calendarRef.getTime();
        Timer timer  = new Timer();
        myTask task = new myTask();
        timer.schedule(task, runDate);

//        try{
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
class myTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Time: "+ new Date());
    }
}