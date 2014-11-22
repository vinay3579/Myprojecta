package FunctionLibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/* Class Name 	: WebDriverBrowser
 * Method Name	: getWebDriver 
 * Description	: This method will return Webdriver object depending on browser type.
 * Parameters	: 
 * 	1. broswerName : Broswer Name as String 
 * Created By	: Kuldeep Singh 
 * Created Date	: 11-08-2014
 */
public final class WebDriverBrowser {

	private WebDriverBrowser() {
	}

	public static WebDriver getWebDriver(String broswerName) throws IOException, Exception {
		WebDriver driver = null;
		FirefoxProfile profile;
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		Properties prop = new Properties();
		InputStream inputConfig = new FileInputStream(AutomationConstants.PROPERTY_FILE_NAME);
		prop.load(inputConfig);
        if(System.getenv("Browser")!=null){
            broswerName= System.getenv("Browser");
           }
        System.out.println("Brower Type >>>"+broswerName);
        
		if ("Firefox".equals(broswerName)) {
			// Create a new instance of firefox driver
			profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			FirefoxBinary binary = new FirefoxBinary();
			binary.setEnvironmentProperty("DISPLAY", ":1");
			driver = new FirefoxDriver(binary, profile);
		} else if ("Chrome".equals(broswerName)) {
			// Create a new instance of chrome driver
			System.setProperty(AutomationConstants.WEBDRIVER_CHROME_DRIVER, System.getProperty(AutomationConstants.USER_DIR) + prop.getProperty(AutomationConstants.CHROME_DRIVER));
			driver = new ChromeDriver();
		} else if ("IE".equals(broswerName)) {
			// Create a new instance of ie driver
			System.setProperty(AutomationConstants.WEBDRIVER_IE_DRIVER,System.getProperty(AutomationConstants.USER_DIR)+prop.getProperty(AutomationConstants.IEDRIVER));
			driver = new InternetExplorerDriver(ieCapabilities);
		} else {
			driver = new FirefoxDriver();
		}
		return driver;
	}
}