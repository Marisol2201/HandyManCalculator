package IAS.HandyManCalculator.repository.service;

import IAS.HandyManCalculator.domain.ServiceType;
import IAS.HandyManCalculator.repository.CrudRepository;

import java.util.UUID;

// This is an exploration class
public interface ServiceCRUDRepository extends CrudRepository<ServiceType, UUID> {
}
