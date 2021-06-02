package IAS.HandyManCalculator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Week {

    private String id;
    private String technicianId;
    private String serviceId;
    private short totalWeekHours;
    private short totalWeekNormalHours;
    private short weekNormalDaytimeHours;
    private short weekNormalNightHours;
    private short sundayNormalHours;
    private short totalWeekExtraHours;
    private short weekExtraDaytimeHours;
    private short weekExtraNightHours;
    private short sundayExtraHours;
}
