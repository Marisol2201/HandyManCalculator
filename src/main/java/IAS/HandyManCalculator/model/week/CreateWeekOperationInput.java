package IAS.HandyManCalculator.model.week;

import java.util.Date;
import java.util.List;

public class CreateWeekOperationInput {
    private String id;
    private List<Date> dates;

    public String getId() {
        return id;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}
