package IAS.HandyManCalculator.services;

import IAS.HandyManCalculator.commons.OperationResult;
import IAS.HandyManCalculator.commons.UseCase;
import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.errors.ResourceNotFoundError;
import IAS.HandyManCalculator.model.DeleteWeekInput;
import IAS.HandyManCalculator.model.DeleteWeekOutput;
import IAS.HandyManCalculator.repository.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteWeekUseCase implements UseCase<DeleteWeekInput, DeleteWeekOutput> {
    private final WeekRepository repository;

    public DeleteWeekUseCase(WeekRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResult<DeleteWeekOutput> execute(DeleteWeekInput input) {
        Optional<Week> weekById = repository.findWeekById(input.getWeekId());
        if (weekById.isPresent()) {
            Week week = weekById.get();
            DeleteWeekOutput output = new DeleteWeekOutput(week);
            return OperationResult.ofValue(output);
        } else {
            String errorMessage = "Week with id: " + input.getWeekId() + " does not exists";
            ResourceNotFoundError notFoundError = new ResourceNotFoundError(errorMessage);
            return OperationResult.ofError(notFoundError);
        }
    }
}
