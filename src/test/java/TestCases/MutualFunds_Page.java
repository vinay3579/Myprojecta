package TestCases;

/* Description: Verification of Mutual Funds Page.
 * Created By: Darwin Bhandari
 * Created Date: 19 Aug 2014
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
import PageObjects.MutualFundsPage;
import Reports.CustomMethodReport;

public class MutualFunds_Page {

	private MutualFundsPage obj_mutualfundspage;
	static WebDriver driver;

	Properties prop = new Properties();
	CustomMethodReport cmr = new CustomMethodReport();
	FunctionLibrary fLib = new FunctionLibrary();
	PrintWriter printWrite = null;
	boolean isVerificationPassed= true;
	
	// This method would be run before each method present in testcase file & will launch browser & will open application.
	//parameter method will extract the method name which would be running
	
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
	
	//Scenario 1: Verify text for Mutual Funds tool-tip and that user is able to navigate to all sub-tabs
	
	@Test()
	public void MutualFunds_VerifyTextAndNavigation() {
		try {
			LoggerInstance.logger.info("*************MutualFunds_VerifyTextAndNavigation() Started**************");
		
		// Initialize Page Factory For MutualFunds Page
			obj_mutualfundspage = PageFactory.initElements(driver,MutualFundsPage.class);
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
				
		// Verify that text is displayed correctly
		LoggerInstance.logger.info("Verify that text is displayed correctly");
		boolean isVerifyTextMF = obj_mutualfundspage.verifyTextMF();
		
		if(isVerifyTextMF){
			cmr.generateExecutionReport(printWrite, "Verify that On right of subtabs, text is displayed", "On right of subtabs, text is displayed.", "On right of subtabs, text is displayed", true, null);
		}else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify that On right of subtabs, text is displayed", "On right of subtabs, text is displayed.", "On right of subtabs, text is not displayed", false, fLib.captureScreenshot());
		}
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on Funds House item
		LoggerInstance.logger.info("Click on Funds House item");
		obj_mutualfundspage.clickOnFundHouses();
		
		// Verify Funds House page is opened
		LoggerInstance.logger.info("Verify Funds House page is opened");
		boolean isVerifyFundHousesNavigation=obj_mutualfundspage.verifyFundHousesNavigation(driver);
		if(isVerifyFundHousesNavigation){
			cmr.generateExecutionReport(printWrite, "Verify if Funds House Page is opened.", "Funds House Page is opened.", "Funds House Page is opened.", true, null);
		}else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Funds House Page is opened.", "Funds House Page is opened.", "Funds House Page is not opened.", true, fLib.captureScreenshot());
		}
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on Funds item
		LoggerInstance.logger.info("Click on Funds item");
		obj_mutualfundspage.clickOnFunds();
		
		// Verify Funds page is opened
		LoggerInstance.logger.info("Verify Funds page is opened");
		boolean isVerifyFundsNavigation =obj_mutualfundspage.verifyFundsNavigation();
		if(isVerifyFundsNavigation){
			cmr.generateExecutionReport(printWrite, "Verify if Funds Page is opened.", "Funds Page is opened.", "Funds Page is opened.", true, null);
		}else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Funds Page is opened.", "Funds Page is opened.", "Funds Page is not opened.", false, fLib.captureScreenshot());
		}
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on Funds Screener item
		LoggerInstance.logger.info("Click on Funds Screener item");
		obj_mutualfundspage.clickOnFundScreener();
		
		// Verify Funds Screener page is opened
		LoggerInstance.logger.info("Verify Funds Screener page is opened");
		boolean isVerifyFundScreenerNavigation = obj_mutualfundspage.verifyFundScreenerNavigation();
		if(isVerifyFundScreenerNavigation){
			cmr.generateExecutionReport(printWrite, "Verify if Funds screener page is opened.", "Funds Screener page is opened.", "Funds screener page is opened.", true, null);
		}else {
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Funds screener page is opened.", "Funds Screener page is opened.", "Funds screener page is not opened.", false, fLib.captureScreenshot());
		}
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on Portfolio Churning item
		LoggerInstance.logger.info("Click on Portfolio Churning item");
		obj_mutualfundspage.clickOnPortChur();
		
		// Verify Portfolio Churning page is opened
		LoggerInstance.logger.info("Verify Portfolio Churning page is opened");
		boolean isVerifyPortChurNavigation = obj_mutualfundspage.verifyPortChurNavigation();
		if(isVerifyPortChurNavigation){
			cmr.generateExecutionReport(printWrite, "Verify if Portfolio Churning page is opened.", "Portfolio Churning Page is opened.", "Portfolio Churning page is opened.", true, null);
		}else {
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Portfolio Churning page is opened.", "Portfolio Churning Page is opened.", "Portfolio Churning page is not opened.", false, fLib.captureScreenshot());
		}
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on Compare Funds item
		LoggerInstance.logger.info("Click on Compare Funds item");
		obj_mutualfundspage.clickOnCompareFunds(driver);
		
		// Verify Compare Funds page is opened
		LoggerInstance.logger.info("Verify Compare Funds page is opened");
		boolean isVerifyCompFundsNavigation =obj_mutualfundspage.verifyCompFundsNavigation();
		
		if(isVerifyCompFundsNavigation){
			cmr.generateExecutionReport(printWrite, "Verify if Compare Funds page is opened.", "Compare Funds page is opened.", "Compare Funds page is opened.", true, null);
		} else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Compare Funds page is opened.", "Compare Funds page is opened.", "Compare Funds page is not opened.", false, fLib.captureScreenshot());
		}
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on Monthly Score Card item
		LoggerInstance.logger.info("Click on Monthly Score Card item");
		obj_mutualfundspage.clickOnMonthlySCard(driver);
		
		// Verify Monthly Score card page is opened
		LoggerInstance.logger.info("Verify Monthly Score card page is opened");
		boolean isVerifyMSCNavigation = obj_mutualfundspage.verifyMSCNavigation();
		if(isVerifyMSCNavigation){
			cmr.generateExecutionReport(printWrite, "Verify if Monthly Score card page is opened.", "Monthly Score card page is opened.", "Monthly score card page is opened.", true, null);
		}else {
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Monthly Score card page is opened.", "Monthly Score card page is opened.", "Monthly score card page is not opened.", false, fLib.captureScreenshot());
		}
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Click on New Fund Offers item
		LoggerInstance.logger.info("Click on New Fund Offers item");
		obj_mutualfundspage.clickOnNewFOffers();
		
		// Verify New Fund Offers page is opened
		LoggerInstance.logger.info("Verify New Fund Offers page is opened");
		boolean isVerifyNFONavigation = obj_mutualfundspage.verifyNFONavigation();
		if(isVerifyNFONavigation){
			cmr.generateExecutionReport(printWrite, "Verify if New Fund Offers Page is opened.", "New Fund Offers Page is opened.", "New Fund Offers Page is opened.", true, null);
		}else{
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if New Fund Offers Page is opened.", "New Fund Offers Page is opened.", "New Fund Offers Page is opened.", false, fLib.captureScreenshot());
		}
			
		LoggerInstance.logger.info("***********MutualFunds_VerifyTextAndNavigation() Ended**************");
		
		if(!isVerificationPassed){
			isVerificationPassed=true;
			org.testng.Assert.fail();
		}
		
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			obj_mutualfundspage = null;
			if(!isVerificationPassed){
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
		}	
	}	
	
	
	//Scenario 2: This test case will navigate to  Monthly Score Card page and verify color and value
	
@Test
public void MutualFunds_MonthScoreCard_VerifyColorAndValue() {
	try {
		LoggerInstance.logger.info("**************MutualFunds_MonthScoreCard_VerifyColorAndValue() Started**************");
	
	// Initialize Page Factory For MutualFunds Page
		obj_mutualfundspage = PageFactory.initElements(driver,MutualFundsPage.class);
	
	// Hover mouse over Mutual Funds tab
	LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
	obj_mutualfundspage.hoverMouse();
	
	// Click on Monthly Score card item
	LoggerInstance.logger.info("Click on Monthly Score card item");
	obj_mutualfundspage.clickOnMonthlySCard(driver);
	
	// Verify Top 5 Fund Houses in terms of Corpus (displayed in BLUE)
	LoggerInstance.logger.info("Verify Top 5 Fund Houses in terms of Corpus (displayed in BLUE)");
	boolean isVerifyCorpusColour =obj_mutualfundspage.verifyCorpusColour(driver);
	
	if(isVerifyCorpusColour){
		cmr.generateExecutionReport(printWrite, "Verify if Top 5 Fund Houses in terms of Corpus are displayed in BLUE.", "Top 5 Fund Houses in terms of Corpus are displayed in BLUE.", "Top 5 Fund Houses in terms of Corpus are displayed in BLUE.", true, null);
	}else {
		isVerificationPassed=false;
		cmr.generateExecutionReport(printWrite, "Verify if Top 5 Fund Houses in terms of Corpus are displayed in BLUE.", "Top 5 Fund Houses in terms of Corpus are displayed in BLUE.", "Top 5 Fund Houses in terms of Corpus are not displayed in BLUE.", false, fLib.captureScreenshot());
	}
	
	// Verify Top 5 Fund Houses Gainers on Corpus basis(displayed in GREEN)
	LoggerInstance.logger.info("Verify Top 5 Fund Houses Gainers on Corpus basis(displayed in GREEN)");
	boolean isVerifyCorpusGainersColour = obj_mutualfundspage.verifyCorpusGainersColour();
	if(isVerifyCorpusGainersColour){
		cmr.generateExecutionReport(printWrite, "Verify if Top 5 Fund Houses Gainers on Corpus bases are displayed in GREEN.", "Top 5 Fund Houses Gainers on Corpus bases are displayed in GREEN.", "Top 5 Fund Houses Gainers on Corpus bases are displayed in GREEN.", true, null);
	}else {
		isVerificationPassed=false;
		cmr.generateExecutionReport(printWrite, "Verify if Top 5 Fund Houses Gainers on Corpus bases are displayed in GREEN.", "Top 5 Fund Houses Gainers on Corpus bases are displayed in GREEN.", "Top 5 Fund Houses Gainers on Corpus bases are not displayed in GREEN.", false, fLib.captureScreenshot());
	}
	// Verify Top 5 Fund Houses Losers on Corpus basis(displayed in RED)
	LoggerInstance.logger.info("Verify Top 5 Fund Houses Losers on Corpus basis(displayed in RED)");
	boolean isVerifyCorpusLosersColour = obj_mutualfundspage.verifyCorpusLosersColour();
	if(isVerifyCorpusLosersColour){
		cmr.generateExecutionReport(printWrite, "Verify if Top 5 Fund Houses Losers on Corpus Bases are displayed in RED.", "Top 5 Fund Houses Losers on Corpus Bases are displayed in RED.", "Top 5 Fund Houses Losers on Corpus Bases are displayed in RED.", true, null);
	}else {
		isVerificationPassed=false;
		cmr.generateExecutionReport(printWrite, "Verify if Top 5 Fund Houses Losers on Corpus Bases are displayed in RED.", "Top 5 Fund Houses Losers on Corpus Bases are displayed in RED.", "Top 5 Fund Houses Losers on Corpus Bases are not displayed in RED.", false, fLib.captureScreenshot());
	}
	// Verify Top 5 NAV (%) Gainers (displayed in GREEN)
	LoggerInstance.logger.info("Verify Top 5 NAV (%) Gainers (displayed in GREEN)");
	boolean isVerifyNAVGainersColour = obj_mutualfundspage.verifyNAVGainersColour();
	if(isVerifyNAVGainersColour) {
		cmr.generateExecutionReport(printWrite, "Verify if Top 5 NAV (%) Gainers are displayed in GREEN.", "Top 5 NAV (%) Gainers are displayed in GREEN.", "Top 5 NAV (%) Gainers are displayed in GREEN.", true, null);
	} else{
		isVerificationPassed=false;
		cmr.generateExecutionReport(printWrite, "Verify if Top 5 NAV (%) Gainers are displayed in GREEN.", "Top 5 NAV (%) Gainers are displayed in GREEN.", "Top 5 NAV (%) Gainers are not displayed in GREEN.", false, fLib.captureScreenshot());
	}
	
	// Verify Top 5 NAV (%) Losers tables (displayed in RED)
	LoggerInstance.logger.info("Verify Top 5 NAV (%) Losers tables (displayed in RED)");
	boolean isVerifyNAVLosersColour = obj_mutualfundspage.verifyNAVLosersColour();
	if(isVerifyNAVLosersColour){
		cmr.generateExecutionReport(printWrite, "Verify if Top 5 NAV (%) Losers are displayed in RED.", "Top 5 NAV (%) Losers are displayed in RED.", "Top 5 NAV (%) Losers are displayed in RED.", true, null);
	}else{
		isVerificationPassed=false;
		cmr.generateExecutionReport(printWrite, "Verify if Top 5 NAV (%) Losers are displayed in RED.", "Top 5 NAV (%) Losers are displayed in RED.", "Top 5 NAV (%) Losers are displayed in RED.", false, fLib.captureScreenshot());
	}
	// Verify same Corpus Amount is displayed on page for first record of "Top 5 Fund Houses Gainers on Corpus basis
	LoggerInstance.logger.info("Verify same Corpus Amount is displayed on page for first record of Top 5 Fund Houses Gainers on Corpus basis");
	boolean isVerifyValueCorpusGainers = obj_mutualfundspage.verifyValueCorpusGainers();
	if(isVerifyValueCorpusGainers){
		cmr.generateExecutionReport(printWrite, "Verify if same Corpus Amount is displayed on page for first record of Top 5 Fund Houses Gainsers on Corpus basis.", "same Corpus Amount is displayed on page for first record of Top 5 Fund Houses Gainsers on Corpus basis.", "same Corpus Amount is displayed on page for first record of Top 5 Fund Houses Gainsers on Corpus basis.", true, null);
	} else {
		isVerificationPassed=false;
		cmr.generateExecutionReport(printWrite, "Verify if same Corpus Amount is displayed on page for first record of Top 5 Fund Houses Gainsers on Corpus basis.", "same Corpus Amount is displayed on page for first record of Top 5 Fund Houses Gainsers on Corpus basis.", "same Corpus Amount is not displayed on page for first record of Top 5 Fund Houses Gainsers on Corpus basis.", false, fLib.captureScreenshot());
	}
	// Hover mouse over Mutual Funds tab
	LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
	obj_mutualfundspage.hoverMouse();
	
	// Click on Monthly Score card page
	LoggerInstance.logger.info("Click on Monthly Score card page");
	obj_mutualfundspage.clickOnMonthlySCard(driver);
	
	// Verify same Corpus Amount is displayed on page for first record of "Top 5 Fund Houses Losers on Corpus basis
	LoggerInstance.logger.info("Verify same Corpus Amount is displayed on page for first record of Top 5 Fund Houses Losers on Corpus basis");
	boolean isVerifyValueCorpusLosers =obj_mutualfundspage.verifyValueCorpusLosers(driver);
	if(isVerifyValueCorpusLosers){
		cmr.generateExecutionReport(printWrite, "Verify if same corpus amount is displayed on page for first record of top 5 fund houses losers on corpus bases.", "same corpus amount is displayed on page for first record of top 5 fund houses losers on corpus bases.", "same corpus amount is displayed on page for first record of top 5 fund houses losers on corpus bases.", true, null);
	}else {
		isVerificationPassed=false;
		cmr.generateExecutionReport(printWrite, "Verify if same corpus amount is displayed on page for first record of top 5 fund houses losers on corpus bases.", "same corpus amount is displayed on page for first record of top 5 fund houses losers on corpus bases.", "same corpus amount is not displayed on page for first record of top 5 fund houses losers on corpus bases.", false, fLib.captureScreenshot());
	}
	LoggerInstance.logger.info("***********MutualFunds_MonthScoreCard_VerifyColorAndValue() Ended**************");
	
	if(!isVerificationPassed) {
		isVerificationPassed=true;
		org.testng.Assert.fail();
	}
	
	} catch (Exception e) {
		LoggerInstance.logger.info("Exception occured.");
		e.printStackTrace();
	} finally {
		obj_mutualfundspage = null;
		if(!isVerificationPassed) {
			isVerificationPassed=true;
			org.testng.Assert.fail();
		}
	}	
}
	
	
	//Scenario 3: This test case will navigate to  Compare Funds page and verify text and graph

  @Test()
	public void MutualFunds_CompareFunds_VerifyTextAndGraph() throws Throwable  {
		try {
			LoggerInstance.logger.info("************MutualFunds_CompareFunds_VerifyTextAndGraph() Started**************");
		// Initialize Page Factory For MutualFunds Page
			obj_mutualfundspage = PageFactory.initElements(driver,MutualFundsPage.class);
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");
		obj_mutualfundspage.hoverMouse();
		
		// Hover mouse over Compare Funds item
		LoggerInstance.logger.info("Hover mouse over Compare Funds item");
		obj_mutualfundspage.hoverMouseCF();
		
		// Verify that expected text is displayed on Page
		LoggerInstance.logger.info("Verify that expected text is displayed on Page");
		boolean isVerifyTextCF =obj_mutualfundspage.verifyTextCF(driver);
		
		if(isVerifyTextCF){
			cmr.generateExecutionReport(printWrite, "Verify if expected text is displayed on page.", "Expected Text is displayed on page.", "Expected text is displayed on page.", true, null);
		}else {
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if expected text is displayed on page.", "Expected Text is displayed on page.", "Expected text is not displayed on page.", false, fLib.captureScreenshot());
		}
		
		// Hover mouse over Mutual Funds tab
		LoggerInstance.logger.info("Hover mouse over Mutual Funds tab");	
		obj_mutualfundspage.hoverMouse();
		
		// Click on Compare Funds item
		LoggerInstance.logger.info("Click on Compare Funds item");
		obj_mutualfundspage.clickOnCompareFunds(driver);
		
		// Verify Comparison Graph is displayed
		LoggerInstance.logger.info("Verify Comparison Graph is displayed");
		boolean isCompareFundsGraph =obj_mutualfundspage.compareFundsGraph(driver,"S&P AUTO", "S&P BANKEX");
		
		if(isCompareFundsGraph) {
			cmr.generateExecutionReport(printWrite, "Verify if Comparision Graph is displayed.", "Comparision Graph is displayed.", "Comparision Graph is displayed.", true, null);
		}else {
			isVerificationPassed=false;
			cmr.generateExecutionReport(printWrite, "Verify if Comparision Graph is displayed.", "Comparision Graph is displayed.", "Comparision Graph is not displayed.", false, fLib.captureScreenshot());
		}
		LoggerInstance.logger.info("************MutualFunds_CompareFunds_VerifyTextAndGraph() Ended**************");
		
		if(!isVerificationPassed) {
			isVerificationPassed=true;
			org.testng.Assert.fail();
		}
		
		} catch (Exception e) {
			LoggerInstance.logger.info("Exception occured.");
			e.printStackTrace();
		} finally {
			obj_mutualfundspage = null;
			if(!isVerificationPassed) {
				isVerificationPassed=true;
				org.testng.Assert.fail();
			}
		}	
	}	
	

	// This method will be run after each method present in test case file& will close the all browser windows.
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		LoggerInstance.logger.info("Browser closed");
		cmr.endHtmlPage(printWrite);
		printWrite.flush();
	}	
}

