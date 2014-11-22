package PageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import FunctionLibraries.FunctionLibrary;
import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;


public class WidgetPage {
	WebDriver driver;

	
private final String linkTest_widgetGallery_tab="Widget Gallery";
private final String linkTest_company_snapshot_link="Company Snapshot";
private final String xpath_widget_lbl="//span[contains(@id,'lblWidgetName')]";
private final String xpath_BSE_lbl="//span[contains(.,'BSE:')]";
private final String company="//a[@class='companyTitle']";
private final String bseTopGainersLosers="//a[contains(.,'BSE Top Gainers & Losers')]";
private final String xpath_BSE_MarketTicker="//a[@title='BSE Market Ticker']";
private final String xpath_NiftyTicker="//a[@title='Nifty Ticker']";
private final String xpath_MarketBreadth="//a[@title='Market Breadth']";
private final String id_latestImpression="lnkJustViewed";
private final String id_justDownloaded="lnkJustDownloaded";
private final String id_mostDownloaded="lnkMostDownloaded";
private final String xpath_refresh="//img[@alt='Refresh']";
private final String xpath_getwdgetcode="//img[@alt='Get Widget Code']";
private final String xpath_feedback="//img[@title='Feedback']";
private final String xpath_investorspowered="//img[@src='http://impetus-d270/Finalaya/images/finalaya_small.gif']";
private final String xpath_bsemarketindices="//a[contains(.,'BSE Market Indices')]";
private final String id_DashboardTitle="ctl00_BodyCPH_lblWidgetName";
private final String xpath_market="//*[@class='widRHT'][1]/li[5]/a[1]";
private final String css_markettext="#aspnetForm > div:nth-child(36) > div > div:nth-child(14) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > p:nth-child(1) > span:nth-child(2)";
private final String xpath_bsemarketimg="//*[@id='divRecentViewed']/ul/li[3]/div[2]/h2/a";





@FindBy(how = How.LINK_TEXT, using = linkTest_widgetGallery_tab)
private WebElement widget_gallery;

@FindBy(how = How.LINK_TEXT, using = linkTest_company_snapshot_link)
private WebElement company_snapshot;

@FindBy(how = How.XPATH, using = xpath_widget_lbl)
private WebElement widgetlabel;


@FindBy(how = How.XPATH, using = xpath_bsemarketimg )
private WebElement bse_market_indice;

@FindBy(how = How.XPATH, using = xpath_BSE_lbl)
private WebElement label_BSE;

@FindBy(how = How.XPATH, using = company)
private WebElement company_title;
	
@FindBy(how = How.XPATH, using = bseTopGainersLosers)
private WebElement bsetopgainerslosers;

@FindBy(how = How.XPATH, using = xpath_BSE_MarketTicker)
private WebElement bsemarketticker;

@FindBy(how = How.XPATH, using = xpath_NiftyTicker)
private WebElement niftyTicker;

@FindBy(how = How.XPATH, using =xpath_MarketBreadth)
private WebElement MarketBreadth;

@FindBy(how=How.ID, using = id_latestImpression)
private WebElement latestImpression;

@FindBy(how=How.ID,using = id_justDownloaded)
private WebElement justDownloaded;

@FindBy(how=How.ID, using = id_mostDownloaded)
private WebElement mostDownloaded;

@FindBy(how = How.XPATH, using = xpath_refresh)
private WebElement refreshIcon;

@FindBy(how = How.XPATH, using = xpath_feedback)
private WebElement feedbackIcon;

@FindBy(how = How.XPATH, using = xpath_investorspowered)
private WebElement investorsIcon;

@FindBy(how = How.XPATH, using = xpath_bsemarketindices)
private WebElement bseindiceswidgetlink;

@FindBy(how = How.ID, using = id_DashboardTitle)
private WebElement dashboardTitle;

@FindBy(how = How.XPATH, using = xpath_market)
private WebElement MarketlinkunderBySection;


@FindBy(how = How.CSS, using = css_markettext)
private WebElement MarketText;

@FindBy(how = How.XPATH, using = xpath_refresh)
private WebElement refresh_icon;

@FindBy(how = How.XPATH, using = xpath_feedback)
private WebElement feedback_icon;

@FindBy(how = How.XPATH, using = xpath_investorspowered)
private WebElement investorspowered_icon;

public void WidgetPage(WebDriver driver) {
	this.driver = driver;
}

/* Method Name: clickOnWidgetTab
 * Description: This method will click Widget Tab
 * Created By: Aman Saraf Jain
 * Created Date: 23-08-2014
 * */
public void clickOnWidgetTab() {
	try{
		LoggerInstance.logger.info("clicking  widget tab link on widget Tab");
		FunctionLibrary.clickWebLink(widget_gallery);
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  }
	  catch(Exception e){
		  LoggerInstance.logger.info("unable to click");
	  }
	}

/* Method Name: clickOnCompanySnapshot
 * Description: This method will clickOn Company Snapshot link
 * Created By: Aman Saraf Jain
 * Created Date: 23-08-2014
 * */
public void clickOnCompanySnapshot() {
	try{
		 LoggerInstance.logger.info("clicking  company_snapshot link on widget Tab");
		FunctionLibrary.clickWebLink(company_snapshot);
	  }
	  catch(Exception e){
		  LoggerInstance.logger.info("unable to click");
	  }
	}
/* Method Name: clickOnBseTopLoserGainer
 * Description: This method will click On Bse Top Loser Gainer
 * Created By: Aman Saraf Jain
 * Created Date: 23-08-2014
 * */
public void clickOnBseTopLoserGainer() {
	try{
		LoggerInstance.logger.info("clicking  bse top gainers losers on widget Tab");
		FunctionLibrary.clickWebLink(bsetopgainerslosers);
	  }
	  catch(Exception e){
		  LoggerInstance.logger.info("unable to click");
	  }
	}

/* Method Name: verifyCompanySnapshot
 * Description: This method verify company snapshot link
 * Created By: Aman Saraf Jain
 * Created Date: 23-08-2014
 * */
  public boolean verifyCompanySnapshot() {
	  boolean result=false;
	  boolean result1=false;
	  boolean result2=false;
	  boolean result3=false;
	  try{ 
			  LoggerInstance.logger.info("Verifying company snapshot link on widget Tab");
			  FunctionLibrary.verifyTextWebelement("Company Snapshot", widgetlabel);
			  FunctionLibrary.verifyTextWebelement("BSE", label_BSE);
			  result1 = company_title.isDisplayed();
			  if (result1==true&&result2==true&&result3==true){
				     result=true;
					 LoggerInstance.logger.info("Verification passed");
						 return result;
							}
		}
	  catch(Exception e)
	  {
				  LoggerInstance.logger.info("verification Failed");
				  return result;
	  }
	return result;
	
 }
  
	/* Method Name: verifylinkspresent
 * Description: This method verify various links present on Widget tab
 * Created By: Aman Saraf Jain
 * Created Date: 23-08-2014
 * */
  public boolean verifyLinksPresent(){
	  boolean result=false;
	  boolean result1=false;
	  boolean result2=false;
	  boolean result3=false;
	  boolean result4=false;
	  boolean result5=false;
	  boolean result6=false;
	  boolean result7=false;
	  boolean result8=false;
	  try{
			  LoggerInstance.logger.info("Verifying links : Company Snapshot ,Bse MArket Ticker, Nifty tracker Latest Impressions.. links on widget Tab");
			  result1 = FunctionLibrary.verifyTextWebelement("Company Snapshot", company_snapshot);
			  result2 = FunctionLibrary.verifyTextWebelement("BSE Market Ticker", bsemarketticker);
			  result3 = FunctionLibrary.verifyTextWebelement("Nifty Ticker", niftyTicker);
			  result4 = FunctionLibrary.verifyTextWebelement("BSE Top Gainers & Losers", bsetopgainerslosers);
			  result5 = FunctionLibrary.verifyTextWebelement("Market Breadth", MarketBreadth);	
			  result6 = FunctionLibrary.verifyTextWebelement("Latest Impressions", latestImpression);
			  result7 = FunctionLibrary.verifyTextWebelement("Just Downloaded", justDownloaded);
			  result8 = FunctionLibrary.verifyTextWebelement("Most Downloaded", mostDownloaded);
			  if (result1==true&&result2==true&&result3==true&&result4==true&&result5==true&&result6==true&&result7==true&&result8==true){
				     result=true;
					 LoggerInstance.logger.info("Verification passed");
			 return result;
		}
	  }
	  catch(Exception e){
		  	LoggerInstance.logger.info("verification Failed");
		  	return result;
	  }
	  return result; 
  }

	/* Method Name: verifymarketBreadthlink
 * Description: This method verify market breadth link
 * Created By: Aman Saraf Jain
 * Created Date: 23-08-2014
 * */
  
  public  boolean verifyMarketBreadthLink(WebDriver driver){
	  boolean result=false;
	  boolean result1=false;
	  boolean result2=false;
	  boolean result3=false;
	  boolean result4=false;
	  try{
		  LoggerInstance.logger.info("Verifying Market Breadth link on widget Tab");
		  FunctionLibrary.clickWebLink(MarketBreadth);
		  Thread.sleep(3000);
		  result1 = FunctionLibrary.verifyTextWebelement("Market Breadth", widgetlabel);
		  Thread.sleep(3000);
		  FunctionLibrary.switchFrame(driver,"ctl00_BodyCPH_ifrmMarketTracker");
		  result2 = FunctionLibrary.verifyStringsAreSame("Refresh", FunctionLibrary.getTooltipValue(refresh_icon));
		  FunctionLibrary.switchDefaultFrame(driver);

		  if (result1==true&&result2==true){
			  result=true;
			  LoggerInstance.logger.info("Verification passed");
			  return result;
			}
	  	}
	  catch(Exception e){
		  LoggerInstance.logger.info("verification Failed");
		  return result;
	  }
	  return result;
}

/* Method Name: verifymarketIndicelink
 * Description: This method verify market Indice link
 * Created By: Aman Saraf Jain
 * Created Date: 23-08-2014
 * */

  public  boolean verifymMrketIndiceLink(){
	  boolean result=false;
	  try{
		  LoggerInstance.logger.info("Verifying Market Indice link on widget Tab");
		  FunctionLibrary.clickWebLink(bseindiceswidgetlink);
		  result = FunctionLibrary.verifyTextWebelement("Finalaya Widgets - BSE Market Indices", dashboardTitle);
		  if (result==true){
			  	LoggerInstance.logger.info("Verification passed");
			  	return result;
			}
		  }
	  catch(Exception e){
		  	LoggerInstance.logger.info("verification Failed");
	  		}
	  return result; 
  	}
 
	/* Method Name: verifysectionby
 * Description: This method verify section by link
 * Created By: Aman Saraf Jain
 * Created Date: 23-08-2014
 * */
  public  boolean verifysectionby(){
	  boolean result=false;
	  try{
		  LoggerInstance.logger.info("Verifying Section By  link on widget Tab");
		  Thread.sleep(3000);
		  FunctionLibrary.clickWebLink(MarketlinkunderBySection);
		  result = FunctionLibrary.verifyTextWebelement("\"Market\"", MarketText);
		  if (result==true)
		  {
			  LoggerInstance.logger.info("Verification passed");
			  return result;
		}
	  }
	  catch(Exception e){
		  LoggerInstance.logger.info("verification Failed");
	  	}
	  return result; 
	  }
	/* Method Name: verifyLatestImpression
* Description: This method verify link under Latest Impression 
* Created By: Aman Saraf Jain
* Created Date: 23-08-2014
* */
public  boolean verifyLatestImpression(){
	  boolean result=false;
	  try{
		  LoggerInstance.logger.info("Verifying Latest Impression section");
		  String expected = bse_market_indice.getText();
		  FunctionLibrary.clickWebLink(bse_market_indice);
		  result = FunctionLibrary.verifyTextWebelement(expected, dashboardTitle);
		  if (result==true)
		  {
			  LoggerInstance.logger.info("Verification passed - Navigation to sublink widget successfull");
			  return result;
		}
	  }
	  catch(Exception e){
		  LoggerInstance.logger.info("verification Failed");
	  	}
	  return result; 
	  }
  
}