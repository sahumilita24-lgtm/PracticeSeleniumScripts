package ex05_Selenium_Waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.Description;

public class TestSelenium23_Fix_Miniproject extends commonToAll{
	
	// Locators - Find the Web elements
    // Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
    //Find the Email id** and enter the email as admin@admin.com
    //Find the pass inputbox** and enter passwrod as admin.
    //Find and Click on the submit button
    //Verify that the error message is shown "Your email, password, IP address or location did not match"
	
	@Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
	@Test
	public void testVwoLoginNegative ()
	{
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--incognito");
		option.addArguments("--start-maxmized");
		
		WebDriver driver = new EdgeDriver(option);
		openbrowser(driver,"https://app.vwo.com/#/login");
		
	    Assert.assertEquals(driver.getTitle(),"Login - VWO");		
	    
	    WebElement emailInputBox= driver.findElement(By.id("login-username"));
	    emailInputBox.sendKeys("admin@admin.com");
	    
	    WebElement passwordInputBox = driver.findElement(By.name("password"));
	    passwordInputBox.sendKeys("admin");
	    
	    WebElement submitButton = driver.findElement(By.id("js-login-btn"));
	    submitButton.click();
	    
	    //WebDriverWait 
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));
	    
	    WebElement error_message = driver.findElement(By.className("notification-box-description"));
	    Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
	    
	    closedriver(driver);
	    
	    
	}

}
