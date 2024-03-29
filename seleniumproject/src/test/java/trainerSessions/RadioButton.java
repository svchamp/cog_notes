package trainerSessions;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		
import org.openqa.selenium.*;

public class RadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaration and instantiation of objects/variables		
        					
        WebDriver driver = new ChromeDriver();					

        driver.get("http://demo.guru99.com/test/radio.html");			
        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));							
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));							
        //Radio Button1 is selected		
        radio1.click();			
        System.out.println("Radio Button Option 1 Selected");					
        //Radio Button1 is de-selected and Radio Button2 is selected		
        radio2.click();			
        System.out.println("Radio Button Option 2 Selected");					
        // Selecting CheckBox		
        WebElement option1 = driver.findElement(By.id("vfb-6-0"));							

        // This will Toggle the Check box 		
        option1.click();			

        // Check whether the Check box is toggled on 		
        if (option1.isSelected()) {					
            System.out.println("Checkbox is Toggled On");					

        } else {			
            System.out.println("Checkbox is Toggled Off");					
        }		

		//driver.close();

	}

}


		
 
//	public class Radiobuttons {				
//	    public static void main(String[] args) {									
//	    	// declaration and instantiation of objects/variables		
//	        System.setProperty("webdriver.chrome.driver","C:\\\\Drivers\\\\chromedriver.exe");					
//	        WebDriver driver = new ChromeDriver();					
// 
//	        driver.get("http://demo.guru99.com/test/radio.html");			
//	        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));							
//	        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));							
//	        //Radio Button1 is selected		
//	        radio1.click();			
//	        System.out.println("Radio Button Option 1 Selected");					
//	        //Radio Button1 is de-selected and Radio Button2 is selected		
//	        radio2.click();			
//	        System.out.println("Radio Button Option 2 Selected");					
//	        // Selecting CheckBox		
//	        WebElement option1 = driver.findElement(By.id("vfb-6-0"));							
// 
//	        // This will Toggle the Check box 		
//	        option1.click();			
// 
//	        // Check whether the Check box is toggled on 		
//	        if (option1.isSelected()) {					
//	            System.out.println("Checkbox is Toggled On");					
// 
//	        } else {			
//	            System.out.println("Checkbox is Toggled Off");					
//	        }		
//
//			//driver.close();		
//	    }		
//	}
