package IAS.HandyManCalculator.model.serviceType;

import IAS.HandyManCalculator.commons.Validate;

import java.util.UUID;

public class ReadServiceByIdInput {
    private final UUID id;

    public ReadServiceByIdInput(UUID id) {
        Validate.checkNotNull(id);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
