package IAS.HandyManCalculator.model.technician;

import IAS.HandyManCalculator.commons.Validate;

import java.util.UUID;

public class DeleteTechnicianInput {
    private final UUID technicianId;

    public DeleteTechnicianInput(UUID technicianId) {
        Validate.checkNotNull(technicianId);
        this.technicianId = technicianId;
    }

    public UUID getTechnicianId() {
        return technicianId;
    }
}
