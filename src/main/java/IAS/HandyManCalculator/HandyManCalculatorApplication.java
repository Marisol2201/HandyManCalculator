package IAS.HandyManCalculator;
import IAS.HandyManCalculator.model.CalculateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

@SpringBootApplication
public class HandyManCalculatorApplication {

	public static void main(String[] args) {

		Date date1 = new Date(1220227200 * 1000L);
		Date date2 = new Date();

		ArrayList dateList = new ArrayList();
		dateList.add(date1);
		dateList.add(date2);
		ArrayList al = new ArrayList(dateList);
		System.out.println(al);

		//CalculateTime class
		SpringApplication.run(HandyManCalculatorApplication.class, args);
		CalculateTime time = new CalculateTime(al);
		time.calculateWeekNumber(al);
		time.calculateHours(al);
		time.calculateInitialDate(al);
		time.calculateFinalDate(al);
	}
}
