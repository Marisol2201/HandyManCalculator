package IAS.HandyManCalculator.model;
import java.util.Calendar;
import java.util.Date;

public class CalculateTime {

    public CalculateTime(Date initialTime, Date finalTime) {
        if(initialTime.before(finalTime) || (initialTime.equals(finalTime))) {
            calculateWeekNumber(initialTime);
            calculateWeekNumber(finalTime);
            System.out.println("This is initialTime from the calculateTime class + initialTime: " + initialTime);
            System.out.println("This is finalTime from the calculateTime class + finalTime: " + finalTime);
        } else {
            System.out.println("Error from CalculateTime class");
        }
    }

    public int calculateWeekNumber(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println("This is weekNumber from calculateWeek from the calculateTime class + weekNumber: " + weekNumber);
        return weekNumber;
    }

    public int calculateHoursForEachDay(Date firstDate, Date secondDate) {
        int sumHours = 0;
        if(calculateWeekNumber(secondDate) != calculateWeekNumber(firstDate)) {
            sumHours = (calculateHours(secondDate) - (calculateHours(firstDate)));
        }
        System.out.println("This is sumHours from calculateHoursForEachDay from the calculateTime class + sumHours: " + sumHours);
        return sumHours;
    }

    public int calculateHours(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayHour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("This from calculateHours from the calculateTime class + dayHour: " + dayHour);
        return dayHour;
    }

  //  public Date convertToMilitaryHour(Date date) {
//
    //};
}