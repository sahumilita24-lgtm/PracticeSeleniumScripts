package ex15_Relative_locators;

import static org.openqa.selenium.support.locators.RelativeLocator.*;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Lab42_RL_P2 {
	
	@Test
	@Severity(SeverityLevel.MINOR)
	public void belowRelativeLocator()
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--guest");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
		
		//Switch to frame
		driver.switchTo().frame("result");
		//click on Submit to get error messages
		WebElement buttonSubmit = driver.findElement(By.cssSelector("#form button"));
		buttonSubmit.click();
		//find the username Error messages using Relative locators
		WebElement inputUsername = driver.findElement(By.id("username"));
		WebElement errorMessageUsername = driver.findElement(with(By.tagName("small")).below(inputUsername));
		
		String messageerror= errorMessageUsername.getText();
		Assert.assertEquals(messageerror, "Username must be at least 3 characters");
		
		driver.close();
		
		
		
	}

}
