package IAS.HandyManCalculator.repository.technician;

import IAS.HandyManCalculator.domain.Technician;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TechnicianRepository {
    void storeTechnician(Technician technician);

    void updateTechnician(Technician technician);

    void deleteTechnician(UUID id);

    Optional<Technician> findTechnicianById(UUID id);

    List<Technician> listTechnicians();
}
