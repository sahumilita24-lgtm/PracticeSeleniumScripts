package JavaSeleniumAutomation.AutomationFrameworkSelenium;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class TestSelenium16_Mini_Project_2_Add_Extension {
	
	@Description("Options class")
	@Test()
	public void test_Selenium01()
	{
		ChromeOptions choptions = new ChromeOptions();
		//choptions.addArguments("--window-size=1920,1080");
		//choptions.addArguments("--incognito");
		File filepath= new File("/src/test/java/JavaSeleniumAutomation/AutomationFrameworkSelenium/AdBlockers.crx");
		choptions.addExtensions(filepath);//added extension to choptions , path we have mentioned above
		
		
		WebDriver driver = new ChromeDriver(choptions);
		WebDriverWait time = new WebDriverWait(driver, Duration.ofSeconds(1000));
		//time.until(ExpectedConditions.visibilityOf())
		driver.get("https://www.youtube.com/watch?v=BwTSxsAqlEc");
		
		driver.quit();
	}

}
