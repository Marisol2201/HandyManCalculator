package IAS.HandyManCalculator.repository.week;

import IAS.HandyManCalculator.domain.Week;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WeekRepository {
    void storeWeek(Week week);

    void updateWeek(Week week);

    void deleteWeek(UUID id);

    Optional<Week> findWeekById(UUID id);

    List<Week> listWeeks();
}
