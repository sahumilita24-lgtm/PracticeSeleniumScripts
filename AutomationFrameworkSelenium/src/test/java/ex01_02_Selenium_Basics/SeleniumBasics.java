package ex01_02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SeleniumBasics {
	
	@Test()
	public void basics()
	{
		WebDriver driver = new EdgeDriver();
		// new EdgeDriver(); - This START of the Selenium Session
        // Sesion - Fresh copy of browser is started!.
        // POST request to the Server - Edge Driver.
		driver.get("https://google.com");
		// Selenium 4.x - Selenium Manager - will automatically download the Drivers all
        // when needed when you start the Selenium server.
	}
	

}
