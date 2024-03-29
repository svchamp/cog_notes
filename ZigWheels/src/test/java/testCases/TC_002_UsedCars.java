package testCases;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.UsedCars;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC_002_UsedCars extends BaseClass {
	
	@Test
	public void verifyUsedCars() {
		logger.info("** Starting TC_002_UsedCars **");
		System.out.println("** Starting TC_002_UsedCars **");
		
		HomePage hp=new HomePage(driver);
		logger.info("Clicking on Chennai in Used Cars dropdown");
		System.out.println("Clicking on Chennai in Used Cars dropdown");
		hp.clickUsedCars_Chennai();
		
		logger.info("Storing popular used cars in a list");
		System.out.println("Storing popular used cars in a list");
		UsedCars uc=new UsedCars(driver);
		List<String> names=uc.getPopularCars();
		
		logger.info("Storing popular used cars in used_cars_chennai.xlsx");
		String path=System.getProperty("user.dir")+"\\test-output\\used_cars_chennai.xlsx";
		System.out.println("The popular used cars in Chennai are as follows:");
		ExcelUtility eu=new ExcelUtility(path);
		for(int i=0;i<names.size();i++) {
			try {
				eu.setCellData("Used_Cars_Chennai", i, 0, names.get(i));
				System.out.println(names.get(i));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Successfully stored used cars in Chennai in used_cars_chennai.xlsx");
		
		System.out.println("** Finished TC_002_UsedCars **");
		logger.info("** Finished TC_002_UsedCars **");
	}
}
