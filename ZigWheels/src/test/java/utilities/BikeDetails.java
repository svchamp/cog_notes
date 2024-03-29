package utilities;

public class BikeDetails{
	public String bikeName;
	public int price;
	public String launchDate;
	public BikeDetails(String bikeName, String price, String launchDate) {
		super();
		this.bikeName = bikeName;
		this.price = convertPriceToInteger(price);
		int x=launchDate.indexOf(":");
		this.launchDate = launchDate.substring(x+2);
	}
	
	public String toString() {
		return bikeName+" : "+price+" : "+launchDate;
	}
	public int convertPriceToInteger(String p) {
		p=p.toLowerCase();
		p=p.substring(4);
		if(p.contains("lakh")) {
			int x=p.indexOf("l");
			p=p.substring(0, x);
			double y=Double.parseDouble(p);
			y=y*100000;
			return (int) Math.round(y);
		}
		else {
			p=p.replace(",", "");
			double y=Double.parseDouble(p);
			return (int)y;
		}
	}
	
}