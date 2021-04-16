package IAS.HandyManCalculator.model.technician;

import IAS.HandyManCalculator.commons.Validate;
import IAS.HandyManCalculator.domain.Technician;

public class CreateTechnicianOperationOutput {
    private final Technician technician;

    public CreateTechnicianOperationOutput(Technician technician) {
        Validate.checkNotNull(technician);
        this.technician = technician;
    }

    public Technician getTechnician() {
        return technician;
    }

    @Override
    public String toString() {
        return "CreateTechnicianOperationOutput{" +
                "technician=" + technician +
                '}';
    }
}
