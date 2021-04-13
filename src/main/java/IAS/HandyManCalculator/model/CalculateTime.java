package IAS.HandyManCalculator.model;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalculateTime {

    private final List<Date> date;

    public CalculateTime(List<Date> date) {
        this.date = date;
    }


//        Calendar calendar = Calendar.getInstance();
//        for (Date d: date
//        ) {
//            calendar.setTime(d);
//            if(date.before(finalTime) || (initialTime.equals(finalTime))) {
//                calculateWeekNumber(initialTime);
//                System.out.println("This is initialTime from the calculateTime class + initialTime: " + initialTime);
//                System.out.println("This is finalTime from the calculateTime class + finalTime: " + finalTime);
//        }
//        } else {
//            System.out.println("Error from CalculateTime class");
//        }
//    }

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

    public ArrayList<Integer> calculateHours(List<Date> date) {
        Calendar calendar = Calendar.getInstance();
        ArrayList<Integer> result = new ArrayList();
        for (Date d: date) {
            calendar.setTime(d);
            int weekSumHours = calendar.get(Calendar.HOUR);
            result.add(weekSumHours);
        }
        //System.out.println("This is sumHours from calculateHours from the calculateTime class + result: " + result);
        return result;
    }
    public ArrayList<Date> calculateInitialDate(List<Date> date) {
        ArrayList<Date> result = new ArrayList();
        result.add(date.get(0));
        //System.out.println("This is result from calculateInitialDate from the calculateTime class + result: " + result);
        return result;
    }

    public ArrayList<Date> calculateFinalDate(List<Date> date) {
        ArrayList<Date> result = new ArrayList();
        result.add(date.get(date.size() - 1));
        //System.out.println("This is result from calculateFinalDate from the calculateTime class + result: " + result);
        return result;
    }
}