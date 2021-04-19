package IAS.HandyManCalculator.services.week;

import IAS.HandyManCalculator.commons.CalculateTime;
import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.model.week.CreateWeekOperationInput;
import IAS.HandyManCalculator.model.week.CreateWeekOperationOutput;
import IAS.HandyManCalculator.repository.week.WeekRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateWeekUseCase implements UseCase<CreateWeekOperationInput, CreateWeekOperationOutput> {
    private final WeekRepository repository;

    public CreateWeekUseCase(WeekRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<CreateWeekOperationOutput> execute(CreateWeekOperationInput input) {

        CalculateTime calculateTime = new CalculateTime(input.getDate());
        short weekHours = calculateTime.differenceInHoursBetweenDates(input.getDate());
        String weekNumber = calculateTime.calculateWeekNumber(input.getDate());

        Week week = new Week(
                weekNumber,
                weekHours
        );
        repository.storeWeek(week);
        CreateWeekOperationOutput output = new CreateWeekOperationOutput(week);
        return OperationResult.ofValue(output);
    }
}
