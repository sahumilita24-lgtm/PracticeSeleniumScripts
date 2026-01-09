package ex06_Input_Select_Alerts_Radio;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium28_Alerts {
	@Test
	public void alert()
	{
	ChromeDriver driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    System.out.println(driver.getTitle());
    driver.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1000));
    
    //js Alert
    WebElement jsAlert_Button = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
    WebElement alerttext =driver.findElement(By.id("result"));
    
    jsAlert_Button.click();
    wait.until(ExpectedConditions.alertIsPresent());
    
    Alert alert= driver.switchTo().alert();
    System.out.println(alert.getText());
    
    Assert.assertEquals(alert.getText(), "I am a JS Alert");
    alert.accept();
    Assert.assertEquals(alerttext.getText(), "You successfully clicked an alert");
    
    //js confirm
    WebElement JS_Confirm_Button = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
    JS_Confirm_Button.click();
    
    wait.until(ExpectedConditions.alertIsPresent());
    System.out.println(alert.getText());
    alert.dismiss();
    Assert.assertEquals(alerttext.getText(), "You clicked: Cancel");
    
    //js prompt
    
    WebElement jspromt_button = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
    jspromt_button.click();
    
    wait.until(ExpectedConditions.alertIsPresent());
    alert.sendKeys("My name is Milita Sahu");
    alert.accept();
    Assert.assertEquals(alerttext.getText(), "You entered: My name is Milita Sahu");
    
    
    
    driver.quit();
    
	}

}
