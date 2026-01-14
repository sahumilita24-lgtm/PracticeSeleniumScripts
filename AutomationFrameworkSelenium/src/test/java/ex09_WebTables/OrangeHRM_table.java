package ex09_WebTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import commonFolder.commonToAll;
import io.qameta.allure.Description;

public class OrangeHRM_table extends commonToAll{
	
	@Description("Orange HRM employee list data")
	@Test
	public void employee_list ()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://awesomeqa.com/hr/web/index.php/pim/viewEmployeeList");		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		oranheHRMLogin( driver);
		
		List<WebElement> tablerows = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div"));
		for(int i=0; i< 5;i++)
		{
			List<WebElement> column = tablerows.get(i).findElements(By.xpath(".//div[@role='cell']/div"));
			for(WebElement eachcell: column)
			{
				if (!eachcell.getText().isEmpty())
				System.out.println(eachcell.getText());
				
			}
		}
				
	}

}
