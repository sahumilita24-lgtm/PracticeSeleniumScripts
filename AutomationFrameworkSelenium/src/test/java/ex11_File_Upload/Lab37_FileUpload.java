package ex11_File_Upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Lab37_FileUpload {
	
	@Test
	public void upload_file()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://awesomeqa.com/selenium/upload.html");
		
		WebElement fileupload= driver.findElement(By.id("fileToUpload"));
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
		fileupload.sendKeys(userDir + "/src/test/java/ex11_File_Upload/TestData.txt" );
		
		driver.findElement(By.name("submit")).click();
		
		driver.close();
	}

}
