package cycle;
import java.util.*;

public class UserInterface {
	public static CycleInfo extractDetails(String cycleDetails) {
		String[] x=cycleDetails.split(":");
		CycleInfo obj=new CycleInfo(x[0],x[1],x[2],x[3],Double.parseDouble(x[4]));
		return obj;
	}
	
	public static void main(String args[]) {
//		Scanner sc=new Scanner(System.in);
//		String s1="CYCAS345:Hi-Fast Gangster x89:Road Cycle:yes:24000";
//		String s2="CYCMO567:fireFox Kreed 27.5D:Mountain Cycle:no:17900";
//		CycleInfo obj=extractDetails(s2);
//		System.out.println("Bill amount to be paid:"+obj.calculateBillAmount());
	}
}