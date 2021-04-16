package IAS.HandyManCalculator.services.serviceType;

import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.ServiceType;
import IAS.HandyManCalculator.errors.ResourceNotFoundError;
import IAS.HandyManCalculator.model.serviceType.ReadServiceByIdInput;
import IAS.HandyManCalculator.model.serviceType.ReadServiceByIdOutput;
import IAS.HandyManCalculator.repository.service.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadServiceByIdUseCase implements UseCase<ReadServiceByIdInput, ReadServiceByIdOutput> {
    private final ServiceRepository repository;

    public ReadServiceByIdUseCase(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<ReadServiceByIdOutput> execute(ReadServiceByIdInput input) {
        Optional<ServiceType> serviceById = repository.findServiceById(input.getId());
        if (serviceById.isPresent()) {
            ServiceType service = serviceById.get();
            ReadServiceByIdOutput output = new ReadServiceByIdOutput(service);
            return OperationResult.ofValue(output);
        } else {
            String errorMessage = "ServiceType with id: " + input.getId() + " does not exists";
            ResourceNotFoundError notFoundError = new ResourceNotFoundError(errorMessage);
            return OperationResult.ofError(notFoundError);
        }
    }
}
