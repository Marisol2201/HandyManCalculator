package IAS.HandyManCalculator.repository.service;

import IAS.HandyManCalculator.domain.ServiceType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiceRepository {
    void storeService(ServiceType service);

    void updateService(ServiceType service);

    void deleteService(UUID id);

    Optional<ServiceType> findServiceById(UUID id);

    List<ServiceType> listServices();
}
