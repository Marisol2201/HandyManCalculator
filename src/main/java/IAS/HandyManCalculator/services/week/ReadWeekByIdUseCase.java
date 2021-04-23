package IAS.HandyManCalculator.services.week;

import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.errors.ResourceNotFoundError;
import IAS.HandyManCalculator.model.week.ReadWeekByIdInput;
import IAS.HandyManCalculator.model.week.ReadWeekByIdOutput;
import IAS.HandyManCalculator.repository.week.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadWeekByIdUseCase implements UseCase<ReadWeekByIdInput, ReadWeekByIdOutput> {
    private final WeekRepository repository;

    public ReadWeekByIdUseCase(WeekRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<ReadWeekByIdOutput> execute(ReadWeekByIdInput input) {
        Optional<Week> weekById = repository.findWeekById(input.getId());
        if (weekById.isPresent()) {
            Week week = weekById.get();
            ReadWeekByIdOutput output = new ReadWeekByIdOutput(week);
            return OperationResult.ofValue(output);
        } else {
            String errorMessage = "Week with id: " + input.getId() + " does not exists";
            ResourceNotFoundError notFoundError = new ResourceNotFoundError(errorMessage);
            return OperationResult.ofError(notFoundError);
        }
    }
}
