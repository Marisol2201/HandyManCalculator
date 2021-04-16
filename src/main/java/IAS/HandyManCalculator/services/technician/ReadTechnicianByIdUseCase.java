package IAS.HandyManCalculator.services.technician;

import org.springframework.stereotype.Service;
import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.Technician;
import IAS.HandyManCalculator.errors.ResourceNotFoundError;
import IAS.HandyManCalculator.model.technician.ReadTechnicianByIdInput;
import IAS.HandyManCalculator.model.technician.ReadTechnicianByIdOutput;
import IAS.HandyManCalculator.repository.technician.TechnicianRepository;

import java.util.Optional;

@Service
public class ReadTechnicianByIdUseCase implements UseCase<ReadTechnicianByIdInput, ReadTechnicianByIdOutput> {
    private final TechnicianRepository repository;

    public ReadTechnicianByIdUseCase(TechnicianRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<ReadTechnicianByIdOutput> execute(ReadTechnicianByIdInput input) {
        Optional<Technician> technicianById = repository.findTechnicianById(input.getId());
        if (technicianById.isPresent()) {
            Technician technician = technicianById.get();
            ReadTechnicianByIdOutput output = new ReadTechnicianByIdOutput(technician);
            return OperationResult.ofValue(output);
        } else {
            String errorMessage = "Technician with id: " + input.getId() + " does not exists";
            ResourceNotFoundError notFoundError = new ResourceNotFoundError(errorMessage);
            return OperationResult.ofError(notFoundError);
        }
    }
}
