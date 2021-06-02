package IAS.HandyManCalculator.model;

//import IAS.HandyManCalculator.serialization.ReportSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;

public class CreateWeekOperationInput {

    private String technicianId;

    private String serviceId;

    //@JsonDeserialize(using = ReportSerializer.class)
    @JsonProperty("dates")
    private List<Date> dates;

    public String getTechnicianId() {
        return technicianId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}

/*package IAS.HandyManCalculator.model;

import IAS.HandyManCalculator.serialization.ReportSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.core.serializer.Deserializer;

import java.util.Date;
import java.util.List;

public class CreateWeekOperationInput {

    private String technicianId;

    private String serviceId;

    @JsonDeserialize(using = ReportSerializer.class)
    @JsonProperty("startDate")
    @JsonFormat(pattern = "dd-M-yyyy hh:mm:ss")
    private Date startDate;

    @JsonDeserialize(using = ReportSerializer.class)
    @JsonProperty("endDate")
    @JsonFormat(pattern = "dd-M-yyyy hh:mm:ss")
    private Date endDate;

    public String getTechnicianId() {
        return technicianId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public List<Date> getDates() {
        List<Date> dates = null;
        dates.add(startDate);
        dates.add(endDate);
        return dates;
    }

}*/

