package finalEval;

import org.testng.annotations.Test;

public class Price {
	@Test
	public void run() {
		String s="Rs. 79,000";
		String x="Rs. 4.79 Lakh";
		System.out.println(convertPriceToInteger(x));
	}
	public int convertPriceToInteger(String p) {
		p=p.toLowerCase();
		p=p.substring(4);
		if(p.contains("lakh")) {
			int x=p.indexOf("l");
			p=p.substring(0, x);
			double y=Double.parseDouble(p);
			y=y*100000;
			return (int) y;
		}
		else {
			System.out.println(p);
			p=p.replace(",", "");
			double y=Double.parseDouble(p);
			return (int)y;
		}
	}
}
