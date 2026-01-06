package ex04_Selenium_XPATH;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.*;

public class TestSelenium21_MiniProject_3  extends commonToAll{
	
	@Owner("Milita Sahu")
	@Description("Verify that with valid email, pass, appointment page is loaded")
	@Severity(SeverityLevel.CRITICAL)
	@Test()
	public void test_katalon_login()
	{
		WebDriver driver = new EdgeDriver();
		openbrowser(driver,"https://katalon-demo-cura.herokuapp.com/");
		
		WebElement make_appointment_btn_xpath= driver.findElement(By.linkText("Make Appointment"));
		make_appointment_btn_xpath.click();
		
		List<WebElement> username_input_box_xpath_placeholder = driver.findElements(By.xpath("//input[@placeholder='Username']"));
		username_input_box_xpath_placeholder.get(1).sendKeys("John Doe");
		
		List<WebElement> password_input_box = driver.findElements(By.xpath("//input[@placeholder='Password']"));
		password_input_box.get(1).sendKeys("ThisIsNotAPassword");
		
		WebElement login_input_box = driver.findElement(By.id("btn-login"));
		login_input_box.click();
		
		customWait(1000);
		WebElement h2 = driver.findElement(By.tagName("h2"));
		Assert.assertEquals(h2.getText(), "Make Appointment");
		Assert.assertTrue(h2.isDisplayed());
		
		
		closedriver(driver);
		
	}

}
