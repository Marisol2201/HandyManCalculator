package IAS.HandyManCalculator.services.week;

import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.errors.ResourceNotFoundError;
import IAS.HandyManCalculator.model.week.UpdateWeekInput;
import IAS.HandyManCalculator.model.week.UpdateWeekOutput;
import IAS.HandyManCalculator.repository.week.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateWeekUseCase implements UseCase<UpdateWeekInput, UpdateWeekOutput> {
    private final WeekRepository repository;

    public UpdateWeekUseCase(WeekRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<UpdateWeekOutput> execute(UpdateWeekInput input) {
        Optional<Week> weekById = repository.findWeekById(input.getId());
        System.out.println("This is input: "+ input);
        if (weekById.isPresent()) {
            Week week = weekById.get();
            System.out.println("This is week: "+ week);
            UpdateWeekOutput output = new UpdateWeekOutput(week);
            return OperationResult.ofValue(output);
        } else {
            String errorMessage = "Week with id: " + input.getId() + " does not exists";
            ResourceNotFoundError notFoundError = new ResourceNotFoundError(errorMessage);
            return OperationResult.ofError(notFoundError);
        }
    }
}

