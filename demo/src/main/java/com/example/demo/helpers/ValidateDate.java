package com.example.demo.helpers;

import java.util.Calendar;
import java.util.Date;

public class ValidateDate {

	public boolean isToday2(Date dateToCheck) {
        Calendar calendar = Calendar.getInstance();

        // you have to set calendar object to 00:00:00
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        // milliseconds of 1 day = 86400000
        System.out.println(dateToCheck.getTime() - calendar.getTimeInMillis() < 86400000);
        return dateToCheck.getTime() - calendar.getTimeInMillis() < 86400000; 
    }
}
