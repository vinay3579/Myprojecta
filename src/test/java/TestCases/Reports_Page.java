package TestCases;

/* Description: Verification of ReportsPage.
 * Created By: Sunny Jain
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
import PageObjects.ReportsPage;
import Reports.CustomMethodReport;


public class Reports_Page {
	
	private ReportsPage obj_reportPage;
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
	
	//Scenario 1:This test case will navigate to Research Reports menu of reports tab & will verify the different tabs,click on the report and verify the title of report opened in new window.
	@Test
	public void Reports_ResearchReports_VerifyReportsPage() throws Exception{
		
		try{
		
		LoggerInstance.logger.info("***********************Reports_ResearchReports_VerifyReportsPage() Started*********************************");
		
		// Initialize Page Factory For Reports Page
		obj_reportPage = PageFactory.initElements(driver, ReportsPage.class);
		
		// Click on Research Reports Sub Tab
		LoggerInstance.logger.info("Navigate to Research reports page.");
		obj_reportPage.clickOnResearchReportstab();
		
		//Verify the title of the page.
		LoggerInstance.logger.info("Verify user is navigated to Research reports page.");
		boolean isVerifyTitle = obj_reportPage.verifyTitle(driver);
		if(isVerifyTitle){
			cmr.generateExecutionReport(printWrite, "Verify if user is navigaed to Research Reports Page.", "User is navigaed to Research Reports Page.", "User is navigated to Research Reports Page.", true, null);
		}else {
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if user is navigaed to Research Reports Page.", "User is navigaed to Research Reports Page.", "User is not navigated to Research Reports Page.", false, fLib.captureScreenshot());
		}
		// Verify the reports tab is displayed.
		LoggerInstance.logger.info("Verify All reports tab is displayed.");
		
		boolean isVerifyAllReportsTabIsDisplayed= obj_reportPage.verifyAllReportsTabIsDisplayed(driver);
		if(isVerifyAllReportsTabIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if All Reports tab is displayed.", "All Reports tab is displayed.", "All Reports tab is displayed.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if All Reports tab is displayed.", "All Reports tab is displayed.", "All Reports tab is not displayed.", false, fLib.captureScreenshot());
		}
		
		// Verify the premium tab is displayed.
		LoggerInstance.logger.info("Verify premium tab is displayed.");
		boolean isVerifyPremiumTabIsDisplayed =obj_reportPage.verifyPremiumTabIsDisplayed(driver);
		
		if(isVerifyPremiumTabIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if Premium Tab is displayed.", "Premium Tab is displayed.", "Premium Tab is displayed.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Premium Tab is displayed.", "Premium Tab is displayed.", "Premium Tab is not displayed.", false, fLib.captureScreenshot());
		}
		
		// Verify the latest tab is displayed.
		LoggerInstance.logger.info("Verify latest tab is displayed.");
		boolean isVerifyLatestTabIsDisplayed = obj_reportPage.verifyLatestTabIsDisplayed(driver);
		
		if(isVerifyLatestTabIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if Latest tab is displayed.", "Latest tab is displayed.", "Latest tab is displayed.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Latest tab is displayed.", "Latest tab is displayed.", "Latest tab is not displayed.", false, fLib.captureScreenshot());
		}
		
		// Verify the most viewed tab is displayed.
		LoggerInstance.logger.info("Verify Most viewed tab is displayed.");
		
		boolean isVerifyMostViewedTabIsDisplayed = obj_reportPage.verifyMostViewedTabIsDisplayed(driver);
		if(isVerifyMostViewedTabIsDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if Most Viewed Tab is displayed.", "Most Viewed Tab is displayed.", "Most Viewed Tab is displayed.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Most Viewed Tab is displayed.", "Most Viewed Tab is displayed.", "Most Viewed Tab is not displayed.", false, fLib.captureScreenshot());
		}
		
		// Click on the first report.
		LoggerInstance.logger.info("Click on the first report link");
		obj_reportPage.clickOnReportLink(driver);
		
		
		
		// Switch to the newly opened window
		LoggerInstance.logger.info("Switch to new window");
		obj_reportPage.switchOfNewWindow();
		
		// Verify the title of report opened in new window.
		LoggerInstance.logger.info("Verify the title of new window");
		boolean isVerifyNewWindowTitle = obj_reportPage.verifyNewWindowTitle(driver);
		if(isVerifyNewWindowTitle){
			cmr.generateExecutionReport(printWrite, "Verify the title of new window.", "Title of the new window is matched.","Title of the new window is matched.", true, null);
		} else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify the title of new window.", "Title of the new window is matched.","Title of the new window is matched.", false, fLib.captureScreenshot());
		}
		LoggerInstance.logger.info("***********************Reports_ResearchReports_VerifyReportsPage() Ended*********************************");
		if(!isVerificationPassed){
			isVerificationPassed=true;
			org.testng.Assert.fail();
		}
	} catch (Exception e) {
		LoggerInstance.logger.info("Exception occured.");
		e.printStackTrace();
	} finally {
		obj_reportPage = null;
		if(!isVerificationPassed){
			isVerificationPassed=true;
			org.testng.Assert.fail();
		}
	}
}
	
	// Scenario 2 :This test case will navigate to Daily Wrap menu of reports tab & will verify the tables , tables columns and click on the any date and will verify the same on the newly opened window.
	@Test
	public void Reports_DailyWrap_VerifyDailyWrapPage()
	{
	try
	{
		LoggerInstance.logger.info("***********************Reports_DailyWrap_VerifyDailyWrapPage() Started*********************************");	
		
		// Initialize Page Factory For Reports Page
		obj_reportPage = PageFactory.initElements(driver, ReportsPage.class);
		
		// Verify the page is displayed or not.
		LoggerInstance.logger.info("Verify Daily Market WrapPage Is displayed.");
		boolean isVerifyDailyMarketWrapPageIsdisplayed =obj_reportPage.VerifyDailyMarketWrapPageIsdisplayed();
		if(isVerifyDailyMarketWrapPageIsdisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if Daily Market Wrap Page is displayed.", "Daily Market Wrap Page is displayed.", "Daily Market Wrap Page is displayed.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Daily Market Wrap Page is displayed.", "Daily Market Wrap Page is displayed.", "Daily Market Wrap Page is not displayed.", false, fLib.captureScreenshot());
		}
		// Verify the cnx table is displayed .
		LoggerInstance.logger.info("Verify CNX Table Is  displayed on Daily Market WrapPage Page.");
		
		boolean isVerifyCNXTableIsdisplayed = obj_reportPage.VerifyCNXTableIsdisplayed();
		if(isVerifyCNXTableIsdisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if CNX table is displayed on Daily Market WrapPage page.", "CNX table is displayed on Daily Market WrapPage page.", "CNX table is displayed on Daily Market WrapPage page.", true, null);
		else{
			isVerificationPassed= false;
			cmr.generateExecutionReport(printWrite, "Verify if CNX table is displayed on Daily Market WrapPage page.", "CNX table is displayed on Daily Market WrapPage page.", "CNX table is not displayed on Daily Market WrapPage page.", false, fLib.captureScreenshot());
		}
		//Verify the BSE sensex table is displayed.
		LoggerInstance.logger.info("Verify BSE Sensex Table Is  displayed on Daily Market WrapPage Page.");
		boolean isVerifyBSESensexTableIsdisplayed = obj_reportPage.VerifyBSESensexTableIsdisplayed();
		if(isVerifyBSESensexTableIsdisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if BSE sensex table is displayed on Daily Market Wrap Page.", "BSE sensex table is displayed on Daily Market Wrap Page.", "BSE sensex table is displayed on Daily Market Wrap Page.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if BSE sensex table is displayed on Daily Market Wrap Page.", "BSE sensex table is displayed on Daily Market Wrap Page.", "BSE sensex table is not displayed on Daily Market Wrap Page.", false, fLib.captureScreenshot());
		}
		
		//Verify The CNX Table date
     	LoggerInstance.logger.info("Verify that CNX Table contains Last Three Dates.");
     	boolean isVerifyCNXEffectiveDateDisplayed = obj_reportPage.VerifyCNXEffectiveDateDisplayed();
     	if(isVerifyCNXEffectiveDateDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if CNX table contains last three dates.", "CNX table contains last three dates.", "CNX table contains last three dates.", true, null);
		else{
			isVerificationPassed= false;
			cmr.generateExecutionReport(printWrite, "Verify if CNX table contains last three dates.", "CNX table contains last three dates.", "CNX table does not contain last three dates.", false, fLib.captureScreenshot());
		}
		//Verify The BSE Sensex Table date
		LoggerInstance.logger.info("Verify that BSE SEnsex Table contains Last Three Dates.");
		boolean isVerifyBSESensexTableDateDisplayed =obj_reportPage.VerifyBSESensexTableDateDisplayed();
		if(isVerifyBSESensexTableDateDisplayed)
			cmr.generateExecutionReport(printWrite, "Verify if BSE sensex table contains last three dates.", "BSE sensex table contains last three dates.", "BSE sensex table contains last three dates.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if BSE sensex table contains last three dates.", "BSE sensex table contains last three dates.", "BSE sensex table does not contain last three dates.", false, fLib.captureScreenshot());
		}
		// Verify date and heading  daily wrap and scrap and heading
		LoggerInstance.logger.info("Verify that Daily Scrap  contains Heading and 10 colmun.");
		boolean isVerifyDailyWrapFrameContainsHeading = obj_reportPage.VerifyDailyWrapFrameContainsHeading();
		if(isVerifyDailyWrapFrameContainsHeading)
			cmr.generateExecutionReport(printWrite, "Verify if Daily Scrap contains heading and 10 column.", "Daily Scrap contains heading and 10 column.", "Daily Scrap contains heading and 10 column.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Daily Scrap contains heading and 10 column.", "Daily Scrap contains heading and 10 column.", "Daily Scrap does not contain heading and 10 column.", false, fLib.captureScreenshot());
		}
		// Verify date and heading  daily wrap and scrap and heading on new loaded page
		LoggerInstance.logger.info("Verify that Daily Scrap  contains Heading as on New Page.");
		boolean isVerifyDailyWrapDatePageHeading =obj_reportPage.VerifyDailyWrapDatePageHeading();
		if(isVerifyDailyWrapDatePageHeading)
			cmr.generateExecutionReport(printWrite, "Verify if Daily Scrap contains heading as on New Page.", "Daily Scrap contains heading as on New Page.", "Daily Scrap contains heading as on New Page.", true, null);
		else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Daily Scrap contains heading as on New Page.", "Daily Scrap contains heading as on New Page.", "Daily Scrap does not contain heading as on New Page.", false, fLib.captureScreenshot());
		}
		LoggerInstance.logger.info("***********************Reports_DailyWrap_VerifyDailyWrapPage()Ended*********************************");	
		if(!isVerificationPassed){
			isVerificationPassed=true;
			org.testng.Assert.fail();
		}
	} catch (Exception e) {
		LoggerInstance.logger.info("Exception occured.");
		e.printStackTrace();
	} finally {
		obj_reportPage = null;
		if(!isVerificationPassed){
			isVerificationPassed=true;
			org.testng.Assert.fail();
		}
	}	
		
	}
	
	// // Scenario 3 :This test case will verify Report Page .

	@Test
	public void verifyweeklywraplink() throws Exception {
		
		String url = null;
		try {
			LoggerInstance.logger.info("***********************Report Tab Scenario Started*********************************");
			obj_reportPage = PageFactory.initElements(driver, ReportsPage.class);
			//verifying weekly wrap link
			LoggerInstance.logger.info("verifying weekly wrap link");
			boolean isVerifyweeklyWraplink = obj_reportPage.verifyweeklyWraplink();	
			if(isVerifyweeklyWraplink) {
				cmr.generateExecutionReport(printWrite, "Verify if Weekly wrap link is available.", "Weekly wrap link is available.", "Weekly wrap link is available.", true, null);
			} else {
				isVerificationPassed= false;
				cmr.generateExecutionReport(printWrite, "Verify if Weekly wrap link is available.", "Weekly wrap link is available.", "Weekly wrap link is not available.", false, fLib.captureScreenshot());
			}
			
			//Verifying tables present on report tab
			LoggerInstance.logger.info("Verifying tables present on report tab");
			boolean isVerify_table_headers = obj_reportPage.verify_table_headers();
			if(isVerify_table_headers) {
				cmr.generateExecutionReport(printWrite, "Verify if tables are present on report tab.", "tables are present on report tab.", "tables are present on report tab.", true, null);
			}else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if tables are present on report tab.", "tables are present on report tab.", "tables are not present on report tab.", false, fLib.captureScreenshot());
			}
			//navigating back to weekly wrap link
			LoggerInstance.logger.info("navigating back to weekly wrap link");
			obj_reportPage.clickOnweeklyWraplink();		
			//verifying RHP tables of report tab
			LoggerInstance.logger.info("verifying RHP tables of report tab");
			boolean isVerify_right_hand_tables = obj_reportPage.verify_right_hand_tables();
			if(isVerify_right_hand_tables) {
				cmr.generateExecutionReport(printWrite, "Verify if RHP table is present on report tab.", "RHP table is present on report tab.", "RHP table is present on report tab.", true, null);
			} else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if RHP table is present on report tab.", "RHP table is present on report tab.", "RHP table is not present on report tab.", false, fLib.captureScreenshot());
			}
			//navigating back to weekly wrap link
			LoggerInstance.logger.info("navigating back to weekly wrap link");
			obj_reportPage.clickOnweeklyWraplink();		
			//verifying index link it navigates to market today page
			LoggerInstance.logger.info("verifying index link it navigates to market today page");
			boolean isVerify_index_link_navigates_marketToday_page = obj_reportPage.verify_index_link_navigates_marketToday_page();
			if(isVerify_index_link_navigates_marketToday_page){	
				cmr.generateExecutionReport(printWrite, "Verify if Index link is available that navigates to market today.", "Index link is available that navigates to market today.", "Index link is available that navigates to market today.", true, null);
			} else {
				isVerificationPassed=false;
				cmr.generateExecutionReport(printWrite, "Verify if Index link is available that navigates to market today.", "Index link is available that navigates to market today.", "Index link is not available that navigates to market today.", false, fLib.captureScreenshot());
			}
			
			LoggerInstance.logger.info("***********************Report Tab Scenario Finished*********************************");
			
			if(!isVerificationPassed){
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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



