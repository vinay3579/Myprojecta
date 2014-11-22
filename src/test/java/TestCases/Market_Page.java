package TestCases;

/* Description: Verification of Market Page .
 * Created By: Rohit Mighlani
 * Created Date: 13 Aug 2014
 * */

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
import PageObjects.MarketPage;
import Reports.CustomMethodReport;


public class Market_Page {
	
	private MarketPage obj_marketPage;
	WebDriver driver;
	
	Properties prop = new Properties();
	
	CustomMethodReport cmr = new CustomMethodReport();
	FunctionLibrary fLib = new FunctionLibrary();
	PrintWriter printWrite = null;
	boolean isVerificationPassed= true;
	
	// This method would be run before each method present in testcase file & will launch browser & will open application.
	@BeforeMethod
	public void setUp(Method method) throws Exception {
		String browser = null;
		String url = null;
		
		// Create the html file internal verification
		printWrite = cmr.createWriter(method.getName());
		cmr.startHtmlPage(printWrite);
		
		// Create input stream object of property file.
		InputStream inputConfig = new FileInputStream(AutomationConstants.PROPERTY_FILE_NAME);
		// Create the logger instance object
		LoggerInstance l = new LoggerInstance();
		try {
			prop.load(inputConfig);
			// To get browser value from property file
			browser = prop.get(AutomationConstants.BROWSER).toString();
			// Initialize driver object of particular browser.
			driver = WebDriverBrowser.getWebDriver(browser);
			LoggerInstance.logger.info("Browser launched");
			// Maximize the browser window.
			driver.manage().window().maximize();
			// To get application url value from property file.
			url = prop.get(AutomationConstants.URL).toString();
			driver.get(url);
			LoggerInstance.logger.info("Navigated to "+url);
			
		} catch (Exception e) {
			LoggerInstance.logger.info("Unable to launch browser ");
		} 

	}
	// Scenario 1 :This test case will navigate to the Market Page and will Verify all the Sensex Value and and Nifty Value is Displayed.
	@Test
	public void Market_VerifyMarketTab(){
		try {
		LoggerInstance.logger.info("***********************Market Verify MarketTab() Started*********************************");
		// Initialize Page Factory For Market Page
		obj_marketPage = PageFactory.initElements(driver, MarketPage.class);
		obj_marketPage.clickOnMarketTab();
		// Verify user is navigated to Market page
		LoggerInstance.logger.info("Verify user is navigated to Market page.");
		boolean isVerifyMarketPageIsDisplayed = obj_marketPage.verifyMarketPageIsDisplayed(driver);
		
		if(isVerifyMarketPageIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if User is navigated to Market Page.", "User is navigated to Market Page.", "User is navigated to Market Page.", true, null);
		else {
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if User is navigated to Market Page.", "User is navigated to Market Page.", "User is not navigated to Market Page.", false, fLib.captureScreenshot());
		}
		
		// Click On BSE Tab.
		obj_marketPage.clickOnBSETab();
		
		// Verify current value of sensex is displayed.
		LoggerInstance.logger.info("Verify current value of sensex is displayed.");
		boolean isverifyCurrentValueOfSensexIsDisplayed=obj_marketPage.verifyCurrentValueOfSensexIsDisplayed(driver);
		
		if(isverifyCurrentValueOfSensexIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if current values of sensex is displayed.", "Current Value of sensex is displayed.", "Current Values of sensex is displayed.", true, null);
		else {
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if current values of sensex is displayed.", "Current Value of sensex is displayed.", "Current Values of sensex is not displayed.", false, fLib.captureScreenshot());
		}
		
		// Verify value change of sensex is displayed.
		LoggerInstance.logger.info("Verify value change of sensex is displayed.");
		boolean isVerifyValueChangeOfSensexIsDisplayed = obj_marketPage.verifyValueChangeOfSensexIsDisplayed(driver);
		if(isVerifyValueChangeOfSensexIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if value change of sensex is displayed.", "Values change of sensex is displayed.", "Value change of sensex is displayed.", true, null);
		else {
			isVerificationPassed= false;
			cmr.generateExecutionReport(printWrite, "Verify if value change of sensex is displayed.", "Values change of sensex is displayed.", "Value change of sensex is not displayed.", false, fLib.captureScreenshot());
		}
		
		// Verify Percentage change of sensex is displayed.
		LoggerInstance.logger.info("Verify Percentage change of sensex is displayed.");
		boolean isVerifyPercentageChangeOfSensexIsDisplayed = obj_marketPage.verifyPercentageChangeOfSensexIsDisplayed(driver);
		
		if(isVerifyPercentageChangeOfSensexIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if Percentage change of sensex is displayed.", "Percentage change of sensex is displayed.", "Percentage change of sensex is displayed.", true, null);
		else {
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Percentage change of sensex is displayed.", "Percentage change of sensex is displayed.", "Percentage change of sensex is not displayed.", false, fLib.captureScreenshot());
		}
		
		// Verify Open, Low, High and Pre Close of Sensex is displayed.
		LoggerInstance.logger.info("Verify Open, Low, High and Pre Close of Sensex is displayed.");
		boolean isVerifyOpenLowHighPreCloseIsDisplayed = obj_marketPage.verifyOpenLowHighPreCloseIsDisplayed(driver);
		
		if(isVerifyOpenLowHighPreCloseIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if Open, Low, High and PreClose of sensex is displayed.", "Open, Low, igh and PreClose of sensex is displayed.", "Open, Low, igh and PreClose of sensex is displayed.", true, null);
		else {
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Open, Low, High and PreClose of sensex is displayed.", "Open, Low, igh and PreClose of sensex is displayed.", "Open, Low, igh and PreClose of sensex is not displayed.", false, fLib.captureScreenshot());
		}
		
		// Click On NSE Tab.
		obj_marketPage.clickOnNSETab();
		
		// Verify current value of Nifty is displayed.
		LoggerInstance.logger.info("Verify current value of Nifty is displayed.");
		boolean isVerifyCurrentValueOfNiftyIsDisplayed =obj_marketPage.verifyCurrentValueOfNiftyIsDisplayed(driver);
		
		if(isVerifyCurrentValueOfNiftyIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if Current Value of nifty is displayed.", "Current value of nifty is displayed.", "Current Value of nifty is displayed.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Current Value of nifty is displayed.", "Current value of nifty is displayed.", "Current Value of nifty is not displayed.", false, fLib.captureScreenshot());
		}
		
		// Verify Percentage change of Nifty is displayed.
		LoggerInstance.logger.info("Verify Percentage change of Nifty is displayed.");
		boolean isVerifyPercentageChangeOfNiftyIsDisplayed = obj_marketPage.verifyPercentageChangeOfNiftyIsDisplayed(driver);
		
		if(isVerifyPercentageChangeOfNiftyIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if Percentage change of Nifty is displayed.", "Percentage change of Nifty is displayed.", "Percentage change of Nifty is displayed.", true, null);
		else{
			isVerificationPassed= false;
			cmr.generateExecutionReport(printWrite, "Verify if Percentage change of Nifty is displayed.", "Percentage change of Nifty is displayed.", "Percentage change of Nifty is not displayed.", false, fLib.captureScreenshot());
		}
		
		// Verify value change of Nifty is displayed.
		LoggerInstance.logger.info("Verify value change of Nifty is displayed.");
		boolean isVerifyValueChangeOfNiftyIsDisplayed = obj_marketPage.verifyValueChangeOfNiftyIsDisplayed(driver);
		
		if(isVerifyValueChangeOfNiftyIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if Value change of Nifty is displayed.", "Value change of Nifty is displayed.", "Value change of Nifty is displayed.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Value change of Nifty is displayed.", "Value change of Nifty is displayed.", "Value change of Nifty is not displayed.", false, fLib.captureScreenshot());
		}
		
		// Verify Open, Low, High and Pre Close of Nifty is displayed.
		LoggerInstance.logger.info("Verify Open, Low, High and Pre Close of Nifty is displayed.");
		boolean isVerifyOpenLowHighPreCloseIsDisplayedNifty=obj_marketPage.verifyOpenLowHighPreCloseIsDisplayed(driver);
		
		if(isVerifyOpenLowHighPreCloseIsDisplayedNifty)
			cmr.generateExecutionReport(printWrite, "Verify if Open, Low, High and Pre Close of Nifty is displayed.", "Open, Low, High and Pre Close of Nifty is displayed.", "Open, Low, High and Pre Close of Nifty is displayed.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Open, Low, High and Pre Close of Nifty is displayed.", "Open, Low, High and Pre Close of Nifty is displayed.", "Open, Low, High and Pre Close of Nifty is not displayed.", false, fLib.captureScreenshot());
		}
		
		LoggerInstance.logger.info("***********************Market Verify MarketTab() Ended*********************************");
		
		if(!isVerificationPassed) {
			org.testng.Assert.fail();
		}
		
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			obj_marketPage = null;
			if(!isVerificationPassed) {
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
		}
			
	}
	// Scenario 2 :This test case will navigate  to ETF Zone page and will Verify Gold ETF Table is displayed.
	@Test
	public void Market_VerifyETFTab() throws InterruptedException{
		try {
		LoggerInstance.logger.info("***********************Market Verify ETFTab() Started*********************************");
		// Initialize Page Factory For Market Page
		obj_marketPage = PageFactory.initElements(driver, MarketPage.class);
		// Navigate to ETF Zone tab.
		LoggerInstance.logger.info("Navigate to ETF Zone tab");
		obj_marketPage.clickOnETFZoneTab(driver);
		
		// Verify user is navigated to ETF Zone page.
		LoggerInstance.logger.info("Verify user is navigated to ETF Zone page.");
		boolean isVerifyETFZonePageIsDisplayed = obj_marketPage.verifyETFZonePageIsDisplayed(driver);
		if(isVerifyETFZonePageIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if User is navigated to ETF Zone.", "User is navigated to ETF Zone.", "User is navigated to ETF Zone.", true, null);
		else{
			isVerificationPassed= false;
			cmr.generateExecutionReport(printWrite, "Verify if User is navigated to ETF Zone.", "User is navigated to ETF Zone.", "User is not navigated to ETF Zone.", false, fLib.captureScreenshot());
		}
		
		// Verify Gold ETF Table is displayed on the ETF Zone page.
		LoggerInstance.logger.info("Verify Gold ETF Table is displayed on the ETF Zone page.");
		boolean isVerifyGoldETFTableIsDisplayed = obj_marketPage.verifyGoldETFTableIsDisplayed(driver);
		
		if(isVerifyGoldETFTableIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if Gold ETF Table is displayed on the ETF zone page.", "Gold ETF Table is displayed on the ETF zone page.", "Gold ETF Table is displayed on the ETF zone page.", true, null);
		else {
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Gold ETF Table is displayed on the ETF zone page.", "Gold ETF Table is displayed on the ETF zone page.", "Gold ETF Table is not displayed on the ETF zone page.", false, fLib.captureScreenshot());
		}
		
		// Verify Verify Non Gold ETF Table is displayed on the ETF Zone page.
		LoggerInstance.logger.info("Verify Non Gold ETF Table is displayed on the ETF Zone page.");
		boolean isVerifyNonGoldETFTableIsDisplayed = obj_marketPage.verifyNonGoldETFTableIsDisplayed(driver);
		
		if(isVerifyNonGoldETFTableIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if Non Gold ETF Table is displayed on the ETF zone page.", "Non Gold ETF Table is displayed on the ETF zone page.", "Non Gold ETF Table is displayed on the ETF zone page.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Non Gold ETF Table is displayed on the ETF zone page.", "Non Gold ETF Table is displayed on the ETF zone page.", "Non Gold ETF Table is not displayed on the ETF zone page.", false, fLib.captureScreenshot());
		}
		
		// Select Non Gold from Underlying dropdown.
		LoggerInstance.logger.info("Select Non Gold from Underlying dropdown");
		obj_marketPage.selectValueFromUnderlying("Non Gold");
		
		
		
		// Verify Non Gold ETF Table is displayed on the ETF Zone page.
		LoggerInstance.logger.info("Verify Non Gold ETF Table is displayed on the ETF Zone page.");
		obj_marketPage.verifyNonGoldETFTableIsDisplayed(driver);
		
		
		// Select Gold from Underlying dropdown.
		LoggerInstance.logger.info("Select Gold from Underlying dropdown");
		obj_marketPage.selectValueFromUnderlying("Gold");
		
		// Verify Gold ETF Table is displayed on the ETF Zone page.
		LoggerInstance.logger.info("Verify Gold ETF Table is displayed on the ETF Zone page.");
		boolean isverifyNonGoldETFTableIsDisplayed = obj_marketPage.verifyGoldETFTableIsDisplayed(driver);
		
		if(isverifyNonGoldETFTableIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify Gold ETF Table is displayed on the ETF Zone page.", "Gold ETF Table is displayed on the ETF Zone page.", "Gold ETF Table is not displayed on the ETF Zone page.", true, null);
		else{
			isVerificationPassed= false;
			cmr.generateExecutionReport(printWrite, "Verify Gold ETF Table is displayed on the ETF Zone page.", "Gold ETF Table is displayed on the ETF Zone page.", "Gold ETF Table is not displayed on the ETF Zone page.", false, fLib.captureScreenshot());
		}
		
		
		// Verify negative value is displayed in red color
		LoggerInstance.logger.info("Verify negative value is displayed in red color");
		boolean isVerifyNegativeValueColor = obj_marketPage.verifyNegativeValueColor();
		
		if(isVerifyNegativeValueColor)
			cmr.generateExecutionReport(printWrite, "Verify if Negative value is displayed in red color.", "Negative value is displayed in red color.", "Negative value is displayed in red color.", true, null);
		else{
			isVerificationPassed= false;
			cmr.generateExecutionReport(printWrite, "Verify if Negative value is displayed in red color.", "Negative value is displayed in red color.", "Negative value is not displayed in red color.", false, fLib.captureScreenshot());
		}
		
		LoggerInstance.logger.info("***********************Market Verify ETFTab() Ended*********************************");
		
		if(!isVerificationPassed){
			isVerificationPassed = true;
			org.testng.Assert.fail();
		}
		
	} catch (Exception e) {
		LoggerInstance.logger.info("Exception occured.");
		e.printStackTrace();
	} finally {
		obj_marketPage = null;
		if(!isVerificationPassed){
			isVerificationPassed = true;
			org.testng.Assert.fail();
		}
		
	}
	}
	// This method will be run after each method present in testcase file& will close the all browser windows.
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		LoggerInstance.logger.info("Browser closed.");
		cmr.endHtmlPage(printWrite);
		printWrite.flush();
	}
}
