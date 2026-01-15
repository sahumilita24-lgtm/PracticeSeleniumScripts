package ex08_SVG_Elements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.Description;

public class Lab30_SVG extends commonToAll{
	ChromeDriver driver;

	@Description("Verify that the on search with svg icon results are visible.")
    @Test
    public void test_Flipkart_Search_SVG_Icon() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        String URL = "https://www.flipkart.com/search";
        driver.get(URL);

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("macmini");
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']")); 
        //name() or local-name() = 'svg' is used to find svg element 
        
        svgElements.get(0).click();
        
        List<WebElement> product_Names= driver.findElements(By.xpath("//div[contains(@data-tkid , 'CPU') or contains(@data-tkid,'mp')]/a[2]"));
        
        for(WebElement name: product_Names)
        {
        	System.out.println(name.getText());
        }
        driver.quit();
        

}
}