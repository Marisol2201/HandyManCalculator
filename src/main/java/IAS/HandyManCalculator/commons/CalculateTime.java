package IAS.HandyManCalculator.commons;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalculateTime {

    private final List<Date> date;

    public CalculateTime(List<Date> date) {
        this.date = date;
    }

    public String calculateWeekNumber(List<Date> date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date.get(0));
        int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
        return weekNumber + "";
    }

    public short differenceInHoursBetweenDates(List<Date> date) {
        Date startDate = (date.get(0));
        Date endDate = (date.get(date.size() - 1));
        int hoursDifference = 0;
        if (startDate.before(endDate)) {
            long diff = endDate.getTime() - startDate.getTime();
            hoursDifference = (int) (diff / (60 * 60 * 1000));
        } else {
            System.out.println("The final date is before the initial date");
        }
        return (short)hoursDifference;
    }

    public short sumHours(short initialHours, short finalHours) {
        return (short)(initialHours + finalHours);
    }
}
