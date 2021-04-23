package IAS.HandyManCalculator.services.technician;

import org.springframework.stereotype.Service;
import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.Technician;
import IAS.HandyManCalculator.model.technician.CreateTechnicianOperationInput;
import IAS.HandyManCalculator.model.technician.CreateTechnicianOperationOutput;
import IAS.HandyManCalculator.repository.technician.TechnicianRepository;

import java.util.UUID;

@Service
public class CreateTechnicianUseCase implements UseCase<CreateTechnicianOperationInput, CreateTechnicianOperationOutput> {
    private final TechnicianRepository repository;

    public CreateTechnicianUseCase(TechnicianRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<CreateTechnicianOperationOutput> execute(CreateTechnicianOperationInput input) {
        UUID technicianId = UUID.randomUUID();
        Technician technician = new Technician(
                technicianId,
                input.getName()
        );
        repository.storeTechnician(technician);
        CreateTechnicianOperationOutput output = new CreateTechnicianOperationOutput(technician);
        return OperationResult.ofValue(output);
    }
}
