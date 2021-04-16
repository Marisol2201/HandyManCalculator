package IAS.HandyManCalculator.model.serviceType;

import IAS.HandyManCalculator.commons.Validate;
import IAS.HandyManCalculator.domain.ServiceType;

public class DeleteServiceOutput {
    private final ServiceType service;

    public DeleteServiceOutput(ServiceType service) {
        Validate.checkNotNull(service);
        this.service = service;
    }

    public ServiceType getService() {
        return service;
    }
}
