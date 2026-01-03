package commonFolder;

import org.openqa.selenium.WebDriver;

public class commonToAll {
	
	public void openbrowser(WebDriver driver,String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void closedriver(WebDriver driver)
	{
		 try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            throw new RuntimeException(e);
	        }
		driver.quit();
	}
	
	
	public void customWait(int time) 
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			 throw new RuntimeException(e);
		}
	}
	
	

}
