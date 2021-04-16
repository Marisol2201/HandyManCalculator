package IAS.HandyManCalculator.model.serviceType;

import IAS.HandyManCalculator.commons.Validate;

import java.util.UUID;

public class DeleteServiceInput {
    private final UUID serviceId;

    public DeleteServiceInput(UUID serviceId) {
        Validate.checkNotNull(serviceId);
        this.serviceId = serviceId;
    }

    public UUID getServiceId() {
        return serviceId;
    }
}
