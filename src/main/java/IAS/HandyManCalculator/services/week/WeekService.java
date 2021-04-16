package IAS.HandyManCalculator.services.week;

import IAS.HandyManCalculator.domain.Week;
import IAS.HandyManCalculator.model.week.DeleteWeekInput;
import IAS.HandyManCalculator.model.week.DeleteWeekOutput;
import IAS.HandyManCalculator.model.week.UpdateWeekInput;
import IAS.HandyManCalculator.model.week.UpdateWeekOutput;
import IAS.HandyManCalculator.repository.week.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WeekService {
    private final WeekRepository repository;

    public WeekService(WeekRepository repository) {
        this.repository = repository;
    }

    public List<Week> listWeeks() {
        return repository.listWeeks();
    }



    public UpdateWeekOutput updateWeekOperation(
            UpdateWeekInput input
    ) {
        UUID weekId = input.getId();
        Optional<Week> weekById = repository.findWeekById(weekId);
        if (weekById.isPresent()) {
            Week dbWeek = weekById.get();
            Week weekUpdate = new Week(
                    dbWeek.getId(),
                    input.getName()
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
        UUID weekId = input.getWeekId();
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
