package PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;

public class CompaniesPage {	
	
	     private WebDriver driver;
		 private final String id_InforMationTab = "liViewCompanyResult";
		 private final String id_DocumentTab ="ctl00_BodyCPH_lnkViewDocumentResult";
		 private final String css_InforMationTabclick="#ctl00_BodyCPH_lnkViewCompanyResult";
	     private final String css_toolTipTextIndustryName="#lblIndustry";
	     private final String id_Paginationval="ctl00_BodyCPH_Pagination_pages";
	     private final String Xpath_Paginationflicker="//*[@id='pagination-flickr']/li[1]";
	     private final String css_PaginationflickerNextBtn="#pagination-flickr > li.next > a";
	     private final String css_PaginationflickerPreviousBtn="#pagination-flickr > li.previous > a";
	     private final String xpath_CompaniesTab="//*[@id='menu-wrapper']/ul/li[2]/a";
	     private final String xpath_RowTextVal="//table[@id='tblStockSearchResult']/tbody/tr/td[1]";
	     private final String css_RowTextVal ="#ctl00_BodyCPH_rpStockSearchResult_ctl00_lb_Company";
	     private final String xpath_HeaderTable="//table[@id='tblStockSearchResult']/thead";
	     private final String xpath_ColorimageNse="//table[@id='tblStockSearchResult']/tbody/tr/td[3]//img";
	     private final String xpath_ColorTextNse="//table[@id='tblStockSearchResult']/tbody/tr/td[3]//span";
	     private final String xpath_ColorimageBse="//table[@id='tblStockSearchResult']/tbody/tr/td[4]//img";
	     private final String xpath_ColorTextBse="//table[@id='tblStockSearchResult']/tbody/tr/td[4]//span";
	     private final String xpath_leftimageBegng="//table[@id='tblStockSearchResult']/tbody/tr/td[1]//img[1]";
	     private final String xpath_rightimagetext="//table[@id='tblStockSearchResult']/tbody/tr/td[1]//img[2]";
	     private final String id_PaginationDisplayed="ctl00_BodyCPH_Pagination_pages";
	     private final String xpath_TableColumnVal="//table[@id='tblStockSearchResult']/tbody/tr/td[1]";
	     private final String xpath_TableColumnVal2="//table[@id='tblStockSearchResult']/tbody/tr/td[2]";
	     private final String csspath_MainLink = "#menu-wrapper > ul > li:nth-child(2) > a";
	 	 private final String csspath_MicrositeSublink = "#menu-wrapper > ul > li:nth-child(2) > div > div.nav-column > ul > li:nth-child(1) > a";
	 	 private final String csspath_ResultsSubLink = "#menu-wrapper > ul > li:nth-child(2) > div > div.nav-column > ul > li:nth-child(2) > a";
	 	 private final String csspath_AnnoucementsSubLink = "#menu-wrapper > ul > li:nth-child(2) > div > div.nav-column > ul > li:nth-child(3) > a";
	 	 private final String csspath_CompareCompnaiesSubLink = "#menu-wrapper > ul > li:nth-child(2) > div > div.nav-column > ul > li:nth-child(4) > a";
	 	 private final String csspath_IndustriesSubTab = "#menu-wrapper > ul > li:nth-child(2) > div > div.nav-column > ul > li:nth-child(5) > a";
	 	 private final String csspath_DocumentSubTab = "#menu-wrapper > ul > li:nth-child(2) > div > div.nav-column > ul > li:nth-child(6) > a";
	 	 private final String csspath_Microsite = "#ctl00_BodyCPH_divCompany > span";
	 	 private final String csspath_Resultspage = "#ctl00_BodyCPH_divCompany > h1";
	 	 private final String csspath_Annoucement = "#mainOuter > div > div > div > div.DashboardTitle > h1";
	 	 private final String csspath_CompareCompaniesPage = "#aspnetForm > div:nth-child(38) > div > div:nth-child(14) > div > h1 > span";
	 	 private final String csspath_Industriespage = "#divHeader > span > div > h1 > span";
	 	 private final String csspath_CompanyDocument = "#ctl00_BodyCPH_divDocument > span";
	 	
	     @FindBy(css=css_InforMationTabclick)
		 public WebElement we_InforMationTabclick;
	     
	     @FindBy(id=id_InforMationTab)
		 public WebElement we_InforMationTab;
	    
		 @FindBy(id=id_DocumentTab)
		 public WebElement we_DocumentTab;
		 
	     @FindBy(xpath=xpath_CompaniesTab)
		 public WebElement we_CompaniesTab;  
	     
		 @FindBy(xpath=xpath_RowTextVal)
		 public List<WebElement> we_RowTextVal;
		 
		 @FindBy(xpath=xpath_HeaderTable)
		 List<WebElement> we_headertable;
		 
		 @FindBy(xpath=xpath_ColorimageNse)
		 public List<WebElement> we_ColorImageArrowNse;
		 
		 @FindBy(xpath=xpath_ColorTextNse)
	     List<WebElement> we_ColorTextNse;
		 
		 @FindBy(xpath=xpath_ColorimageBse)
		 public List<WebElement> we_ColorImageArrowBse;
		 
		 @FindBy(xpath=xpath_ColorTextBse)
		 List<WebElement> we_ColorTextBse;
		 
		 @FindBy(xpath=xpath_leftimageBegng)
		 List<WebElement> we_LeftImgBegng;
		 
		 @FindBy(xpath=xpath_rightimagetext)
		 List<WebElement> we_RigtImg;
		 
		 @FindBy(css=css_RowTextVal)
		 public WebElement we_desc;
		 
		 @FindBy(id=id_Paginationval)
		 public List<WebElement> we_Paginationval;
		 
		 @FindBy(xpath=Xpath_Paginationflicker)
		 public List<WebElement> we_Paginationflicker;
		 
		 @FindBy(css=css_PaginationflickerNextBtn)
		 public WebElement we_PaginationflickerNextBtn;
		 
		 @FindBy(css=css_PaginationflickerPreviousBtn)
	   	 public WebElement we_PaginationflickerPreviousBtn;
		 
		 @FindBy(id=id_PaginationDisplayed)
	 	 WebElement we_PaginationIsdisplayed;
		 
		 @FindBy(xpath=xpath_TableColumnVal)
		 List<WebElement> we_ToolTipColumnval;
		 
		 @FindBy(xpath=xpath_TableColumnVal2)
		 List<WebElement> we_ToolTipColumnval2;
		 
		 @FindBy(css=css_toolTipTextIndustryName)
		 WebElement we_toolTipTextIndustryName;
		 
		 @FindBy(css = csspath_MainLink)
		 private WebElement we_csspath_MainLink;

		 @FindBy(css = csspath_MicrositeSublink)
		 private WebElement we_csspath_MicrositeSublink;

		 @FindBy(css = csspath_ResultsSubLink)
		 private WebElement we_csspath_ResultsSubLink;

		 @FindBy(css = csspath_AnnoucementsSubLink)
		 private WebElement we_csspath_AnnoucementsSubLink;

		 @FindBy(css = csspath_CompareCompnaiesSubLink)
		 private WebElement we_csspath_CompareCompnaiesSubLink;

		 @FindBy(css = csspath_IndustriesSubTab)
		 private WebElement we_csspath_IndustriesSubTab;

		 @FindBy(css = csspath_DocumentSubTab)
		 private WebElement we_csspath_DocumentSubTab;

		 @FindBy(css = csspath_Microsite)
		 private WebElement we_csspath_Microsite;

		 @FindBy(css = csspath_Resultspage)
		 private WebElement we_csspath_Resultspage;

		 @FindBy(css = csspath_Annoucement)
		 private WebElement we_csspath_Annoucement;

		 @FindBy(css = csspath_CompareCompaniesPage)
		 private WebElement we_css_CompareCompaniesPage;

		 @FindBy(css = csspath_Industriespage)
		 private WebElement we_csspath_Industriespage;

		 @FindBy(css = csspath_CompanyDocument)
		 private WebElement we_CompanyDocumentPage;

		 // This is a constructor, as every page need a base driver to find web elements
		public CompaniesPage(WebDriver driver) {
			this.driver = driver;
		}

/* Method Name: 
 * Description: Function to click on Companies Tab
 * Created By: Mohd Suhail
 * Created Date: 19-08-2014
 * */

public void clickOnCompaniesTab() {
	try {
		LoggerInstance.logger.info("click on Companies Tab");
		FunctionLibrary.clickWebLink(we_CompaniesTab)    ;
	} catch (Exception e) {
		LoggerInstance.logger.info("Not able to click on Companies Tab");
	}
}
		

/* Method Name: 
 * Description: Function to click on InforMationTabclick
 * Created By: Mohd Suhail
 * Created Date: 19-08-2014
 * */

public void clickInformationTab() throws InterruptedException
{
	try {
	FunctionLibrary.clickWebLink(we_InforMationTabclick)    ;
	Thread.sleep(10000);
	} catch (Exception e) {
		LoggerInstance.logger.info("Not able to click on Information Tab");
	}
}

		
 /* Method Name: 
 * Description: Function to Verify Information Tab Displayed
 * Created By: Mohd Suhail
 * Created Date: 20-08-2014
 * */

		public Boolean verifyInformationTab(){
			boolean result= false;
			try{
				 result=we_InforMationTab.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("Information _Tab is displayed");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("Information _Tab is not displayed");
				return result;
			}
		}

 /* Method Name: 
 * Description: Function to Verify Document Tab Displayed
 * Created By: Mohd Suhail
 * Created Date: 20-08-2014
 * */
		public Boolean verifyDocumentTabIsDisplayed(){
			
			boolean result= false;
			try{
				 result=we_DocumentTab.isDisplayed();
				 if (result==true)
				 LoggerInstance.logger.info("Document_Tab is displayed");
				 return result;
			}
			catch (Exception e) 
			{
				LoggerInstance.logger.info("Document_Tab is not displayed");
				return result;
			}
		}
		
	
 /* Method Name: 
 * Description: Function to Verify Company name in Ascending order
 * Created By: Mohd Suhail
 * Created Date: 20-08-2014
 * */

public boolean VerifyComanyNameSortedAscending(){
	boolean result = false ;
	try{
		List<WebElement> textverifyAscending= we_RowTextVal;
	 for(int i=0;i<textverifyAscending.size()-1;i++)
	    {
	    	String Current=textverifyAscending.get(i).getText();
	    	String Next=textverifyAscending.get(i+1).getText();
	    	if (result=Current.compareToIgnoreCase(Next )< 0)
	    	{ 
	    		LoggerInstance.logger.info("Companies Name Is arranged in Ascending Order in Row"+(i+1)+".");
	    	}
	    	else if(result=Current.compareToIgnoreCase(Next) > 0)
	    	{ 
	    		LoggerInstance.logger.info("Companies Name Is not arranged in Ascending Order in Row"+(i+1)+".");
	    	}
	    	else
	    	{ 
	    		LoggerInstance.logger.info("Companies Name are identical.");
	    	}
	    }
	  }
	catch (Exception e) 
		{
			LoggerInstance.logger.info("Company Name is not arranged in Ascending Order.");
			return result;
		}
	return result;
}
	


/* Method Name: 
* Description: Function to Verify Company name in Descending order
* Created By: Mohd Suhail
* Created Date: 20-08-2014
* */
    
public boolean VerifyComanyNameSorteDecendingOrder(){
boolean result = false ;
	try{
	FunctionLibrary.clickWebLink(we_desc);
	
	List<WebElement> textverifyAscending= we_RowTextVal;
	
	 for(int i=0;i<textverifyAscending.size()-1;i++)
	    {
	    	String Current=textverifyAscending.get(i).getText();
	    	String Next=textverifyAscending.get(i+1).getText();
	    	if (result=Current.compareToIgnoreCase(Next ) >0)
	    	{ 
	    		LoggerInstance.logger.info("Companies Name Is arranged in Descending Order in Row"+(i+1)+".");
	    	}
	    	else if(result=Current.compareToIgnoreCase(Next) < 0)
	    	{ 
	    		LoggerInstance.logger.info("Companies Name Is not arranged in Descending Order in Row"+(i+1)+".");
	    	}
	    	else
	    	{ 
	    		LoggerInstance.logger.info("Companies Name are identical.");
	    	}
	    }	
	  }
	catch (Exception e) 
   		{
			LoggerInstance.logger.info("Company Name is not arranged in Descending Order.");
   		}
	return result;
}
	 
/* Method Name: 
* Description: Function to Verify Table heading CompanyName ,Industry Name
*                            NSE, BSE is displayed
* Created By: Mohd Suhail
* Created Date: 20-08-2014
* */
	 public boolean VerifyComanyTableHeadingIsDisplayed()
	 {	 
		 boolean result = false ;
			
			try{
	 List<WebElement> headerelment=we_headertable;
		 for(int i=0;i<headerelment.size();i++)
		   {
			   
		String HeaderText=	 headerelment.get(i).getText();
		
		if(result=HeaderText.equalsIgnoreCase("Company Name Industry NSE BSE"))
		{
			
			LoggerInstance.logger.info("Companies Column Heading Is Displayed and verified.");
		}
		else
		{
			LoggerInstance.logger.info("Companies Column Heading Is not Displayed and verified.");
		}
		   }   
		   }
		 catch (Exception e) 
			{
				LoggerInstance.logger.info("Element is not displayed");
				return result;
		}
			return result;
	 }
	
 /* Method Name: 
 * Description: Function to Nse value displayed red color has down arrow
 *               and  value green color in up arrow
 * Created By: Mohd Suhail
 * Created Date: 20-08-2014
 * */
 
 public Boolean VerifyNSEArrowColorTextVal()
 {
 boolean result = false ;
	 List<WebElement> colorTextNse=we_ColorTextNse;
	 List<WebElement> colorArrowImage=we_ColorImageArrowNse;
	 for(int i=0;i<colorTextNse.size();i++)
        {
           String     colorArrowImagepos=colorArrowImage.get(i).getAttribute("src");
       String     colorTextNseval=colorTextNse.get(i).getAttribute("style");
      try{  
            if(colorArrowImagepos!=null && colorTextNseval!=null)
            {
                 if(result=colorArrowImagepos.contains("green-arrow.gif") && colorTextNseval.contains("rgb(16, 143, 16)"))
                 {
                	 LoggerInstance.logger.info("NSE Data Value is green in color and image is up arrow.");
                 }
                 else if(result=colorArrowImagepos.contains("red-arrow.gif") && colorTextNseval.contains("rgb(255, 0, 0)"))
                		 {
                	 LoggerInstance.logger.info("NSE Data Value is red in color and image is down arrow.");
                 }   
                 else if(result=colorArrowImagepos.contains("red-arrow.gif") && colorTextNseval.contains("rgb(16, 143, 16)"))
        		 {
                	 LoggerInstance.logger.info("NSE Data Value is green in color and image is down arrow.");
        		 } 
                 else if(result=colorArrowImagepos.contains("green-arrow.gif") && colorTextNseval.contains("rgb(255, 0, 0)"))
        		 {
                	 LoggerInstance.logger.info("NSE Data Value is red in color and image is up arrow.");
        		 } 
            }
          }
       catch(Exception e)
          { 
            	  LoggerInstance.logger.info("NSE column does not contain any data Value.");
                  
              }
        }
	return result; 
}	
 
 
 /* Method Name: 
 * Description: Function to BSE value displayed red color has down arrow
 *               and  value green color in up arrow
 * Created By: Mohd Suhail
 * Created Date: 20-08-2014
 * */
 public Boolean VerifyBSEArrowColorTextVal()
   {
	 boolean result = false ;
	 List<WebElement> colorTextBse=we_ColorTextBse;
	 List<WebElement> colorArrowImage=we_ColorImageArrowBse;
	 for(int i=0;i<colorTextBse.size();i++)
        {
          
                String colorArrowImagepos=colorArrowImage.get(i).getAttribute("src");
                String colorTextNseval=colorTextBse.get(i).getAttribute("style");
                  try{  
                if(colorArrowImagepos!=null && colorTextNseval!=null)
                {
                     if(result=colorArrowImagepos.contains("green-arrow.gif") && colorTextNseval.contains("rgb(16, 143, 16)"))
                     {
                     	
                    	 LoggerInstance.logger.info("BSE Data Value is green in color and image is up arrow.");
                     }
                     
                     else if(result=colorArrowImagepos.contains("red-arrow.gif") && colorTextNseval.contains("rgb(255, 0, 0)"))
                    		 {
                    	 LoggerInstance.logger.info("BSE Data Value is red in color and image is down arrow.");
                     }   
                     
                     
                     else if(result=colorArrowImagepos.contains("red-arrow.gif") && colorTextNseval.contains("rgb(16, 143, 16)"))
            		 {
                    	 LoggerInstance.logger.info("BSE Data Value is green in color and image is down arrow.");
            		 } 
                     else if(result=colorArrowImagepos.contains("green-arrow.gif") && colorTextNseval.contains("rgb(255, 0, 0)"))
            		 {
                    	 LoggerInstance.logger.info("BSE Data is red in color and image is up arrow.");
            		 } 
              }
           }
        catch(Exception e)
        	{
                	  LoggerInstance.logger.info("BSE column does not contain ant data");
	        	}
	        }
		return result;
	 }	
 
	 
 /* Method Name: 
 * Description: Function to Verify Image is displayed to left
 *               of company name
 * Created By: Mohd Suhail
 * Created Date: 22-08-2014
 * */
 
 public Boolean verifyImageLeftTextIsDisplayed()
 {
	 boolean result = false ;
	 List<WebElement> leftimage=we_LeftImgBegng;
	    for(int i=0;i<leftimage.size();i++)
	    {
	    	try
	    {
	            String colortextaleftimagesrcval=leftimage.get(i).getAttribute("src");
            if(result=colortextaleftimagesrcval.contains("star-4.png")|| colortextaleftimagesrcval.contains("CID") || colortextaleftimagesrcval.contains("NoSparkline_N.jpg"))
            {
            	 LoggerInstance.logger.info("Image is displayed in left of text Value.");
            }
         
            }catch (Exception e) {
            	 LoggerInstance.logger.info("Image is  not displayed in left of text Value.");
				}
	    }
		return result;
	    }
 
 
 
 /* Method Name: 
 * Description: Function to Verify Image is displayed to Right
 *               of company name
 * Created By: Mohd Suhail
 * Created Date: 22-08-2014
 * */
    
    public Boolean verifyImageRightTextIsDisplayed()
	 {
    	boolean result = false ;
		 List<WebElement> Rightimage=we_RigtImg;
		    for(int i=0;i<Rightimage.size();i++)
		    {
		    	try
		    {
		            String  colortextaleftimagesrcval=Rightimage.get(i).getAttribute("src");
		            if(result=colortextaleftimagesrcval.contains("II_Trans_Graph.GIF") )
		            {
		            	 LoggerInstance.logger.info("Image is displayed in Right of Text Value.");
		            }
	
		            }catch (Exception e) {
		            	LoggerInstance.logger.info("Image is  not displayed in Right of Text Value.");
						}
			    }
				return result;
		 }
 
    /* Method Name: 
 * Description: Function to Verify Pagination is displayed 
 * Created By: Mohd Suhail
 * Created Date: 22-08-2014
 * */
    
public Boolean verifyPaginationdisplayed()
{
	boolean result= false;
	try{
		 result=we_PaginationIsdisplayed.isDisplayed();
		 if (result==true)
		 LoggerInstance.logger.info("Pagination  is displayed at the bottom.");
		 return result;
	}
	catch (Exception e) 
	{
		LoggerInstance.logger.info("Pagination is not displayed.");
		return result;
	}
}

/* Method Name: 
 * Description: Function to Verify Next Page then results of next page is displayed 
 *               and when user click on Previous page then results of Previous page is displayed
 * Created By: Mohd Suhail
 * Created Date: 23-08-2014
 * */
public Boolean verifyClickingNextPreviousDislayedPage()
{
	boolean result= false;
	try{
	List<WebElement> elmnt=we_Paginationval;
	List<WebElement> elmnt1=we_Paginationflicker;
	for(int i=0;i<elmnt.size();i++)
	{
		String Previousbtn=elmnt1.get(i).getAttribute("class");
		if(result=Previousbtn.equalsIgnoreCase("previous-off"))
		{
			LoggerInstance.logger.info("Page One  is displayed.");
			we_PaginationflickerNextBtn.click();
			LoggerInstance.logger.info("Next Button is clicked.");
			LoggerInstance.logger.info("Page two is  displayed.");
			WebElement PreviousBtnEnabled=we_PaginationflickerPreviousBtn;
			if(result=PreviousBtnEnabled.isEnabled())
			{
				PreviousBtnEnabled.click();
				LoggerInstance.logger.info("Previous Button is  displayed and clicked.");
				LoggerInstance.logger.info("Page one is  displayed.");
			}
		}
		}
	}catch(Exception e)
	{
		LoggerInstance.logger.info("Previous Button and Next Button is not enabled.");
	}
	return result;
	}

/* Method Name: 
 * Description: Function to Verify Company Name  ToolTip Industry Value 
 *              and Industry  column value is matching . 
 * Created By: Mohd Suhail
 * Created Date: 23-08-2014
 * */
public  boolean VerifyToolTipCompanyValIndustryColumnValMatches() throws InterruptedException
{
	boolean result= false;
	try{
	List<WebElement>  Companynameval=we_ToolTipColumnval;
    List<WebElement> ColumnIndustryname=we_ToolTipColumnval2;
	for(int i=0;i<Companynameval.size();i++)
	{
	    String text=Companynameval.get(i).getText();
		WebDriverWait wait = new WebDriverWait(driver, 80); 
		WebElement cmpnyName = driver.findElement(By.linkText(text));
		Actions act = new Actions(driver);
		act.moveToElement(cmpnyName).build().perform(); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css_toolTipTextIndustryName))); 
	    WebElement toolTipTextIndustryName  = we_toolTipTextIndustryName; 
	    Thread.sleep(2000); 
	    String popmsg1=toolTipTextIndustryName.getText();
	   for(int j=0;j< ColumnIndustryname.size();j++)
	   {
		   String ColumnTextValue=ColumnIndustryname.get(i).getText();
		   if (result=popmsg1.equalsIgnoreCase(ColumnTextValue))
		   {
		   LoggerInstance.logger.info("Tool Tip Text Value Company Name" +" "+ popmsg1 +" "+ "equals Industry name" +" "+ColumnTextValue+".");
		   break;
		  
		   }
		   else{
			   LoggerInstance.logger.info("Tool Tip Text ValueCompany Name" +" "+popmsg1 +" "+"not equals Industry name"+" " +ColumnTextValue+".");
			   break;
		   }
	   }
	} 
}
catch (Exception e) 
{
   	 LoggerInstance.logger.info("Tool tip is not exist");
           	 return result;
		}   
	return result;
	}


/*
 * Method Name: Description: Verify SubTab Microsite Page is Displayed
 * Created By: Mohd Suhail Created Date: 19-08-2014
 */

public Boolean VerifyMicrositePageIsdisplayed() {
	boolean result = false;
	try {
		LoggerInstance.logger.info("Going to  Sub Tab");
		FunctionLibrary.clickMenuItem(driver, we_csspath_MainLink,
				we_csspath_MicrositeSublink);
		result = we_csspath_Microsite.isDisplayed();
		if (result == true)
			LoggerInstance.logger.info("Microsite Page is displayed");
		return result;
	} catch (Exception e) {
		LoggerInstance.logger.info("Microsite Page is not displayed");
		return result;
	}
}

/*
 * Method Name: Description: Verify SubTab Results Page is Displayed Created
 * By: Mohd Suhail Created Date: 19-08-2014
 */

public Boolean verifyResultsPageIsdisplayed() {
	boolean result = false;
	try {
		LoggerInstance.logger.info("Going to  Sub Tab");
		FunctionLibrary.clickMenuItem(driver, we_csspath_MainLink,
				we_csspath_ResultsSubLink);
		result = we_csspath_Resultspage.isDisplayed();
		if (result == true)
			LoggerInstance.logger.info("Results Page is displayed");
		return result;
	} catch (Exception e) {
		LoggerInstance.logger.info("Results Page is not displayed");
		return result;
	}
}

/*
 * Method Name: Description: Verify SubTab Annoucement Page is Displayed
 * Created By: Mohd Suhail Created Date: 19-08-2014
 */
public Boolean VerifyAnnoucementPageIsdisplayed() {
	boolean result = false;
	try {
		LoggerInstance.logger.info("Going to  Sub Tab");
		FunctionLibrary.clickMenuItem(driver, we_csspath_MainLink,
				we_csspath_AnnoucementsSubLink);
		result = we_csspath_Annoucement.isDisplayed();
		if (result == true)
			LoggerInstance.logger.info("Annoucement Page is displayed");
		return result;
	} catch (Exception e) {
		LoggerInstance.logger.info("Annoucement Page is not displayed");
		return result;
	}
}

/*
 * Method Name: Description: Verify SubTab CompareCompaniesPage is Displayed
 * Created By: Mohd Suhail Created Date: 19-08-2014
 */

public Boolean verifyCompareCompaniesPageIsdisplayed() {

	boolean result = false;
	try {
		LoggerInstance.logger.info("Going to  Sub Tab");
		FunctionLibrary.clickMenuItem(driver, we_csspath_MainLink,
				we_csspath_CompareCompnaiesSubLink);
		result = we_css_CompareCompaniesPage.isDisplayed();
		if (result == true)
			LoggerInstance.logger
					.info("Compare Companies Page is displayed");
		return result;
	} catch (Exception e) {
		LoggerInstance.logger
				.info("Compare Companies Page is not displayed");
		return result;
	}
}

/*
 * Method Name: Description: Verify SubTab IndustriesPage is Displayed
 * Created By: Mohd Suhail Created Date: 19-08-2014
 */

public Boolean verifyIndustriesPageIsdisplayed() {
	boolean result = false;
	try {
		LoggerInstance.logger.info("Going to  Sub Tab");
		FunctionLibrary.clickMenuItem(driver, we_csspath_MainLink,
				we_csspath_IndustriesSubTab);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		result = we_csspath_Industriespage.isDisplayed();
		if (result == true)
			LoggerInstance.logger.info("Industries Page is displayed");
		return result;
	} catch (Exception e) {
		LoggerInstance.logger.info("Industries Page is not displayed");
		return result;
	}
}

// /* Method Name:
// * Description: Verify SubTab DocumentPage is Displayed
// * Created By: Mohd Suhail
// * Created Date: 19-08-2014
// * */
public Boolean VerifyDocumentPageIsdisplayed() {
	boolean result = false;
	try {
		LoggerInstance.logger.info("Going to  Sub Tab");
		FunctionLibrary.clickMenuItem(driver, we_csspath_MainLink,
				we_csspath_DocumentSubTab);
		result = we_CompanyDocumentPage.isDisplayed();
		if (result == true)
			LoggerInstance.logger.info("Document Page is displayed");
		return result;
	} catch (Exception e) {
		LoggerInstance.logger.info("Document Page is not displayed");
		return result;
	}
}
}
			
	
	
	 
	 



