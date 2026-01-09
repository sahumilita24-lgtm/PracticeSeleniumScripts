package ex09_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class StaticTables {
	//table, tbody: entire body, td:table data cell, th: table headertr: Table Row 
	
	@Test(groups = "QA")
    @Description("Test Case Description")
    public void test_web_table_login() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();
        
        //xpath=//table[@id='customers']/tbody/tr[2]/td
        
        String first_part = "//table[@id='customers']/tbody/tr[";
        String second_part="]/td[";
        String third_part= "]";
        
        int tableRow= driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size(); //output is list so size function is used
        int tableColumn= driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();
        
        for(int i=2;i<=tableRow;i++) // row as 2 first row doesnt contain td its contains th table header
        {
        	for (int j =1;j<=tableColumn;j++)
        	{
        		String xpath_ofEach_Cell= first_part+i+second_part + j + third_part;
        		String data =driver.findElement(By.xpath(xpath_ofEach_Cell)).getText();
        		//System.out.println(data);
        		
        		if (data.contains("Roland Mendel"))
        		{
        			String countryName= driver.findElement(By.xpath(xpath_ofEach_Cell + "/following-sibling ::td")).getText();
        			System.out.println("Roland Mendel is from " +  countryName);
        		}
        	}
        }
	}
}
