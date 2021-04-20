package IAS.HandyManCalculator.commons;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ChoosePath {

    public boolean IsSunday(List<Date> date) {
        System.out.println(date);
        boolean result = false;
        Date startDate = (date.get(date.size() - 1));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == Calendar.SUNDAY) {
            result = true;
        }
        System.out.println(result);
        return result;
    }

    public short daytimeHoursWithOneDate(List<Date> date) {
        Date startDate = (date.get(0));
        Date endDate = (date.get(date.size() - 1));
        int daytimeHours = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        int firstHour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("firstHour first day: " + firstHour);
        calendar.setTime(endDate);
        int secondHour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("secondHour first day: " + secondHour);
        System.out.println("daytimeHours first day: " + daytimeHours);
        return (short)daytimeHours;
    }

    public short nightHoursWithOneDate(Date date) {
        int daytimeHours = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        if ((hours > 7) && (hours < 20)) {
            daytimeHours = (20 - hours);
        }
        if ((hours < 7)) {
            daytimeHours = 12;
        }
        System.out.println("daytimeHours first day: " + daytimeHours);
        return (short)daytimeHours;
    }

    //if sunday is present
    //1 date == 2 date
    //worked hours > 48
    //1 date before 2 date
    //extra in week - sunday hours
}
