package IAS.HandyManCalculator.services.week;

import IAS.HandyManCalculator.commons.CalculateTime;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.model.week.*;
import IAS.HandyManCalculator.repository.week.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeekService {
    private final WeekRepository repository;

    public WeekService(WeekRepository repository) {
        this.repository = repository;
    }

    //post
    public CreateWeekOperationOutput createWeek(CreateWeekOperationInput input) {

        CalculateTime calculateTime = new CalculateTime(input.getDates());
        String weekNumber = calculateTime.calculateWeekNumber(input.getDates());
        short weekHours = calculateTime.differenceInHoursBetweenDates(input.getDates());

        Week week = new Week(
                weekNumber,
                weekHours
    );
        repository.storeWeek(week);
        return new CreateWeekOperationOutput(week);
    }

    //get
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

    //put
    public UpdateWeekOutput updateWeekOperation(UpdateWeekInput input) {

        CalculateTime calculateTime = new CalculateTime(input.getDates());
        String weekNumber = calculateTime.calculateWeekNumber(input.getDates());
        short weekHours = calculateTime.differenceInHoursBetweenDates(input.getDates());

        String weekId = weekNumber;
        Optional<Week> weekById = repository.findWeekById(weekId);
        if (weekById.isPresent()) {
            Week dbWeek = weekById.get();
            Week weekUpdate = new Week(
                    dbWeek.getId(),
                    calculateTime.sumHours(weekHours, (dbWeek.getHours()))
            );
            repository.updateWeek(weekUpdate);
            return new UpdateWeekOutput(weekUpdate);
        } else {
            throw new IllegalArgumentException("Week " + weekId + " does not exist.");
        }
    }

    public DeleteWeekOutput deleteWeekOperation(
            DeleteWeekInput input
    ) {
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
