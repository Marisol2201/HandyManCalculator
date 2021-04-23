package IAS.HandyManCalculator.model.week;

import IAS.HandyManCalculator.commons.Validate;
import IAS.HandyManCalculator.domain.Week;

public class ReadWeekByIdOutput {
    private final Week week;

    public ReadWeekByIdOutput(Week week) {
        Validate.checkNotNull(week);
        this.week = week;
    }

    public Week getWeek() {
        return week;
    }
}
