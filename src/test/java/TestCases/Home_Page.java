package TestCases;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import FunctionLibraries.AutomationConstants;
import FunctionLibraries.FunctionLibrary;
import FunctionLibraries.WebDriverBrowser;
import Logger.LoggerInstance;
import PageObjects.HomePage;
import PageObjects.IPOPage;
import Reports.CustomMethodReport;


public class Home_Page{

	static WebDriver driver;
	private HomePage homePage;
	
	CustomMethodReport cmr = new CustomMethodReport();
	FunctionLibrary fLib = new FunctionLibrary();
	PrintWriter printWrite = null;
	boolean isVerificationPassed= true;
	Properties prop = new Properties();

	@BeforeMethod
	public void setUp(Method method) throws Exception {
		String browser = null;
		String url = null;
		
		//Call create Writer method to generate the html file
		printWrite = cmr.createWriter(method.getName());
		cmr.startHtmlPage(printWrite);
		
		InputStream inputConfig = new FileInputStream(AutomationConstants.PROPERTY_FILE_NAME);
		LoggerInstance l = new LoggerInstance();
		try {
			prop.load(inputConfig);
			browser = prop.get(AutomationConstants.BROWSER).toString();
			driver = WebDriverBrowser.getWebDriver(browser);
			LoggerInstance.logger.info("Browser launched");
			driver.manage().window().maximize();
			url = prop.get(AutomationConstants.URL).toString();
			driver.get(url);
			LoggerInstance.logger.info("Navigated to  " + url);
		} catch (Exception e) {
			LoggerInstance.logger.info("Unable to launch browser ");
		} finally {
			browser = null;
			url = null;
			inputConfig = null;
		}
	}
	
	@Test
	public void verifyHomeTabCal() throws Exception {
		try {
			LoggerInstance.logger.info("***********************verifyHomeTabCal() Started*********************************");
			
			// Initialize Page Factory For HOME Page
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			
			// Verifing Finalaya logo
			LoggerInstance.logger.info("Verify finalaya logo");
			boolean isVerifyLogoImage = homePage.verifyLogoImage();	

			if(isVerifyLogoImage) {
				cmr.generateExecutionReport(printWrite, "Verify if logo is verified.", "Logo is verified.", "Logo is verified.", true, null);
			} else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if logo is verified.", "Logo is verified.", "Logo is not verified.", false, fLib.captureScreenshot());
			}
			
			// Verifing HomePage tab
			LoggerInstance.logger.info("Click on Home Page Tab.");
			boolean isVerifyTabDisplay = homePage.verifyTabDisplay();
			
			if(isVerifyTabDisplay)
				cmr.generateExecutionReport(printWrite, "Verify if Home Page tab is displayed.", "Home Page Tab is displayed.", "Home Page Tab is displayed.", true, null);
			else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Home Page tab is displayed.", "Home Page Tab is displayed.", "Home Page Tab is not displayed.", false, fLib.captureScreenshot());
			}
			
            // Verify HomePage tab Squence 
			LoggerInstance.logger.info("Verify finalaya tab squence.");
			boolean isVerifyTabsquence = homePage.verifyTabsquence();
			
			if(isVerifyTabsquence) {
				cmr.generateExecutionReport(printWrite, "Verify if Finalaya Tab sequences are correct.", "Finalaya Tab sequences are correct.", "Finalaya Tab sequences are correct.", true, null);
			} else{
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Finalaya Tab sequences are correct.", "Finalaya Tab sequences are correct.", "Finalaya Tab sequences are not correct.", true, fLib.captureScreenshot());
			}
			
			//Click on first square button and Verifing Market Today,sensex text
			LoggerInstance.logger.info("Click on square button and verify Market today, sensex text.");
			homePage.clickOnSquareButton();
			
			//Verify Latest News Section
			LoggerInstance.logger.info("Verify latest newes section.");
			boolean isVerifyLatestNewsSection = homePage.verifyLatestNewsSection();
			
			if(isVerifyLatestNewsSection) {
				cmr.generateExecutionReport(printWrite, "Verify if latest news section is displayed.", "Latest news section is displayed.", "Latest news section is displayed.", true, null);
			} else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if latest news section is displayed.", "Latest news section is displayed.", "Latest news section is not displayed.", false, fLib.captureScreenshot());
			}
			
			//Verify Search on home page
			LoggerInstance.logger.info("Click on home page search.");
			boolean isVerifySearchOnHomePage = homePage.verifySearchOnHomePage();
			
			if(isVerifySearchOnHomePage){
				cmr.generateExecutionReport(printWrite, "Verify if Company Name is searched.", "Company Name is searched.", "Company Name is searched.", true, null);
			} else{
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Company Name is searched.", "Company Name is searched.", "Company Name is not searched.", false, fLib.captureScreenshot());
			}
			
			LoggerInstance.logger.info("***********************verifyHomeTabCal() Ended*********************************");
			if(!isVerificationPassed) {
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
			
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			homePage = null;
			if(!isVerificationPassed) {
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

}

