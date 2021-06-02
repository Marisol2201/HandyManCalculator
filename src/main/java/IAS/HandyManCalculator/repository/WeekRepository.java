package IAS.HandyManCalculator.repository;

import IAS.HandyManCalculator.domain.Week;

import java.util.List;
import java.util.Optional;

public interface WeekRepository {
    void storeWeek(Week week);

    void updateWeek(Week week);

    void deleteWeek(String id);

    Optional<Week> findWeekById(String id);

    List<Week> listWeeks();
}
