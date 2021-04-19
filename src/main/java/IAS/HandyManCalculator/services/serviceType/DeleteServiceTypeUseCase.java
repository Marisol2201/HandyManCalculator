/*
package IAS.HandyManCalculator.services.serviceType;

import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.ServiceType;
import IAS.HandyManCalculator.errors.ResourceNotFoundError;
import IAS.HandyManCalculator.model.serviceType.DeleteServiceTypeInput;
import IAS.HandyManCalculator.model.serviceType.DeleteServiceTypeOutput;
import IAS.HandyManCalculator.repository.service.ServiceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteServiceTypeUseCase implements UseCase<DeleteServiceTypeInput, DeleteServiceTypeOutput> {
    private final ServiceTypeRepository repository;

    public DeleteServiceTypeUseCase(ServiceTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<DeleteServiceTypeOutput> execute(DeleteServiceTypeInput input) {
        Optional<ServiceType> serviceById = repository.findServiceById(input.getServiceId());
        if (serviceById.isPresent()) {
            ServiceType service = serviceById.get();
            DeleteServiceTypeOutput output = new DeleteServiceTypeOutput(service);
            return OperationResult.ofValue(output);
        } else {
            String errorMessage = "ServiceType with id: " + input.getServiceId() + " does not exists";
            ResourceNotFoundError notFoundError = new ResourceNotFoundError(errorMessage);
            return OperationResult.ofError(notFoundError);
        }
    }
}
*/
