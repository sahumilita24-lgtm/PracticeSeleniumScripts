package ex10_Actions_Class;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Lab33_ActionClass_MoveToElement {
	
	@Test
	public void spricejet_Dropdown()
	{
		 WebDriver driver = new ChromeDriver();
	        String URL = "https://www.spicejet.com/";
	        driver.get(URL);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	        
	        WebElement origin= driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));
	        WebElement destination = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/div/div/input"));
	        WebElement SearchButton = driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']/div"));
	        
	        Actions action = new Actions(driver);
	        action.moveToElement(origin).click().sendKeys("BLR").moveToElement(destination).sendKeys("VTZ").build().perform();
	        driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")).click();
	        action.moveToElement(SearchButton).click().build().perform();
	        
	        driver.quit();
	}

}
