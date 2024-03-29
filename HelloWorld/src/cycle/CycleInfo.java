package cycle;

public class CycleInfo {
	private String cycleId;
	private String cycleName;
	private String cycleType;
	private String accessories;
	private double price;
	
	public String getCycleId() {
		return cycleId;
	}
	public void setCycleId(String cycleId) {
		this.cycleId = cycleId;
	}
	public String getCycleName() {
		return cycleName;
	}
	public void setCycleName(String cycleName) {
		this.cycleName = cycleName;
	}
	public String getCycleType() {
		return cycleType;
	}
	public void setCycleType(String cycleType) {
		this.cycleType = cycleType;
	}
	public String getAccessories() {
		return accessories;
	}
	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CycleInfo(String cycleId, String cycleName, String cycleType, String accessories, double price) {
		super();
		this.cycleId = cycleId;
		this.cycleName = cycleName;
		this.cycleType = cycleType;
		this.accessories = accessories;
		this.price = price;
	}
	
	public double calculateBillAmount() {
		//fill code here
		double tax;
		if( !(accessories.equalsIgnoreCase("yes") || accessories.equalsIgnoreCase("no")) ) {
			return -1;
		}
		if(cycleType.equals("Road Cycle")) {
			tax=2;
		}
		else if(cycleType.equals("Mountain Cycle")) {
			tax=5;
		}
		else if(cycleType.equals("Hybrid Cycle")) {
			tax=6;
		}
		else if(cycleType.equals("Touring Cycle")) {
			tax=4;
		}
		else if(cycleType.equals("Electric Cycle")) {
			tax=3;
		}
		else {
			return -1;
		}
		double bill=price+ ( price*tax/100 );
		if(accessories.equalsIgnoreCase("yes"))
			bill=bill+1000;
		return bill;
	}
}