package PageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.Logger;

//import com.gargoylesoftware.htmlunit.WebConsole.Logger;

import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;

public class MarketPage {
	
	WebDriver driver;
	Logger logger;
	public MarketPage(){
		this.driver= driver;
		//logger= LoggerInstance.logger;
	}
	private final String csspath_MarketTab = "#menu-wrapper > ul > li:nth-child(1) > a";//"html.js.flexbox.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.no-csstransforms3d.csstransitions.fontface.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body form#form1 div.topContainerHome div.fltLft100 div div#ucHeader_divHeader div#ucHeader_divMenu.fltLft100 div#menu-wrapper.menu-wrapper ul.nav li a";
	private final String csspath_GoldETFTAble="#dvGoldReal > table > tbody > tr:nth-child(1) > td > table";
	private final String csspath_NonGoldETFTable="#dvNonGoldReal > table > tbody > tr:nth-child(1) > td > table";
	private final String id_BSETAb="ctl00_BodyCPH_lnkBSE";
	private final String id_NegativeValue="ctl00_BodyCPH_rptETFReatTime_Gold_ctl14_lblChange";
	private final String id_NSETAb="ctl00_BodyCPH_lnkNSE";
	private final String name_Underlying="ctl00$BodyCPH$ddlUnderLying";	
	private final String id_SensexCurrentValue="ctl00_BodyCPH_ucExGraph_lblCurrentValue";
	private final String id_SensexValueChange="ctl00_BodyCPH_ucExGraph_lblAbsoluteChange";
	private final String id_SensexPercentageChange="ctl00_BodyCPH_ucExGraph_lblPercentChange";
	private final String id_ETFZonePage="ctl00_BodyCPH_lblDocuments";
	private final String css_MarketToday="#divMarket > table:nth-child(1) > tbody > tr:nth-child(2) > td > div > h1";//*[@id='divMarket']//div[contains(text(),'Market Today')]";
	private final String csspath_ETFZoneTab ="#menu-wrapper > ul > li:nth-child(1) > div > div.nav-column > ul > li:nth-child(5) > a";
	private final String csspath_OpenLowHighPreClose = "#divExchangeGraph > div > div.mar_OHLC";
	@FindBy(css = csspath_MarketTab)
	public WebElement we_MarketTab;
	@FindBy(name = name_Underlying)
	public WebElement we_Underlying;
	@FindBy(css = csspath_GoldETFTAble)
	public WebElement we_GoldETFTable;
	@FindBy(css = csspath_NonGoldETFTable)
	public WebElement we_NonGoldETFTable;
	@FindBy(css = csspath_OpenLowHighPreClose)
	public WebElement we_OpenLowHighPreClose;
	@FindBy(css = csspath_ETFZoneTab)
	public WebElement we_ETFZoneTab;
	@FindBy(id = id_BSETAb)
	public WebElement we_BSETab;
	@FindBy(id = id_NegativeValue)
	public WebElement we_NegativeValue;
	@FindBy(id = id_ETFZonePage)
	public WebElement we_ETFZonePage;
	@FindBy(id = id_NSETAb)
	public WebElement we_NSETab;
	@FindBy(id = id_SensexCurrentValue)
	public WebElement we_SensexCurrentValue;
	@FindBy(id = id_SensexValueChange)
	public WebElement we_SensexValueChange;
	@FindBy(id = id_SensexPercentageChange)
	public WebElement we_SensexPercentageChange;
	@FindBy(css = css_MarketToday)
	public WebElement we_MarketToday;
	
	
	/* Method Name: clickOnMarketTab
     * Description: This function will click on Market tab.
     * Parameters:  
     * Created By: Rohit Miglani
     * Created Date: 13-08-2014
     * */
	public void clickOnMarketTab()
	{
		try
		{
			LoggerInstance.logger.info("click on Market Tab");
			FunctionLibrary.clickWebLink(we_MarketTab);
		}
		catch(Exception e)
		{
		LoggerInstance.logger.info("Not able to click on Market Tab");
		}
	}
	
	/* Method Name: clickOnETFZoneTab
     * Description: Function to click on ETFZone tab.
     * Parameters:  
     * Created By: Rohit Miglani
     * Created Date: 13-08-2014
     * */
	
	public void clickOnETFZoneTab(WebDriver driver)
	{
		try
		{
			FunctionLibrary.clickMenuItem(driver,we_MarketTab, we_ETFZoneTab);
			//FunctionLibrary.clickWebLink(we_ETFZoneTab);
			LoggerInstance.logger.info("click on ETF Zone tab");
		}
		catch (Exception e) {
			LoggerInstance.logger.info("not able to click ETF Zone tab");
		}
	}
	
	/* Method Name: selectValueFromUnderlying
     * Description: Function to select value from Underlying dropdown
     * Parameters:  
     * Created By: Rohit Miglani
     * Created Date: 13-08-2014
     * */
	public void selectValueFromUnderlying(String toselect){
		try{
			LoggerInstance.logger.info("Select value "+toselect+" from underlying dropdown");
			FunctionLibrary.selectItemFromWeblist(we_Underlying,toselect );
		}catch (Exception e) {
			LoggerInstance.logger.info("Unable to Select "+toselect+"from underlying dropdown");
		}
		
	}
	/* Method Name: verifyNegativeValueColor
     * Description: Function to verify negative value color is red.
     * Parameters:  
     * Created By: Rohit Miglani
     * Created Date: 13-08-2014
     * */
	public boolean verifyNegativeValueColor(){
		boolean result = false;
		try{
			
			LoggerInstance.logger.info("verify the color of negative value is Red");
			String result2=FunctionLibrary.getrgbaColor(we_NegativeValue);
			result= FunctionLibrary.verifyStringsAreSame(result2,"#FF0000");
		}
		catch(Exception e){
			LoggerInstance.logger.info("unable to verify the color");
		}
		return result;
	}
	
	/* Method Name: clickOnBSETab
     * Description: Function to click on BSE tab.
     * Parameters:  
     * Created By: Rohit Miglani
     * Created Date: 13-08-2014
     * */
	public void clickOnBSETab()
	{
		try
		{
			LoggerInstance.logger.info("click on BSE Tab");
			FunctionLibrary.clickWebLink(we_BSETab);
		}
		catch(Exception e)
		{
			LoggerInstance.logger.info("Not able to click on BSE Tab");
		}
	}
	/* Method Name: clickOnNSETab
     * Description: Function to click on NSE tab.
     * Parameters:  
     * Created By: Rohit Miglani
     * Created Date: 13-08-2014
     * */
		public void clickOnNSETab()
		{
			try
			{
				LoggerInstance.logger.info("click on NSE Tab");
				FunctionLibrary.clickWebLink(we_NSETab);
			}
			catch(Exception e)
			{
				LoggerInstance.logger.info("Not able to click on NSE Tab");
			}
		}
		/* Method Name: verifyOpenLowHighPreCloseIsDisplayed
	     * Description: Function to verify Open,Low,High,PreClose is displayed.
	     * Parameters:  
	     * Created By: Rohit Miglani
	     * Created Date: 13-08-2014
	     * */
		public boolean verifyOpenLowHighPreCloseIsDisplayed(WebDriver driver){
			boolean result= false;
			try{
				FunctionLibrary.waitTillElementPresent(driver, 10, By.cssSelector(csspath_OpenLowHighPreClose));
				 result=we_OpenLowHighPreClose.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("Open, low, Hig, Pre Close is displayed");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("Open, low, Hig, Pre Close is not displayed");
				return result;
			}
		}
		/* Method Name: verifyMarketPageIsDisplayed
	     * Description: Function to verify Market Page is displayed.
	     * Parameters:  
	     * Created By: Rohit Miglani
	     * Created Date: 13-08-2014
	     * */
		public boolean verifyMarketPageIsDisplayed(WebDriver driver){
			boolean result= false;
			try{
				FunctionLibrary.waitTillElementPresent(driver, 10, By.cssSelector(css_MarketToday));
				 result=we_MarketToday.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("User is navigated to Market Page");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("User is not navigated to Market Page"+e.getMessage());
				return result;
			}
		}
		
		/* Method Name: verifyETFZonePageIsDisplayed
	     * Description: Function to verify ETFZone Page is displayed.
	     * Parameters:  
	     * Created By: Rohit Miglani
	     * Created Date: 13-08-2014
	     * */
		public boolean verifyETFZonePageIsDisplayed(WebDriver driver){
			boolean result= false;
			try{	
				FunctionLibrary.waitTillElementPresent(driver, 10, By.id(id_ETFZonePage));
				 result=we_ETFZonePage.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("User is navigated to ETFZone Page");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("User is not navigated to ETFZone Page");
				return result;
			}
		}
		/* Method Name: verifyGoldETFTableIsDisplayed
	     * Description: Function to verify Gold ETF Table is displayed.
	     * Parameters:  
	     * Created By: Rohit Miglani
	     * Created Date: 13-08-2014
	     * */
		public boolean verifyGoldETFTableIsDisplayed(WebDriver driver){
			boolean result= false;
			try{
				FunctionLibrary.waitTillElementPresent(driver, 10, By.cssSelector(csspath_GoldETFTAble));
				 result=we_GoldETFTable.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("User is navigated to Gold ETF Table");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("User is not navigated to Gold ETF Table");
				return result;
			}
		}
		
		/* Method Name: verifyNonGoldETFTableIsDisplayed
	     * Description: Function to verify Non Gold ETF Table is displayed.
	     * Parameters:  
	     * Created By: Rohit Miglani
	     * Created Date: 13-08-2014
	     * */
		public boolean verifyNonGoldETFTableIsDisplayed(WebDriver driver){
			boolean result= false;
			try{
				//Thread.sleep(3000);
					FunctionLibrary.waitTillElementPresent(driver, 10, By.cssSelector(csspath_NonGoldETFTable));
				 result=we_NonGoldETFTable.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("User is navigated to Gold ETF Table");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("User is not navigated to Gold ETF Table");
				return result;
			}
		}
		
		/* Method Name: verifyCurrentValueOfSensexIsDisplayed
	     * Description: Function to verify Current value of Sensex is displayed.
	     * Parameters:  
	     * Created By: Rohit Miglani
	     * Created Date: 13-08-2014
	     * */
		public boolean verifyCurrentValueOfSensexIsDisplayed(WebDriver driver){
			boolean result= false;
			try{
				FunctionLibrary.waitTillElementPresent(driver, 10, By.id(id_SensexCurrentValue));
				 result=we_SensexCurrentValue.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("Current value of Sensex is displayed");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("Current value of Sensex is not displayed");
				return result;
			}
		}
		/* Method Name: verifyCurrentValueOfNiftyIsDisplayed
	     * Description: Function to verify Current value of Nifty is displayed.
	     * Parameters:  
	     * Created By: Rohit Miglani
	     * Created Date: 13-08-2014
	     * */
		public boolean verifyCurrentValueOfNiftyIsDisplayed(WebDriver driver){
			boolean result= false;
			try{
				FunctionLibrary.waitTillElementPresent(driver, 10, By.id(id_SensexCurrentValue));
				 result=we_SensexCurrentValue.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("Current value of Nifty is displayed");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("Current value of Nifty is not displayed");
				return result;
			}
		}
		
		/* Method Name: verifyValueChangeOfNiftyIsDisplayed
	     * Description: Function to verify value Change of Nifty is displayed.
	     * Parameters:  
	     * Created By: Rohit Miglani
	     * Created Date: 13-08-2014
	     * */
		public boolean verifyValueChangeOfNiftyIsDisplayed(WebDriver driver){
			boolean result= false;
			try{
				FunctionLibrary.waitTillElementPresent(driver, 10, By.id(id_SensexValueChange));
				 result=we_SensexValueChange.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("Value  of Nifty is displayed");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("Value change of Nifty is not displayed");
				return result;
			}
		}
		/* Method Name: verifyValueChangeOfSensexIsDisplayed
	     * Description: Function to verify value Change of Sensex is displayed.
	     * Parameters:  
	     * Created By: Rohit Miglani
	     * Created Date: 13-08-2014
	     * */
		public boolean verifyValueChangeOfSensexIsDisplayed(WebDriver driver){
			boolean result= false;
			try{
				FunctionLibrary.waitTillElementPresent(driver, 10, By.id(id_SensexValueChange));
				 result=we_SensexValueChange.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("Value change of Sensex is displayed");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("Value change of Sensex is not displayed");
				return result;
			}
		}
		
		/* Method Name: verifyPercentageChangeOfSensexIsDisplayed
	     * Description: Function to verify Percentage Change of Sensex is displayed.
	     * Parameters:  
	     * Created By: Rohit Miglani
	     * Created Date: 13-08-2014
	     * */
		
		public boolean verifyPercentageChangeOfSensexIsDisplayed(WebDriver driver){
			boolean result= false;
			try{
				FunctionLibrary.waitTillElementPresent(driver, 10, By.id(id_SensexPercentageChange));
				 result=we_SensexPercentageChange.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("Percentage change of Sensex is displayed");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("Percentage change of Sensex is not displayed");
				return result;
			}
		}
		
		/* Method Name: verifyPercentageChangeOfNiftyIsDisplayed
	     * Description: Function to verify Percentage Change of Nifty is displayed.
	     * Parameters:  
	     * Created By: Rohit Miglani
	     * Created Date: 13-08-2014
	     * */
		public boolean verifyPercentageChangeOfNiftyIsDisplayed(WebDriver driver){
			boolean result= false;
			try{
				FunctionLibrary.waitTillElementPresent(driver, 10, By.id(id_SensexPercentageChange));
				 result=we_SensexPercentageChange.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("Percentage change of Nifty is displayed");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("Percentage change of Nifty is not displayed");
				return result;
			}
		}
		
}

