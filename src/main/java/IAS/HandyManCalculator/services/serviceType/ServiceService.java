package IAS.HandyManCalculator.services.serviceType;

import IAS.HandyManCalculator.domain.ServiceType;
import IAS.HandyManCalculator.model.serviceType.DeleteServiceInput;
import IAS.HandyManCalculator.model.serviceType.DeleteServiceOutput;
import IAS.HandyManCalculator.model.serviceType.UpdateServiceInput;
import IAS.HandyManCalculator.model.serviceType.UpdateServiceOutput;
import IAS.HandyManCalculator.repository.service.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceService {
    private final ServiceRepository repository;

    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }

    public List<ServiceType> listServices() {
        return repository.listServices();
    }



    public UpdateServiceOutput updateServiceOperation(
            UpdateServiceInput input
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
            return new UpdateServiceOutput(serviceUpdate);
        } else {
            throw new IllegalArgumentException("ServiceType " + serviceId + " does not exist.");
        }
    }

    public DeleteServiceOutput deleteServiceOperation(
            DeleteServiceInput input
    ) {
        UUID serviceId = input.getServiceId();
        Optional<ServiceType> serviceById = repository.findServiceById(serviceId);
        if (serviceById.isPresent()) {
            ServiceType dbService = serviceById.get();
            repository.deleteService(dbService.getId());
            return new DeleteServiceOutput(dbService);
        } else {
            throw new IllegalArgumentException("ServiceType " + serviceId + " does not exist.");
        }
    }
}
