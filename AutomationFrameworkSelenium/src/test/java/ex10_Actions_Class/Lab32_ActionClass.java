package ex10_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Lab32_ActionClass {
	
	@Test
	public void action_validation()
	{
		 WebDriver driver = new ChromeDriver();
	        String URL = "https://awesomeqa.com/practice.html";
	        driver.get(URL);
	        
	        WebElement firstName = driver.findElement(By.name("firstname"));
	        Actions action = new Actions(driver);
	        //send value in capital letter to first name field
	        action.keyDown(Keys.SHIFT).sendKeys(firstName,"Testing Academy").build().perform();
	        
	        driver.quit();
	}

}
