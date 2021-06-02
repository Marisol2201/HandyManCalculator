package IAS.HandyManCalculator.model;

import IAS.HandyManCalculator.commons.Validate;
import IAS.HandyManCalculator.domain.Week;

public class UpdateWeekOutput {
    private final Week week;

    public UpdateWeekOutput(Week week) {
        Validate.checkNotNull(week);
        this.week = week;
    }

    public Week getWeek() {
        return week;
    }
}
