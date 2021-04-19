/*
package IAS.HandyManCalculator.services.serviceType;

import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.ServiceType;
import IAS.HandyManCalculator.errors.ResourceNotFoundError;
import IAS.HandyManCalculator.model.serviceType.ReadServiceTypeByIdInput;
import IAS.HandyManCalculator.model.serviceType.ReadServiceTypeByIdOutput;
import IAS.HandyManCalculator.repository.service.ServiceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadServiceTypeByIdUseCase implements UseCase<ReadServiceTypeByIdInput, ReadServiceTypeByIdOutput> {
    private final ServiceTypeRepository repository;

    public ReadServiceTypeByIdUseCase(ServiceTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<ReadServiceTypeByIdOutput> execute(ReadServiceTypeByIdInput input) {
        Optional<ServiceType> serviceById = repository.findServiceById(input.getId());
        if (serviceById.isPresent()) {
            ServiceType service = serviceById.get();
            ReadServiceTypeByIdOutput output = new ReadServiceTypeByIdOutput(service);
            return OperationResult.ofValue(output);
        } else {
            String errorMessage = "ServiceType with id: " + input.getId() + " does not exists";
            ResourceNotFoundError notFoundError = new ResourceNotFoundError(errorMessage);
            return OperationResult.ofError(notFoundError);
        }
    }
}
*/
