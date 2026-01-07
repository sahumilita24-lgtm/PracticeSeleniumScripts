package ex05_Selenium_Waits;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.Description;

public class TestSelenium25_Fluent_Wait extends commonToAll {
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
	    /*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));
	    
	    //fluent Wait 
	    FluentWait<WebDriver> wait = new FluentWait<>(driver)
	    		.withTimeout(Duration.ofSeconds(20))
	    		.pollingEvery(Duration.ofSeconds(6))
	    		.ignoring(NoSuchElementException.class);
	    WebElement error_message= wait.until(
	    		new Function<WebDriver,WebElement>(){

			@Override
			public WebElement apply(WebDriver webDriver) {
				// TODO Auto-generated method stub
				return driver.findElement((By.className("notification-box-description")));
			}
  	
	    }); 
	    
	    FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);


        WebElement error_message = wait.until(
                new Function<WebDriver, WebElement>() {
                    @Override
                    public WebElement apply(WebDriver webDriver) {
                    	WebElement element =driver.findElement((By.className("notification-box-description")));
                        if(!element.getText().trim().isEmpty())
                        {
                        	return element;
                        }
                        else return null;

                    }
                }
        ); */
	    
	    WebElement error_message= fluentWait_TillTextvisibility(driver,100,Duration.ofSeconds(2),"js-notification-box-msg");

	    
	    //WebElement error_message = driver.findElement(By.className("notification-box-description"));
	    Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
	    
	    closedriver(driver);

}
}
