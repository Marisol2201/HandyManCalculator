package IAS.HandyManCalculator.services.serviceType;

import IAS.HandyManCalculator.domain.ServiceType;
import IAS.HandyManCalculator.model.serviceType.DeleteServiceTypeInput;
import IAS.HandyManCalculator.model.serviceType.DeleteServiceTypeOutput;
import IAS.HandyManCalculator.model.serviceType.UpdateServiceTypeInput;
import IAS.HandyManCalculator.model.serviceType.UpdateServiceTypeOutput;
import IAS.HandyManCalculator.model.serviceType.CreateServiceTypeOperationInput;
import IAS.HandyManCalculator.model.serviceType.CreateServiceTypeOperationOutput;
import IAS.HandyManCalculator.model.serviceType.ReadServiceTypeByIdInput;
import IAS.HandyManCalculator.model.serviceType.ReadServiceTypeByIdOutput;
import IAS.HandyManCalculator.repository.service.ServiceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceTypeService {
    private final ServiceTypeRepository repository;

    public ServiceTypeService(ServiceTypeRepository repository) {
        this.repository = repository;
    }

    public CreateServiceTypeOperationOutput createServiceType(CreateServiceTypeOperationInput input) {
        UUID serviceTypeId = UUID.randomUUID();
        ServiceType serviceType = new ServiceType(
                serviceTypeId,
                input.getName()
        );
        repository.storeService(serviceType);
        return new CreateServiceTypeOperationOutput(serviceType);
    }

    public List<ServiceType> listServices() {
        return repository.listServices();
    }

    public Optional<ReadServiceTypeByIdOutput> readServiceTypeByIdOperation(ReadServiceTypeByIdInput input) {
        Optional<ServiceType> serviceTypeById = repository.findServiceById(input.getId());
        if (serviceTypeById.isPresent()) {
            ServiceType serviceType = serviceTypeById.get();
            ReadServiceTypeByIdOutput output = new ReadServiceTypeByIdOutput(serviceType);
            return Optional.of(output);
        } else {
            return Optional.empty();
        }
    }

    public UpdateServiceTypeOutput updateServiceOperation(
            UpdateServiceTypeInput input
    ) {
        UUID serviceId = input.getId();
        Optional<ServiceType> serviceById = repository.findServiceById(serviceId);
        if (serviceById.isPresent()) {
            ServiceType dbService = serviceById.get();
            ServiceType serviceUpdate = new ServiceType(
                    dbService.getId(),
                    input.getName()
            );
            repository.updateService(serviceUpdate);
            return new UpdateServiceTypeOutput(serviceUpdate);
        } else {
            throw new IllegalArgumentException("ServiceType " + serviceId + " does not exist.");
        }
    }

    public DeleteServiceTypeOutput deleteServiceOperation(
            DeleteServiceTypeInput input
    ) {
        UUID serviceId = input.getServiceId();
        Optional<ServiceType> serviceById = repository.findServiceById(serviceId);
        if (serviceById.isPresent()) {
            ServiceType dbService = serviceById.get();
            repository.deleteService(dbService.getId());
            return new DeleteServiceTypeOutput(dbService);
        } else {
            throw new IllegalArgumentException("ServiceType " + serviceId + " does not exist.");
        }
    }
}
