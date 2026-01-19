package ex12_Windows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lab38_Windows_Part1 {
	
	static WebDriver driver;
	
	@BeforeMethod
	public static void openbrowser()
	{
	EdgeOptions option = new EdgeOptions();
	option.addArguments("--start-maximized");
	option.addArguments("--guest");
	driver = new EdgeDriver(option);
	driver.get("https://the-internet.herokuapp.com/windows");	
	}
	
	@Test(enabled= false)
	public void windowhandle_foreachloop()
	{
		String currentwindowid= driver.getWindowHandle();
		System.out.println(currentwindowid); //8F0EDE6E6C5C211085F7837C68D683C0
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windowid = driver.getWindowHandles();
		for(String temp: windowid)			
		{
			System.out.println(temp);
			driver.switchTo().window(temp);
			if(driver.getTitle().contains("New Window"))
				
			{
				System.out.println("Reached child window");
			}
			
		}
		driver.switchTo().window(currentwindowid);
		
		driver.quit();
	}
	
	@Test
	public void windowhandle_iterator()
	{
		String currentwindowid= driver.getWindowHandle();
		System.out.println(currentwindowid);
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windowids = driver.getWindowHandles();
		Iterator<String> it= windowids.iterator();
		String parentwindow= it.next();
		System.out.println(parentwindow + " parent window");
		String childwindow= it.next();
		System.out.println(childwindow + " child window");
		driver.switchTo().window(childwindow);
		System.out.println(driver.getTitle());
		driver.quit();
		
		
	}

}
