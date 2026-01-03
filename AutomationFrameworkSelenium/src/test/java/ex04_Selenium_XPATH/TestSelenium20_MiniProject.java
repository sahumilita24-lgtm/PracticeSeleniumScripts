package ex04_Selenium_XPATH;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TestSelenium20_MiniProject extends commonToAll {
	@Severity(SeverityLevel.CRITICAL)
    @Description("Verify login is working")
    @Test
    public void test_OHRM_login()
    {
		WebDriver driver = new ChromeDriver();
        openbrowser(driver,"https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        
        WebElement input_username = driver.findElement(By.xpath("//input[@placeholder='Username']"));      
        WebElement input_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement button = driver.findElement(By.xpath("//button"));

        input_username.sendKeys("admin");
        input_password.sendKeys("Hacker@4321");
        button.click();

        customWait(3000);
        
        WebElement h6= driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6"));
        Assert.assertEquals(h6.getText(), "PIM");
        
        closedriver(driver);
    }

}
