package smallpageAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonFolder.commonToAll;

public class Selectorshub_Task extends commonToAll {

	static WebDriver driver;
	static Actions action;
	static JavascriptExecutor js;

	@BeforeMethod
	public void browserRelatedsetup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
	}

	@Test(enabled = true)
	public void dummyform() {
		WebElement inputUserEmail = driver.findElement(By.name("email"));
		inputUserEmail.sendKeys("milita.sahu@gmail.com");
		WebElement inputPassword = driver.findElement(By.id("pass"));
		inputPassword.sendKeys("Password@1234");
		WebElement inputCompany = driver.findElement(By.cssSelector("input[name= 'company']"));
		inputCompany.sendKeys("Accenture");
		WebElement inputMobileNumber = driver
				.findElement(By.xpath("//input[@placeholder ='Enter your mobile number']"));
		inputMobileNumber.sendKeys("1234567890");
		WebElement InputCountry = driver
				.findElement(By.xpath("//input[@name='mobile number']/following-sibling::div//input"));
		InputCountry.sendKeys("India");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		waitForVisibility(driver, 10, "//button[text()='Submit']");
		WebElement buttonSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
		buttonSubmit.click();

		driver.quit();

	}

	@Test (enabled= true)
	public void shadowDOM() {
		
		//waitForVisibility(driver, 10, "//h6[text()='Shadow DOM']");

		// Learning Hub Link clicking 
		WebElement tag_a_LearningHub = (WebElement) js
				.executeScript("return document.querySelector('div#userName').shadowRoot.querySelector('a')");
		js.executeScript("arguments[0].click()", tag_a_LearningHub);
		
		//Validate child window opened and switch back to Parent window
		UtilityCommon testwindow = new UtilityCommon();
		String childwindow = testwindow.windowValidation(driver); 
		Assert.assertEquals(childwindow, "SelectorsHub - YouTube");
		
		//User Name input
		WebElement input_username = (WebElement) js.executeScript(
				"return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"input#kils\")");
		input_username.sendKeys("Milita.sahu");
		
		//Pizza Name input
		WebElement pizzaName = (WebElement) js.executeScript(
				"return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"input#pizza\")");
		pizzaName.sendKeys("Pizza farmHouse- Milita");
		
		//Password Input
		action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Password@1234").build().perform();
		
		closedriver(driver);

	}

	@Test(enabled=true)
	public void modalValidation()
	{
		//Click on the modal
		WebElement openModal= driver.findElement(By.id("myBtn"));
		action.moveToElement(openModal).click().build().perform();
		
		//validate the modal message 
		String ModalMessage = driver.findElement(By.cssSelector(".modal-header a")).getText();
		Assert.assertEquals(ModalMessage, "Testing Daily - Free App To Get The Latest Testing Feed.");
		
		//close modal
		driver.findElement(By.cssSelector(".close")).click(); 
		
		closedriver(driver);
	}
	
	@Test
	public void paymentPage()
	{
		driver.findElement(By.id("cardName")).sendKeys("Milita Sahu");
		driver.findElement(By.cssSelector("#cardNumber")).sendKeys("1234 5678 9012 3456");
		driver.findElement(By.cssSelector("#expiry")).sendKeys("05/09");
		driver.findElement(By.cssSelector("#cvv")).sendKeys("123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		driver.quit();
	}
}
