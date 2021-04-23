package IAS.HandyManCalculator.model.serviceType;

import IAS.HandyManCalculator.commons.Validate;
import IAS.HandyManCalculator.domain.ServiceType;

public class ReadServiceTypeByIdOutput {
    private final ServiceType service;

    public ReadServiceTypeByIdOutput(ServiceType service) {
        Validate.checkNotNull(service);
        this.service = service;
    }

    public ServiceType getService() {
        return service;
    }
}
