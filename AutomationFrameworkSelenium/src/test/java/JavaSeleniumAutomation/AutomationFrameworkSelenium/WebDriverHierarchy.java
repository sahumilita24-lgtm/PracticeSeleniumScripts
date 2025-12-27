package JavaSeleniumAutomation.AutomationFrameworkSelenium;

public class WebDriverHierarchy {
	// Webdriver hierarchy
    // SearchContext(I) -> (2) -> WebDriver(I)( ~10) -> RemoteWebDriver(C) (~15)
    //        //// -> ChromiumDriver(C) ~25 -> EdgeDriver(C) (~45)
    // SearchContext - Interface - findElement, and findElements - GGF
    // WebDriver - Interface - some incomplete functions - GF
    // RemoteWebDriver - Class- It also has some functions - F
    // ChromeDriver, FirefoxDriver, EdgeDriver, SafariDriver, InternetExplorerDriver  Class - S

}
