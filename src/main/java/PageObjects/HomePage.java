package PageObjects;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;

public class HomePage {

	final WebDriver driver;
	private final String xPath_FinalayaImage = "//img[@title='Finalaya']";
	private final String xPath_MarketNowTab = "//a[text()='Markets Now']";
	private final String linkTest_Companies_tab= "Companies";
	private final String linkTest_MutualFundsTab= "Mutual Funds";
	private final String linkTest_IPOTab = "IPO";
	private final String linkTest_ResearchHubTab = "Research Hub";
	private final String linkTest_WidgetGalleryTab = "Widget Gallery";
	private final String linkTest_ResourcesTab = "Resources";
	private final String linkTest_ReportsTab = "Reports";
	private final String xpath_QuickLink = "//span[contains(.,'QUICK LINKS')]";
	private final String xpath_SquareButton = "//img[@src='images/gifs/1x1Spacer.gif']";
	private final String xpath_MarketToday = "//img[@src='Images/NewHomePage/mt_Home.jpg']";
	private final String xpath_Sensex = "//span[contains(.,'SENSEX')]";
	private final String xpath_LatestNews = "//span[contains(.,'Latest News')]";
	private final String xpath_SearchText = "//input[@id='ucHeader_ucSearch_myTextBox']";
	private final String xpath_SearchButton = "//input[@id='ucHeader_ucSearch_btnFinSearch']";
	private final String xpath_RSTText = "//span[@id='ctl00_BodyCPH_lblcompany']";
	
	
	@FindBy(how = How.XPATH, using = xPath_FinalayaImage)
	private WebElement we_FinalayaImage;	
	@FindBy(xpath = xPath_MarketNowTab)
	private WebElement we_MarketNowTab;	
	@FindBy(linkText = linkTest_Companies_tab)
	private WebElement we_CompaniesTab;	
	@FindBy(linkText = linkTest_MutualFundsTab)
	private WebElement we_MutualFundsTab;	
	@FindBy(linkText = linkTest_IPOTab)
	private WebElement we_IPOTab;	
	@FindBy(linkText= linkTest_ResearchHubTab)
	private WebElement we_ResearchHubTab;	
	@FindBy(linkText= linkTest_WidgetGalleryTab)
	private WebElement we_WidgetGalleryTab;	
	@FindBy(linkText = linkTest_ResourcesTab)
	private WebElement we_ResourcesTab;	
	@FindBy(linkText = linkTest_ReportsTab)
	private WebElement we_ReportsTab;	
	@FindBy(xpath = xpath_SquareButton)
	private WebElement we_SquareButton;	
	@FindBy(xpath= xpath_MarketToday)
	private WebElement we_MarketToday;	
	@FindBy(xpath = xpath_Sensex)
	private WebElement we_Sensex;	
	@FindBy(xpath = xpath_LatestNews)
	private WebElement we_LatestNews;	
	@FindBy(xpath = xpath_SearchText)
	private WebElement we_SearchText;	
	@FindBy(xpath = xpath_SearchButton)
	private WebElement we_SearchButton;	
	@FindBy(xpath = xpath_QuickLink)
	private WebElement we_QuickLink;	
	@FindBy(xpath= xpath_RSTText)
	private WebElement we_RSTText;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/* Method Name: verifyTabDisplay
     * Description: This method verify all tabs
     * Created By: Anjul Tiwari
     * Created Date: 23-08-2014
     * */
 
	public boolean verifyTabDisplay() {
		boolean result=false;
		boolean result1=false;
		boolean result2=false;
		boolean result3=false;
		boolean result4=false;
		boolean result5=false;
		boolean result6=false;
		boolean result7=false;
		boolean result8=false;
		boolean result9=false;
		boolean result10=false;
		
		try{
		LoggerInstance.logger.info("click on Market Tab");
		result9 = FunctionLibrary.verifyTextWebelement("Markets Now", we_MarketNowTab);
		LoggerInstance.logger.info("click on Companies Tab");
		result1=FunctionLibrary.verifyTextWebelement("Companies", we_CompaniesTab);
		LoggerInstance.logger.info("click on Mutual Funds Tab");
		result2=FunctionLibrary.verifyTextWebelement("Mutual Funds", we_MutualFundsTab);
		LoggerInstance.logger.info("click on IPO Tab");
		result3=FunctionLibrary.verifyTextWebelement("IPO", we_IPOTab);
		LoggerInstance.logger.info("click on Research Hub Tab");
		result4=FunctionLibrary.verifyTextWebelement("Research Hub", we_ResearchHubTab);
		LoggerInstance.logger.info("click on Widget Gallery Tab");
		result5=FunctionLibrary.verifyTextWebelement("Widget Gallery", we_WidgetGalleryTab);
		LoggerInstance.logger.info("click on Resources Tab");
		result6=FunctionLibrary.verifyTextWebelement("Resources", we_ResourcesTab);
		LoggerInstance.logger.info("click on Reports Tab");
		result7=FunctionLibrary.verifyTextWebelement("Reports", we_ReportsTab);
		LoggerInstance.logger.info("click on QUICK LINKS Tab");
		result8=FunctionLibrary.verifyTextWebelement("QUICK LINKS", we_QuickLink);
		LoggerInstance.logger.info("click on Latest News button");
		result10=FunctionLibrary.verifyTextWebelement("Latest News", we_LatestNews);
		
		if(result9==true && result1==true && result2==true && result3==true && result4==true && result5==true && result6==true && result7==true && result8==true && result10==true){
		result=true;
			return result;
		}}
		catch(Exception e)
		{
		LoggerInstance.logger.info("Not able to click on Tab");
		return result;
		}
		return result;	}	
	
	/* Method Name: clickOnSquareButton
     * Description: This method verify after click on square button sensex is displayed or not 
     * Created By: Anjul Tiwari
     * Created Date: 23-08-2014
     * */
	public boolean clickOnSquareButton() {
		boolean result=false;
		try{
		LoggerInstance.logger.info("click on square button");
		FunctionLibrary.clickWebLink(we_SquareButton);
		LoggerInstance.logger.info("click on SENSEX link");
		result=FunctionLibrary.verifyTextWebelement("SENSEX", we_Sensex);
		if(result==true)
			return result;
	}
		catch(Exception e)
		{
		LoggerInstance.logger.info("Not able to click on Tab");
		return result;
		}
		return result;
	}		
	
	/* Method Name: verifyLatestNewsSection
     * Description: This method click on verify Latest news section.
     * Created By: Anjul Tiwari
     * Created Date: 23-08-2014
     * */
	public boolean verifyLatestNewsSection() {
		boolean result= false;
		try{
			LoggerInstance.logger.info("click on Latest News button");
			result=FunctionLibrary.verifyTextWebelement("Latest News", we_LatestNews);
			if (result==true)
				LoggerInstance.logger.info("click on Latest News button");
				return result;
		}
	catch(Exception e)
	{
	LoggerInstance.logger.info("Not able to click on Latest News button");
	return result;
	}
}	
	public boolean verifyLogoImage() {
		boolean result=false;
		
		try{
		LoggerInstance.logger.info("verify logo image");
		
		File directory = new File ("");
		
		String absolutepath	=	directory.getAbsolutePath();
		
		String logoFile = absolutepath + "\\finalaya_logo.jpg";
		
		result=FunctionLibrary.verifyImage(we_FinalayaImage, logoFile);
		
		if(result==true)
			return result;
	}
		catch(Exception e)
		{
		LoggerInstance.logger.info("Not able to verify logo image");
		return result;
		}
		return result;
	}
	
	/* Method Name: verifySearchOnHomePage
     * Description: This method verify search functionality 
     * Created By: Anjul Tiwari
     * Created Date: 23-08-2014
     * */
	public boolean verifySearchOnHomePage() {
		boolean result= false;
		try{
	    LoggerInstance.logger.info("sends company name on search bar");
		we_SearchText.sendKeys("Real Strips Ltd");
		LoggerInstance.logger.info("Click on search button");
		FunctionLibrary.clickWebLink(we_SearchButton);
		LoggerInstance.logger.info("Verify searched company name");
		result = FunctionLibrary.verifyTextWebelement("Real Strips Ltd", we_RSTText);
		if (result==true){
			return result;
		}
	}catch(Exception e)
	{
	LoggerInstance.logger.info("Not able to click on Tab");
	return result;
	}
		return result;
}

	public boolean verifyTabsquence() {
		// TODO Auto-generated method stub
		return true;
	}
	}


