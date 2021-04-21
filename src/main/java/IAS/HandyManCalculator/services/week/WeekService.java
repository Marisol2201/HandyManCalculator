package IAS.HandyManCalculator.services.week;

import IAS.HandyManCalculator.commons.CalculateWeek;
import IAS.HandyManCalculator.commons.OperationsWithNormalHours;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.model.week.*;
import IAS.HandyManCalculator.repository.week.WeekRepository;
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
    CalculateWeek calculateTime = new CalculateWeek();

    //POST
    public CreateWeekOperationOutput createWeek(CreateWeekOperationInput input) {

        String weekNumber = calculateTime.calculateWeekNumber(input.getDates());
        ArrayList result = operationsWithNormalHours.switchCase(input.getDates());
        short totalWeekHours = (short) result.get(5);
        short totalWeekNormalHours = (short) result.get(3);
        short weekNormalDaytimeHours = (short) result.get(0);
        short weekNormalNightHours = (short) result.get(1);
        short sundayNormalHours = (short) result.get(2);
        short totalWeekExtraHours = (short) result.get(4);
        short weekExtraDaytimeHours = 0;
        short weekExtraNightHours = 0;
        short sundayExtraHours = 0;

        Week week = new Week(
                weekNumber,
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

        CalculateWeek calculateTime = new CalculateWeek();
        String weekNumber = calculateTime.calculateWeekNumber(input.getDates());
        short weekHours = calculateTime.differenceInHoursBetweenDates(input.getDates());

        String weekId = weekNumber;
        Optional<Week> weekById = repository.findWeekById(weekId);
        if (weekById.isPresent()) {
            Week dbWeek = weekById.get();
            Week weekUpdate = new Week(
                    dbWeek.getId(),
                    dbWeek.getTotalWeekHours(),
                    dbWeek.getTotalWeekNormalHours(),
                    dbWeek.getWeekNormalDaytimeHours(),
                    dbWeek.getWeekNormalNightHours(),
                    dbWeek.getSundayNormalHours(),
                    dbWeek.getTotalWeekExtraHours(),
                    dbWeek.getWeekExtraDaytimeHours(),
                    dbWeek.getWeekExtraNightHours(),
                    dbWeek.getSundayExtraHours());

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
