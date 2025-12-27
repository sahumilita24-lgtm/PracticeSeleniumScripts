package JavaSeleniumAutomation.AutomationFrameworkSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MaximizeMinimize {
	
	@Test()
	public void maxAndMinimize() throws InterruptedException
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://google.com");;
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().window().minimize();
		Thread.sleep(2000);
		
	   Assert.assertEquals(driver.getTitle(), "Google");
		
		driver.quit();
	}

}
