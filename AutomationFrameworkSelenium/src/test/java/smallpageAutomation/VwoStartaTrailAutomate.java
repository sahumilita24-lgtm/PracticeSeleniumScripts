package smallpageAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VwoStartaTrailAutomate {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//timeout issue by implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		driver.get("https://app.vwo.com/#/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Start a free trial']")).click(); // click on the "Start a Trial" button.
		String pagetitle= driver.getTitle();
		Assert.assertEquals(pagetitle, "Get Started with Free Trial | VWO"); //validate page title to check you are in correct page
		//add an invalid email and verify
		WebElement username= driver.findElement(By.name("email"));
		username.sendKeys("@123.com");
		WebElement errormessage=driver.findElement(By.xpath("//*[@id= 'page-v1-step1-email']/following-sibling::div"));
		wait.until(ExpectedConditions.visibilityOf(errormessage));
		String errormessagetext = errormessage.getText(); //Error message retreived post typing invalid email
		Assert.assertEquals(errormessagetext, "The email address you entered is incorrect.");
		//click on the radio box also. And then verify that the , "Create" button is not clickable 
		driver.findElement(By.cssSelector("#page-free-trial-step1-cu-gdpr-consent-checkbox")).click();
		driver.findElement(By.xpath("//button[text()='Create a Free Trial Account']")).click();
		Assert.assertEquals(errormessagetext, "The email address you entered is incorrect.");
		
		driver.quit();
		
		
	}

}
