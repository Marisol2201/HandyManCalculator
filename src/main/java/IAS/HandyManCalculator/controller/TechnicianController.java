package IAS.HandyManCalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import IAS.HandyManCalculator.commons.ControllerHandler;
import IAS.HandyManCalculator.commons.OperationError;
import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.domain.Technician;
import IAS.HandyManCalculator.model.technician.*;
import IAS.HandyManCalculator.services.technician.CreateTechnicianUseCase;
import IAS.HandyManCalculator.services.technician.TechnicianService;
import IAS.HandyManCalculator.services.technician.ReadTechnicianByIdUseCase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/technicians")
public class TechnicianController {
    private final TechnicianService service;
    private final CreateTechnicianUseCase createTechnician;
    private final ReadTechnicianByIdUseCase readTechnicianByIdUseCase;

    public TechnicianController(
            TechnicianService service,
            CreateTechnicianUseCase createTechnician,
            ReadTechnicianByIdUseCase readTechnicianByIdUseCase
    ) {
        this.service = service;
        this.createTechnician = createTechnician;
        this.readTechnicianByIdUseCase = readTechnicianByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> createTechnician(
            @RequestBody CreateTechnicianOperationInput input
    ) {
        return new ControllerHandler<>(
                () -> input,
                createTechnician
        )
                .execute();
    }

    @GetMapping
    public List<Technician> listTechnicians() {
        return service.listTechnicians();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readTechnicianById(
            @PathVariable("id") String id
    ) {
        return new ControllerHandler<>(
                () -> {
                    UUID uuid = UUID.fromString(id);
                    return new ReadTechnicianByIdInput(uuid);
                },
                readTechnicianByIdUseCase
        )
                .execute();
    }

    @PutMapping
    public UpdateTechnicianOutput updateTechnician(
            @RequestBody UpdateTechnicianInput input
    ) {
        return service.updateTechnicianOperation(input);
    }

    @DeleteMapping("/{technicianId}")
    public DeleteTechnicianOutput deleteTechnician(@PathVariable("technicianId") String unsafeTechnicianId) {
        UUID technicianId = UUID.fromString(unsafeTechnicianId);
        DeleteTechnicianInput input = new DeleteTechnicianInput(technicianId);
        return service.deleteTechnicianOperation(input);
    }
}