package IAS.HandyManCalculator.domain;

import IAS.HandyManCalculator.commons.Validate;

public class Week {
    private final String id;

    private final short totalWeekHours;
    private final short totalWeekNormalHours;
    private final short weekNormalDaytimeHours;
    private final short weekNormalNightHours;
    private final short sundayNormalHours;
    private final short totalWeekExtraHours;
    private final short weekExtraDaytimeHours;
    private final short weekExtraNightHours;
    private final short sundayExtraHours;

    public Week(String id, short totalWeekHours, short totalWeekNormalHours, short weekNormalDaytimeHours,
                short weekNormalNightHours, short sundayNormalHours, short totalWeekExtraHours,
                short weekExtraDaytimeHours, short weekExtraNightHours, short sundayExtraHours) {

        Validate.checkNotNull(id);
        this.id = id;
        this.totalWeekHours = totalWeekHours;
        this.totalWeekNormalHours = totalWeekNormalHours;
        this.weekNormalDaytimeHours = weekNormalDaytimeHours;
        this.weekNormalNightHours = weekNormalNightHours;
        this.sundayNormalHours = sundayNormalHours;
        this.totalWeekExtraHours = totalWeekExtraHours;
        this.weekExtraDaytimeHours = weekExtraDaytimeHours;
        this.weekExtraNightHours = weekExtraNightHours;
        this.sundayExtraHours = sundayExtraHours;
    }

    public String getId() {
        return id;
    }

    public short getTotalWeekHours() {
        return totalWeekHours;
    }

    public short getTotalWeekNormalHours() {
        return totalWeekNormalHours;
    }

    public short getWeekNormalDaytimeHours() {
        return weekNormalDaytimeHours;
    }

    public short getWeekNormalNightHours() {
        return weekNormalNightHours;
    }

    public short getSundayNormalHours() {
        return sundayNormalHours;
    }

    public short getTotalWeekExtraHours() {
        return totalWeekExtraHours;
    }

    public short getWeekExtraDaytimeHours() {
        return weekExtraDaytimeHours;
    }

    public short getWeekExtraNightHours() {
        return weekExtraNightHours;
    }

    public short getSundayExtraHours() {
        return sundayExtraHours;
    }
}
