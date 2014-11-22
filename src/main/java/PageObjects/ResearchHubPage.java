package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;

public class ResearchHubPage {
	
	WebDriver driver;
	private final String csspath_ResearchTab="#lnkResearch";
	private final String csspath_ResultsInsightsTab="#menu-wrapper > ul > li:nth-child(5) > div > div.nav-column > ul > li:nth-child(2) > a";
	private final String csspath_ResultsInsightstitle="#aspnetForm>div>div>div>div>div>div>h1>img";
	private final String csspath_GoBtn="#ctl00_BodyCPH_btnSearch";
	private final String xpath_PrimarySelectionddl=".//*[@id='ctl00_BodyCPH_ddlCompanyFilter_chzn']/a";
	private final String xpath_ResultsValddl="//ul[@class='chzn-results']";
	private final String tagname_Results="li";
	private final String xpath_SecondrySelectionddl=".//*[@id='ctl00_BodyCPH_ddlMarketCap_chzn']/a";
	private final String xpath_ResultTypeddl="//*[@id='ctl00_BodyCPH_ddlResultType_chzn']/a";
	private final String xpath_ResultsTypeValddl="//div[@id='ctl00_BodyCPH_ddlResultType_chzn']//ul[@class='chzn-results']";
	private final String xpath_SelectTimeLineddl=".//*[@id='ctl00_BodyCPH_ddlQuartersQ_chzn']/a";
	private final String xpath_Quaterlyddl=".//*[@id='ctl00_BodyCPH_ddlCompareType_chzn']/a";
	private final String csspath_QD1="#tblClassicView > tbody > tr:nth-child(1) > td:nth-child(1) > span:nth-child(1) > span:nth-child(1)";
	private final String csspath_QD2="#tblClassicView > tbody > tr:nth-child(1) > td:nth-child(2) > span:nth-child(1) > span:nth-child(1)";
	private final String csspath_QD3="#tblClassicView > tbody > tr:nth-child(2) > td:nth-child(1) > span:nth-child(1) > span:nth-child(1)";
	private final String csspath_QD4="#tblClassicView > tbody > tr:nth-child(2) > td:nth-child(2) > span:nth-child(1) > span:nth-child(1)";
	private final String csspath_AdvanceViewbtn="#ctl00_BodyCPH_btnShowMT";
	private final String csspath_QuadrantViewbtn="#ctl00_BodyCPH_btnShowQD";
	private final String csspath_MotionChartViewbtn="#ctl00_BodyCPH_btnShowMotionChart";
	private final String xpath_QuadrantCharacteristicsheader="//table[@class='bordered']/thead";
	private final String csspath_QD2FrameValbtn="#ctl00_BodyCPH_lblQD2_CNT_CV";
	private final String csspath_QD2ResultantFrame="#divTables>div";
	private final String csspath_QD2ResultantFrameclosebtn="#divTables>div>div>p";

	
	@FindBy(css = csspath_ResearchTab)
	public WebElement we_ResearchTab;
	@FindBy(css = csspath_ResultsInsightsTab)
	public WebElement we_ResultsInsightsTab;
	@FindBy(css = csspath_ResultsInsightstitle)
	public WebElement we_ResultsInsightstitle;
	@FindBy(xpath = xpath_PrimarySelectionddl)
	public WebElement we_PrimarySelectionddl;
	@FindBy(xpath = xpath_SecondrySelectionddl)
	public WebElement we_SecondrySelectionddl;
	@FindBy(xpath = xpath_ResultTypeddl)
	public WebElement we_ResultTypeddl;
	@FindBy(xpath = xpath_ResultsTypeValddl)
	public List<WebElement> we_ResultsTypeValddl;
	@FindBy(xpath = xpath_SelectTimeLineddl)
	public WebElement we_SelectTimeLineddl;
	@FindBy(xpath = xpath_Quaterlyddl)
	public WebElement we_Quaterlyddl;
	@FindBy(xpath = xpath_QuadrantCharacteristicsheader)
	public WebElement we_xpath_QuadrantCharacteristicsheader;
	@FindBy(css = csspath_QD1)
	public WebElement we_QD1;
	@FindBy(css = csspath_QD2)
	public WebElement we_QD2;
	@FindBy(css = csspath_QD3)
	public WebElement we_QD3;
	@FindBy(css = csspath_QD4)
	public WebElement we_QD4;
	@FindBy(css = csspath_AdvanceViewbtn)
	public WebElement we_AdvanceViewbtn;
	@FindBy(css = csspath_QuadrantViewbtn)
	public WebElement we_QuadrantViewbtn;
	@FindBy(css = csspath_MotionChartViewbtn)
	public WebElement we_MotionChartViewbtn;
	@FindBy(css = csspath_QD2FrameValbtn)
	public WebElement we_QD2FrameValbtn;
	@FindBy(css = csspath_QD2ResultantFrame)
	public WebElement we_QD2ResultantFrame;
	@FindBy(css = csspath_QD2ResultantFrameclosebtn)
	public WebElement we_QD2ResultantFrameclosebtn;
	
	@FindBy(css = csspath_GoBtn)
	public WebElement we_GoBtn;
	
	@FindBy(xpath = xpath_ResultsValddl)
	public  List<WebElement> we_ResultsValddl;
	
	@FindBy( tagName= tagname_Results)
	public  List<WebElement> we_tagname_Results;
	
	
	


	//this will Instance the Webdriver Object
	public ResearchHubPage(WebDriver driver) {
		this.driver = driver;
	}
	
	

	/* Method Name: Function to click on Primary Selection drop down
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 11-08-2014
     * */
	
 public void clickPrimarySelectionddl()
	{
		try
		{
			FunctionLibrary.clickWebLink(we_PrimarySelectionddl);
			we_ResultsValddl=we_tagname_Results;
			List<WebElement> options = we_ResultsValddl;
			for (WebElement option : options) 
			{
				
	            if ("Market Capitalization".equalsIgnoreCase(option.getText())) 
	            {
	                  
	                  option.click();
	                  LoggerInstance.logger.info("click on Primary Selection DropDown.");
	            }	
		}
		}
		catch (Exception e) {
			LoggerInstance.logger.info("Not able to click on Primary Selection DropDown.");
		}
	}
    
 /* Method Name: Function to click on SecondrySelection drop down
  * Description: 
  * Created By: Mohd Suhail
  * Created Date: 11-08-2014
  * */
    
    public void clickSecondrySelectionddl()
	{
		try
		{
			FunctionLibrary.clickWebLink(we_SecondrySelectionddl);
			we_ResultsValddl=we_tagname_Results;
			List<WebElement> options = we_ResultsValddl;
			for (WebElement option : options) 
			{
				
	            if ("Mid Cap".equalsIgnoreCase(option.getText())) 
	            {
	                  
	                  option.click();
	                
	                  LoggerInstance.logger.info("click on Secondary Selection DropDown Value.");
	                  
	            }
		}
		}
		catch (Exception e) {
			LoggerInstance.logger.info("Not able to click on Secondary Selection DropDown Value.");
		}
	}

    
    /* Method Name: Function to click on Result Type drop down
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 11-08-2014
     * */
    
    public void clickResultTypeddl()
   	{
   		try
   		{
   			FunctionLibrary.clickWebLink(we_ResultTypeddl);
   			we_ResultsTypeValddl=we_tagname_Results;
   			List<WebElement> options = we_ResultsTypeValddl;
   			for (WebElement option : options) 
   			{
   			
   	           if ("Quarterly".equals(option.getText())) 
   	            {
   	                  
   	                  option.click();
   	                 
   	               LoggerInstance.logger.info("click on Results Type DropDown Value .");
   	               break;
   	            }
   			}
   		
   		}
   		catch (Exception e) {
   			LoggerInstance.logger.info("not able click on Results Type DropDown Value .");
   		}
   	}
    
    

    /* Method Name: Function to click on Select TimeLine drop down
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 11-08-2014
     * */
    
    public void clickSelectTimeLineddl()
   	{
   		try
   		{
   			FunctionLibrary.clickWebLink(we_SelectTimeLineddl);
   			we_ResultsValddl=we_tagname_Results;
   			List<WebElement> options = we_ResultsValddl;
   			for (WebElement option : options) 
   			{
   				
   	            if ("Apr-Jun 30, 2014".equalsIgnoreCase(option.getText())) 
   	            {
   	                  
   	                  option.click();
   	               LoggerInstance.logger.info("click on Select Time Line DropDown.");
   	            }   			
   		}
   		}
   		catch (Exception e) {
   			LoggerInstance.logger.info("Not able to click Select Time Line DropDown.");
   		}
   	}
    
    /* Method Name: Function to click on Quaterly drop down
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 11-08-2014
     * */
    public void clickQuaterlyddl()
   	{
   		try
   		{
   			FunctionLibrary.clickWebLink(we_Quaterlyddl);
   			we_ResultsValddl=we_tagname_Results;
   			List<WebElement> options = we_ResultsValddl;
   			for (WebElement option : options) 
   			{
   			
   	            if ("Q-o-Q".equalsIgnoreCase(option.getText())) 
   	            {
   	                  
   	                  option.click();
   	               LoggerInstance.logger.info("click on Quarterly DropDown.");
   	            }	
   		}
   		}
   		catch (Exception e) {
   			LoggerInstance.logger.info("Not able to click  on Quarterly DropDown.");
   		}
   	}

    /* Method Name: Function to click on Resultant Frame close button
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 11-08-2014
     * */
    
    public void clickQD2ResultantFrameclosebtn()
	{
		try
		{
			LoggerInstance.logger.info("click on QD2 Resultant Frame close Button.");
			FunctionLibrary.clickWebLink(we_GoBtn);
		}
		catch(Exception e)
		{
			LoggerInstance.logger.info("Not able to click on QD2 Resultant Frame close Button.");
		}
	}
    
    /* Method Name: Function to click on Go button
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 11-08-2014
     * */
    public void clickGobtn()
	{
		try
		{
			LoggerInstance.logger.info("click on Go Button");
			FunctionLibrary.clickWebLink(we_GoBtn);
		}
		catch(Exception e)
		{
			LoggerInstance.logger.info("Not able to click on Go Button");
		}
	}
    
    /* Method Name: Function to click on  Frame value button
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 11-08-2014
     * */
    public void clickQD2FrameVal()
   	{
   		try
   		{
   			LoggerInstance.logger.info("click on QD2 Frame Value");
   			FunctionLibrary.clickWebLink(we_QD2FrameValbtn);
   		}
   		catch(Exception e)
   		{
   			LoggerInstance.logger.info("Not able to click on QD2 Frame Value");
   		}
   	}
    
    /* Method Name: Function to click on Results Insights Tab
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 11-08-2014
     * */
	public void clickOnResultsInsightsTab(WebDriver driver)
	{
		try
		{
			FunctionLibrary.clickMenuItem(driver,we_ResearchTab, we_ResultsInsightsTab);
			LoggerInstance.logger.info("click on Results Insights Tab.");
		}
		catch (Exception e) {
			LoggerInstance.logger.info("Not able to click Results Insights Tab.");
		}
	}
	
	 /* Method Name: Function to Verify QD2 Resultant Frame Displayed
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 11-08-2014
     * */
	
	public boolean VerifyQD2ResultantFrameDisplayed(){
		boolean result= false;
		try{
			 result=we_QD2ResultantFrame.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("QD2 Resultant Frame is displayed");
			 return result;
		}
		catch (Exception e) 
		{
			LoggerInstance.logger.info("QD2 Resultant Frame is  not displayed");
			return result;
		}
	}
	
	
	/* Method Name: Function to Verify Results title isDisplayed
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 11-08-2014
     * */
	public boolean VerifyResultstitleDisplayed(){
		boolean result= false;
		try{
			 result=we_ResultsInsightstitle.isDisplayed();
			 if (result==true)
			 LoggerInstance.logger.info("Results Insights title is displayed");
			 return result;
		}
		catch (Exception e) 
		{
			LoggerInstance.logger.info("Results Insights title is not displayed");
			return result;
		}
	}
	
	

	/* Method Name: Function to PrimarySelection,SecondrySelection, 
	 *              ResultType,SelectTimeLine and Quaterly Dropdown is displayed
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 11-08-2014
     * */

	public boolean VerifyPrimarySecondaryDisplayed(){
		boolean result= false;
		try{
			 boolean a=we_PrimarySelectionddl.isDisplayed();
			 boolean b=we_SecondrySelectionddl.isDisplayed();
			 boolean c=we_ResultTypeddl.isDisplayed();
			 boolean d=we_SelectTimeLineddl.isDisplayed();
			 boolean e=we_Quaterlyddl.isDisplayed();			 
			 if (a && b && c && d && e )
			 LoggerInstance.logger.info("PrimarySelection,SecondrySelection,ResultType,SelectTimeLine and Quaterly Dropdown is displayed");
			
			 return result;
		}
		catch (Exception e) 
		{
			LoggerInstance.logger.info("PrimarySelection,SecondrySelection,ResultType,SelectTimeLine and Quaterly Dropdown not is displayed");
			return result;
		}
	}
	
	
	/* Method Name: Function to QD1,QD2,QD3,QD4 ,Advance  View Button,QuadrantView Button and Motion Chart Button is displayed
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 11-08-2014
     * */
	public boolean VerifyQD1QD2QD3QD4Displayed(){
		boolean result= false;
		try{
			 boolean a=we_QD1.isDisplayed();
			 boolean b=we_QD2.isDisplayed();
			 boolean c=we_QD3.isDisplayed();
			 boolean d=we_QD4.isDisplayed();
			 boolean e=we_AdvanceViewbtn.isDisplayed();
			 boolean f=we_QuadrantViewbtn.isDisplayed();
			 boolean g=we_MotionChartViewbtn.isDisplayed();
			 
			 if (a && b && c && d && e && f && g)
			 LoggerInstance.logger.info("QD1,QD2,QD3,QD4 ,Advance View Button,QuadrantView Button and Motion Chart Button is displayed");
			
			 return result;
		}
		catch (Exception e) 
		{
			LoggerInstance.logger.info("QD1,QD2,QD3,QD4 ,Advance View Button,QuadrantView Button and Motion Chart Button is  not displayed");
			return result;
		}
	}
	
	
	}
	
	

