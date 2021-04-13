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
        int weekNumber = 0;
        ArrayList<Integer> result = new ArrayList();
        for (Date d: date) {
            calendar.setTime(d);
            weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
            result.add(weekNumber);
        }
        System.out.println("This is weekNumber from calculateWeek from the calculateTime class + result: " + result);
        return result;
    }

//    public int calculateHoursForEachDay(Date firstDate, Date secondDate) {
//        int sumHours = 0;
//        if(calculateWeekNumber(secondDate) != calculateWeekNumber(firstDate)) {
//            sumHours = (calculateHours(secondDate) - (calculateHours(firstDate)));
//        }
//        System.out.println("This is sumHours from calculateHoursForEachDay from the calculateTime class + sumHours: " + sumHours);
//        return sumHours;
//    }
//
//    public int calculateHours(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        int dayHour = calendar.get(Calendar.HOUR_OF_DAY);
//        System.out.println("This from calculateHours from the calculateTime class + dayHour: " + dayHour);
//        return dayHour;
//    }
//
//  //  public Date convertToMilitaryHour(Date date) {
////
//    //};
}