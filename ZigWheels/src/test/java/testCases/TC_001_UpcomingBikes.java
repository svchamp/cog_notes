package testCases;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.UpcomingBikes;
import testBase.BaseClass;
import utilities.BikeDetails;
import utilities.ExcelUtility;

public class TC_001_UpcomingBikes extends BaseClass {
	
	@Test(groups= {"g1"})
	public void verifyUpcomingBikes() {
		logger.info("** Starting TC_001_UpcomingBikes **");
		System.out.println("** Starting TC_001_UpcomingBikes **");
		HomePage hp=new HomePage(driver);
		
		System.out.println("Clicking on upcoming bikes");
		logger.info("Clicking on Upcoming bikes");
		hp.clickUpcomingBikes();
		
		
		
		logger.info("Storing upcoming bike details in a list");
		System.out.println("Storing upcoming bike details in a list");
		UpcomingBikes ub=new UpcomingBikes(driver,myWait);
		ub.selectManufaturer();
		List<BikeDetails> list=ub.getDetails();
		
		logger.info("Storing upcoming bike details in bike_details.xlsx");
		
		String path=System.getProperty("user.dir")+"\\test-output\\bike_details.xlsx";
		ExcelUtility eu=new ExcelUtility(path);
		System.out.println("The upcoming bike details of 'Honda' with price lower than 4 lakhs are as follows:");
		for(int i=0;i<list.size();i++) {
			try {
				eu.setCellData("Bike_Details", i, 0, list.get(i).bikeName);
				System.out.print("Bike Name: "+list.get(i).bikeName);
				eu.setCellData("Bike_Details", i, 1, String.valueOf(list.get(i).price));
				System.out.print("\tBike Price: Rs"+list.get(i).price);
				eu.setCellData("Bike_Details", i, 2, list.get(i).launchDate);
				System.out.print("\tLaunch Date: "+list.get(i).launchDate);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
		System.out.println("Bike details successfully stored in bike_details.xlsx");
		
		System.out.println("** Finished TC_001_UpcomingBikes **");
		logger.info("** Finished TC_001_UpcomingBikes **");
	}

}