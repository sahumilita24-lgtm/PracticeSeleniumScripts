package ex03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TestSelenium17_Project_Locators_Selenium_ID_CLASSNAME_NAME  extends commonToAll{
	@Description("TC#1 - Verify that with invalid login, error message is displayed!")
	@Owner("Milita Sahu")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void test_vwo_login_invalid_login() 
	{
		// Step 1 - Find the EMAIL ID and enter the admin@admin.com.
        // Step 2 - Find the Password and enter the 1234.
        // Step 3 - Find the Submit and click on the button.
        // Step 4 - Wait some time.
        // Step 5 - Verify the message error message.

		WebDriver driver = new ChromeDriver();
		openbrowser(driver, "https://app.vwo.com");
		// Step 1 - Find the EMAIL ID and enter the admin@admin.com.
		WebElement email_input_box = driver.findElement(By.id("login-username"));
        email_input_box.sendKeys("admin@admin.com");
        
     // 2. Find the password inputbox and enter the password
        WebElement password_input_box = driver.findElement(By.name("password"));
        password_input_box.sendKeys("wrongpass@123");
        
        WebElement button_submit = driver.findElement(By.id("js-login-btn"));
        button_submit.click();

        // Step 4 - Wait some time.
        customWait(5000);
        
     // Step 5 - Verify the message error message.
        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        System.out.println(error_message.getText());

        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
		
        closedriver(driver);

        
        
        

	}

}
