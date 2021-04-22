package IAS.HandyManCalculator.commons;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalculateWeek {

    public String calculateWeekNumber(List<Date> date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date.get(0));
        int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
        return weekNumber + "";
    }

    public short sumHours(short initialHours, short finalHours) {
        return (short)(initialHours + finalHours);
    }
}
