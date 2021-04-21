package IAS.HandyManCalculator.services.serviceType;

import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.ServiceType;
import IAS.HandyManCalculator.errors.ResourceNotFoundError;
import IAS.HandyManCalculator.model.serviceType.UpdateServiceTypeInput;
import IAS.HandyManCalculator.model.serviceType.UpdateServiceTypeOutput;
import IAS.HandyManCalculator.repository.service.ServiceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateServiceTypeUseCase implements UseCase<UpdateServiceTypeInput, UpdateServiceTypeOutput> {
    private final ServiceTypeRepository repository;

    public UpdateServiceTypeUseCase(ServiceTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<UpdateServiceTypeOutput> execute(UpdateServiceTypeInput input) {
        Optional<ServiceType> serviceById = repository.findServiceById(input.getId());
        System.out.println("This is input: "+ input);
        if (serviceById.isPresent()) {
            ServiceType service = serviceById.get();
            System.out.println("This is service: "+ service);
            UpdateServiceTypeOutput output = new UpdateServiceTypeOutput(service);
            return OperationResult.ofValue(output);
        } else {
            String errorMessage = "Service with id: " + input.getId() + " does not exists";
            ResourceNotFoundError notFoundError = new ResourceNotFoundError(errorMessage);
            return OperationResult.ofError(notFoundError);
        }
    }
}

