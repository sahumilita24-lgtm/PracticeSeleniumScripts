package smallpageAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class orangepagelogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Hacker@4321");
		driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
		String value = driver.findElement(By.xpath("//span/h6")).getText();
		Assert.assertEquals(value, "PIM");
		
		driver.close();
		

	}

}
