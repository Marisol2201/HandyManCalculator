package IAS.HandyManCalculator.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationsWithExtraHours {

    SundayAndOneDate sunday = new SundayAndOneDate();
    HoursDuringTheWeek normalAndExtra = new HoursDuringTheWeek();

    public ArrayList<Short> switchCase (List<Date> dates) {
        short totalWeekExtraHours = 0;
        short weekExtraDaytimeHours = 0;
        short weekExtraNightHours = 0;
        short sundayExtraHours = 0;
        short totalWeekNormalHours = 0;
        short weekNormalDaytimeHours = 0;
        short weekNormalNightHours = 0;
        short sundayNormalHours = 0;

        //LIST > 2 & SUNDAY IS THE LAST DAY
        if ((dates.size() > 2) && (sunday.IsSunday(dates))) {
            weekExtraDaytimeHours = (short) ((normalAndExtra.daytimeHoursFirstDay(dates)) +
                    normalAndExtra.daytimeHoursMiddleDates(dates));
            weekExtraNightHours = (short) (normalAndExtra.nightHoursFirstDay(dates) +
                    normalAndExtra.nightHoursMiddleDates(dates));
            sundayExtraHours = sunday.sundayHoursSeveralDays(dates);
            totalWeekExtraHours = (short) (weekExtraDaytimeHours + weekExtraNightHours + sundayExtraHours);
        }

        //LIST == 2 & TWO DATES ARE THE SAME DATE & IS SUNDAY
        if ((dates.size() == 2) && (sunday.IsSunday(dates)) && ((dates.get(0)) == (dates.get(dates.size() - 1)))) {
            sundayExtraHours = sunday.sundayHoursOnlyDay(dates);
            totalWeekExtraHours = (short) (weekExtraDaytimeHours + weekExtraNightHours + sundayExtraHours);
        }

        //LIST == 2 & TWO DATES ARE DIFFERENT DATES & SUNDAY IS IN THE LAST DAY
        if ((dates.size() == 2) && (sunday.IsSunday(dates)) && ((dates.get(0)) != (dates.get(dates.size() - 1)))) {
            weekExtraDaytimeHours = (normalAndExtra.daytimeHoursFirstDay(dates));
            weekExtraNightHours = (normalAndExtra.nightHoursFirstDay(dates));
            sundayExtraHours = sunday.sundayHoursOnlyDay(dates);
            totalWeekExtraHours = (short) (weekExtraDaytimeHours + weekExtraNightHours + sundayExtraHours);
        }

        //LIST > 2 & SUNDAY IS NOT IN THE LIST
        if ((dates.size() > 2) && (!sunday.IsSunday(dates))) {
            weekExtraDaytimeHours = (short) ((normalAndExtra.daytimeHoursFirstDay(dates)) +
                    normalAndExtra.daytimeHoursMiddleDates(dates) + normalAndExtra.daytimeHoursLastDay(dates));
            weekExtraNightHours = (short) ((normalAndExtra.nightHoursFirstDay(dates)) +
                    normalAndExtra.nightHoursMiddleDates(dates) + normalAndExtra.nightHoursLastDay(dates));
            totalWeekExtraHours = (short) (weekExtraDaytimeHours + weekExtraNightHours + sundayExtraHours);
        }

        //LIST == 2 & SUNDAY IS NOT IN THE LIST & TWO DATES ARE THE SAME DATE
        if ((dates.size() == 2) && (!sunday.IsSunday(dates))) {
            weekExtraDaytimeHours = sunday.daytimeHoursWithOneDate(dates);
            weekExtraNightHours = sunday.nightHoursWithOneDate(dates);
            totalWeekExtraHours = (short) (weekExtraDaytimeHours + weekExtraNightHours + sundayExtraHours);
            System.out.println(totalWeekExtraHours);
        }

        //LIST == 2 & SUNDAY IS NOT IN THE LIST & TWO DATES ARE DIFFERENT DATES
        if ((dates.size() == 2) && (!sunday.IsSunday(dates)) && (dates.get(0)) != (dates.get(dates.size() - 1))) {
            weekExtraDaytimeHours = (short) ((normalAndExtra.daytimeHoursFirstDay(dates)) +
                    normalAndExtra.daytimeHoursLastDay(dates));
            weekExtraNightHours = (short) ((normalAndExtra.nightHoursFirstDay(dates)) +
                    normalAndExtra.nightHoursLastDay(dates));
            totalWeekExtraHours = (short) (weekExtraDaytimeHours + weekExtraNightHours + sundayExtraHours);
        }

        if (totalWeekExtraHours > 48) {
            totalWeekExtraHours = (short) (totalWeekExtraHours - 48);
        }

        short totalWeekHours = (short) (totalWeekNormalHours + totalWeekExtraHours);
        ArrayList<Short> result = new ArrayList();
        result.add(weekNormalDaytimeHours);
        result.add(weekNormalNightHours);
        result.add(sundayNormalHours);
        result.add(totalWeekNormalHours);
        result.add(totalWeekExtraHours);
        result.add(totalWeekHours);
        result.add(sundayExtraHours);
        result.add(weekExtraNightHours);
        result.add(weekExtraDaytimeHours);
        return result;
    }
}
