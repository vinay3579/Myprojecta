package TestCases;

/* Description: Verification of IPO Page.
 * Created By: Kuldeep Singh
 * Created Date: 19 Aug 2014
 * */

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import FunctionLibraries.AutomationConstants;
import FunctionLibraries.FunctionLibrary;
import FunctionLibraries.WebDriverBrowser;
import Logger.LoggerInstance;
import PageObjects.IPOPage;
import Reports.CustomMethodReport;

public class IPO_Page {

	private IPOPage ipoPage;
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

		//Call this method to generate the html file
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

	
	// Scenario 1 :This test case will navigate to the forthcoming menu of the IPO tab & will verify the displayed columns & records.
	@Test
	public void IPO_Forthcoming_VerifyForthcomingTab() throws Exception {

		try {
			LoggerInstance.logger.info("***********************IPO_Forthcoming_VerifyForthcomingTab() Started*********************************");

			// Initialize Page Factory For IPO Page
			ipoPage = PageFactory.initElements(driver, IPOPage.class);

			// Click on Forthcoming IPO page Sub Tab
			LoggerInstance.logger.info("Click on Forthcoming IPO page Sub Tab.");
			ipoPage.clickForthcomingSubTab();

			// Verify that Forthcoming IPO Information Label is displayed
			LoggerInstance.logger.info("Verify Forthcoming tab Information.");
			boolean isVerifyForthcomingInfoLabel =ipoPage.verifyForthcomingInfoLabel();
			
			if(isVerifyForthcomingInfoLabel) {
				cmr.generateExecutionReport(printWrite, "Verify Forthcoming tab Information", "Forthcoming Tab is present.", "Forthcoming tab is present", true, null);
			} else {
				cmr.generateExecutionReport(printWrite, "Verify Forthcoming tab Information", "Forthcoming Tab is present.", "Forthcoming tab is not present", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			// Verify Information and Documents Tabs are displayed
			LoggerInstance.logger.info("Verify Information and Documents Tabs are displayed.");
			boolean isVerifyInformationAndDocumentsTabs = ipoPage.verifyInformationAndDocumentsTabs();
			
			if(isVerifyInformationAndDocumentsTabs)
				cmr.generateExecutionReport(printWrite, "Verify Information and Documents Tabs are displayed.", "Information and Documents tabs are displayed.", "Information and Documents tabs are displayed.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify Information and Documents Tabs are displayed.", "Information and Documents tabs are displayed.", "Information and Documents tabs are not displayed.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			// Verify Forthcoming Columns header
			LoggerInstance.logger.info("Verify Forthcoming Columns header.");
			boolean isVerifyColumnsHeaders= ipoPage.verifyColumnsHeaders();

			if(isVerifyColumnsHeaders)
				cmr.generateExecutionReport(printWrite, "Verify ForthComing Columns header.", "Columns are present.", "Columns are present.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify ForthComing Columns header.", "Columns are present.", "Columns are not displayed.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			// Verify Forthcoming tab Records
			LoggerInstance.logger.info("Verify Forthcoming tab Records.");
			boolean isVerifyForthcomingTabRecords = ipoPage.verifyForthcomingTabRecords();
			
			if(isVerifyForthcomingTabRecords)
				cmr.generateExecutionReport(printWrite, "Verify Forthcoming Tab Records.", "Forthcoming tab records are displayed.", "Forthcoming tab records are displayed.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify Forthcoming Tab Records.", "Forthcoming tab records are displayed.", "Forthcoming tab records are not displayed.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			// Verify Forthcoming Guided Search Section
			LoggerInstance.logger.info("Verify Forthcoming Guided Search Section.");
			boolean isVerifyGuidedSearchSection = ipoPage.verifyGuidedSearchSection();
			
			if(isVerifyGuidedSearchSection)
				cmr.generateExecutionReport(printWrite, "Verify Forthcoming Guide Search section.", "Forthcoming Guide Search Section is displayed.", "Forthcoming Guide Search Section is displayed.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify Forthcoming Guide Search section.", "Forthcoming Guide Search Section is not displayed.", "Forthcoming Guide Search Section is displayed.", true, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			LoggerInstance.logger.info("***********************IPO_Forthcoming_VerifyForthcomingTab() Ended*********************************");

			// to check whether all the test cases are passed. If any testcase from above fails
			// this will fail the overall status of testcase
			if(!isVerificationPassed) {
				isVerificationPassed = true;
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			ipoPage = null;
			if(!isVerificationPassed) {
				isVerificationPassed = true;
				org.testng.Assert.fail();
			}
		}
	}

	
	// Scenario 2: This test case will navigate to the calender menu of the IPO tab & will verify the displayed calender for companies, different sections displayed.
	@Test
	public void IPO_Calender_VerifyCalenderTab() throws Exception {
		try {
			LoggerInstance.logger.info("***********************IPO_Calender_VerifyCalenderTab() Started*********************************");

			// Initialize Page Factory For IPO Page
			ipoPage = PageFactory.initElements(driver, IPOPage.class);

			// Clicking on IPO tab
			ipoPage.clickOnIPOTab();

			// Verify that user should be navigated to IPO page - verify IPO page level
			LoggerInstance.logger.info("Verify user is navigated to IPO page.");
			boolean isVerifyIPOPageLevel = ipoPage.verifyIPOPageLevel();
			
			if(isVerifyIPOPageLevel)
				cmr.generateExecutionReport(printWrite, "Verify if user is navigated to IPO page.", "User is navigated to IPO page.", "User is navigated to IPO page.", true,null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify if user is navigated to IPO page.", "User is navigated to IPO page.", "User is not navigated to IPO page.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}

			// Verify that Calendar current month and year is displayed on the page - verify that calendar current month and year is displaying
			LoggerInstance.logger.info("Verify that Calendar current month and year is displayed on the IPO page.");
			boolean isVerifyCalendarCurrentMonthAndYearDisplay = ipoPage.verifyCalendarCurrentMonthAndYearDisplay();
			
			if(isVerifyCalendarCurrentMonthAndYearDisplay)
				cmr.generateExecutionReport(printWrite, "Verify if Calender current month and year is displayed on IPO page.", "Calender current month and year is displayed on IPO page.", "Calender current month and year is displayed on IPO page.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify if Calender current month and year is displayed on IPO page.", "Calender current month and year is displayed on IPO page.", "Calender current month and year is not displayed on IPO page.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			// Verify that IPO Microsite where Company Name is displayed as Label
			LoggerInstance.logger.info("Verify that IPO Microsite where Company Name is displayed as Label");
			boolean isVerifyCalendarCompanyies = ipoPage.verifyCalendarCompanyies();
			
			if(isVerifyCalendarCompanyies)
				cmr.generateExecutionReport(printWrite, "Verify if IPO Microsite where Company Name is displayed as Label", "IPO Microsite where Company Name is displayed as Label.", "IPO Microsite where Company Name is displayed as Label", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify if IPO Microsite where Company Name is displayed as Label", "IPO Microsite where Company Name is displayed as Label.", "IPO Microsite where Company Name is not displayed as Label", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			// Verify that On IPO Microsite Page sections displayed are as Overview, Issue details, Contact Information, IPO Managing Bodies, Documents Research Reports
			LoggerInstance.logger.info("Verify that On IPO Microsite Page sections displayed are as Overview, Issue details, Contact Information, IPO Managing Bodies, Documents Research Reports");
			boolean isVerifyIPOMicrositeTableHeader =ipoPage.verifyIPOMicrositeTableHeader();
			if(isVerifyIPOMicrositeTableHeader)
				cmr.generateExecutionReport(printWrite, "Verify if on IPO Microsite Page sections displayed are as Overview, Issue Details, Contact Information, IPO Managing Bodies, Documents Research Reports.", "IPO Microsite Page sections displayed are as Overview, Issue Details, Contact Information, IPO Managing Bodies, Documents Research Reports.", "IPO Microsite Page sections displayed are as Overview, Issue Details, Contact Information, IPO Managing Bodies, Documents Research Reports.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify if on IPO Microsite Page sections displayed are as Overview, Issue Details, Contact Information, IPO Managing Bodies, Documents Research Reports.", "IPO Microsite Page sections displayed are as Overview, Issue Details, Contact Information, IPO Managing Bodies, Documents Research Reports.", "IPO Microsite Page sections displayed are not as Overview, Issue Details, Contact Information, IPO Managing Bodies, Documents Research Reports.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			LoggerInstance.logger.info("***********************IPO_Calender_VerifyCalenderTab() Ended***********************************");
			// To check if all the test cases are passed. If any of the case is failed
			// Overall status of the testcase would be changed to fail
			if(!isVerificationPassed) {
				isVerificationPassed = true;
				org.testng.Assert.fail();
			}
			
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			ipoPage = null;
			if(!isVerificationPassed) {
				isVerificationPassed = true;
				org.testng.Assert.fail();
			}
		}
	}

	
	// Scenario 3 :This test case will navigate to IPO tab & will verify the displayed calender for current Month is displayed ,labels navigation buttons .
	@Test
	public void IPO_VerifyCalenderOnIPOPage() throws Exception { 

		try {
			LoggerInstance.logger.info("***********************IPO_VerifyCalenderOnIPOPage() Started*********************************");

			// Initialize Page Factory For IPO Page
			ipoPage = PageFactory.initElements(driver, IPOPage.class);

			// Clicking on IPO tab
			ipoPage.clickOnIPOTab();

			// Verify that user should be navigated to IPO page - verify IPO
			// page level
			LoggerInstance.logger.info("Verify user is navigated to IPO page.");
			boolean isVerifyIPOPageLevel = ipoPage.verifyIPOPageLevel();
			
			if(isVerifyIPOPageLevel)
				cmr.generateExecutionReport(printWrite, "Verify if user is navigated to IPO page.", "User is navigated to IPO page.", "User is navigated to IPO page.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify if user is navigated to IPO page.", "User is navigated to IPO page.", "User is not navigated to IPO page.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			// Verify that Calendar is displayed on the page - verify that
			// calendar days are displaying
			LoggerInstance.logger.info("Verify that Calendar is displayed on the IPO page.");
			boolean isVerifyCalendarDisplay = ipoPage.verifyCalendarDisplay();
			
			if(isVerifyCalendarDisplay)
				cmr.generateExecutionReport(printWrite, "Verify if Calender is displayed on IPO page.", "Calender is displayed on IPO page.", "Calender is displayed on IPO page.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify if Calender is displayed on IPO page.", "Calender is displayed on IPO page.", "Calender is not displayed on IPO page.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			// Verify that Calendar current month and year is displayed on the
			// page - verify that calendar current month and year is displaying
			LoggerInstance.logger.info("Verify that Calendar current month and year is displayed on the IPO page.");
			boolean isVerifyCalendarCurrentMonthAndYearDisplay = ipoPage.verifyCalendarCurrentMonthAndYearDisplay();
			
			if(isVerifyCalendarCurrentMonthAndYearDisplay)
				cmr.generateExecutionReport(printWrite, "Verify if Calender current month and year is displayed on the IPO page.", "Calender current month and year is displayed on the IPO page.", "Calender current month and year is displayed on the IPO page.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify if Calender current month and year is displayed on the IPO page.", "Calender current month and year is displayed on the IPO page.", "Calender current month and year is not displayed on the IPO page.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			// Verify that Calendar navigation is displayed on the right upper
			// side of Calendar - verify calendar navigation is displayed
			LoggerInstance.logger.info("Verify that Calendar navigation is displayed on the right upper side of Calendar.");
			boolean isVerifyCalendarNavigationDisplay = ipoPage.verifyCalendarNavigationDisplay();
			
			if(isVerifyCalendarNavigationDisplay)
				cmr.generateExecutionReport(printWrite, "Verify if Calender navigation is displayed on the right upper side of Calender.", "Calender navigation is displayed on the right upper side of Calender.", "Calender navigation is displayed on the right upper side of Calender.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify if Calender navigation is displayed on the right upper side of Calender.", "Calender navigation is displayed on the right upper side of Calender.", "Calender navigation is not displayed on the right upper side of Calender.", false, fLib.captureScreenshot());
				isVerificationPassed= false;
			}
			
			// Verify that (Green) Open,(Red) close, (Fellow)Upcoming,
			// (Blue)Listing is displayed - verify color code and text
			LoggerInstance.logger.info("Verify that (Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed.");
			boolean isVerifyCalendarColorAndText = ipoPage.verifyCalendarColorAndText();
			
			if(isVerifyCalendarColorAndText)
				cmr.generateExecutionReport(printWrite, "Verify if (Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed.", "(Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed.", "(Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify if (Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed.", "(Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed.", "(Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is not displayed.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			// Verify that Calendar navigation functionality is working or not -
			// verify calendar navigation functionality
			LoggerInstance.logger.info("Verify that Calendar navigation functionality is working or not.");
			boolean isVerifyCalendarNavigation = ipoPage.verifyCalendarNavigation();
			
			if(isVerifyCalendarNavigation)
				cmr.generateExecutionReport(printWrite, "Verify if Calendar navigation functionality is working or not.", "Calendar navigation functionality is working or not.", "Calendar navigation functionality is working or not.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify if Calendar navigation functionality is working or not.", "Calendar navigation functionality is working or not.", "Calendar navigation functionality is working or not.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			LoggerInstance.logger.info("***********************IPO_VerifyCalenderOnIPOPage() Ended*********************************");
			if(!isVerificationPassed) {
				isVerificationPassed = true;
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			ipoPage = null;
			if(!isVerificationPassed) {
				isVerificationPassed = true;
				org.testng.Assert.fail();
			}
		}
	}

	
	// Scenario 4 :This test case will navigate to Past menu of IPO tab & will verify the different tabs,columns & fields.
	@Test
	public void IPO_Past_VerifyCalenderTab() throws Exception {

		try {
			LoggerInstance.logger.info("***********************IPO_Past_VerifyCalenderTab() Started*********************************");

			// Initialize Page Factory For IPO Page
			ipoPage = PageFactory.initElements(driver, IPOPage.class);

			// Click on Past IPO page Sub Tab
			LoggerInstance.logger.info("Click on Forthcoming IPO page Sub Tab.");
			ipoPage.clickPastSubTab();

			// Verify that Past IPO Information Label is displayed
			LoggerInstance.logger.info("Verify Past IPO Information.");
			boolean isVerifyPastIPOInfoLabel = ipoPage.verifyPastIPOInfoLabel();
			
			if(isVerifyPastIPOInfoLabel)
				cmr.generateExecutionReport(printWrite, "Verify Past IPO Information.", "Past IPO Information is displayed.", "Past IPO Information is displayed.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify Past IPO Information.", "Past IPO Information is displayed.", "Past IPO Information is not displayed.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			
			// Verify Information and Documents Tabs are displayed
			LoggerInstance.logger.info("Verify Information and Documents Tabs are displayed.");
			boolean isVerifyInformationAndDocumentsTabsPastIPO =ipoPage.verifyInformationAndDocumentsTabsPastIPO();
			
			if(isVerifyInformationAndDocumentsTabsPastIPO)
				cmr.generateExecutionReport(printWrite, "Verify Information and Documents Tabs are displayed.", "Information and Documents Tabs are displayed.", "Information and Documents Tabs are displayed.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify Information and Documents Tabs are displayed.", "Information and Documents Tabs are displayed.", "Information and Documents Tabs are not displayed.", false, fLib.captureScreenshot());
				isVerificationPassed= false;
			}
			
			// Verify Past IPO Columns header
			LoggerInstance.logger.info("Verify Past IPO Columns header.");
			boolean isVerifyPastIPOTableHeader = ipoPage.verifyPastIPOTableHeader();
			
			if(isVerifyPastIPOTableHeader)
				cmr.generateExecutionReport(printWrite, "Verify Information and Documents Tabs are displayed.", "Information and Documents Tabs are displayed.", "Information and Documents Tabs are displayed.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify Information and Documents Tabs are displayed.", "Information and Documents Tabs are displayed.", "Information and Documents Tabs are not displayed.", false, fLib.captureScreenshot());
				isVerificationPassed= false;
			}
			
			// Verify Past tab Records and their order
			LoggerInstance.logger.info("Verify Past IPO tab Records and their order is in Descending.");
			boolean isVerifyPastIPOTabRecordsDecrendingOrder =ipoPage.verifyPastIPOTabRecordsDecrendingOrder();
			
			if(isVerifyPastIPOTabRecordsDecrendingOrder)
				cmr.generateExecutionReport(printWrite, "Verify Past IPO tab Records and their order is in Descending.", "Past IPO tab Records and their order is in Descending.", "Past IPO tab Records and their order is in Descending.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify Past IPO tab Records and their order is in Descending.", "Past IPO tab Records and their order is in Descending.", "Past IPO tab Records and their order is in Descending.", false, fLib.captureScreenshot());
				isVerificationPassed = false;
			}
			// Verify that Clicking on Close Date Column, records will be sorted
			// in Ascending Order
			LoggerInstance.logger.info("Verify after Clicking on Close Date Column, records will be sorted in Ascending Order.");
			boolean isVerifyPastIPOTabRecordsAscendingOrder =ipoPage.verifyPastIPOTabRecordsAscendingOrder();
			
			if(isVerifyPastIPOTabRecordsAscendingOrder)
				cmr.generateExecutionReport(printWrite, "Verify after Clicking on Close Date Column, records will be sorted in Ascending Order.", "After Clicking on Close Date Column, records will be sorted in Ascending Order.", "Verify after Clicking on Close Date Column, records will be sorted in Ascending Order.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify after Clicking on Close Date Column, records will be sorted in Ascending Order.", "After Clicking on Close Date Column, records will be sorted in Ascending Order.", "Verify after Clicking on Close Date Column, records will be sorted in Ascending Order.", true, fLib.captureScreenshot());
				isVerificationPassed= false;
			}
			
			// Verify Past Guided Search Section
			LoggerInstance.logger.info("Verify Past Guided Search Section.");
			boolean isVerifyGuidedSearchSection = ipoPage.verifyGuidedSearchSection();
			
			if(isVerifyGuidedSearchSection)
				cmr.generateExecutionReport(printWrite, "Verify Past Guided Search Section.", "Verify Past Guided Search Section.", "Past Guided Search Section.", true, fLib.captureScreenshot());
			else {
				cmr.generateExecutionReport(printWrite, "Verify Past Guided Search Section.", "Verify Past Guided Search Section.", "Past Guided Search Section.", false, fLib.captureScreenshot());
				isVerificationPassed= false;
			}
			
			// Verify that after entering Values into fields Close Date From and
			// To and click GO Button, records are displayed where Close date is
			// ranging between From and To dates
			LoggerInstance.logger.info("Verify that after entering Values into fields Close Date From and To and click GO Button, records are displayed where Close date is ranging between From and To dates.");
			boolean isVerifySearchCriteria =ipoPage.verifySearchCriteria();
			
			if(isVerifySearchCriteria)
				cmr.generateExecutionReport(printWrite, "Verify that after entering Values into fields Close Date From and To and click GO Button, records are displayed where Close date is ranging between From and To dates.", "After entering Values into fields Close Date From and To and click GO Button, records are displayed where Close date is ranging between From and To dates.", "after entering Values into fields Close Date From and To and click GO Button, records are displayed where Close date is ranging between From and To dates.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify that after entering Values into fields Close Date From and To and click GO Button, records are displayed where Close date is ranging between From and To dates.", "After entering Values into fields Close Date From and To and click GO Button, records are displayed where Close date is ranging between From and To dates.", "after entering Values into fields Close Date From and To and click GO Button, records are displayed where Close date is ranging between From and To dates.", true, fLib.captureScreenshot());
				isVerificationPassed= false;
			}
			
			// Verify that Under Company Column click on any record and user is
			// navigated to Company's details Page
			LoggerInstance.logger.info("Verify that Under Company Column click on any record and user is navigated to Company's details Page.");
			boolean isVerifyCompanyClickNevigation = ipoPage.verifyCompanyClickNevigation();
			
			if(isVerifyCompanyClickNevigation)
				cmr.generateExecutionReport(printWrite, "Verify that Under Company Column click on any record and user is navigated to Company's details Page.", "Under Company Column click on any record and user is navigated to Company's details Page.", "Under Company Column click on any record and user is navigated to Company's details Page.", true, null);
			else {
				cmr.generateExecutionReport(printWrite, "Verify that Under Company Column click on any record and user is navigated to Company's details Page.", "Under Company Column click on any record and user is navigated to Company's details Page.", "Under Company Column click on any record and user is not navigated to Company's details Page.", false, fLib.captureScreenshot());
				isVerificationPassed= false;
			}
			
			LoggerInstance.logger.info("***********************IPO_Past_VerifyCalenderTab() Ended*********************************");
			
			if(!isVerificationPassed) {
				isVerificationPassed = true;
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			ipoPage = null;
			if(!isVerificationPassed) {
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
		LoggerInstance.logger.info("Browser closed");
		cmr.endHtmlPage(printWrite);
		printWrite.flush();
	}

}
