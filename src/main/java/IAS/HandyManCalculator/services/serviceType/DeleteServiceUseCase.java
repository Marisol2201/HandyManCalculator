package IAS.HandyManCalculator.services.serviceType;

import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.ServiceType;
import IAS.HandyManCalculator.errors.ResourceNotFoundError;
import IAS.HandyManCalculator.model.serviceType.DeleteServiceInput;
import IAS.HandyManCalculator.model.serviceType.DeleteServiceOutput;
import IAS.HandyManCalculator.repository.service.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteServiceUseCase implements UseCase<DeleteServiceInput, DeleteServiceOutput> {
    private final ServiceRepository repository;

    public DeleteServiceUseCase(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<DeleteServiceOutput> execute(DeleteServiceInput input) {
        Optional<ServiceType> serviceById = repository.findServiceById(input.getServiceId());
        if (serviceById.isPresent()) {
            ServiceType service = serviceById.get();
            DeleteServiceOutput output = new DeleteServiceOutput(service);
            return OperationResult.ofValue(output);
        } else {
            String errorMessage = "ServiceType with id: " + input.getServiceId() + " does not exists";
            ResourceNotFoundError notFoundError = new ResourceNotFoundError(errorMessage);
            return OperationResult.ofError(notFoundError);
        }
    }
}
