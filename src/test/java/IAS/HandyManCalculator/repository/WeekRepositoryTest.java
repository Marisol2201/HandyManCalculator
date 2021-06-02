/*
package IAS.HandyManCalculator.repository.week;

import java.util.List;

import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import IAS.HandyManCalculator.domain.Week;
import static org.junit.jupiter.api.Assertions.*;
import IAS.HandyManCalculator.services.week.WeekService;

class WeekRepositoryTest {

    private final Week week1 = new Week("19", (short) 88, (short) 68, (short) 19, (short) 22, (short) 13, (short) 9, (short) 0, (short) 1, (short)7);
    private final Week week2 = new Week("19", (short) 88, (short) 68, (short) 19, (short) 22, (short) 13, (short) 9, (short) 0, (short) 1, (short)7);
    private final Week week3 = new Week("19", (short) 88, (short) 68, (short) 19, (short) 22, (short) 13, (short) 9, (short) 0, (short) 1, (short)7);

    List weeks = List.of(week1, week2, week3);

    @Mock
    private WeekRepository weekRepository;

    private WeekService weekService;

    @BeforeEach
    void setUp() {
        weekService = new WeekService(weekRepository);
    }

    @Test
    void storeWeek() {
    }

    @Test
    void updateWeek() {
    }

    @Test
    void deleteWeek() {
    }

    @Test
    void findWeekById() {
    }

    @Test
    void listWeeks() {
        List list = weekRepository.listWeeks();

        List actual = weekService.listWeeks();

        assertAll((Executable) actual, (Executable) weeks);
}
}*/
