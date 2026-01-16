package ex10_Actions_Class;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import commonFolder.commonToAll;

public class Lab34_ActionClass_MakeMyTRIP_example extends commonToAll {

	@Test
	public void test_actions_p4() {
		WebDriver driver = new ChromeDriver();
		openbrowser(driver, "https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//wait for the modal to show
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
		WebElement close_Modal= driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
		
		//close the modal
		close_Modal.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='minimize']")));
		//AI Modal close
		WebElement ai_modal = driver.findElement(By.xpath("//img[@alt='minimize']"));
		ai_modal.click();
		
		//click outside to remove the field highlight
		By background_element = By.tagName("body");
		driver.findElement(background_element).click(); // just to remove the transparent layer.
		customWait(2);
		
		WebElement fromCity = driver.findElement(By.xpath("//input[@data-cy='fromCity']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(fromCity).click().build().perform();
		customWait(1000);
		action.moveToElement(fromCity).click().sendKeys("IXC").build().perform();
		
		customWait(1000);
		List<WebElement> airportNames= driver.findElements(By.cssSelector(".react-autosuggest__suggestions-list .revampedCityName"));
		
		try {
		for(WebElement requiredAirport: airportNames)
		{
			System.out.println(requiredAirport.getText());
			if(requiredAirport.getText().contains("Chandigarh"))
			{
				requiredAirport.click();
				break;
			}

		}}
		
		catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		
		
		
		
		
		
		

	}

}
