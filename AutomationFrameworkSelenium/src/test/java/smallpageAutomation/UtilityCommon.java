package smallpageAutomation;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class UtilityCommon {
	
	public  String windowValidation(WebDriver driver)
	{
		WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(40));
		Set<String> windowIds= driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Cancel']")));
		String childtitle= driver.getTitle();
		
		
		/*for(String tempids:windowIds )
		{
			driver.switchTo().window(tempids);
			if(driver.getTitle().contains("SelectorsHub - YouTube"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Cancel']")));
				driver.findElement(By.xpath("//button[@aria-label='Cancel']")).click();
				System.out.println(driver.getTitle());
				driver.close();

			}
			else {
				 parent = tempids;
			}
		} */
		
		driver.switchTo().window(parent);
		return childtitle;
	}
	
	
}
