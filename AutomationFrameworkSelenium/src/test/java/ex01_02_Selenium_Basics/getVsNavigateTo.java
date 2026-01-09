package ex01_02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class getVsNavigateTo {
	
	@Test()
	public void getvsnavigate_check()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://google.com"); // get do not have back, forward and refresh functions while navigate.to has
		
		driver.navigate().to("https://google.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
	}

}
