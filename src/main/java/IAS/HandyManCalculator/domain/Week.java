package IAS.HandyManCalculator.domain;

import IAS.HandyManCalculator.commons.Validate;

import java.util.UUID;

public class Week {
    private final UUID id;
    private final String name;

    public Week(UUID id, String name) {
        Validate.checkNotNull(id);
        Validate.checkNotNull(name);
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Week{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
