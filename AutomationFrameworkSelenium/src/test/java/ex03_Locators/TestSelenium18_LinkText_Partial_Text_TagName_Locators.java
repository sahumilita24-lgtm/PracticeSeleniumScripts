package ex03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.Description;

public class TestSelenium18_LinkText_Partial_Text_TagName_Locators extends commonToAll{
	
	
	 @Description("Verify vwo create account negative TC")
	 @Test
	 public void test_login_vwo()
	 {
		 WebDriver driver = new ChromeDriver();
		 openbrowser(driver,"https://app.vwo.com");
		 
		// LinkText - Full Text match --starta with anchor tag mostly
	     // Partial Linktext - Partial Match

	     WebElement a_Tag_free_trail_full_match = driver.findElement(By.linkText("Start a free trial"));
	     WebElement a_tag_partial_match = driver.findElement(By.partialLinkText("trial"));
	        // Start a free trial
	        // Start a free
	        // Start a
	        // Start , Trail, free, a, Star...
	     
	     a_tag_partial_match.click();
	     customWait(1000);
	     closedriver(driver);
		 
	 }

}
