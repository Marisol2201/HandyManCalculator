package IAS.HandyManCalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import IAS.HandyManCalculator.commons.ControllerHandler;
import IAS.HandyManCalculator.commons.OperationError;
import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.model.week.*;
import IAS.HandyManCalculator.services.week.CreateWeekUseCase;
import IAS.HandyManCalculator.services.week.WeekService;
import IAS.HandyManCalculator.services.week.ReadWeekByIdUseCase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/weeks")
public class WeekController {
    private final WeekService service;
    private final CreateWeekUseCase createWeek;
    private final ReadWeekByIdUseCase readWeekByIdUseCase;

    public WeekController(
            WeekService service,
            CreateWeekUseCase createWeek,
            ReadWeekByIdUseCase readWeekByIdUseCase
    ) {
        this.service = service;
        this.createWeek = createWeek;
        this.readWeekByIdUseCase = readWeekByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> createWeek(
            @RequestBody CreateWeekOperationInput input
    ) {
        return new ControllerHandler<>(
                () -> input,
                createWeek
        )
                .execute();
    }

    @GetMapping
    public List<Week> listWeeks() {
        return service.listWeeks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readWeekById(
            @PathVariable("id") String id
    ) {
        return new ControllerHandler<>(
                () -> {
                    UUID uuid = UUID.fromString(id);
                    return new ReadWeekByIdInput(uuid);
                },
                readWeekByIdUseCase
        )
                .execute();
    }

    @PutMapping
    public UpdateWeekOutput updateWeek(
            @RequestBody UpdateWeekInput input
    ) {
        return service.updateWeekOperation(input);
    }

    @DeleteMapping("/{weekId}")
    public DeleteWeekOutput deleteWeek(@PathVariable("weekId") String unsafeWeekId) {
        UUID weekId = UUID.fromString(unsafeWeekId);
        DeleteWeekInput input = new DeleteWeekInput(weekId);
        return service.deleteWeekOperation(input);
    }
}