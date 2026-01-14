package commonFolder;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonToAll {
	
	public void openbrowser(WebDriver driver,String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void closedriver(WebDriver driver)
	{
		 try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            throw new RuntimeException(e);
	        }
		driver.quit();
	}
	
	
	public void customWait(int time) 
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			 throw new RuntimeException(e);
		}
	}
	
	public void waitForVisibility(WebDriver driver, int timeInseconds,String xpathvalue)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeInseconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathvalue)));
	}
	
	public WebElement fluentWait_TillTextvisibility(WebDriver driver, int waittimeinsecond, Duration pollingInSecond, String locatorIDValue)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(waittimeinsecond))
				.pollingEvery(pollingInSecond)
				.ignoring(NoSuchElementException.class);
		         
		WebElement error_message =wait.until(new Function<WebDriver,WebElement>(){

				 public WebElement apply(WebDriver driver) {
					if (!driver.findElement(By.id(locatorIDValue)).getText().trim().isEmpty())
					{
					return driver.findElement(By.id(locatorIDValue));
					}
					else return null;
				}});
		return error_message;
	}
	
	public void oranheHRMLogin(WebDriver driver)
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name= 'password']")).sendKeys("Hacker@4321");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	

}
