package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsedCars extends BasePage {
	//div[@class='gsc_thin_scroll']//label
	@FindBy(xpath="//div[@class='gsc_thin_scroll']//label")
	List<WebElement> popularCars;
	
	public UsedCars(WebDriver driver) {
		super(driver);
	}
	
	public List<String> getPopularCars(){
		List<String> names=new ArrayList<>();
		for(int i=0;i<popularCars.size();i++) {
			names.add(popularCars.get(i).getText());
		}
		return names;
	}
}
