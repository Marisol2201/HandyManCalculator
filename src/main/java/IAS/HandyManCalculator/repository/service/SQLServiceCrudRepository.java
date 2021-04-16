package IAS.HandyManCalculator.repository.service;

import IAS.HandyManCalculator.domain.ServiceType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// This is an exploration class
public class SQLServiceCrudRepository implements ServiceCRUDRepository {
    @Override
    public void store(ServiceType item) {

    }

    @Override
    public void update(ServiceType item) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<ServiceType> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<ServiceType> list() {
        return null;
    }
}
