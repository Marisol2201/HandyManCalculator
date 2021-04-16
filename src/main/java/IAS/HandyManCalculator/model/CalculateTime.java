package IAS.HandyManCalculator.model;
import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalculateTime {

    private final List<Date> date;

    public CalculateTime(List<Date> date) {
        this.date = date;
    }


    public ArrayList<Integer> sumHoursToEachWeek(List<Date> date) {
        Calendar calendar = Calendar.getInstance();
        ArrayList<Integer> result = new ArrayList();
        for (Date d: date) {
            calendar.setTime(d);
            int weekNumberForEachDay = calendar.get(Calendar.WEEK_OF_YEAR);
            result.add(weekNumberForEachDay);
        }
        //System.out.println("This is weekNumber from calculateWeekNumber from the calculateTime class + result: " + result);
        return result;
    }

    public ArrayList<Integer> calculateWeekNumber(List<Date> date) {
        Calendar calendar = Calendar.getInstance();
        ArrayList<Integer> result = new ArrayList();
        for (Date d: date) {
            calendar.setTime(d);
            int weekNumberForEachDay = calendar.get(Calendar.WEEK_OF_YEAR);
            result.add(weekNumberForEachDay);
        }
        //System.out.println("This is weekNumber from calculateWeekNumber from the calculateTime class + result: " + result);
        return result;
    }

    public Date calculateInitialDate(List<Date> date) {
        Date result = (date.get(0));
        //System.out.println("This is result from calculateInitialDate from the calculateTime class + result: " + result);
        return result;
    }

    public Date calculateFinalDate(List<Date> date) {
        Date result = (date.get(date.size() - 1));
        //System.out.println("This is result from calculateFinalDate from the calculateTime class + result: " + result);
        return result;
    }

    public int differenceInHoursBetweenDates(Date startDate, Date endDate) {
        long diff = endDate.getTime() - startDate.getTime();
        int hoursDifference = (int) (diff/(60 * 60 *1000));
        //System.out.println("This is difference from differenceBetweenDates from the calculateTime class + difference: " + hoursDifference);
        return hoursDifference;
    }
}