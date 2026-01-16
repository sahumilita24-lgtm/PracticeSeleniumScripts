package ex11_File_Upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ex07_WaitHelper.WaitHelpers;

import io.qameta.allure.Description;

public class Lab38_FileUpload_BS {
	
	@Description("Upload file to browser stack page")
	@Test
	public void upload_APK_File()
	{
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.browserstack.com/users/sign_in");
        driver.manage().window().maximize();
        
        WebElement username = driver.findElement(By.id("user_email_login"));
        username.sendKeys("lnn76@1secmail.website");

        new WaitHelpers().waitJVM(2000);

        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("lnn76@1secmail.website");

        new WaitHelpers().waitJVM(2000);

        WebElement user_submit = driver.findElement(By.id("user_submit"));
        user_submit.click();

        new WaitHelpers().waitJVM(5000);

        driver.get("https://app-automate.browserstack.com/utilities/app_management");
        

        WebElement uploadFileInput = driver.findElement(By.id("file-upload"));
        String user_Dir = System.getProperty("user.dir");
        String apk_FilePath = user_Dir+ "/src/test/java/ex11_File_Upload/testdroid-sample-app.apk"; //better way to handle directory
        
        uploadFileInput.sendKeys(apk_FilePath);
	}

}
