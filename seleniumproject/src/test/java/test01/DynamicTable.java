package test01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://demo.opencart.com/admin/index.php?route=customer/customer&user_token=8d4757c8a9205e0f0c59e8bd871fa81d";
		WebDriver driver=new ChromeDriver();
		driver.get(url);
	}

}
