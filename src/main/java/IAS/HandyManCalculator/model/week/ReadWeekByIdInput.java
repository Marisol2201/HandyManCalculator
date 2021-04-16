package IAS.HandyManCalculator.model.week;

import IAS.HandyManCalculator.commons.Validate;

import java.util.UUID;

public class ReadWeekByIdInput {
    private final UUID id;

    public ReadWeekByIdInput(UUID id) {
        Validate.checkNotNull(id);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
