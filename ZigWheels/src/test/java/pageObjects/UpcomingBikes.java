package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BikeDetails;

public class UpcomingBikes extends BasePage {
	
	public UpcomingBikes(WebDriver driver,WebDriverWait myWait) {
		super(driver,myWait);
	}

	@FindBy(xpath="//select[@id='makeId']")
	WebElement selectManufacturer;
	
	@FindBy(xpath="//span[text()='View More Bikes ']")
	WebElement viewMoreBikes;
	
	@FindBy(xpath="//div[@class='zw-con p-0 sl-card']/div[3]/a")
	List<WebElement> elementBikeName;
	
	@FindBy(xpath="//div[@class='zw-con p-0 sl-card']/div[3]/div[@class='b fnt-15']")
	List<WebElement> elementPrice;
	
	@FindBy(xpath="//div[@class='zw-con p-0 sl-card']/div[3]/div[@class='clr-try fnt-14']")
	List<WebElement> elementLaunchDate;
	
	public void selectManufaturer() {
		Select select=new Select(selectManufacturer);
		select.selectByVisibleText("Honda");
	}
	
	public List<BikeDetails> getDetails() {
		myWait.until(ExpectedConditions.elementToBeClickable(viewMoreBikes));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", viewMoreBikes);
		
		js.executeScript("arguments[0].click()", viewMoreBikes);
		
		List<BikeDetails> list=new ArrayList<>();
		for(int i=0;i<14;i++) {
			String n=elementBikeName.get(i).getAttribute("title");
			String p=elementPrice.get(i).getText();
			String l=elementLaunchDate.get(i).getText();
			BikeDetails obj=new BikeDetails(n,p,l);
			list.add(obj);
		}
		
		list=list.stream().filter(e->e.price<=400000)
							.collect(Collectors.toList());
		return list;
		
	}
	
}


