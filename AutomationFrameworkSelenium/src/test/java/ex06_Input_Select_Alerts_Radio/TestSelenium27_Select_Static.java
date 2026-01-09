package ex06_Input_Select_Alerts_Radio;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.Description;

public class TestSelenium27_Select_Static extends commonToAll {
	
	@Description("Validate the Select dropdown static")
	@Test
	public void test_select() throws InterruptedException
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        /*driver.get("https://awesomeqa.com/practice.html");
        System.out.println(driver.getTitle());
        
        //Select class 
        WebElement selectStaticDropdown = driver.findElement(By.cssSelector("#continents"));
        Select select = new Select(selectStaticDropdown);
        select.selectByIndex(2); 
        
        //select.selectByValue("Africa"); doesnt work as value isnt added
        select.selectByVisibleText("Australia");
        
        */
        
		driver.get("https://the-internet.herokuapp.com/dropdown");
        System.out.println(driver.getTitle());
        
        WebElement selectdropdown =driver.findElement(By.id("dropdown"));
        Select select1 = new Select(selectdropdown);
        
        select1.selectByIndex(2); 
        // if you select index as 0 its will through Throws UnsupportedOperationException for Disabled Options. as its the first option in the list

        Thread.sleep(1000);
        select1.selectByValue("1");
        Thread.sleep(1000);
        select1.selectByVisibleText("Option 2");
        
        driver.quit();
        
	}

}
