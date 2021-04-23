package IAS.HandyManCalculator.model.week;

import IAS.HandyManCalculator.commons.Validate;

import java.util.UUID;

public class ReadWeekByIdInput {
    private final String id;

    public ReadWeekByIdInput(String id) {
        Validate.checkNotNull(id);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
