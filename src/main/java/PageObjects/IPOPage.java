package PageObjects;

/* Description: IPO page object class
 * Created By: Kuldeep Singh
 * Created Date: 16 Aug 2014
 * */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;

public class IPOPage {

	final WebDriver driver;

	private final String csspath_IPOTab = "#menu-wrapper > ul > li:nth-child(4) > a";
	private final String csspath_IPOPageLabel = "#ctl00_BodyCPH_ipoCalendar_divCompany";
	private final String csspath_IPOPageCalDay_Sunday = ".fc-sun.ui-widget-header.fc-first";
	private final String csspath_IPOPageCalDay_Monday = ".fc-mon.ui-widget-header";
	private final String csspath_IPOPageCalDay_Tuesday = ".fc-tue.ui-widget-header";
	private final String csspath_IPOPageCalDay_Wednesday = ".fc-wed.ui-widget-header";
	private final String csspath_IPOPageCalDay_Thursday = ".fc-thu.ui-widget-header";
	private final String csspath_IPOPageCalDay_Friday = ".fc-fri.ui-widget-header";
	private final String csspath_IPOPageCalDay_Saturday = ".fc-sat.ui-widget-header.fc-last";
	private final String csspath_IPOPageCalCurrentMonthAndYear = ".fc-header-title>h2";
	private final String csspath_IPOPageCal_PreYear = "#calendar > table > tbody > tr > td.fc-header-right > span.fc-button.fc-button-prevYear.ui-state-default.ui-corner-left > span > span.fc-button-content > span > span";
	private final String csspath_IPOPageCal_PreMonth = "#calendar > table > tbody > tr > td.fc-header-right > span.fc-button.fc-button-prev.ui-state-default.ui-corner-right > span > span.fc-button-content > span > span";
	private final String csspath_IPOPageCal_Today = "#calendar > table > tbody > tr > td.fc-header-right > span.fc-button.fc-button-today.ui-state-default.ui-corner-left.ui-corner-right";
	private final String csspath_IPOPageCal_NextMonth = "#calendar > table > tbody > tr > td.fc-header-right > span.fc-button.fc-button-next.ui-state-default.ui-corner-left > span > span.fc-button-content > span > span";
	private final String csspath_IPOPageCal_NextYear = "#calendar > table > tbody > tr > td.fc-header-right > span.fc-button.fc-button-nextYear.ui-state-default.ui-corner-right > span > span.fc-button-content > span > span";
	private final String csspath_IPOPageOpen_Color = "#rhtBig > table > tbody > tr:nth-child(4) > td > div > div:nth-child(1) > div:nth-child(1)";
	private final String csspath_IPOPageClose_Color = "#rhtBig > table > tbody > tr:nth-child(4) > td > div > div:nth-child(1) > div:nth-child(3)";
	private final String csspath_IPOPageUpcoming_Color = "#rhtBig > table > tbody > tr:nth-child(4) > td > div > div:nth-child(1) > div:nth-child(5)";
	private final String csspath_IPOPageListing_Color = "#rhtBig > table > tbody > tr:nth-child(4) > td > div > div:nth-child(1) > div:nth-child(7)";
	private final String xpath_IPOPageOpen_Text = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/span[1]";
	private final String xpath_IPOPageClose_Text = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/span[2]";
	private final String xpath_IPOPageUpcoming_Text = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/span[3]";
	private final String xpath_IPOPageListing_Text = ".//*[@id='rhtBig']/table/tbody/tr[4]/td/div/div[1]/span[4]";
	private final String csspath_IPOCalDiv = "#calendar > div > div > div > div:nth-child(1) > div > span > a";
	private final String csspath_IPOCalMicrositeName = "#ctl00_BodyCPH_lblHeading";
	private final String csspath_IPOCalMicrositeTableHeader = ".bordered>thead>tr>th";
	
	private final String xpath_IPOCalMicrositeTableHeader_Overview = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/div[1]/table/tbody/tr[1]/td/table/thead/tr/th";
	private final String xpath_IPOCalMicrositeTableHeader_IssueDetails = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/div[1]/table/tbody/tr[3]/td/table/thead/tr/th";
	private final String xpath_IPOCalMicrositeTableHeader_ContactInformation = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/div[1]/table/tbody/tr[5]/td/table/thead/tr/th";
	private final String xpath_IPOCalMicrositeTableHeader_IPOManagingBodies = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/div[2]/table/tbody/tr[2]/td/table/thead/tr/th";
	private final String xpath_IPOCalMicrositeTableHeader_Documents = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/div[2]/table/tbody/tr[4]/td/table/thead/tr/th";
	private final String xpath_IPOCalMicrositeTableHeader_ResearchReports = ".//*[@id='aspnetForm']/div[5]/div/div[10]/table/tbody/tr[4]/td/div[2]/table/tbody/tr[6]/td/table/thead/tr/th";
	private final String csspath_IPOForthcomingSubTab = "#menu-wrapper > ul > li:nth-child(4) > div > div.nav-column > ul > li:nth-child(1) > a";
	private final String csspath_IPOForthcomingLabel = "#ctl00_BodyCPH_ForthcomingIssues_lblInfoDetail";
	private final String csspath_IPOForthcoming_Information = "#ctl00_BodyCPH_ForthcomingIssues_lnkViewIPOResult";
	private final String csspath_IPOForthcoming_Documents = "#ctl00_BodyCPH_ForthcomingIssues_lnkViewDocumentResult";

//    private final String csspath_IPOForthcoming_TableHeader = ".bordered>thead>tr";
//    private final String csspath_IPOForthcoming_TableNoData = ".bordered>tbody>tr";
    
    private final String csspath_IPOForthcoming_TableHeader = "#ctl00_BodyCPH_ForthcomingIssues_tblMessage>tbody>tr";
    private final String csspath_IPOForthcoming_TableNoData = "#ctl00_BodyCPH_ForthcomingIssues_tblMessage>tbody>tr>td";
    
    private final String xpath_IPOForthcoming_TableHeader = "//table[@class='bordered']/tbody/tr";
    private final String xpath_IPOForthcoming_TableNoData = "//table[@class='bordered']/tbody/tr/td";

	private final String csspath_IPOForthcoming_GuidedSearch = ".divGuiSearch>h3";
	private final String csspath_IPOForthcoming_GuidedSearch_Contents = ".gray";
	private final String csspath_IPOPastSubTab = "#menu-wrapper > ul > li:nth-child(4) > div > div.nav-column > ul > li:nth-child(3) > a";
	private final String xpath_IPOPastLabel = ".//*[@id='divIPOInfo']/span";
	private final String csspath_IPOPast_Information = "#ctl00_BodyCPH_PastIssues_lnkViewIPOResult";
	private final String csspath_IPOPast_Documents = "#ctl00_BodyCPH_PastIssues_lnkViewDocumentResult";
	private final String csspath_IPOPast_TableHeader = "#tblIssueList>thead";
	private final String csspath_IPOPast_TableHeader_CloseDate = "#ctl00_BodyCPH_PastIssues_rptIssueList_ctl00_lnkCloseDate";
	private final String csspath_IPOPast_FromDate = "#ctl00_BodyCPH_PastIssues_txtFromDate";
	private final String csspath_IPOPast_ToDate = "#ctl00_BodyCPH_PastIssues_txtToDate";
	private final String csspath_IPOPast_GoBtn = "#ctl00_BodyCPH_PastIssues_ibtnFilter";
	private final String csspath_IPOPast_CompanyLink = "#ctl00_BodyCPH_PastIssues_rptIssueList_ctl01_hlnkCompany";
	private final String csspath_IPOPast_InfoTab_Row = "#tblIssueList>tbody";


	@FindBy(css = csspath_IPOTab)
	private WebElement we_IPOTab2;

	@FindBy(css = csspath_IPOPageLabel)
	private WebElement we_IPOPageLabel;

	@FindBy(css = csspath_IPOPageCalDay_Sunday)
	private WebElement we_IPOPageCalDay_Sunday;

	@FindBy(css = csspath_IPOPageCalDay_Monday)
	private WebElement we_IPOPageCalDay_Monday;

	@FindBy(css = csspath_IPOPageCalDay_Tuesday)
	private WebElement we_IPOPageCalDay_Tuesday;

	@FindBy(css = csspath_IPOPageCalDay_Wednesday)
	private WebElement we_IPOPageCalDay_Wednesday;

	@FindBy(css = csspath_IPOPageCalDay_Thursday)
	private WebElement we_IPOPageCalDay_Thursday;

	@FindBy(css = csspath_IPOPageCalDay_Friday)
	private WebElement we_IPOPageCalDay_Friday;

	@FindBy(css = csspath_IPOPageCalDay_Saturday)
	private WebElement we_IPOPageCalDay_Saturday;

	@FindBy(css = csspath_IPOPageCalCurrentMonthAndYear)
	private WebElement we_IPOPageCalCurrentMonthAndYear;

	@FindBy(css = csspath_IPOPageCal_PreYear)
	private WebElement we_IPOPageCal_PreYear;

	@FindBy(css = csspath_IPOPageCal_PreMonth)
	private WebElement we_IPOPageCal_PreMonth;

	@FindBy(css = csspath_IPOPageCal_NextYear)
	private WebElement we_IPOPageCal_NextYear;

	@FindBy(css = csspath_IPOPageCal_NextMonth)
	private WebElement we_IPOPageCal_NextMonth;

	@FindBy(css = csspath_IPOPageCal_Today)
	private WebElement we_IPOPageCal_Today;

	@FindBy(css = csspath_IPOPageOpen_Color)
	private WebElement we_IPOPageOpen_Color;

	@FindBy(css = csspath_IPOPageClose_Color)
	private WebElement we_IPOPageClose_Color;

	@FindBy(css = csspath_IPOPageUpcoming_Color)
	private WebElement we_IPOPageUpcoming_Color;

	@FindBy(css = csspath_IPOPageListing_Color)
	private WebElement we_IPOPageListing_Color;

	@FindBy(xpath = xpath_IPOPageOpen_Text)
	private WebElement we_IPOPageOpen_Text;

	@FindBy(xpath = xpath_IPOPageClose_Text)
	private WebElement we_IPOPageClose_Text;

	@FindBy(xpath = xpath_IPOPageUpcoming_Text)
	private WebElement we_IPOPageUpcoming_Text;

	@FindBy(xpath = xpath_IPOPageListing_Text)
	private WebElement we_IPOPageListing_Text;

	@FindBy(css = csspath_IPOCalDiv)
	private WebElement we_IPOCalDiv;

	@FindBy(css = csspath_IPOCalMicrositeName)
	private WebElement we_IPOCalMicrositeName;

	@FindBy(xpath = xpath_IPOCalMicrositeTableHeader_Overview)
	private WebElement we_IPOCalMicrositeTableHeader_Overview;

	@FindBy(xpath = xpath_IPOCalMicrositeTableHeader_IssueDetails)
	private WebElement we_IPOCalMicrositeTableHeader_IssueDetails;

	@FindBy(xpath = xpath_IPOCalMicrositeTableHeader_ContactInformation)
	private WebElement we_IPOCalMicrositeTableHeader_ContactInformation;

	@FindBy(xpath = xpath_IPOCalMicrositeTableHeader_IPOManagingBodies)
	private WebElement we_IPOCalMicrositeTableHeader_IPOManagingBodies;

	@FindBy(xpath = xpath_IPOCalMicrositeTableHeader_Documents)
	private WebElement we_IPOCalMicrositeTableHeader_Documents;

	@FindBy(xpath = xpath_IPOCalMicrositeTableHeader_ResearchReports)
	private WebElement we_IPOCalMicrositeTableHeader_ResearchReports;

	@FindBy(css = csspath_IPOForthcomingSubTab)
	private WebElement we_IPOForthcomingSubTab;

	@FindBy(css = csspath_IPOForthcomingLabel)
	private WebElement we_IPOForthcomingLabel;

	@FindBy(css = csspath_IPOForthcoming_Information)
	private WebElement we_IPOForthcoming_Information;

	@FindBy(css = csspath_IPOForthcoming_Documents)
	private WebElement we_IPOForthcoming_Documents;

	@FindBy(css = csspath_IPOForthcoming_TableHeader)
	private WebElement we_IPOForthcoming_TableHeader;

	@FindBy(css = csspath_IPOForthcoming_TableNoData)
	private List<WebElement> we_IPOForthcoming_TableNoData;
	
	@FindBy(xpath = xpath_IPOForthcoming_TableHeader)
	private WebElement we_IPOForthcoming_TableHeaderXpath;

	@FindBy(xpath = xpath_IPOForthcoming_TableNoData)
	private List<WebElement> we_IPOForthcoming_TableNoDataXpath;

	@FindBy(css = csspath_IPOForthcoming_GuidedSearch)
	private WebElement we_IPOForthcoming_GuidedSearch;

	@FindBy(css = csspath_IPOForthcoming_GuidedSearch_Contents)
	private List<WebElement> we_IPOForthcoming_GuidedSearch_Contents;

	@FindBy(css = csspath_IPOPastSubTab)
	private WebElement we_IPOPastSubTab;

	@FindBy(xpath = xpath_IPOPastLabel)
	private WebElement we_IPOPastLabel;

	@FindBy(css = csspath_IPOPast_Information)
	private WebElement we_IPOPast_Information;

	@FindBy(css = csspath_IPOPast_Documents)
	private WebElement we_IPOPast_Documents;

	@FindBy(css = csspath_IPOPast_TableHeader)
	private WebElement we_IPOPast_TableHeader;

	@FindBy(css = csspath_IPOPast_InfoTab_Row)
	private WebElement we_IPOPast_InfoTab_Row;

	@FindBy(css = csspath_IPOPast_TableHeader_CloseDate)
	private WebElement we_IPOPast_TableHeader_CloseDate;

	@FindBy(css = csspath_IPOPast_FromDate)
	private WebElement we_IPOPast_FromDate;

	@FindBy(css = csspath_IPOPast_ToDate)
	private WebElement we_IPOPast_ToDate;

	@FindBy(css = csspath_IPOPast_GoBtn)
	private WebElement we_IPOPast_GoBtn;

	@FindBy(css = csspath_IPOPast_CompanyLink)
	private WebElement we_IPOPast_CompanyLink;
	
	@FindBy(css = csspath_IPOCalMicrositeTableHeader)
	private List<WebElement> we_IPOCalMicrositeTableHeader;

	
	// This is a constructor, as every page need a base driver to find web
	// elements
	public IPOPage(WebDriver driver) {
		this.driver = driver;
	}

	// Function to click on IPO tab
	public void clickOnIPOTab() {
		try {
			LoggerInstance.logger.info("click on IPO Tab");
			FunctionLibrary.clickWebLink(we_IPOTab2);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to click on Market Tab");
		}
	}

	/*
	 * Method Name: verifyIPOPageLevel 
	 * Description: Function to Verify that user should be navigated to IPO page - verify IPO page level. 
	 * Parameters:
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyIPOPageLevel() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("User is navigated to IPO page");
			result = FunctionLibrary.verifyTextWebelement("IPO Calendar", we_IPOPageLabel);
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("User is not navigated to IPO page");
			return result;
		}
	}

	/*
	 * Method Name: verifyCalendarDisplay 
	 * Description: Verify that Calendar is displayed on the page - verify that calendar days are displaying
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyCalendarDisplay() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Calendar is displayed");
			boolean a = FunctionLibrary.verifyTextWebelement("Sun", we_IPOPageCalDay_Sunday);
			boolean b = FunctionLibrary.verifyTextWebelement("Mon", we_IPOPageCalDay_Monday);
			boolean c = FunctionLibrary.verifyTextWebelement("Tue", we_IPOPageCalDay_Tuesday);
			boolean d = FunctionLibrary.verifyTextWebelement("Wed", we_IPOPageCalDay_Wednesday);
			boolean e = FunctionLibrary.verifyTextWebelement("Thu", we_IPOPageCalDay_Thursday);
			boolean f = FunctionLibrary.verifyTextWebelement("Fri", we_IPOPageCalDay_Friday);
			boolean g = FunctionLibrary.verifyTextWebelement("Sat", we_IPOPageCalDay_Saturday);
			if (a && b && c && d && e && f && g) {
				result = true;
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("Calendar is not displayed");
			result = false;
		}
		return result;
	}

	/*
	 * Method Name: verifyCalendarCurrentMonthAndYearDisplay 
	 * Description: Verify that Calendar current month and year is displayed on the page - verify that calendar current month and year is displaying 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyCalendarCurrentMonthAndYearDisplay() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Calendar current month and year is displayed");
			result = FunctionLibrary.verifyTextWebelement(FunctionLibrary.getCalendarCurrentMonthAndYear(), we_IPOPageCalCurrentMonthAndYear);
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("Calendar current month and year is not displayed");
			return result;
		}
	}

	/*
	 * Method Name: verifyCalendarNavigationDisplay 
	 * Description: Verify that Calendar navigation is displayed on the right upper side of Calendar - verify calendar navigation is displayed 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyCalendarNavigationDisplay() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Calendar navigation is displayed on the right upper side of Calendar");
			boolean a = we_IPOPageCal_PreYear.isEnabled();
			boolean b = we_IPOPageCal_PreMonth.isEnabled();
			boolean c = we_IPOPageCal_Today.isDisplayed();
			boolean d = we_IPOPageCal_NextMonth.isEnabled();
			boolean e = we_IPOPageCal_NextYear.isEnabled();
			if (a && b && c && d && e) {
				result = true;
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("Calendar navigation is not displayed on the right upper side of Calendar");
			result = false;
		}
		return result;
	}

	/*
	 * Method Name: verifyCalendarColorAndText 
	 * Description: Verify that (Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed - verify color code and text 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyCalendarColorAndText() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("(Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is displayed");
			boolean flag1 = ("#9FE900".equals(FunctionLibrary.getrgbaBackgroundColor(we_IPOPageOpen_Color))) ? true : false;
			boolean flag2 = ("#D00000".equals(FunctionLibrary.getrgbaBackgroundColor(we_IPOPageClose_Color))) ? true : false;
			boolean flag3 = ("#E9C500".equals(FunctionLibrary.getrgbaBackgroundColor(we_IPOPageUpcoming_Color))) ? true : false;
			boolean flag4 = ("#005DE9".equals(FunctionLibrary.getrgbaBackgroundColor(we_IPOPageListing_Color))) ? true : false;
			boolean flag5 = FunctionLibrary.verifyTextWebelement("Open", we_IPOPageOpen_Text);
			boolean flag6 = FunctionLibrary.verifyTextWebelement("Close", we_IPOPageClose_Text);
			boolean flag7 = FunctionLibrary.verifyTextWebelement("Upcoming", we_IPOPageUpcoming_Text);
			boolean flag8 = FunctionLibrary.verifyTextWebelement("Listing", we_IPOPageListing_Text);
			if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8) {
				result = true;
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("(Green) Open,(Red) close, (Fellow)Upcoming, (Blue)Listing is not displayed");
			result = false;
		}
		return result;
	}

	/*
	 * Method Name: verifyCalendarNavigation 
	 * Description: Verify that Calendar navigation functionality is working or not - verify calendar navigation functionality 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyCalendarNavigation() {
		boolean result = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		try {
				LoggerInstance.logger.info("Going to check Calendar navigation functionality");
				// Storing current month and year value in currentMonth and
				// currentYear variable
				String string_IPOPageCalCurrentMonthAndYear = we_IPOPageCalCurrentMonthAndYear.getText();
				int currentMonth = FunctionLibrary.getMonthIntValue(string_IPOPageCalCurrentMonthAndYear.split(" ")[0]);
				int currentYear = Integer.parseInt(string_IPOPageCalCurrentMonthAndYear.split(" ")[1]);
	
				// Clicking on Previous year link
				FunctionLibrary.clickWebLink(we_IPOPageCal_PreYear);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				String preMonthAndYear = we_IPOPageCalCurrentMonthAndYear.getText();
				int preYear = Integer.parseInt(preMonthAndYear.split(" ")[1]);
			if (preYear == currentYear - 1) {
				LoggerInstance.logger.info("Previous Year match with value " + preYear);
				flag1 = true;
			} else {
				LoggerInstance.logger.info("Previous Year value is not matching");
			}

				// Clicking on Previous Month link
				FunctionLibrary.clickWebLink(we_IPOPageCal_Today);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				FunctionLibrary.clickWebLink(we_IPOPageCal_PreMonth);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				String preMonthAndYear_Again = we_IPOPageCalCurrentMonthAndYear.getText();
				int preMonth = FunctionLibrary.getMonthIntValue(preMonthAndYear_Again.split(" ")[0]);
			if (preMonth == currentMonth - 1) {
				LoggerInstance.logger.info("Previous Month match with value " + preMonth);
				flag2 = true;
			} else
				LoggerInstance.logger.info("Previous Month value is not matching");

				// Clicking on Next Month link
				FunctionLibrary.clickWebLink(we_IPOPageCal_Today);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				FunctionLibrary.clickWebLink(we_IPOPageCal_NextMonth);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				String nextMonthAndYear = we_IPOPageCalCurrentMonthAndYear.getText();
				int nextMonth = FunctionLibrary.getMonthIntValue(nextMonthAndYear.split(" ")[0]);
			if (nextMonth == currentMonth + 1) {
				LoggerInstance.logger.info("Next Month match with value " + nextMonth);
				flag3 = true;
			} else
				LoggerInstance.logger.info("Next Month value is not matching");

				// Clicking on Next Year link
				FunctionLibrary.clickWebLink(we_IPOPageCal_Today);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				FunctionLibrary.clickWebLink(we_IPOPageCal_NextYear);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				String nextMonthAndYear_Again = we_IPOPageCalCurrentMonthAndYear.getText();
				int nextYear = Integer.parseInt(nextMonthAndYear_Again.split(" ")[1]);
			if (nextYear == currentYear + 1) {
				LoggerInstance.logger.info("Next Year match with value " + nextYear);
				flag4 = true;
			} else
				LoggerInstance.logger.info("Next Year value is not matching");
			if (flag1 && flag2 && flag3 && flag4) {
				result = true;
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("Calendar navigation functionality is not working");
			result = false;
		}
		return result;
	}

	/*
	 * Method Name: verifyCalendarCompanyies 
	 * Description: Click on Company Name and Navigated to page under Home> IPO Calender > IPO Microsite where Company Name is displayed as Label 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyCalendarCompanyies() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Going to click on Company and Navigated to page under Home> IPO Calender > IPO Microsite");
			String ipoCompanyName = we_IPOCalDiv.getText();
			FunctionLibrary.clickWebLink(we_IPOCalDiv);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			result = FunctionLibrary.verifyTextWebelement(ipoCompanyName, we_IPOCalMicrositeName);
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to click on Company");
			return result;
		}
	}

	/*
	 * Method Name: verifyIPOMicrositeTableHeader 
	 * Description: On Page sections displayed are as Overview, Issue details, Contact Information, IPO Managing Bodies, Documents Research Reports 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyIPOMicrositeTableHeader() {
		boolean result = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		boolean flag6 = false;
		boolean flag7 = false;
		try {
			LoggerInstance.logger.info("Going to check table header");
			List<WebElement> th = we_IPOCalMicrositeTableHeader;
			int col_position = 0;
			for (int i = 0; i < th.size(); i++) {
				if ("Overview".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag1 = true;
					LoggerInstance.logger.info("Overview displayed");
					continue;
				} else if ("Issue Details".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag2 = true;
					LoggerInstance.logger.info("Issue Details displayed");
					continue;
				} else if ("Contact information".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag3 = true;
					LoggerInstance.logger.info("Contact information displayed");
					continue;
				} else if ("IPO Managing Bodies".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag4 = true;
					LoggerInstance.logger.info("IPO Managing Bodies displayed");
					continue;
				} else if ("Documents".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag5 = true;
					LoggerInstance.logger.info("Documents displayed");
					continue;
				} else if ("Research Reports".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag6 = true;
					LoggerInstance.logger.info("Research Reports displayed");
					continue;
				}
			}
			if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6) {
				result = true;
				LoggerInstance.logger.info("Columns displayed as Company, Open, Close, Price Band (Rs), Size (Rs. Cr.), MOQ, Grade");
			}
		} catch (Exception e) {
			LoggerInstance.logger.info(" Table header are not displayed");
			result = false;
		}
		return result;
	}

	/*
	 * Method Name: clickForthcomingSubTab 
	 * Description: Click on Forthcoming IPO page Sub Tab 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public void clickForthcomingSubTab() {
		try {
			LoggerInstance.logger.info("Going to click on Forthcoming IPO page Sub Tab");
			FunctionLibrary.clickMenuItem(driver, we_IPOTab2, we_IPOForthcomingSubTab);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to click on Forthcoming IPO page Sub Tab");
		}
	}

	/*
	 * Method Name: verifyForthcomingInfoLabel 
	 * Description: Verify Forthcoming Info label 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyForthcomingInfoLabel() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Going to verify Forthcoming Information label");
			result = FunctionLibrary.verifyTextWebelement("Forthcoming IPO Information", we_IPOForthcomingLabel);
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("Forthcoming Information label not verified");
			return result;
		}

	}

	/*
	 * Method Name: verifyInformationAndDocumentsTabs
	 * Description: Verify Information and Documents Tabs are displayed 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyInformationAndDocumentsTabs() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Going to verify Information and Documents Tabs are displayed");
			boolean a = FunctionLibrary.verifyTextWebelement("Information", we_IPOForthcoming_Information);
			boolean b = FunctionLibrary.verifyTextWebelement("Documents", we_IPOForthcoming_Documents);
			if (a && b) {
				result = true;
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("Information and Documents Tabs are not displayed");
			result = false;
		}
		return result;
	}

	/*
	 * Method Name: verifyColumnsHeaders 
	 * Description: Verify Forthcoming Columns header 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyColumnsHeaders() {
		boolean result = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		boolean flag6 = false;
		boolean flag7 = false;

		try {
			LoggerInstance.logger.info("Going to verify that Columns displayed as Company, Open, Close, Price Band (Rs), Size (Rs. Cr.), MOQ, Grade");
			List<WebElement> th = we_IPOForthcoming_TableHeaderXpath.findElements(By.tagName("th"));
			int col_position = 0;
			for (int i = 0; i < th.size(); i++) {
				if ("Company".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag1 = true;
					LoggerInstance.logger.info("Company column displayed");
					continue;
				} else if ("Open".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag2 = true;
					LoggerInstance.logger.info("Open column displayed");
					continue;
				} else if ("Close".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag3 = true;
					LoggerInstance.logger.info("Close column displayed");
					continue;
				} else if ("Price Band (Rs.)".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag4 = true;
					LoggerInstance.logger.info("Price Band (Rs.) column displayed");
					continue;
				} else if ("Size(Rs. Cr.)".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag5 = true;
					LoggerInstance.logger.info("Size(Rs. Cr.) column displayed");
					continue;
				} else if ("MOQ".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag6 = true;
					LoggerInstance.logger.info("MOQ column displayed");
					continue;
				} else if ("Grade".equalsIgnoreCase(th.get(i).getText())) {
					col_position = i + 1;
					flag7 = true;
					LoggerInstance.logger.info("Grade column displayed");
					continue;
				}
			}
			if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7) {
				result = true;
				LoggerInstance.logger.info("Columns displayed as Company, Open, Close, Price Band (Rs), Size (Rs. Cr.), MOQ, Grade");
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("Columns are not displayed");
			result = false;
		}
		return result;
	}

	/*
	 * Method Name: verifyForthcomingTabRecords 
	 * Description: Verify Forthcoming tab Records 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyForthcomingTabRecords() {
        boolean result = false;
        try {
            LoggerInstance.logger.info("Going to verify If no records, altenate text 'There is no Current IPO Available' is displayed");
            List<WebElement> td = we_IPOForthcoming_TableNoDataXpath;
            int col_position = 0;
            for (int i = 0; i < td.size(); i++) {
            	if(td.size()==1 && td.get(i).findElement(By.tagName("span")).isDisplayed()){
            		WebElement span = td.get(i).findElement(By.tagName("span"));
            		if(("There is no Forthcoming IPO available.").equals(span.getText())){
            			LoggerInstance.logger.info("Altenate text 'There is no Current IPO Available' is displayed");
            			result=true;
            			break;
            		}
            	}else if (td.size()>0) {
					col_position = i + 1;
					result=true;
					LoggerInstance.logger.info("Records are displaying");
					break;
				} 
			}
            //result = FunctionLibrary.verifyTextWebelement("There is no Forthcoming IPO available.", we_IPOForthcoming_TableNoData);
            return result;
        } catch (Exception e) {
            LoggerInstance.logger.info("Text not displayed");
            return result;
        }

    }


	/*
	 * Method Name: verifyForthcomingGuidedSearchSection 
	 * Description: Verify Guided Search Section is displayed with links - Top Gainers, Top Losers, Largest Issue(Share Capital), Top Rated Issues 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyGuidedSearchSection() {
		boolean result = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		try {
			LoggerInstance.logger.info("Going to Verify Guided Search Section is displayed with links - Top Gainers, Top Losers, Largest Issue(Share Capital), Top Rated Issues");
			FunctionLibrary.verifyTextWebelement("Guided Search", we_IPOForthcoming_GuidedSearch);
			List<WebElement> li = we_IPOForthcoming_GuidedSearch_Contents;
			int col_position = 0;
			for (int i = 0; i < li.size(); i++) {
				if ("Top Gainers".equalsIgnoreCase(li.get(i).getText())) {
					col_position = i + 1;
					flag1 = true;
					LoggerInstance.logger.info("Link - Top Gainers column displayed");
					continue;
				} else if ("Top Losers".equalsIgnoreCase(li.get(i).getText())) {
					col_position = i + 1;
					flag2 = true;
					LoggerInstance.logger.info("Link - Top Losers column displayed");
					continue;
				} else if ("Largest Issue(Share Capital)".equalsIgnoreCase(li.get(i).getText())) {
					col_position = i + 1;
					flag3 = true;
					LoggerInstance.logger.info("Link - Largest Issue(Share Capital) column displayed");
					continue;
				} else if ("Top Rated Issues".equalsIgnoreCase(li.get(i).getText())) {
					col_position = i + 1;
					flag4 = true;
					LoggerInstance.logger.info("Link - Top Rated Issues column displayed");
					continue;
				}
			}
			if (flag1 && flag2 && flag3 && flag4) {
				result = true;
				LoggerInstance.logger.info("Guided Search Section is displayed with links - Top Gainers, Top Losers, Largest Issue(Share Capital), Top Rated Issues");
			}
		} catch (Exception e) {
			LoggerInstance.logger.info(" Guided Search Section not displayed");
			result = false;
		}
		return result;
	}

	/*
	 * Method Name: clickPastSubTab 
	 * Description: Click on Past IPO page Sub Tab 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 27-08-2014
	 */
	public void clickPastSubTab() {
		try {
			LoggerInstance.logger.info("Going to click on Past IPO page Sub Tab");
			FunctionLibrary.clickMenuItem(driver, we_IPOTab2, we_IPOPastSubTab);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to click on Past IPO page Sub Tab");
		}
	}

	/*
	 * Method Name: verifyPastIPOInfoLabel 
	 * Description: Verify Past IPO Info label 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyPastIPOInfoLabel() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Going to verify Past IPO Information from method");
			result = FunctionLibrary.verifyTextWebelement("Past IPO Information", we_IPOPastLabel);
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("Past IPO Information label not verified");
			return result;
		}

	}

	/*
	 * Method Name: verifyInformationAndDocumentsTabs 
	 * Description: Verify Information and Documents Tabs are displayed 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyInformationAndDocumentsTabsPastIPO() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Going to verify Information and Documents Tabs are displayed from method");
			boolean a = FunctionLibrary.verifyTextWebelement("Information", we_IPOPast_Information);
			boolean b = FunctionLibrary.verifyTextWebelement("Documents", we_IPOPast_Documents);
			if (a && b) {
				result = true;
			}
		} catch (Exception e) {
			LoggerInstance.logger.info("Information and Documents Tabs are not displayed");
			result = false;
		}
		return result;
	}

	/*
	 * Method Name: verifyPastIPOTableHeader 
	 * Description: Verify Columns displayed as Company, Listing Date, Price Band (Rs), Size (Rs. Cr.), MOQ, Close Date, Return 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyPastIPOTableHeader() {
		boolean result = false;
		try {
			result = we_IPOPast_TableHeader.isDisplayed();
			if (result == true)
				LoggerInstance.logger.info("Company, Listing Date, Price Band (Rs), Size (Rs. Cr.), MOQ, Close Date, Return are displayed");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("Company, Listing Date, Price Band (Rs), Size (Rs. Cr.), MOQ, Close Date, Return are not displayed");
			return result;
		}
	}

	/*
	 * Method Name: verifyPastIPOTabRecordsDecrendingOrder 
	 * Description: Records are displayed and Sorted for Close Date in Descending Order 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 27-08-2014
	 */
	public boolean verifyPastIPOTabRecordsDecrendingOrder() {
		boolean result = false;
		WebElement colElement;
		List<String> colValues = new ArrayList<String>();
		try {
			List<WebElement> rowList = we_IPOPast_InfoTab_Row.findElements(By.tagName("tr"));
			Iterator<WebElement> i = rowList.iterator();
			int k = 0;
			while (i.hasNext()) {
				k++;
				WebElement row = i.next();
				if (k <= 9) {
					colElement = row.findElement(By.cssSelector("#ctl00_BodyCPH_PastIssues_rptIssueList_ctl0" + k + "_tdItem_CloseDate"));
				} else {
					colElement = row.findElement(By.cssSelector("#ctl00_BodyCPH_PastIssues_rptIssueList_ctl" + k + "_tdItem_CloseDate"));
				}
				// LoggerInstance.logger.info("Value is for index " + k +
				// " is  " + colElement.getText().trim());
				colValues.add(colElement.getText().trim());
			}
			result = FunctionLibrary.checkDateSortingOrder(colValues, false);
			if (result == true)
				LoggerInstance.logger.info("Records are displayed and Sorted for Close Date in Descending Order");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("Records are not displayed and are not Sorted for Close Date in Descending Order");
			return result;
		}
	}

	/*
	 * Method Name: verifyPastIPOTabRecordsAscendingOrder 
	 * Description: Verify after Clicking on Close Date Column, records will be sorted in Ascending Order 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 27-08-2014
	 */
	public boolean verifyPastIPOTabRecordsAscendingOrder() {
		boolean result = false;
		WebElement colElement;
		List<String> colValues = new ArrayList<String>();
		try {
			LoggerInstance.logger.info("Going to click on Close Date Column");
			FunctionLibrary.clickWebLink(we_IPOPast_TableHeader_CloseDate);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(3000);
			List<WebElement> rowList = we_IPOPast_InfoTab_Row.findElements(By.tagName("tr"));
			Iterator<WebElement> i = rowList.iterator();
			int k = 0;
			while (i.hasNext()) {
				k++;
				WebElement row = i.next();
				if (k <= 9) {
					colElement = row.findElement(By.cssSelector("#ctl00_BodyCPH_PastIssues_rptIssueList_ctl0" + k + "_tdItem_CloseDate"));
				} else {
					colElement = row.findElement(By.cssSelector("#ctl00_BodyCPH_PastIssues_rptIssueList_ctl" + k + "_tdItem_CloseDate"));
				}
				// LoggerInstance.logger.info("Value is for index " + k +
				// " is  " + colElement.getText().trim());
				colValues.add(colElement.getText().trim());
			}
			result = FunctionLibrary.checkDateSortingOrder(colValues, true);
			if (result == true)
				LoggerInstance.logger.info("Records are displayed and Sorted for Close Date in Ascending Order");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("Records are not displayed and are not Sorted for Close Date in Ascending Order");
			return result;
		}
	}

	/*
	 * Method Name: verifySearchCriteria 
	 * Description: Verify that after entering Values into fields Close Date From and To and click GO Button, records are displayed where Close date is ranging between From and To dates. 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 27-08-2014
	 */
	public boolean verifySearchCriteria() {
		boolean result = false;
		WebElement colElement;
		List<String> colValues = new ArrayList<String>();
		DateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy");
		DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
		String fromText = "08/07/2014";
		String toText = "17/08/2014";
		try {
			LoggerInstance.logger.info("Going to Verify Search Criteria ");
			we_IPOPast_FromDate.sendKeys(fromText);
			we_IPOPast_ToDate.sendKeys(toText);
			FunctionLibrary.clickWebLink(we_IPOPast_GoBtn);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			List<WebElement> rowList = we_IPOPast_InfoTab_Row.findElements(By.tagName("tr"));
			Iterator<WebElement> i = rowList.iterator();
			int k = 0;
			while (i.hasNext()) {
				k++;
				WebElement row = i.next();
				if (k <= 9) {
					colElement = row.findElement(By.cssSelector("#ctl00_BodyCPH_PastIssues_rptIssueList_ctl0" + k + "_tdItem_CloseDate"));
				} else {
					colElement = row.findElement(By.cssSelector("#ctl00_BodyCPH_PastIssues_rptIssueList_ctl" + k + "_tdItem_CloseDate"));
				}
				// LoggerInstance.logger.info("Value is for index " + k +
				// " is  " + colElement.getText().trim());
				colValues.add(colElement.getText().trim());
			}

			if (colValues == null || colValues.isEmpty()) {
				LoggerInstance.logger.info("Date list is empty");
				result = false;
			}

			Date fromTextDate = format2.parse(fromText);
			Date toTextDate = format2.parse(toText);
			for (int j = 0; j < colValues.size() - 1; j++) {
				Date date = format1.parse(colValues.get(j).toString());
				if (toTextDate.compareTo(date) > 0 && fromTextDate.compareTo(date) <= 0) {
					LoggerInstance.logger.info("Date " + colValues.get(j).toString() + " ranging between from " + fromText + " to " + toText + " dates");
					result = true;
				} else {
					result = false;
				}
			}
			if (result == true)
				LoggerInstance.logger.info("For all Records Close date is ranging between From and To dates");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("For all Records Close date is not ranging between From and To dates");
			return result;
		}
	}

	/*
	 * Method Name: verifyCompanyClickNevigation 
	 * Description: Verify that Under Company Column click on any record and user is navigated to Company's details Page 
	 * Parameters: 
	 * Created By: Kuldeep Singh 
	 * Created Date: 16-08-2014
	 */
	public boolean verifyCompanyClickNevigation() {
		boolean result = false;
		try {
			LoggerInstance.logger.info("Going to click on Past IPO page Sub Tab");
			FunctionLibrary.clickMenuItem(driver, we_IPOTab2, we_IPOPastSubTab);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			LoggerInstance.logger.info("Going to click on Past IPO Company column link");
			String companyName = we_IPOPast_CompanyLink.getText();
			FunctionLibrary.clickWebLink(we_IPOPast_CompanyLink);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			LoggerInstance.logger.info("Going to verify Company label");
			result = FunctionLibrary.verifyTextWebelement(companyName, we_IPOCalMicrositeName);
			if (result == true)
				LoggerInstance.logger.info("User is navigated to Company's details Page ");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("User is not able to navigate to Company's details Page");
			return result;
		}
	}
}
