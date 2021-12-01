package com.example.group11officedeskbooking;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateFormatter {

    public String formatDate(String date){

        //Separate date components
        String[] dateComponents = date.split("-");
        int year = Integer.parseInt(dateComponents[0]);
        int month = Integer.parseInt(dateComponents[1]) - 1;
        int day = Integer.parseInt(dateComponents[2]);

        //Convert to date format
        Calendar tempCal = new GregorianCalendar(year, month, day);
        Date newSearchDate = tempCal.getTime();
        SimpleDateFormat DateFor = new SimpleDateFormat("EEEE d'th' MMM yyyy");

        //Add 'st' and 'rd' to required numbers
        if(day == 1 || day == 21 || day == 31){
            DateFor = new SimpleDateFormat("EEEE d'st' MMM yyyy");
        }
        else if(day == 2 || day == 22){
            DateFor = new SimpleDateFormat("EEEE d'nd' MMM yyyy");
        }
        else if(day == 3 || day == 23){
            DateFor = new SimpleDateFormat("EEEE d'rd' MMM yyyy");
        }
        return DateFor.format(newSearchDate);
    }

}
