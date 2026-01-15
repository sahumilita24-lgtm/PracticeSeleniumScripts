package ex08_SVG_Elements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class Lab31_SVG_MAP {
	
	WebDriver driver;
	
	@BeforeTest
	public void open_Browser()
	{
		EdgeOptions option = new EdgeOptions();
		option.addArguments("-guest");
		option.addArguments("--start-maximized");
		
		driver = new EdgeDriver(option);
					
	}
	@Description("Verify Odisha is present in the map and click to zoom it")
    @Test
    public void test_India_map_SVG() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("https://www.amcharts.com/svg-maps/?map=india");
		List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g'][1]/*[name()='path']"));
		
		//get the state name Odisha from the states list of webElement
		
		for(WebElement state: states)
		{
			System.out.println(state.getDomAttribute("aria-label")); 
			//getdomAttribute is from selenium 4, getattribute is replaced is a legacy now
			if (state.getDomAttribute("aria-label").contains("Odisha"))
			{
				state.click();
			}
		}
	}
	

}
