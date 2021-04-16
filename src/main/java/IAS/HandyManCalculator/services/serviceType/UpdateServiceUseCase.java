package IAS.HandyManCalculator.services.serviceType;

import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.ServiceType;
import IAS.HandyManCalculator.errors.ResourceNotFoundError;
import IAS.HandyManCalculator.model.serviceType.UpdateServiceInput;
import IAS.HandyManCalculator.model.serviceType.UpdateServiceOutput;
import IAS.HandyManCalculator.repository.service.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateServiceUseCase implements UseCase<UpdateServiceInput, UpdateServiceOutput> {
    private final ServiceRepository repository;

    public UpdateServiceUseCase(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<UpdateServiceOutput> execute(UpdateServiceInput input) {
        Optional<ServiceType> serviceById = repository.findServiceById(input.getId());
        System.out.println("This is input: "+ input);
        if (serviceById.isPresent()) {
            ServiceType service = serviceById.get();
            System.out.println("This is service: "+ service);
            UpdateServiceOutput output = new UpdateServiceOutput(service);
            return OperationResult.ofValue(output);
        } else {
            String errorMessage = "Service with id: " + input.getId() + " does not exists";
            ResourceNotFoundError notFoundError = new ResourceNotFoundError(errorMessage);
            return OperationResult.ofError(notFoundError);
        }
    }
}

