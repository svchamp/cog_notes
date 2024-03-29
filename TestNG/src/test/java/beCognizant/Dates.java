package beCognizant;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate ld;
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/YYYY");
		ld=LocalDate.now();
		String now=dtf.format(ld);
		System.out.println(now);
		
		ld=LocalDate.now().minusWeeks(1);
		String one=dtf.format(ld);
		System.out.println(one);
		
		ld=LocalDate.now().minusWeeks(2);
		String two=dtf.format(ld);
		System.out.println(two);
		
	}

}
