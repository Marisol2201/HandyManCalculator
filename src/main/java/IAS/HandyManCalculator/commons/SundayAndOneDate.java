package IAS.HandyManCalculator.commons;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SundayAndOneDate {

    Calendar calendar = Calendar.getInstance();

    //IS SUNDAY?
    public boolean IsSunday(List<Date> date) {
        boolean result = false;
        Date startDate = (date.get(date.size() - 1));
        calendar.setTime(startDate);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == Calendar.SUNDAY) {
            result = true;
        }
        return result;
    }

    //SUNDAY AS ONE DATE
    public short sundayHoursOnlyDay(List<Date> date) {
        calendar.setTime(date.get(0));
        int firstHour = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.setTime(date.get(date.size() - 1));
        int lastHour = calendar.get(Calendar.HOUR_OF_DAY);
        int sundayHours = lastHour - firstHour;
        return (short)sundayHours;
    }

    //SUNDAY WITH MORE DATES
    public short sundayHoursSeveralDays(List<Date> date) {
        calendar.setTime(date.get(date.size() - 1));
        short sundayHours = (short)calendar.get(Calendar.HOUR_OF_DAY);
        return sundayHours;
    }

    //ONLY ONE DATE DIFFERENT TO SUNDAY DAYTIME HOURS
    public short daytimeHoursWithOneDate(List<Date> date) {
        int daytimeHours = 0;
        calendar.setTime(date.get(0));
        int firstHour = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.setTime(date.get(date.size() - 1));
        int lastHour = calendar.get(Calendar.HOUR_OF_DAY);
        if ((firstHour < 7) && (lastHour > 7) && (lastHour < 20)) daytimeHours = lastHour - firstHour;
        if ((firstHour < 7) && (lastHour > 7) && (lastHour > 20)) daytimeHours = 13;
        if ((firstHour < 7) && (lastHour < 7) && (lastHour < 20)) daytimeHours = 0;
        if ((firstHour > 7) && (firstHour < 20) && (lastHour < 20)) daytimeHours = (lastHour - firstHour);
        if ((firstHour > 7) && (firstHour < 20) && (lastHour > 20)) daytimeHours = (20 - firstHour);
        if ((firstHour > 7) && (firstHour > 20) && (lastHour > 20)) daytimeHours = 0;
        System.out.println("daytimeHours first day: " + daytimeHours);
        return (short)daytimeHours;
    }

    //ONLY ONE DATE DIFFERENT TO SUNDAY NIGHT HOURS
    public short nightHoursWithOneDate(List<Date> date) {
        int nightHours = 0;
        calendar.setTime(date.get(0));
        int firstHour = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.setTime(date.get(date.size() - 1));
        int lastHour = calendar.get(Calendar.HOUR_OF_DAY);
        if ((firstHour < 7) && (lastHour > 7) && (lastHour < 20)) nightHours = 7 - firstHour;
        if ((firstHour < 7) && (lastHour > 7) && (lastHour > 20)) nightHours = (7 - firstHour) + (lastHour - 20);
        if ((firstHour < 7) && (lastHour < 7) && (lastHour < 20)) nightHours = lastHour - firstHour;
        if ((firstHour > 7) && (firstHour < 20) && (lastHour < 20)) nightHours = 0;
        if ((firstHour > 7) && (firstHour < 20) && (lastHour > 20)) nightHours = lastHour - 20;
        if ((firstHour > 7) && (firstHour > 20) && (lastHour > 20)) nightHours = lastHour - firstHour;
        return (short)nightHours;
    }
    //worked hours > 48
    //1 date before 2 date
    //extra in week - sunday hours
}
