package IAS.HandyManCalculator.controller;

import IAS.HandyManCalculator.domain.ServiceType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import IAS.HandyManCalculator.commons.ControllerHandler;
import IAS.HandyManCalculator.model.serviceType.*;
import IAS.HandyManCalculator.services.serviceType.CreateServiceTypeUseCase;
import IAS.HandyManCalculator.services.serviceType.ServiceTypeService;
import IAS.HandyManCalculator.services.serviceType.ReadServiceTypeByIdUseCase;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceTypeService service;
    private final CreateServiceTypeUseCase createService;
    private final ReadServiceTypeByIdUseCase readServiceTypeByIdUseCase;

    public ServiceController(
            ServiceTypeService service,
            CreateServiceTypeUseCase createService,
            ReadServiceTypeByIdUseCase readServiceTypeByIdUseCase
    ) {
        this.service = service;
        this.createService = createService;
        this.readServiceTypeByIdUseCase = readServiceTypeByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> createService(
            @RequestBody CreateServiceTypeOperationInput input
    ) {
        return new ControllerHandler<>(
                () -> input,
                createService
        )
                .execute();
    }

    @GetMapping
    public List<ServiceType> listServices() {
        return service.listServices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readServiceById(
            @PathVariable("id") String id
    ) {
        return new ControllerHandler<>(
                () -> {
                    UUID uuid = UUID.fromString(id);
                    return new ReadServiceTypeByIdInput(uuid);
                },
                readServiceTypeByIdUseCase
        )
                .execute();
    }

    @PutMapping
    public UpdateServiceTypeOutput updateService(
            @RequestBody UpdateServiceTypeInput input
    ) {
        return service.updateServiceOperation(input);
    }

    @DeleteMapping("/{serviceId}")
    public DeleteServiceTypeOutput deleteService(@PathVariable("serviceId") String unsafeServiceId) {
        UUID serviceId = UUID.fromString(unsafeServiceId);
        DeleteServiceTypeInput input = new DeleteServiceTypeInput(serviceId);
        return service.deleteServiceOperation(input);
    }
}