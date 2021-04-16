package IAS.HandyManCalculator.services.serviceType;

import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.ServiceType;
import IAS.HandyManCalculator.model.serviceType.CreateServiceOperationInput;
import IAS.HandyManCalculator.model.serviceType.CreateServiceOperationOutput;
import IAS.HandyManCalculator.repository.service.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateServiceUseCase implements UseCase<CreateServiceOperationInput, CreateServiceOperationOutput> {
    private final ServiceRepository repository;

    public CreateServiceUseCase(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<CreateServiceOperationOutput> execute(CreateServiceOperationInput input) {
        UUID serviceId = UUID.randomUUID();
        ServiceType service = new ServiceType(
                serviceId,
                input.getName()
        );
        repository.storeService(service);
        CreateServiceOperationOutput output = new CreateServiceOperationOutput(service);
        return OperationResult.ofValue(output);
    }
}
