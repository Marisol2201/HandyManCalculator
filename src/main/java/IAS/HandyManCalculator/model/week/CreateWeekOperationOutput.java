package IAS.HandyManCalculator.model.week;

import IAS.HandyManCalculator.commons.Validate;
import IAS.HandyManCalculator.domain.Week;

public class CreateWeekOperationOutput {
    private final Week week;

    public CreateWeekOperationOutput(Week week) {
        Validate.checkNotNull(week);
        this.week = week;
    }

    public Week getWeek() {
        return week;
    }

    @Override
    public String toString() {
        return "CreateWeekOperationOutput{" +
                "week=" + week +
                '}';
    }
}
