package ex09_WebTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class StaticTable2 extends commonToAll {
	
	@Owner("Milita Sahu")
	@Description("Test the static Webtable when the table is uneven")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void test_web_table_login()
	{
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--start-maximized");
		WebDriver driver = new EdgeDriver(option);
		openbrowser(driver,"https://awesomeqa.com/webtable1.html");
		
		WebElement tableBody =driver.findElement(By.xpath("//table[contains(@class,'table_s13')]/tbody"));
		List<WebElement> tableRows=  tableBody.findElements(By.tagName("tr"));
	//get the table columns values in each row 
		
		for(int i=0; i<tableRows.size(); i++)
		{
			List<WebElement> column = tableRows.get(i).findElements(By.xpath("td"));
			for(WebElement col:column)
			{
				System.out.println(col.getText());
			}
		}
		
		driver.quit();
		
	}
	

}
