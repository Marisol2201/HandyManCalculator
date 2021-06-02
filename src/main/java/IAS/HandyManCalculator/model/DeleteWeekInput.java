package IAS.HandyManCalculator.model;

import IAS.HandyManCalculator.commons.Validate;

public class DeleteWeekInput {
    private final String weekId;

    public DeleteWeekInput(String weekId) {
        Validate.checkNotNull(weekId);
        this.weekId = weekId;
    }

    public String getWeekId() {
        return weekId;
    }
}
