package IAS.HandyManCalculator.commons;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HoursDuringTheWeek {
    Calendar calendar = Calendar.getInstance();

    //MIDDLE DATES DAYTIME
    public short daytimeHoursMiddleDates(List<Date> date) {
        short middleDates = 0;
        for (Date d: date) {
            if ((d != (date.get(0))) && d != ((date.get(date.size() - 1)))) middleDates++;
        }
        return (short)(middleDates * 13);
    }

    //MIDDLE DATES NIGHT
    public short nightHoursMiddleDates(List<Date> date) {
        short middleDates = 0;
        for (Date d: date) {
            if ((d != (date.get(0))) && d != ((date.get(date.size() - 1)))) middleDates++;
        }
        return (short)(middleDates * 11);
    }

    //FIRST DATE DAYTIME
    public short daytimeHoursFirstDay(List<Date> date) {
        Date startDate = (date.get(0));
        int daytimeHours = 0;
        calendar.setTime(startDate);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        if ((hours > 7) && (hours < 20)) daytimeHours = (20 - hours);
        if ((hours < 7)) daytimeHours = 12;
        System.out.println("daytimeHours first day: " + daytimeHours);
        return (short)daytimeHours;
    }

    //FIRST DATE NIGHT
    public short nightHoursFirstDay(List<Date> date) {
        Date startDate = (date.get(0));
        int nightHours = 0;
        calendar.setTime(startDate);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        if (hours < 7) nightHours = ((7 - hours) + 4);
        if (hours > 20) nightHours = (24 - hours);
        if ((hours > 7)) nightHours = (4);
        System.out.println("nightHours first day: " + nightHours);
        return (short)nightHours;
    }

    //LAST DATE DAYTIME
    public short daytimeHoursLastDay(List<Date> date) {
        System.out.println(date);
        Date startDate = (date.get(date.size() - 1));
        int daytimeHours = 0;
        calendar.setTime(startDate);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        if ((hours > 7) && (hours < 20)) daytimeHours = ((20 - hours));
        if (hours > 20) daytimeHours = 12;
        System.out.println("daytimeHours last day: " + daytimeHours);
        return (short)daytimeHours;
    }

    //LAST DATE NIGHT
    public short nightHoursLastDay(List<Date> date) {
        Date endDate = (date.get(date.size() - 1));
        int nightHours = 0;
        calendar.setTime(endDate);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        if (hours < 7) nightHours = hours;
        if (hours > 20) nightHours = ((hours - 20) + 7);
        System.out.println("nightHours last day: " + nightHours);
        return (short)nightHours;
    }
}
