package IAS.HandyManCalculator.model;

import IAS.HandyManCalculator.domain.Dates;

import java.util.Date;
import java.util.List;

public class UpdateWeekInput {
    private String id;
    private String technicianId;
    private String serviceId;
    private Dates dates;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public List<Date> getDates() {
        return (List<Date>) dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }
}
