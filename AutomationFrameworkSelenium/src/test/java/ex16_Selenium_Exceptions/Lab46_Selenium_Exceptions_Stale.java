package ex16_Selenium_Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab46_Selenium_Exceptions_Stale {
	@Test
    public void test_selenium_exceptions() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println("Start of program");

        WebElement search_input_box  = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));


        driver.navigate().refresh();

       // search_input_box.sendKeys("Hello" +  Keys.ENTER);
        //org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found
        
        //using try and catch
        try {
        	search_input_box.sendKeys("Hello" +  Keys.ENTER);
        }
        catch(StaleElementReferenceException e)
        {
        	System.out.println("StaleElementReferenceException handled");
        }






    }

}
