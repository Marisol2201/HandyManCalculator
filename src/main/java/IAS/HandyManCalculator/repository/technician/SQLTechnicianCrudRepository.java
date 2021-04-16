package IAS.HandyManCalculator.repository.technician;

import IAS.HandyManCalculator.domain.Technician;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// This is an exploration class
public class SQLTechnicianCrudRepository implements TechnicianCRUDRepository {
    @Override
    public void store(Technician item) {

    }

    @Override
    public void update(Technician item) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<Technician> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<Technician> list() {
        return null;
    }
}
