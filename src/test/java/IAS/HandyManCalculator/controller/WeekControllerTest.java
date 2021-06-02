/*
package IAS.HandyManCalculator.controller;

import IAS.HandyManCalculator.domain.Week;
import WeekRepository;
import IAS.HandyManCalculator.services.week.WeekService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import static org.mockito.Mockito.when;
import java.util.List;

@ExtendWith(SpringExtension.class)
class WeekControllerTest {

    private final Week week1 = Week.builder().id("19").totalWeekHours((short) 88).totalWeekNormalHours((short) 68)
            .weekNormalDaytimeHours((short) 42).weekNormalNightHours((short) 26).sundayNormalHours((short) 0)
            .totalWeekExtraHours((short) 20).weekExtraDaytimeHours((short) 0).weekExtraNightHours((short) 0)
            .sundayExtraHours((short) 0).build();
    private final Week week2 = Week.builder().id("19").totalWeekHours((short) 88).totalWeekNormalHours((short) 68)
            .weekNormalDaytimeHours((short) 42).weekNormalNightHours((short) 26).sundayNormalHours((short) 0)
            .totalWeekExtraHours((short) 20).weekExtraDaytimeHours((short) 0).weekExtraNightHours((short) 0)
            .sundayExtraHours((short) 0).build();
    private final Week week3 = Week.builder().id("19").totalWeekHours((short) 88).totalWeekNormalHours((short) 68)
            .weekNormalDaytimeHours((short) 42).weekNormalNightHours((short) 26).sundayNormalHours((short) 0)
            .totalWeekExtraHours((short) 20).weekExtraDaytimeHours((short) 0).weekExtraNightHours((short) 0)
            .sundayExtraHours((short) 0).build();

    @Mock
    private WeekRepository weekRepository;

    private WeekService weekService;

    @BeforeEach
    void setUp() {
        weekService = new WeekService(weekRepository);
    }

    @Test
    void listWeeks() {
        when(weekRepository.listWeeks()).thenReturn((List<Week>) Flux.just(week1, week2, week3));

        Flux<Week> actual = (Flux<Week>) weekService.listWeeks();

        assertResults(actual, week1, week2, week3);
    }

    @Test
    void createWeek() {
    }

    @Test
    void readWeekById() {
    }

    @Test
    void updateWeek() {
    }

    @Test
    void deleteWeek() {
    }
}
*/
