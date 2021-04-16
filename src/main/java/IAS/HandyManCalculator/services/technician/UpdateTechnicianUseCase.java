package IAS.HandyManCalculator.services.technician;
import org.springframework.stereotype.Service;
import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.Technician;
import IAS.HandyManCalculator.errors.ResourceNotFoundError;
import IAS.HandyManCalculator.model.technician.*;
import IAS.HandyManCalculator.repository.technician.TechnicianRepository;

import java.util.Optional;

@Service
public class UpdateTechnicianUseCase implements UseCase<UpdateTechnicianInput, UpdateTechnicianOutput> {
    private final TechnicianRepository repository;

    public UpdateTechnicianUseCase(TechnicianRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<UpdateTechnicianOutput> execute(UpdateTechnicianInput input) {
        Optional<Technician> technicianById = repository.findTechnicianById(input.getId());
        System.out.println("This is input: "+ input);
        if (technicianById.isPresent()) {
            Technician technician = technicianById.get();
            System.out.println("This is technician: "+ technician);
            UpdateTechnicianOutput output = new UpdateTechnicianOutput(technician);
            return OperationResult.ofValue(output);
        } else {
            String errorMessage = "Technician with id: " + input.getId() + " does not exists";
            ResourceNotFoundError notFoundError = new ResourceNotFoundError(errorMessage);
            return OperationResult.ofError(notFoundError);
        }
    }
}

