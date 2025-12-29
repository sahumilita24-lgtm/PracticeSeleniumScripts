package smallpageAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TTABankBeneficiaryPage {

	@Test(enabled = false)
	public void login()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");
	    WebElement username= driver.findElement(By.cssSelector("input[type='email']"));
	    username.clear();
	    username.sendKeys("sahumilita24@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Password@2405");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//button[text()='Transfer Funds'
		
	}
	@Test
	public void signup()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click(); //navigate to signup page
		
		driver.findElement(By.xpath("//input[@placeholder='John Doe']")).sendKeys("Milita") ;
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("sahumilita24@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Password@2405");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		//Transfer funds
		driver.findElement(By.xpath("//button[text()='Transfer Funds']")).click();
		driver.findElement(By.xpath("//button[text()='Manage Beneficiaries']")).click();
		//Fill Manage beneficiaries fields
		driver.findElement(By.xpath("//label[text()='Full Name']/following-sibling::input")).sendKeys("Milita Sahu");
		driver.findElement(By.xpath("//label[text()='Bank Name']/following-sibling::input")).sendKeys("ICICI Bank");
		driver.findElement(By.xpath("//label[text()='Account Number']/following-sibling::input")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[text()='Save Beneficiary']")).click();
		
		driver.findElement(By.xpath("//button[text()='Manage Beneficiaries']")).click();
		
		List<WebElement> payeelist = driver.findElements(By.cssSelector(".space-y-3 div div p:nth-child(1)"));
		for(WebElement i: payeelist)
		{
			String addedbenefit = i.getText();
			if(addedbenefit.contentEquals("Milita Sahu"))
			{
				System.out.println("Beneficiary has been added succesfully");
			}
		}
		
		
		
		
		
	}
}
