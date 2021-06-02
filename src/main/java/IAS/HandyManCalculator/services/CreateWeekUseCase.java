package IAS.HandyManCalculator.services;

import IAS.HandyManCalculator.commons.CalculateWeek;
import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.OperationsWithNormalHours;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.model.CreateWeekOperationInput;
import IAS.HandyManCalculator.model.CreateWeekOperationOutput;
import IAS.HandyManCalculator.repository.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CreateWeekUseCase implements UseCase<CreateWeekOperationInput, CreateWeekOperationOutput> {
    private final WeekRepository repository;

    public CreateWeekUseCase(WeekRepository repository) {
        this.repository = repository;
    }

    OperationsWithNormalHours operationsWithNormalHours = new OperationsWithNormalHours();
    CalculateWeek calculateWeek = new CalculateWeek();

    @Override
    public OperationResult<CreateWeekOperationOutput> execute(CreateWeekOperationInput input) {

        String weekNumber = calculateWeek.calculateWeekNumber(input.getDates());
        ArrayList<Short> result = operationsWithNormalHours.switchCase(input.getDates());
        short totalWeekHours = result.get(0);
        short totalWeekNormalHours = result.get(1);
        short weekNormalDaytimeHours = result.get(2);
        short weekNormalNightHours = result.get(3);
        short sundayNormalHours = result.get(4);
        short totalWeekExtraHours = result.get(5);
        short weekExtraDaytimeHours = result.get(6);
        short weekExtraNightHours = result.get(7);
        short sundayExtraHours = result.get(8);

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
        CreateWeekOperationOutput output = new CreateWeekOperationOutput(week);
        return OperationResult.ofValue(output);
    }
}
