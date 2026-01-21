package ex13_Javascript_ex;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab40_JS_code {
	
	
	@Test
	public void jsexecuto()
	{
	WebDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor)driver; //explcit casting i.e downcasting we are performing here
	js.executeScript("window.location = 'https://www.google.com'");
	
	driver.get("https://selectorshub.com/xpath-practice-page/");
	js.executeScript("window.scrollBy(0,700)");
	
	String title= js.executeScript("return document.title").toString();
	String url = js.executeScript("return document.URL").toString();
	System.out.println("Title: " + title + " url: " + url);
	//driver.close();
	
	}

}
