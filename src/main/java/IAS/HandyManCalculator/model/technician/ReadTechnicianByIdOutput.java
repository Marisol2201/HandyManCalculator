package IAS.HandyManCalculator.model.technician;

import IAS.HandyManCalculator.commons.Validate;
import IAS.HandyManCalculator.domain.Technician;

public class ReadTechnicianByIdOutput {
    private final Technician technician;

    public ReadTechnicianByIdOutput(Technician technician) {
        Validate.checkNotNull(technician);
        this.technician = technician;
    }

    public Technician getTechnician() {
        return technician;
    }
}
