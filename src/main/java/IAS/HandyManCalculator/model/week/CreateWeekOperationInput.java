package IAS.HandyManCalculator.model.week;

public class CreateWeekOperationInput {
    private String id;
    private short hours;

    public String getId() {
        return id;
    }
    public short getHours() {
        return hours;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setHours(short hours) {
        this.hours = hours;
    }
}
