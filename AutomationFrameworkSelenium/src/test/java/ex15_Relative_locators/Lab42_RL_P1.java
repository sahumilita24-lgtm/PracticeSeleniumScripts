package ex15_Relative_locators;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Lab42_RL_P1 {
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void rightofRelativeLocator()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://awesomeqa.com/practice.html");
		
		WebElement SpanYearsOfExperience = driver.findElement(By.xpath("//span[text()='Years of Experience']"));
		driver.findElement((with(By.id("exp-2")).toRightOf(SpanYearsOfExperience))).click();
		
		//Self created scenarios
		WebElement input_AutomationTester =driver.findElement(By.id("profession-1"));
		driver.findElement((with(By.id("profession-0")).toLeftOf(input_AutomationTester))).click();
		
		WebElement input_FirstName= driver.findElement(By.name("firstname"));
		driver.findElement((with(By.name("lastname")).below(input_FirstName))).sendKeys("Sahu");
		
		driver.quit();
		
	}

}
