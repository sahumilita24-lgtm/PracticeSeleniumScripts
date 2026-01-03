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
import io.qameta.allure.TmsLink;

public class TestSelenium19_Mini_Project2_TagName  extends commonToAll{
	
	@Owner("Milita")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("https://bugz.atlassian.net/browse/BUG-17")
    @Description("Verify that the error message comes with invalid email on signup page.")
    @Test
    public void vwo_free_trail_error_verify()
    {

        WebDriver driver = new ChromeDriver();
        openbrowser(driver,"https://app.vwo.com");
        
        WebElement a_tag_partial_match = driver.findElement(By.partialLinkText("trial"));
        a_tag_partial_match.click();
        
        Assert.assertTrue(driver.getCurrentUrl().contains("free-tria"));
        
        WebElement email =driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("abc.com");
        
        WebElement checkbox_policy = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox_policy.click();
        
        WebElement button_create_account= driver.findElement(By.tagName("button"));
        button_create_account.click();
        
        WebElement error_message= driver.findElement(By.className("invalid-reason"));
        
        customWait(1000);
        Assert.assertEquals(error_message.getText(), "The email address you entered is incorrect.");
        
        closedriver(driver);
        
        		
        		
        
        
    }

}
