package IAS.HandyManCalculator.repository.week;

import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.repository.week.WeekCRUDRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SQLWeekCrudRepository implements WeekCRUDRepository {
    @Override
    public void store(Week item) {

    }

    @Override
    public void update(Week item) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Optional<Week> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Week> list() {
        return null;
    }
}
