package IAS.HandyManCalculator;
import IAS.HandyManCalculator.model.CalculateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;

@SpringBootApplication
public class HandyManCalculatorApplication {

	public static void main(String[] args) {
		Date initial = new Date();

		System.out.println("This is from getTime in main + initial " + initial);
		Date fin = new Date();
		System.out.println("This is from getTime in main + fin" + fin);

		//CalculateTime class
		SpringApplication.run(HandyManCalculatorApplication.class, args);
		CalculateTime time = new CalculateTime(initial, fin);
		time.calculateWeekNumber(fin);
		time.calculateHours(initial);
		time.calculateHoursForEachDay(initial, fin);
	}
}
