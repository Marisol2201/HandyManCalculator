package IAS.HandyManCalculator.controller;

import IAS.HandyManCalculator.model.*;
//import IAS.HandyManCalculator.serialization.ReportSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.services.WeekService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class WeekController {

    @Autowired
    private final WeekService service;

    public WeekController(
            WeekService service) { this.service = service; }


    @GetMapping("/reports")
    public Flux<Week> listWeeks() {
        return Flux.fromIterable(service.listWeeks());
    }

    @PostMapping("/reports")
    public Mono<Object> createWeek(
            @RequestBody CreateWeekOperationInput input) {
        System.out.println(input);
        return Mono.just(service.createWeek(input));
    }

    @GetMapping("/reports/{id}")
    public Mono<Object> readWeekById(
            @PathVariable ("id") String id) {
        return Mono.just(service.readWeekByIdOperation(new ReadWeekByIdInput(id)));
    }

    @PutMapping("/reports/{id}")
    public Mono<UpdateWeekOutput> updateWeek (
        @RequestBody UpdateWeekInput input) {
        return Mono.just(service.updateWeekOperation(input));
    }

    @DeleteMapping("/reports/{id}")
    public Mono<DeleteWeekOutput> deleteWeek(
            @PathVariable("id") String unsafeWeekId) {
        return Mono.just(service.deleteWeekOperation(new DeleteWeekInput(unsafeWeekId)));
    }
}