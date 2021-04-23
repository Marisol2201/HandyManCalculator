package IAS.HandyManCalculator.model.week;

import java.util.Date;
import java.util.List;

public class UpdateWeekInput {
    private String id;
    private List<Date> dates;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}
