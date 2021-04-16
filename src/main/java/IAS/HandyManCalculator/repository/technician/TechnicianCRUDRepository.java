package IAS.HandyManCalculator.repository.technician;

import IAS.HandyManCalculator.domain.Technician;
import IAS.HandyManCalculator.repository.CrudRepository;

import java.util.UUID;

// This is an exploration class
public interface TechnicianCRUDRepository extends CrudRepository<Technician, UUID> {
}
