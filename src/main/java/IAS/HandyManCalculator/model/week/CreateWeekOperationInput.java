package IAS.HandyManCalculator.model.week;

import java.util.Date;
import java.util.List;

public class CreateWeekOperationInput {
    private String id;
    private List<Date> date;

    public String getId() {
        return id;
    }

    public List<Date> getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(List<Date> date) {
        this.date = date;
    }
}
