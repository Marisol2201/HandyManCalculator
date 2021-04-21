package IAS.HandyManCalculator.services.week;

import IAS.HandyManCalculator.commons.CalculateWeek;
import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.OperationsWithNormalHours;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.model.week.CreateWeekOperationInput;
import IAS.HandyManCalculator.model.week.CreateWeekOperationOutput;
import IAS.HandyManCalculator.repository.week.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CreateWeekUseCase implements UseCase<CreateWeekOperationInput, CreateWeekOperationOutput> {
    private final WeekRepository repository;

    public CreateWeekUseCase(WeekRepository repository) {
        this.repository = repository;
    }

    OperationsWithNormalHours operationsWithNormalHours = new OperationsWithNormalHours();
    CalculateWeek calculateTime = new CalculateWeek();

    @Override
    public OperationResult<CreateWeekOperationOutput> execute(CreateWeekOperationInput input) {

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
        CreateWeekOperationOutput output = new CreateWeekOperationOutput(week);
        return OperationResult.ofValue(output);
    }
}
