package IAS.HandyManCalculator.commons;

import IAS.HandyManCalculator.domain.Dates;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateWeekTest {

    List<Date> dates = new ArrayList<Date>();

    @Test
    void calculateWeekNumberTest() {
        Date date1 = new Date(1618207200 * 1000L);
        Date date2 = new Date(1618758000 * 1000L);
        dates.add(date1);
        dates.add(date2);
        CalculateWeek calculateWeek = new CalculateWeek();
        assertEquals((calculateWeek.calculateWeekNumber(dates)), String.valueOf(16));
    }

    @Test
    void sumHours() {
    }
}
