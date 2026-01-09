package ex06_Input_Select_Alerts_Radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TestSelenium26_Input_Checkbox_Radio extends commonToAll{
	
	  @Description("This is description")
	  @Severity(SeverityLevel.CRITICAL)
	  @Test
	public void test_HTMLTags()
	{
		WebDriver driver = new EdgeDriver();
		openbrowser(driver,"https://awesomeqa.com/practice.html");
		
		//inputBox
		WebElement fullName_InputBox = driver.findElement(By.name("firstname"));
		fullName_InputBox.sendKeys("Milita Sahu");
		
		 // RADIO Box
		WebElement GenderMale_RadioBox = driver.findElement(By.id("sex-0"));
		GenderMale_RadioBox.click();
		
		// CheckBox
		WebElement Prof_ManualTester_InputBox= driver.findElement(By.xpath("//input[@value='Manual Tester']"));
		Prof_ManualTester_InputBox.click();
		
		closedriver(driver);
		
	}

}
