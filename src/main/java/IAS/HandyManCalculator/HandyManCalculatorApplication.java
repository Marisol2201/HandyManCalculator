package IAS.HandyManCalculator;

import IAS.HandyManCalculator.commons.CalculateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class HandyManCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandyManCalculatorApplication.class, args);

/*		long date1 = 1618327405;
		long date2 = 1618327408;

		ArrayList dateList = new ArrayList();
		dateList.add(date1);
		dateList.add(date2);
		ArrayList al = new ArrayList(dateList);
		System.out.println(al);

		//CalculateTime class

		CalculateTime time = new CalculateTime(al);
		time.calculateWeekNumber(al);
		time.differenceInHoursBetweenDates(al);*/
	}
}
