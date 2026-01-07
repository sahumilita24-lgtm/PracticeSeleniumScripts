package ex07_WaitHelper;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelpers {

	public static void waitJVM(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
	
	public static void waitImplicitWait(WebDriver driver, int timeInSecond)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSecond));
	}
	
	public static void checkVisibility(WebDriver driver, int timeInSecond, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeInSecond));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	public static void checkVisibility(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	
	
	
	public static void checkVisibilityOfAndTextToBePresentInElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.textToBePresentInElement(element,"Your email, password, IP address or location did not match"));
	}
	
	public static WebElement checkVisibilityByFluentWait(WebDriver driver,By locator)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement testMessage= wait.until
		(new Function<WebDriver,WebElement>()
			{
			public WebElement apply(WebDriver driver) 
				{
				 	return driver.findElement(locator);
				}
			}
		);
		
		return testMessage;

				
	}
}
