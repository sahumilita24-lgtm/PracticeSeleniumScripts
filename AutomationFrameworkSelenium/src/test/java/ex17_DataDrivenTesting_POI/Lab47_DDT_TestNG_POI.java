package ex17_DataDrivenTesting_POI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Lab47_DDT_TestNG_POI {

	@Description("run the test with multiple test data")
	@Severity(SeverityLevel.CRITICAL)
	@Test (dataProvider="gettestdata")
	public void test_vwo_login(String username, String password) {
		System.out.println("Multiple Time Login I Have to check!");
		System.out.println(username + " - " + password);
		System.out.println();
	}

	@DataProvider
	public Object[][] gettestdata() {
		Object[][] data = new Object[][] { new Object[] { "Milita", "Password1" },
				new Object[] { "Sarita", "Password2" }, 
				new Object[] {"HArita", "Password3"}};

		
				return data;
	}
}
