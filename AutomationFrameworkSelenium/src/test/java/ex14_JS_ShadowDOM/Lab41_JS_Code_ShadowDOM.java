package ex14_JS_ShadowDOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Lab41_JS_Code_ShadowDOM {
	@Severity(SeverityLevel.CRITICAL)
	@Description("Validate the shadow root field and inout the data")
	@Test(enabled = true)
	public void shadowDOM() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		// driver.findElement(By.id("pizza"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement input_pizza = (WebElement) js.executeScript(
				"return document.querySelector('div#userName').shadowRoot.querySelector('div#app2').shadowRoot.querySelector('input#pizza')");

		input_pizza.sendKeys("FarmHouse pizza");

		driver.close();
	}

	@Test(groups = "iframe")
	public void iframe() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement username = (WebElement) js.executeScript(
				"return document.querySelector('div#userName').shadowRoot.querySelector(\"iframe#pact1\")");
		driver.switchTo().frame(username);
		driver.switchTo().frame("pact3");
		driver.findElement(By.id("glaf")).sendKeys("I am iframe");
		driver.switchTo().defaultContent();
		
		driver.quit();

	}

}
