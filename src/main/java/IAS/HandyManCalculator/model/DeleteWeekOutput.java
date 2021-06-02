package IAS.HandyManCalculator.model;

import IAS.HandyManCalculator.commons.Validate;
import IAS.HandyManCalculator.domain.Week;

public class DeleteWeekOutput {
    private final Week week;

    public DeleteWeekOutput(Week week) {
        Validate.checkNotNull(week);
        this.week = week;
    }

    public Week getWeek() {
        return week;
    }
}
