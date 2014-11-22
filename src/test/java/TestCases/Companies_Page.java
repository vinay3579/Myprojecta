package TestCases;

/* Description: Verification of CompaniesPage.
 * Created By: Mohd Suhail
 * Created Date: 26 Aug 2014
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
import PageObjects.CompaniesPage;
import Reports.CustomMethodReport;

public class Companies_Page {
	
	private CompaniesPage obj_companiesPage;
	static WebDriver driver;
	Properties prop = new Properties();
	
	CustomMethodReport cmr = new CustomMethodReport();
	FunctionLibrary fLib = new FunctionLibrary();
	PrintWriter printWrite = null;
	boolean isVerificationPassed= true;
	
	// This method would be run before each method present in test case file & will launch browser & will open application.
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
		
		//Scenario 1: This testcase will navigate to the companies page and verify the columns displayed as Company Name, Industry, NSE, BSE & results
		@Test
		public void Companies_VerifyCompaniesTab() throws Exception
		{
			try{
				
			LoggerInstance.logger.info("***********************Companies_VerifyCompaniesTab() Started*********************************");
			// Initialize Page Factory For Companies Page
			obj_companiesPage = PageFactory.initElements(driver,CompaniesPage.class);
				
			//Verify Microsite Page Is displayed
			LoggerInstance.logger.info("Verify Microsite Page Is displayed.");
			boolean isVerifyMicrositePageIsdisplayed = obj_companiesPage.VerifyMicrositePageIsdisplayed();
			if(isVerifyMicrositePageIsdisplayed) {
				cmr.generateExecutionReport(printWrite, "Verify if Microsite Page is displayed.", "Microsite Page is displayed.", "Microsite Page is displayed.", true, null);
			} else {
				isVerificationPassed = false;
				cmr.generateExecutionReport(printWrite, "Verify if Microsite Page is displayed.", "Microsite Page is displayed.", "Microsite Page is not displayed.", false, fLib.captureScreenshot());
			}
			
			//Verify Result Page Is displayed
			LoggerInstance.logger.info("Verify Results Page Is displayed.");
			boolean isVerifyResultsPageIsdisplayed = obj_companiesPage.verifyResultsPageIsdisplayed();
			
			if(isVerifyResultsPageIsdisplayed) {
				cmr.generateExecutionReport(printWrite, "Verify if Results Page is displayed.", "Results Page is displayed.", "Results Page is displayed.", true, null);
			} else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Results Page is displayed.", "Results Page is displayed.", "Results Page is not displayed.", false, fLib.captureScreenshot());
			}
			
			//Verify Announcement Page Is displayed
			LoggerInstance.logger.info("Verify Annoucement Page Is displayed.");
			boolean isVerifyAnnoucementPageIsdisplayed= obj_companiesPage.VerifyAnnoucementPageIsdisplayed();
			
			if(isVerifyAnnoucementPageIsdisplayed) {
				cmr.generateExecutionReport(printWrite, "Verify if Announcement Page is displayed.", "Announcement Page is displayed.", "Announcement Page is displayed.", true, null);
			} else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Announcement Page is displayed.", "Announcement Page is displayed.", "Announcement Page is not displayed.", false, fLib.captureScreenshot());
			}
			
			//Verify Compare Companies Page Is displayed
			LoggerInstance.logger.info("Verify Compare Companies Page Is displayed.");
			boolean isVerifyCompareCompaniesPageIsdisplayed = obj_companiesPage.verifyCompareCompaniesPageIsdisplayed();
			if(isVerifyCompareCompaniesPageIsdisplayed) {
				cmr.generateExecutionReport(printWrite, "Verify if Compare Companies Page is displayed.", "Compare Companies Page is displayed.", "Compare Companies Page is displayed.", true, null);
			} else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Companies Page is displayed.", "Compare Companies Page is displayed.", "Compare Companies Page is not displayed.", false, fLib.captureScreenshot());
			}
	
			//Verify IndustriesPage  Is displayed
			LoggerInstance.logger.info("Verify Industries Page Is displayed.");
			boolean isVerifyIndustriesPageIsdisplayed = obj_companiesPage.verifyIndustriesPageIsdisplayed();
			
			if(isVerifyIndustriesPageIsdisplayed) {
				cmr.generateExecutionReport(printWrite, "Verify if Industries Page is displayed.", "Industries Page is displayed.", "Industries Page is displayed.", true, null);
			} else {
				isVerificationPassed= false;
				cmr.generateExecutionReport(printWrite, "Verify if Industries Page is displayed.", "Industries Page is displayed.", "Industries Page is not displayed.", false, fLib.captureScreenshot());
			}
			
			//Verify Document Page Is displayed
			LoggerInstance.logger.info("Verify Document Page Is displayed.");
			boolean isVerifyDocumentPageIsdisplayed = obj_companiesPage.VerifyDocumentPageIsdisplayed();
			
			
			if(isVerifyDocumentPageIsdisplayed)
				cmr.generateExecutionReport(printWrite, "Verify if Document Page is displayed.", "Document Page is displayed.", "Document Page is displayed.", true, null);
			else {
				isVerificationPassed= false;
				cmr.generateExecutionReport(printWrite, "Verify if Document Page is displayed.", "Document Page is displayed.", "Document Page is not displayed.", false, fLib.captureScreenshot());
			}
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("Exception occured.");
				
			}
			LoggerInstance.logger.info("**********************Companies_VerifyCompaniesTab() Ended*******************************");
			if(!isVerificationPassed){
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
		}
		
		//Scenario 2: This test case will navigate all the sub menus and verify that respective pages are displayed.
		@Test
		public void Companies_VerifyNavigationOnCompaniesSubtab() throws Exception
		{
			try{
				
			LoggerInstance.logger.info("***********************Companies_VerifyNavigationOnCompaniesSubtab() Started*********************************");	
				
			// Initialize Page Factory For Companies Page	
			obj_companiesPage = PageFactory.initElements(driver,CompaniesPage.class);
			
			//Click on Companies tab
			LoggerInstance.logger.info("Click On Companies tab.");		
			obj_companiesPage.clickOnCompaniesTab();
			

			//Verify Document  Tab Is Present
			LoggerInstance.logger.info("Verify Information Tab is Present On Page.");	
			boolean isVerifyInformationTab = obj_companiesPage.verifyInformationTab();
			
			if(isVerifyInformationTab)
				cmr.generateExecutionReport(printWrite, "Verify if Information Tab is Present on Page.", "Information Page is displayed on Page.", "Information Page is displayed on Page.", true, null);
			else {
				isVerificationPassed= false;
				cmr.generateExecutionReport(printWrite, "Verify if Information Tab is Present on Page.", "Information Page is displayed on Page.", "Information Page is not displayed on Page.", false, fLib.captureScreenshot());
			}
			
			//Verify Document  Tab Is Present
			LoggerInstance.logger.info("Verify Document Tab Is Displayed on Page.");
			boolean isVerifyDocumentTabIsDisplayed = obj_companiesPage.verifyDocumentTabIsDisplayed();
			
			if(isVerifyDocumentTabIsDisplayed)
				cmr.generateExecutionReport(printWrite, "Verify if Document Tab is Displayed on Page.", "Document Tab is displayed on Page.", "Document Tab is displayed on Page.", true, null);
			else {
				isVerificationPassed= false;
				cmr.generateExecutionReport(printWrite, "Verify if Document Tab is Displayed on Page.", "Document Tab is displayed on Page.", "Document Tab is not displayed on Page.", false, fLib.captureScreenshot());
			}
			//Verify Company Name Is Sorted Ascending order
			LoggerInstance.logger.info("Verify Companies Names are Sorted in Ascending Order on Microsite Page.");
			boolean isVerifyComanyNameSortedAscending = obj_companiesPage.VerifyComanyNameSortedAscending();
			
			if(isVerifyComanyNameSortedAscending)
				cmr.generateExecutionReport(printWrite, "Verify if Companies Names are sorted in ascending Order on Microsite Page.", "Companies Names are sorted in ascending order on Microsite Page.", "Companies Names are sorted in ascending order on Microsite Page.", true, null);
			else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Companies Names are sorted in ascending Order on Microsite Page.", "Companies Names are sorted in ascending order on Microsite Page.", "Companies Names are not sorted in ascending order on Microsite Page.", false, fLib.captureScreenshot());
			}
			
			//Verify Company Name Is Sorted Descending order
			LoggerInstance.logger.info("Verify Companies Names are Sorted in Descending Order on Microsite Page.");
			boolean isVerifyComanyNameSorteDecendingOrder = obj_companiesPage.VerifyComanyNameSorteDecendingOrder();
			
			if(isVerifyComanyNameSorteDecendingOrder)
				cmr.generateExecutionReport(printWrite, "Verify id Companies Names are sorted in descending order on Microsite Page.", "Companies Names are sorted in descending order on Microsite Page.", "Companies Names are sorted in descending orderon Microsite Page.", true, null);
			else {
				isVerificationPassed= false;
				cmr.generateExecutionReport(printWrite, "Verify id Companies Names are sorted in descending order on Microsite Page.", "Companies Names are sorted in descending order on Microsite Page.", "Companies Names are not sorted in descending orderon Microsite Page.", false, fLib.captureScreenshot());
			}
			
			 //Clicking on Companies tab
			LoggerInstance.logger.info("Click On Companies tab.");
			obj_companiesPage.clickOnCompaniesTab();
			
			//Verify Company Table Heading is Displayed and verified
			boolean isVerifyComanyTableHeadingIsDisplayed = obj_companiesPage.VerifyComanyTableHeadingIsDisplayed();
			
			if(isVerifyComanyTableHeadingIsDisplayed)
				cmr.generateExecutionReport(printWrite, "Verify if Company Table Heading is displayed.", "Company Table heading is displayed.", "Company Table heading is displayed.", true, null);
			else {
				isVerificationPassed= false;
				cmr.generateExecutionReport(printWrite, "Verify if Company Table Heading is displayed.", "Company Table heading is displayed.", "Company Table heading is not displayed.", false, fLib.captureScreenshot());
			}
			
			 //Clicking on Industries tab
			LoggerInstance.logger.info("Click On InforMation tab.");
			obj_companiesPage.clickInformationTab();
			
			//Verify Company name and Industry column value is matching with tool tip text.
			LoggerInstance.logger.info("Verify ToolTip Company Text Value Industry Column Value Matches.");
			boolean isVerifyToolTipCompanyValIndustryColumnValMatches = obj_companiesPage.VerifyToolTipCompanyValIndustryColumnValMatches();
			
			if(isVerifyToolTipCompanyValIndustryColumnValMatches)
				cmr.generateExecutionReport(printWrite, "Verify if Company Name and Indusry column values is matching with tool tip text.", "Company Name and Indusry column values is matching with tool tip text.", "Company Name and Indusry column values is matching with tool tip text.", true, null);
			else {
				isVerificationPassed= false;
				cmr.generateExecutionReport(printWrite, "Verify if Company Name and Indusry column values is matching with tool tip text.", "Company Name and Indusry column values is matching with tool tip text.", "Company Name and Indusry column values is not matching with tool tip text.", false, fLib.captureScreenshot());
			}
			
	       //Verify BSE Text red color have down arrow and green color text have up arrow
			LoggerInstance.logger.info("Verify BSE Text red in color have down arrow and green color text have up arrow.");
			boolean isVerifyBSEArrowColorTextVal = obj_companiesPage.VerifyBSEArrowColorTextVal();
			
			if(isVerifyBSEArrowColorTextVal)
				cmr.generateExecutionReport(printWrite, "Verify if BSE text in red color have down arrow and green color text have UP arrow.", "BSE text in red color have down arrow and green color text have UP arrow.", "BSE text in red color have down arrow and green color text have UP arrow.", true, null);
			else {
				isVerificationPassed= false;
				cmr.generateExecutionReport(printWrite, "Verify if BSE text in red color have down arrow and green color text have UP arrow.", "BSE text in red color have down arrow and green color text have UP arrow.", "BSE text in red color does not have down arrow and green color text have UP arrow.", false, fLib.captureScreenshot());
			}
			
			LoggerInstance.logger.info("Verify NSE Text red color have down arrow and green color text have up arrow.");
			//Verify NSE Text red color have down arrow and green color text have up arrow
			boolean isVerifyNSEArrowColorTextVal = obj_companiesPage.VerifyNSEArrowColorTextVal();
			
			if(isVerifyNSEArrowColorTextVal)
				cmr.generateExecutionReport(printWrite, "Verify if NSE text in red color have down arrow and green color have UP arrow", "NSE text in red color have down arrow and green color have UP arrow", "NSE text in red color have down arrow and green color have UP arrow", true, null);
			else {
				isVerificationPassed= false;
				cmr.generateExecutionReport(printWrite, "Verify if NSE text in red color have down arrow and green color have UP arrow", "NSE text in red color have down arrow and green color have UP arrow", "NSE text in red color does not have down arrow and green color have UP arrow", false, fLib.captureScreenshot());
			}
			
			//Verify Image is right displayed to text
			LoggerInstance.logger.info(" Image is right displayed to Text Value.");
			boolean isVerifyImageRightTextIsDisplayed = obj_companiesPage.verifyImageRightTextIsDisplayed();
			
			if(isVerifyImageRightTextIsDisplayed)
				cmr.generateExecutionReport(printWrite, "Verify if Image is right displayed to text.", "Image is right displayed to text.", "Image is right displayed to text.", true, null);
			else {
				isVerificationPassed= false;
				cmr.generateExecutionReport(printWrite, "Verify if Image is right displayed to text.", "Image is right displayed to text.", "Image is not right displayed to text.", false, fLib.captureScreenshot());
			}
			
			//Verify Image is left displayed to text
			LoggerInstance.logger.info(" Image is Left displayed to Text Value.");
			boolean isVerifyImageLeftTextIsDisplayed = obj_companiesPage.verifyImageLeftTextIsDisplayed();
			if(isVerifyImageLeftTextIsDisplayed)
				cmr.generateExecutionReport(printWrite, "Verify if Image is Left displayed to text.", "Image is Left displayed to text displayed.", "Image is Left displayed to text displayed.", true, null);
			else {
				isVerificationPassed= false;
				cmr.generateExecutionReport(printWrite, "Verify if Image is Left displayed to text.", "Image is Left displayed to text displayed.", "Image is not Left displayed to text displayed.", false, fLib.captureScreenshot());
			}
			
			//Verify Pagination occurs or not
			LoggerInstance.logger.info("Verify Pagination is Displayed.");
			boolean isVerifyPaginationdisplayed = obj_companiesPage.verifyPaginationdisplayed();
			if(isVerifyPaginationdisplayed)
				cmr.generateExecutionReport(printWrite, "Verify if Pagination is displayed.", "Pagination is displayed.", "Pagination is displayed.", true, null);
			else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Pagination is displayed.", "Pagination is displayed.", "Pagination is not displayed.", false, fLib.captureScreenshot());
			}
			//Verify Pagination Clicking on Next and Previous button
			LoggerInstance.logger.info("Verify Previous and Next Button are Present and Clickable.");
			boolean isVerifyClickingNextPreviousDislayedPage = obj_companiesPage.verifyClickingNextPreviousDislayedPage();
			
			if(isVerifyClickingNextPreviousDislayedPage)
				cmr.generateExecutionReport(printWrite, "Verify if Previous and Next buttons are present.", "Previous and Next buttons are present.", "Previous and Next buttons are displayed.", true, null);
			else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Previous and Next buttons are present.", "Previous and Next buttons are present.", "Previous and Next buttons are not displayed.", false, fLib.captureScreenshot());
			}
			
			
			if(!isVerificationPassed){
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
			
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("Exception occured.");		
			}
			
			LoggerInstance.logger.info("*********************Companies_VerifyNavigationOnCompaniesSubtab() Ended***************************");
		}
		
		
		// This method will be run after each method present in testcase file& will close the all browser windows.
		@AfterMethod
		public void tearDown() throws Exception {
			driver.close();
			driver.quit();
			cmr.endHtmlPage(printWrite);
			printWrite.flush();
			LoggerInstance.logger.info("Browser closed");
		}

	
}
