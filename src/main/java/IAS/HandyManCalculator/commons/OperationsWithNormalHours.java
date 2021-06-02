package IAS.HandyManCalculator.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationsWithNormalHours {

    SundayAndOneDate sunday = new SundayAndOneDate();
    HoursDuringTheWeek normalAndExtra = new HoursDuringTheWeek();

    public ArrayList<Short> switchCase (List<Date> dates) {
        short totalWeekNormalHours = 0;
        short weekNormalDaytimeHours = 0;
        short weekNormalNightHours = 0;
        short sundayNormalHours = 0;
        short totalWeekExtraHours = 0;
        short weekExtraDaytimeHours = 0;
        short weekExtraNightHours = 0;
        short sundayExtraHours = 0;

        //LIST > 2 & SUNDAY IS THE LAST DAY
        if ((dates.size() > 2) && (sunday.IsSunday(dates))) {
            weekNormalDaytimeHours = (short) ((normalAndExtra.daytimeHoursFirstDay(dates)) +
                    normalAndExtra.daytimeHoursMiddleDates(dates));
            weekNormalNightHours = (short) (normalAndExtra.nightHoursFirstDay(dates) +
                    normalAndExtra.nightHoursMiddleDates(dates));
            sundayNormalHours = sunday.sundayHoursSeveralDays(dates);
            totalWeekNormalHours = (short) (weekNormalDaytimeHours + weekNormalNightHours + sundayNormalHours);
        }

        //LIST == 2 & TWO DATES ARE THE SAME DATE & IS SUNDAY
        if ((dates.size() == 2) && (sunday.IsSunday(dates)) && ((dates.get(0)) == (dates.get(dates.size() - 1)))) {
            sundayNormalHours = sunday.sundayHoursOnlyDay(dates);
            totalWeekNormalHours = (short) (weekNormalDaytimeHours + weekNormalNightHours + sundayNormalHours);
        }

        //LIST == 2 & TWO DATES ARE DIFFERENT DATES & SUNDAY IS IN THE LAST DAY
        if ((dates.size() == 2) && (sunday.IsSunday(dates)) && ((dates.get(0)) != (dates.get(dates.size() - 1)))) {
            weekNormalDaytimeHours = (normalAndExtra.daytimeHoursFirstDay(dates));
            weekNormalNightHours = (normalAndExtra.nightHoursFirstDay(dates));
            sundayNormalHours = sunday.sundayHoursOnlyDay(dates);
            totalWeekNormalHours = (short) (weekNormalDaytimeHours + weekNormalNightHours + sundayNormalHours);
        }

        //LIST > 2 & SUNDAY IS NOT IN THE LIST
        if ((dates.size() > 2) && (!sunday.IsSunday(dates))) {
            weekNormalDaytimeHours = (short) ((normalAndExtra.daytimeHoursFirstDay(dates)) +
                    normalAndExtra.daytimeHoursMiddleDates(dates) + normalAndExtra.daytimeHoursLastDay(dates));
            weekNormalNightHours = (short) ((normalAndExtra.nightHoursFirstDay(dates)) +
                    normalAndExtra.nightHoursMiddleDates(dates) + normalAndExtra.nightHoursLastDay(dates));
            totalWeekNormalHours = (short) (weekNormalDaytimeHours + weekNormalNightHours + sundayNormalHours);
        }

        //LIST == 2 & SUNDAY IS NOT IN THE LIST & TWO DATES ARE THE SAME DATE
        if ((dates.size() == 2) && (!sunday.IsSunday(dates))) {
            weekNormalDaytimeHours = sunday.daytimeHoursWithOneDate(dates);
            weekNormalNightHours = sunday.nightHoursWithOneDate(dates);
            totalWeekNormalHours = (short) (weekNormalDaytimeHours + weekNormalNightHours + sundayNormalHours);
        }

        //LIST == 2 & SUNDAY IS NOT IN THE LIST & TWO DATES ARE DIFFERENT DATES
        if ((dates.size() == 2) && (!sunday.IsSunday(dates)) && (dates.get(0)) != (dates.get(dates.size() - 1))) {
            weekNormalDaytimeHours = (short) ((normalAndExtra.daytimeHoursFirstDay(dates)) +
                    normalAndExtra.daytimeHoursLastDay(dates));
            weekNormalNightHours = (short) ((normalAndExtra.nightHoursFirstDay(dates)) +
                    normalAndExtra.nightHoursLastDay(dates));
            totalWeekNormalHours = (short) (weekNormalDaytimeHours + weekNormalNightHours + sundayNormalHours);
        }

        //IF NORMAL HOURS ARE MORE THAN 48
        if (totalWeekNormalHours > 48) {
            totalWeekExtraHours = (short) (totalWeekNormalHours - 48);
        }

        short totalWeekHours = (short) (totalWeekNormalHours + totalWeekExtraHours);
        ArrayList<Short> result = new ArrayList();
        result.add(totalWeekHours);
        result.add(totalWeekNormalHours);
        result.add(weekNormalDaytimeHours);
        result.add(weekNormalNightHours);
        result.add(sundayNormalHours);
        result.add(totalWeekExtraHours);
        result.add(weekExtraDaytimeHours);
        result.add(weekExtraNightHours);
        result.add(sundayExtraHours);
        return result;
    }
}
