package IAS.HandyManCalculator.model.serviceType;

import IAS.HandyManCalculator.commons.Validate;

import java.util.UUID;

public class DeleteServiceTypeInput {
    private final UUID serviceId;

    public DeleteServiceTypeInput(UUID serviceId) {
        Validate.checkNotNull(serviceId);
        this.serviceId = serviceId;
    }

    public UUID getServiceId() {
        return serviceId;
    }
}
