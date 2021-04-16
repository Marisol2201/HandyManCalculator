package IAS.HandyManCalculator.model.serviceType;

import IAS.HandyManCalculator.commons.Validate;
import IAS.HandyManCalculator.domain.ServiceType;

public class CreateServiceOperationOutput {
    private final ServiceType Service;

    public CreateServiceOperationOutput(ServiceType Service) {
        Validate.checkNotNull(Service);
        this.Service = Service;
    }

    public ServiceType getService() {
        return Service;
    }

    @Override
    public String toString() {
        return "CreateWeekOperationOutput{" +
                "ServiceType=" + Service +
                '}';
    }
}
