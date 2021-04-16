package IAS.HandyManCalculator.repository.week;

import IAS.HandyManCalculator.domain.Week;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// This is an exploration class
public class SQLWeekCrudRepository implements WeekCRUDRepository {
    @Override
    public void store(Week item) {

    }

    @Override
    public void update(Week item) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<Week> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<Week> list() {
        return null;
    }
}
