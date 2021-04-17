package IAS.HandyManCalculator.services.serviceType;

import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.ServiceType;
import IAS.HandyManCalculator.model.serviceType.CreateServiceTypeOperationInput;
import IAS.HandyManCalculator.model.serviceType.CreateServiceTypeOperationOutput;
import IAS.HandyManCalculator.repository.service.ServiceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateServiceTypeUseCase implements UseCase<CreateServiceTypeOperationInput, CreateServiceTypeOperationOutput> {
    private final ServiceTypeRepository repository;

    public CreateServiceTypeUseCase(ServiceTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<CreateServiceTypeOperationOutput> execute(CreateServiceTypeOperationInput input) {
        UUID serviceId = UUID.randomUUID();
        ServiceType service = new ServiceType(
                serviceId,
                input.getName()
        );
        repository.storeService(service);
        CreateServiceTypeOperationOutput output = new CreateServiceTypeOperationOutput(service);
        return OperationResult.ofValue(output);
    }
}
