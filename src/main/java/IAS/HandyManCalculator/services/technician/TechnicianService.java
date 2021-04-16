package IAS.HandyManCalculator.services.technician;

import org.springframework.stereotype.Service;
import IAS.HandyManCalculator.domain.Technician;
import IAS.HandyManCalculator.model.technician.*;
import IAS.HandyManCalculator.repository.technician.TechnicianRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TechnicianService {
    private final TechnicianRepository repository;

    public TechnicianService(TechnicianRepository repository) {
        this.repository = repository;
    }

    public List<Technician> listTechnicians() {
        return repository.listTechnicians();
    }



    public UpdateTechnicianOutput updateTechnicianOperation(
            UpdateTechnicianInput input
    ) {
        UUID technicianId = input.getId();
        Optional<Technician> technicianById = repository.findTechnicianById(technicianId);
        if (technicianById.isPresent()) {
            Technician dbTechnician = technicianById.get();
            Technician technicianUpdate = new Technician(
                    dbTechnician.getId(),
                    input.getName()
            );
            repository.updateTechnician(technicianUpdate);
            return new UpdateTechnicianOutput(technicianUpdate);
        } else {
            throw new IllegalArgumentException("Technician " + technicianId + " does not exist.");
        }
    }

    public DeleteTechnicianOutput deleteTechnicianOperation(
            DeleteTechnicianInput input
    ) {
        UUID technicianId = input.getTechnicianId();
        Optional<Technician> technicianById = repository.findTechnicianById(technicianId);
        if (technicianById.isPresent()) {
            Technician dbTechnician = technicianById.get();
            repository.deleteTechnician(dbTechnician.getId());
            return new DeleteTechnicianOutput(dbTechnician);
        } else {
            throw new IllegalArgumentException("Technician " + technicianId + " does not exist.");
        }
    }
}
