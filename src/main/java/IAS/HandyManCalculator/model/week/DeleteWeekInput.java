package IAS.HandyManCalculator.model.week;

import IAS.HandyManCalculator.commons.Validate;

import java.util.UUID;

public class DeleteWeekInput {
    private final UUID weekId;

    public DeleteWeekInput(UUID weekId) {
        Validate.checkNotNull(weekId);
        this.weekId = weekId;
    }

    public UUID getWeekId() {
        return weekId;
    }
}
