package IAS.HandyManCalculator.model.technician;

import IAS.HandyManCalculator.commons.Validate;

import java.util.UUID;

public class ReadTechnicianByIdInput {
    private final UUID id;

    public ReadTechnicianByIdInput(UUID id) {
        Validate.checkNotNull(id);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
