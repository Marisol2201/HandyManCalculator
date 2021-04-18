package IAS.HandyManCalculator.services.week;

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
        Week week = new Week(
                input.getId(),
                input.getHours()
        );
        repository.storeWeek(week);
        CreateWeekOperationOutput output = new CreateWeekOperationOutput(week);
        return OperationResult.ofValue(output);
    }
}
