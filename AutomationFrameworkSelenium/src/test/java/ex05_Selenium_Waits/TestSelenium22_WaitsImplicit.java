package ex05_Selenium_Waits;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TestSelenium22_WaitsImplicit {
	
	@Description("Implicit wait presented")
	@Owner("Milita")
	@Severity(SeverityLevel.MINOR)
	@Test()
	public void implicitwait()
	{
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		
		WebDriver driver = new EdgeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		
		driver.get("https://vwo.com");
	}

}
