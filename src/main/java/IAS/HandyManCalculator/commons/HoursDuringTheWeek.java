package IAS.HandyManCalculator.commons;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class HoursDuringTheWeek {
    Calendar calendar = Calendar.getInstance();

    //MIDDLE DATES DAYTIME
    public short daytimeHoursMiddleDates(List<Date> date) {
        return ((short) (date.stream()
                .filter(d -> d != date.get(0) && d != date.get(date.size() - 1))
                .count() * (13)));
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
        return (short)nightHours;
    }

    //LAST DATE DAYTIME
    public short daytimeHoursLastDay(List<Date> date) {
        Date startDate = (date.get(date.size() - 1));
        int daytimeHours = 0;
        calendar.setTime(startDate);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        if ((hours > 7) && (hours < 20)) daytimeHours = ((20 - hours));
        if (hours > 20) daytimeHours = 12;
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
        return (short)nightHours;
    }
}
