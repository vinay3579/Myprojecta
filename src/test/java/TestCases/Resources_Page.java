package TestCases;

/* Description: Verification of Resource Page.
 * Created By: Mohd Suhail
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
import PageObjects.ResourcesPage;
import Reports.CustomMethodReport;


public class Resources_Page {

	private ResourcesPage obj_resourcePage;
	
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
		
		printWrite= cmr.createWriter(method.getName());
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

	// Scenario 1 :This test case will navigate to the Resource tab  & Verify  General Economic Indicator Page is displayed and General Economic Contains RBI Reference Exchange Column.
	@Test
	public void Resource_VerifyGeneralEconmicIndicatorPage() throws Exception {

		try {
			LoggerInstance.logger.info("*********************** Resource_VerifyGeneralEconmicIndicatorPage() Started*********************************");

			// Initialize Page Factory For Resource  Page
			obj_resourcePage = PageFactory.initElements(driver, ResourcesPage.class);

			//Click on Resource Tab
			obj_resourcePage.clickOnResourceTab();
			
			//Verify that General Economic Indicator Is Displayed.
			LoggerInstance.logger.info("Verify General Economic Indicator Page is displayed.");
			boolean isVerify_GeneralEconomicIndicatorsIsDisplayed = obj_resourcePage.verify_GeneralEconomicIndicatorsIsDisplayed();
			if(isVerify_GeneralEconomicIndicatorsIsDisplayed)
				cmr.generateExecutionReport(printWrite, "Verify if General Economic Indicator Page is displayed.", "General Economic Indicator Page is displayed.", "General Economic Indicator Page is displayed.", true, null);
			else{
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if General Economic Indicator Page is displayed.", "General Economic Indicator Page is displayed.", "General Economic Indicator Page is not displayed.", false, fLib.captureScreenshot());
			}
			//Verify that KeyEconomic Page is displayed
			LoggerInstance.logger.info("Verify KeyEconomic Page is displayed.");
			boolean isVerify_KeyEconomic = obj_resourcePage.verify_KeyEconomic();
			if(isVerify_KeyEconomic)
				cmr.generateExecutionReport(printWrite, "Verify if KeyEconomic Page is displayed.", "KeyEconomic Page is displayed.", "KeyEconomic Page is displayed.", true, null);
			else{
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if KeyEconomic Page is displayed.", "KeyEconomic Page is displayed.", "KeyEconomic Page is not displayed.", false, fLib.captureScreenshot());
			}
			
			//Verify CCil Indicators Indices Page is displayed.
			LoggerInstance.logger.info("Verify CCil Indicators Indices Page is displayed.");
			boolean isVerify_CCilIndicatorsIndicesIsDisplayed =obj_resourcePage.verify_CCilIndicatorsIndicesIsDisplayed();
			
			if(isVerify_CCilIndicatorsIndicesIsDisplayed)
				cmr.generateExecutionReport(printWrite, "Verify if CCil IndicatorsIndices Page is displayed.", "CCil IndicatorsIndices Page is displayed.", "CCil IndicatorsIndices Page is displayed.", true, null);
			else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if CCil IndicatorsIndices Page is displayed.", "CCil IndicatorsIndices Page is displayed.", "CCil IndicatorsIndices Page is not displayed.", false, fLib.captureScreenshot());
			}
			
			//Verify NSE FIMMDA Indicators Page is displayed .
			LoggerInstance.logger.info("Verify NSE FIMMDA Indicators Page is displayed.");
			boolean isVerify_NSEFIMMDAIndicatorsIsDisplayed = obj_resourcePage.verify_NSEFIMMDAIndicatorsIsDisplayed();
			if(isVerify_NSEFIMMDAIndicatorsIsDisplayed)
				cmr.generateExecutionReport(printWrite, "Verify NSE FIMMDA Indicators Page is displayed.", "NSE FIMMDA Indicators Page is displayed.", "NSE FIMMDA Indicators Page is displayed.", true, null);
			else{
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify NSE FIMMDA Indicators Page is displayed.", "NSE FIMMDA Indicators Page is displayed.", "NSE FIMMDA Indicators Page is not displayed.", false, fLib.captureScreenshot());
			}
			
			//Verify General Economic Contains Indicator Column.
			LoggerInstance.logger.info("Verify General Economic Contains Indicator Column");
			boolean isVerify_GeneralEconomicContainsIndicator = obj_resourcePage.verify_GeneralEconomicContainsIndicator();
			if(isVerify_GeneralEconomicContainsIndicator)
				cmr.generateExecutionReport(printWrite, "Verify if General Economic contains Indicator coulmn.", "General Economic contains Indicator coulmn.", "General Economic contains Indicator coulmn.", true, null);
			else{
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if General Economic contains Indicator coulmn.", "General Economic contains Indicator coulmn.", "General Economic does not contain Indicator coulmn.", false, fLib.captureScreenshot());
			}
			
			//Verify General Economic Contains RBIPolicy Indicator Column.
			LoggerInstance.logger.info("Verify General Economic Contains RBIPolicy Indicator Column");
			boolean isVerify_GeneralEconomicContainsRBIPolicyIndicator =obj_resourcePage.verify_GeneralEconomicContainsRBIPolicyIndicator();
			if(isVerify_GeneralEconomicContainsRBIPolicyIndicator)
				cmr.generateExecutionReport(printWrite, "Verify if General Economic contains RBIPocily Indicator column." , "General Economic contains RBIPocily Indicator column.", "General Economic contains RBIPocily Indicator column.", true, null);
			else{
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if General Economic contains RBIPocily Indicator column." , "General Economic contains RBIPocily Indicator column.", "General Economic does not contain RBIPocily Indicator column.", false, fLib.captureScreenshot());
			}
			
			//Verify General Economic Contains RBI Reference Exchange Column.
			LoggerInstance.logger.info("Verify General Economic Contains RBI Reference Exchange Column");
			obj_resourcePage.verify_GeneralEconomicContainsRBIReferenceExchange();
			boolean isVerify_GeneralEconomicContainsRBIReferenceExchange = obj_resourcePage.verify_GeneralEconomicContainsRBIReferenceExchange();
			if(isVerify_GeneralEconomicContainsRBIReferenceExchange)
				cmr.generateExecutionReport(printWrite, "Verify if General Economic contains RBI Reference Exchange column.", "General Economic contains RBI Reference Exchange column.", "General Economic contains RBI Reference Exchange column.", true, null);
			else{
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if General Economic contains RBI Reference Exchange column.", "General Economic contains RBI Reference Exchange column.", "General Economic does not contain RBI Reference Exchange column.", false, fLib.captureScreenshot());
			}

			LoggerInstance.logger.info("***********************Resource_VerifyGeneralEconmicIndicatorPage()  Ended*********************************");
			if(!isVerificationPassed){
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			obj_resourcePage = null;
			if(!isVerificationPassed){
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
		}
	}

	// This method will be run after each method present in testcase file& will close the all browser windows.
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		LoggerInstance.logger.info("Browser closed");
		cmr.endHtmlPage(printWrite);
		printWrite.flush();
	}

}
