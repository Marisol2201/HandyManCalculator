package IAS.HandyManCalculator.controller;

import IAS.HandyManCalculator.domain.ServiceType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import IAS.HandyManCalculator.commons.ControllerHandler;
import IAS.HandyManCalculator.model.serviceType.*;
import IAS.HandyManCalculator.services.serviceType.CreateServiceUseCase;
import IAS.HandyManCalculator.services.serviceType.ServiceService;
import IAS.HandyManCalculator.services.serviceType.ReadServiceByIdUseCase;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceService service;
    private final CreateServiceUseCase createService;
    private final ReadServiceByIdUseCase readServiceByIdUseCase;

    public ServiceController(
            ServiceService service,
            CreateServiceUseCase createService,
            ReadServiceByIdUseCase readServiceByIdUseCase
    ) {
        this.service = service;
        this.createService = createService;
        this.readServiceByIdUseCase = readServiceByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> createService(
            @RequestBody CreateServiceOperationInput input
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
                    return new ReadServiceByIdInput(uuid);
                },
                readServiceByIdUseCase
        )
                .execute();
    }

    @PutMapping
    public UpdateServiceOutput updateService(
            @RequestBody UpdateServiceInput input
    ) {
        return service.updateServiceOperation(input);
    }

    @DeleteMapping("/{serviceId}")
    public DeleteServiceOutput deleteService(@PathVariable("serviceId") String unsafeServiceId) {
        UUID serviceId = UUID.fromString(unsafeServiceId);
        DeleteServiceInput input = new DeleteServiceInput(serviceId);
        return service.deleteServiceOperation(input);
    }
}