package IAS.HandyManCalculator.services.technician;

import IAS.HandyManCalculator.domain.Technician;
import IAS.HandyManCalculator.model.technician.CreateTechnicianOperationInput;
import IAS.HandyManCalculator.model.technician.CreateTechnicianOperationOutput;
import IAS.HandyManCalculator.model.technician.ReadTechnicianByIdInput;
import IAS.HandyManCalculator.model.technician.ReadTechnicianByIdOutput;
import org.springframework.stereotype.Service;
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

    public CreateTechnicianOperationOutput createTechnician(CreateTechnicianOperationInput input) {
        UUID productId = UUID.randomUUID();
        Technician product = new Technician(
                productId,
                input.getName()
        );
        repository.storeTechnician(product);
        return new CreateTechnicianOperationOutput(product);
    }

    public List<Technician> listTechnicians() {
        return repository.listTechnicians();
    }

    public Optional<ReadTechnicianByIdOutput> readTechnicianByIdOperation(ReadTechnicianByIdInput input) {
        Optional<Technician> productById = repository.findTechnicianById(input.getId());
        if (productById.isPresent()) {
            Technician product = productById.get();
            ReadTechnicianByIdOutput output = new ReadTechnicianByIdOutput(product);
            return Optional.of(output);
        } else {
            return Optional.empty();
        }
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
