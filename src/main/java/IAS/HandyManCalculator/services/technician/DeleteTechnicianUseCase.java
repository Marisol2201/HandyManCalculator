/*
package IAS.HandyManCalculator.services.technician;
import org.springframework.stereotype.Service;
import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.Technician;
import IAS.HandyManCalculator.errors.ResourceNotFoundError;
import IAS.HandyManCalculator.model.technician.DeleteTechnicianInput;
import IAS.HandyManCalculator.model.technician.DeleteTechnicianOutput;
import IAS.HandyManCalculator.repository.technician.TechnicianRepository;

import java.util.Optional;

@Service
public class DeleteTechnicianUseCase implements UseCase<DeleteTechnicianInput, DeleteTechnicianOutput> {
    private final TechnicianRepository repository;

    public DeleteTechnicianUseCase(TechnicianRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<DeleteTechnicianOutput> execute(DeleteTechnicianInput input) {
        Optional<Technician> technicianById = repository.findTechnicianById(input.getTechnicianId());
        if (technicianById.isPresent()) {
            Technician technician = technicianById.get();
            DeleteTechnicianOutput output = new DeleteTechnicianOutput(technician);
            return OperationResult.ofValue(output);
        } else {
            String errorMessage = "Technician with id: " + input.getTechnicianId() + " does not exists";
            ResourceNotFoundError notFoundError = new ResourceNotFoundError(errorMessage);
            return OperationResult.ofError(notFoundError);
        }
    }
}
*/
