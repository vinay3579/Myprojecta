package TestCases;

/* Description: Verification of Widgets Gallery Page .
 * Created By: Aman Saraf Jain
 * Created Date: 23 Aug 2014
 * */

import java.io.FileInputStream;
import java.io.IOException;
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
import PageObjects.WidgetPage;
import Reports.CustomMethodReport;

public class Widget_Page {
	private WidgetPage widgetPage;
	static WebDriver driver;
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
			LoggerInstance.logger.info("Navigated to  " + url);
		} catch (Exception e) {
			LoggerInstance.logger.info("Unable to launch browser ");
		} finally {
			browser = null;
			url = null;
			inputConfig = null;
		}
	}
		// // Scenario 1 :This test case will verify Widget Page .
	@Test
	public void verify_widgetTab() throws Exception {
		try {
			LoggerInstance.logger.info("***********************WidgetPage Tab() Started*********************************");
			widgetPage = PageFactory.initElements(driver, WidgetPage.class);
			
			// Clicking on Widget tab
			LoggerInstance.logger.info("Clicking Widget tab");
			widgetPage.clickOnWidgetTab();
			
			// Verify links present on Widget Tab
			LoggerInstance.logger.info("verifying links present on Widget tab");
			boolean isVerifyLinksPresent = widgetPage.verifyLinksPresent();
			
			if(isVerifyLinksPresent){
				cmr.generateExecutionReport(printWrite, "Verify if Links are present on Widget tab.", "Links are present on Widget tab.", "Links are present on Widget tab.", true, null);
			}else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Links are present on Widget tab.", "Links are present on Widget tab.", "Links are not present on Widget tab.", false, fLib.captureScreenshot());
			}
			
			// Verify market breadth link and sub icons like refresh feedback on Widget Tab
			LoggerInstance.logger.info("Verify market breadth link and sub icons like refresh feedback on Widget Tab");
			boolean isVerifyMarketBreadthLink = widgetPage.verifyMarketBreadthLink(driver);
			if(isVerifyMarketBreadthLink){
				cmr.generateExecutionReport(printWrite, "Verify if market breadth link and sub icons like refresh feedback are present on widget tab.", "market breadth link and sub icons like refresh feedback are present on widget tab.", "market breadth link and sub icons like refresh feedback are present on widget tab.", true, null);
			}else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if market breadth link and sub icons like refresh feedback are present on widget tab.", "market breadth link and sub icons like refresh feedback are present on widget tab.", "market breadth link and sub icons like refresh feedback are not present on widget tab.", false, fLib.captureScreenshot());
			}
			// Navigating back to widget page
			LoggerInstance.logger.info("Navigating back to widget page");
			widgetPage.clickOnWidgetTab();

			// Verify section by on Widget Tab
			LoggerInstance.logger.info("Verify section by on Widget Tab");
			boolean isVerifysectionby = widgetPage.verifysectionby();
			if(isVerifysectionby){
				cmr.generateExecutionReport(printWrite, "Verify Section by on widget tab.", "Section by is present on widget tab.", "Section by is present on widget tab.", true, null);
			}else{
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify Section by on widget tab.", "Section by is present on widget tab.", "Section by is not present on widget tab.", false, fLib.captureScreenshot());
			}
			// Navigating back to widget page
			LoggerInstance.logger.info("Navigating back to widget page");
			widgetPage.clickOnWidgetTab();
						
					
			// Verify Latest Impression section
			LoggerInstance.logger.info("Verify Latest Impression section");
			boolean isVerifyLatestImpression = widgetPage.verifyLatestImpression();
			if(isVerifyLatestImpression) {
				cmr.generateExecutionReport(printWrite, "Verify if Latest Impression section is present.", "Latest Impression section is present.", "Latest Impression section is present.", true, null);
			}else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Latest Impression section is present.", "Latest Impression section is present.", "Latest Impression section is not present.", false, fLib.captureScreenshot());
			}
			LoggerInstance.logger.info("***********************WidgetPage tab() Ended*********************************");				
		
			if(!isVerificationPassed){
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
		}
			catch (Exception e) {
				LoggerInstance.logger.info("Exception occured.");
				e.printStackTrace();
			} finally {
				if(!isVerificationPassed){
					isVerificationPassed=true;
					org.testng.Assert.fail();
				}
				widgetPage = null;
			}
	}
		
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		LoggerInstance.logger.info("Browser closed");
		cmr.endHtmlPage(printWrite);
		printWrite.flush();
	}
}
