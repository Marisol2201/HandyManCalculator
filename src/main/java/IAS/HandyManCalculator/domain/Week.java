package IAS.HandyManCalculator.domain;

import IAS.HandyManCalculator.commons.Validate;

public class Week {
    private final String id;
    private final short hours;

    public Week(String id, short hours) {
        Validate.checkNotNull(id);
        Validate.checkNotNull(hours);
        this.id = id;
        this.hours = hours;
    }

    public String getId() {
        return id;
    }

    public short getHours() {
        return hours;
    }
}
