package IAS.HandyManCalculator.model.technician;

import IAS.HandyManCalculator.commons.Validate;
import IAS.HandyManCalculator.domain.Technician;

public class UpdateTechnicianOutput {
    private final Technician technician;

    public UpdateTechnicianOutput(Technician technician) {
        Validate.checkNotNull(technician);
        this.technician = technician;
    }

    public Technician getTechnician() {
        return technician;
    }
}
