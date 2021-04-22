/*
package IAS.HandyManCalculator.commons;

import IAS.HandyManCalculator.commons.OperationsWithNormalHours;
import IAS.HandyManCalculator.commons.OperationsWithExtraHours;
import IAS.HandyManCalculator.services.week.WeekService;
import IAS.HandyManCalculator.services.week.UpdateWeekUseCase;

import java.util.ArrayList;

public class OperationsPath {

    OperationsWithNormalHours normal = new OperationsWithNormalHours();
    OperationsWithExtraHours extra = new OperationsWithExtraHours();

    public ArrayList<Short> OperationsPathNormal(int hours) {
        ArrayList<Short> result = new ArrayList();
        short totalWeekHours = (short) normal.switchCase(getDates());
        short totalWeekNormalHours = (short) normal.get(3);
        short weekNormalDaytimeHours = (short) normal.get(0);
        short weekNormalNightHours = (short) normal.get(1);
        short sundayNormalHours = (short) normal.get(2);
        short totalWeekExtraHours = (short) normal.get(4);
        short weekExtraDaytimeHours = 0;
        short weekExtraNightHours = 0;
        short sundayExtraHours = 0;
        return result;
    }
}
*/