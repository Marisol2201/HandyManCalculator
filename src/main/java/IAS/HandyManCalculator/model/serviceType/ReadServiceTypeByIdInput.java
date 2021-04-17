package IAS.HandyManCalculator.model.serviceType;

import IAS.HandyManCalculator.commons.Validate;

import java.util.UUID;

public class ReadServiceTypeByIdInput {
    private final UUID id;

    public ReadServiceTypeByIdInput(UUID id) {
        Validate.checkNotNull(id);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
