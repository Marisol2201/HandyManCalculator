package IAS.HandyManCalculator.services.week;

import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.model.week.CreateWeekOperationInput;
import IAS.HandyManCalculator.model.week.CreateWeekOperationOutput;
import IAS.HandyManCalculator.repository.week.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateWeekUseCase implements UseCase<CreateWeekOperationInput, CreateWeekOperationOutput> {
    private final WeekRepository repository;

    public CreateWeekUseCase(WeekRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<CreateWeekOperationOutput> execute(CreateWeekOperationInput input) {
        UUID weekId = UUID.randomUUID();
        Week week = new Week(
                weekId,
                input.getName()
        );
        repository.storeWeek(week);
        CreateWeekOperationOutput output = new CreateWeekOperationOutput(week);
        return OperationResult.ofValue(output);
    }
}
