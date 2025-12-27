package JavaSeleniumAutomation.AutomationFrameworkSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SeleniumCommands {
	
	@Test()
	public void commands()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://thetestingacademy.com");
		
		String url= driver.getCurrentUrl();
		System.out.println(url);
		String titlename = driver.getTitle();
		System.out.println(titlename);
		String pagedata= driver.getPageSource();
		System.out.println(pagedata);
		
	}

}
