package IAS.HandyManCalculator;
//import IAS.HandyManCalculator.commons.CalculateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class HandyManCalculatorApplication {

	public static void main(String[] args) {

/*		Date date1 = new Date(1618327405 * 1000L);
		Date date2 = new Date();

		ArrayList dateList = new ArrayList();
		dateList.add(date1);
		dateList.add(date2);
		ArrayList al = new ArrayList(dateList);
		System.out.println(al);*/

		//CalculateTime class
		SpringApplication.run(HandyManCalculatorApplication.class, args);
/*		CalculateTime time = new CalculateTime(al);
		time.calculateWeekNumber(al);
		time.calculateInitialDate(al);
		time.calculateFinalDate(al);
		time.differenceInHoursBetweenDates(date1, date2);*/
	}
}
