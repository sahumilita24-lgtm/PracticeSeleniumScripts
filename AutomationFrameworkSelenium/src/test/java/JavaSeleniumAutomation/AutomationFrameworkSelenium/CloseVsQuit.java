package JavaSeleniumAutomation.AutomationFrameworkSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseVsQuit {
	@Test()
	public void closevsquit() throws InterruptedException
	{
	
	WebDriver driver = new ChromeDriver();
    driver.get("https://google.com");
    Thread.sleep(5000);

    // driver.close();
    // Close - will close the current tab, not the session (not the all tabs)
    // session id != null

    driver.quit();
    // It will close all the tabs. - session id == null
	}


}
