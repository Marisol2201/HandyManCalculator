package IAS.HandyManCalculator.services;

import IAS.HandyManCalculator.commons.CalculateWeek;
import IAS.HandyManCalculator.commons.OperationsWithNormalHours;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.model.*;
import IAS.HandyManCalculator.repository.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WeekService {
    private final WeekRepository repository;

    public WeekService(WeekRepository repository) {
        this.repository = repository;
    }

    OperationsWithNormalHours operationsWithNormalHours = new OperationsWithNormalHours();
    OperationsWithNormalHours operationsWithExtraHours = new OperationsWithNormalHours();
    CalculateWeek calculateWeek = new CalculateWeek();

    //POST
    public CreateWeekOperationOutput createWeek(CreateWeekOperationInput input) {

        String weekNumber = calculateWeek.calculateWeekNumber(input.getDates());
        ArrayList<Short> result = operationsWithNormalHours.switchCase(input.getDates());

        short totalWeekHours = result.get(0);
        short totalWeekNormalHours = result.get(1);
        short weekNormalDaytimeHours = result.get(2);
        short weekNormalNightHours = result.get(3);
        short sundayNormalHours = result.get(4);
        short totalWeekExtraHours = result.get(5);
        short weekExtraDaytimeHours = result.get(8);
        short weekExtraNightHours = result.get(7);
        short sundayExtraHours = result.get(6);

        Week week = new Week(
                weekNumber,
                input.getTechnicianId(),
                input.getServiceId(),
                totalWeekHours,
                totalWeekNormalHours,
                weekNormalDaytimeHours,
                weekNormalNightHours,
                sundayNormalHours,
                totalWeekExtraHours,
                weekExtraDaytimeHours,
                weekExtraNightHours,
                sundayExtraHours);

        repository.storeWeek(week);
        return new CreateWeekOperationOutput(week);
    }

    //GET
    public List<Week> listWeeks() {
        return repository.listWeeks();
    }

    public Optional<ReadWeekByIdOutput> readWeekByIdOperation(ReadWeekByIdInput input) {
        Optional<Week> weekById = repository.findWeekById(input.getId());
        if (weekById.isPresent()) {
            Week week = weekById.get();
            ReadWeekByIdOutput output = new ReadWeekByIdOutput(week);
            return Optional.of(output);
        } else {
            return Optional.empty();
        }
    }

    //PUT
    public UpdateWeekOutput updateWeekOperation(UpdateWeekInput input) {

        String weekId = calculateWeek.calculateWeekNumber(input.getDates());
        Optional<Week> weekById = repository.findWeekById(weekId);
        if (weekById.isPresent()) {
            Week dbWeek = weekById.get();
            List<Short> result;
            if (dbWeek.getTotalWeekHours() < 48) {
                result = operationsWithNormalHours.switchCase(input.getDates());
            } else {
                result = operationsWithExtraHours.switchCase(input.getDates());
            }
            Week weekUpdate = new Week(
                    dbWeek.getId(),
                    dbWeek.getTechnicianId(),
                    dbWeek.getServiceId(),
                    calculateWeek.sumHours(result.get(0), (dbWeek.getTotalWeekHours())),
                    calculateWeek.sumHours(result.get(1), (dbWeek.getTotalWeekNormalHours())),
                    calculateWeek.sumHours(result.get(2), (dbWeek.getWeekNormalDaytimeHours())),
                    calculateWeek.sumHours(result.get(3), (dbWeek.getWeekNormalNightHours())),
                    calculateWeek.sumHours(result.get(4), (dbWeek.getSundayNormalHours())),
                    calculateWeek.sumHours(result.get(5), (dbWeek.getTotalWeekExtraHours())),
                    calculateWeek.sumHours(result.get(6), (dbWeek.getWeekExtraDaytimeHours())),
                    calculateWeek.sumHours(result.get(7), (dbWeek.getWeekExtraNightHours())),
                    calculateWeek.sumHours(result.get(8), (dbWeek.getSundayExtraHours()))
            );
            repository.updateWeek(weekUpdate);
            return new UpdateWeekOutput(weekUpdate);
        } else {
            throw new IllegalArgumentException("Week " + weekId + " does not exist.");
        }
    }

    //DELETE
    public DeleteWeekOutput deleteWeekOperation(DeleteWeekInput input) {

        String weekId = input.getWeekId();
        Optional<Week> weekById = repository.findWeekById(weekId);
        if (weekById.isPresent()) {
            Week dbWeek = weekById.get();
            repository.deleteWeek(dbWeek.getId());
            return new DeleteWeekOutput(dbWeek);
        } else {
            throw new IllegalArgumentException("Week " + weekId + " does not exist.");
        }
    }
}
