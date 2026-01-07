package ex05_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.Description;

public class TestSelenium24_MMT_Modal extends commonToAll{

	 @Description("Verify  makemytrip opens with modal")
	    @Test
	    public void testCloseModal() {
		 
		 ChromeOptions option = new ChromeOptions();
		 option.addArguments("--incognito");
		 option.addArguments("--start-maximized");

	        WebDriver driver = new ChromeDriver(option);
	        driver.navigate().to("https://www.makemytrip.com/");
	        System.out.println(driver.getTitle());
	        
	        String modalxpath = "//span[@class='commonModal__close']";
	        waitForVisibility(driver,100,modalxpath);
	        
	        driver.findElement(By.xpath(modalxpath)).click();
	        
	        closedriver(driver);
	        
	 }
}
