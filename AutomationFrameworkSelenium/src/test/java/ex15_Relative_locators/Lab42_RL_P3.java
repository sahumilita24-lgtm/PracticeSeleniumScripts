package ex15_Relative_locators;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Lab42_RL_P3 extends commonToAll {
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void aqi_toLeftOf_toRightOf()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//enter country name
		WebElement searchBox= driver.findElement(By.xpath("//input[@placeholder='Search']"));
		driver.manage().window().maximize();
		searchBox.sendKeys("India" +  Keys.ENTER);
		//wait for the result
		
		/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions. visibilityOfAllElementsLocatedBy(By.cssSelector("img[src = 'https://flagcdn.com/w160/in.webp']")));*/
		
		customWait(1000);
		
		List<WebElement> cityName= driver.findElements(By.cssSelector(".location-name p"));
		
		for(WebElement city: cityName)
		{
			String rank = driver.findElement(with(By.cssSelector(".location-rank")).toLeftOf(city)).getText();
			String aqi = driver.findElement(with(By.cssSelector(".aqi-level span")).toRightOf(city)).getText();
			
			System.out.println("| +" + rank + " | " + city.getText() + " | " + aqi + " | ");
		}
		driver.close();
		}
	
	
 
}
