package IAS.HandyManCalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import IAS.HandyManCalculator.commons.ControllerHandler;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.model.week.*;
import IAS.HandyManCalculator.services.week.CreateWeekUseCase;
import IAS.HandyManCalculator.services.week.WeekService;
import IAS.HandyManCalculator.services.week.ReadWeekByIdUseCase;

import java.util.List;

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
            @RequestBody CreateWeekOperationInput input) {
        return new ControllerHandler<>(
                () -> input,
                createWeek)
                .execute();
    }

    @GetMapping
    public List<Week> listWeeks() {
        return service.listWeeks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readWeekById(
            @PathVariable("id") String id) {
        return new ControllerHandler<>(
                () -> {
                    String weekId = id;
                    return new ReadWeekByIdInput(weekId);
                },
                readWeekByIdUseCase)
                .execute();
    }

    @PutMapping
    public UpdateWeekOutput updateWeek(
            @RequestBody UpdateWeekInput input) {
        return service.updateWeekOperation(input);
    }

    @DeleteMapping
    public DeleteWeekOutput deleteWeek(
            @PathVariable("weekId") String unsafeWeekId) {
        String weekId = unsafeWeekId;
        DeleteWeekInput input = new DeleteWeekInput(weekId);
        return service.deleteWeekOperation(input);
    }
}