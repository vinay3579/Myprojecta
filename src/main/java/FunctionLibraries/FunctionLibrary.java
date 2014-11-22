package FunctionLibraries;



import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Logger.LoggerInstance;

public class FunctionLibrary {
	static WebDriver driver = null;
	
	  /* Method Name: GetTooltipValue
       * Description: 
       *            This method will return the ToolTip value i.e. title
       * Parameters: 
       *            1. WebElement object 
       * Created By: Anjul Tiwari
       * Created Date: 11-08-2014
       * */

	public static String getTooltipValue (WebElement toolTipObject)     {
		String googleTooltip = null;
	   try {
			 LoggerInstance.logger.info("Get the tool tip value");
		    googleTooltip = toolTipObject.getAttribute("title");
			return googleTooltip;
		}
	  catch(Exception e) {
		  LoggerInstance.logger.info("Not able to get the tool tip value");
			return googleTooltip;
					
		  }
	}
	
	
	/* Method Name: switchFrame
     * Description:This method will switch the iframe
     * Parameters: 
     *            1. Webdriver instance 
                  2. Frame id or name
                               
     * Created By: Aman Saraf Jain
     * Created Date: 11-09-2014
     * */  

    public static void switchFrame(WebDriver driver,String frameid) {
          try {
              driver.switchTo().frame(frameid);
              LoggerInstance.logger.info("Frame switched");
              }
          catch (Exception e) {
              LoggerInstance.logger.info("Unable to switch frame");
          }

  }
    
    /* Method Name: switchDefaultFrame
     * Description:This method will switch the iframe
     * Parameters: 
     *            1. Webdriver instance 
                               
     * Created By: Aman Saraf Jain
     * Created Date: 11-09-2014
     * */  

    
    public static void switchDefaultFrame(WebDriver driver) {
          try {
              driver.switchTo().defaultContent();
              }
          catch (Exception e) {
              LoggerInstance.logger.info("Unable to switch frame");
          }
  } 

	
	
	
	   /* Class Name    : WebDriverBrowser
		* Method Name   : getWebDriver 
		* Description   : This method will return WebDriver object depending on browser type.
		* Parameters    : 1. broswerName : Browser Name as String 
		* Created By    : Kuldeep Singh 
		* Created Date  : 11-08-2014
		*/
	
	public static WebDriver getWebDriver(String browserName) {
        driver =null;
       // browserName = 
		try {   
	        switch(browserName) {
	        case "firefox":
	        	LoggerInstance.logger.info("Firefox browser is initialized");
	        	 driver = new FirefoxDriver(); 
	        	break;
	        case "chrome" :
	        	LoggerInstance.logger.info("Crome browser is initialized");
	        	System.setProperty("webdriver.chrome.driver", "");
	        	break;
	        case "ie" :
	        	LoggerInstance.logger.info("Internet Explorer browser is initialized");
	        	driver = new InternetExplorerDriver();
	        	break;
	        }
        } catch (Exception e) {
        		LoggerInstance.logger.info("Browser is not initialized");
        }
        	return driver;
      }


	/*
     * Method Name    : clickWebLink 
     * Description    : This method will click on web link.
     * Parameters     : 1. btnWebElement : Webelement for web link xpath 
     * Created By     : Kuldeep Singh 
     * Created Date   : 11-08-2014
     */

     public static void clickWebLink(WebElement webLinkWebElement) {
           try {
                 if (webLinkWebElement.isEnabled()) {
//                	 LoggerInstance.logger.info("Click on"+webLinkWebElement.getText());
                     webLinkWebElement.click();
                 }
           } catch (Exception e) {
        	   		LoggerInstance.logger.info("Not able to click on Weblink");
           }
     }

	/*
	 * Method Name   : clickButton 
	 * Description   : This method will click on button.
	 * Parameters    : 1. btnWebElement : Webelement for button xpath 
	 * Created By    : Kuldeep Singh 
	 * Created Date  : 11-08-2014
	 */

      public void clickButton(WebElement btnWebElement) {
            try {
                  if (btnWebElement.isEnabled()) {
                	  LoggerInstance.logger.info("click on "+btnWebElement);
                      btnWebElement.click();
                                   }
            } catch (Exception e) {
            		LoggerInstance.logger.info("Unable to click on "+btnWebElement);
            }
      }

	  
	/* Method Name: waitTillElementPresent
	 * Description: This function will wait for a pre-defined time until an element is present on the DOM of a page.
	 * Parameters: 
	 *	1.	sDriver � variable name used for driver 
	 *	2.	iTimeOut � value in seconds for pre-defined time, function will wait for
     *	3.	sIdentifier � variable for identifier type by which object will be located
	 *	4.	wElement - variable for identifier value by which object will be located
	 * Created By: Darwin Bhandari
	 * Created Date: 12-08-2014
	 * */

public static void waitTillElementPresent(WebDriver driver, int iTimeOut, By byVal) {
		try {
			LoggerInstance.logger.info("wait for Element to present");
			WebDriverWait wait = new WebDriverWait(driver, iTimeOut);
			wait.until(ExpectedConditions.presenceOfElementLocated(byVal));
		    }
		catch (Exception e) {
			LoggerInstance.logger.info("Element is not present");
		}

}	
	/* Method Name: waitTillElementVisible
	 * Description: This function will wait for a pre-defined time till an element is visible on web page.
					Visibility means that the element is not only displayed but also has a height and width that is greater than 0
	 * Parameters: 
	 *	1.	sDriver � variable name used for driver 
	 *	2.	iTimeOut � variable for pre-defined time, function will wait for
	 *	3.	sIdentifier � variable for identifier type by which object will be located
	 *	4.	wElement - variable for identifier value by which object will be located
	 * Created By: Darwin Bhandari
	 * Created Date: 12-08-2014
	 * */

public static void waitTillElementVisible(int iTimeOut, By byVal) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, iTimeOut);
			LoggerInstance.logger.info("wait for Element to Visible");
			wait.until(ExpectedConditions.visibilityOfElementLocated(byVal));
		    }
		catch (Exception e) {
			LoggerInstance.logger.info("Element is not Visible");
		}
}

	/* Method Name: readCellValue
	 * Description: This function will fetch the cell value
	 * Parameters: 
	 *	1.	xls or xlsx file path
	 *	2.	Sheet name
	 *	3.	Row number
	 *	4.	Column number
	 * Created By: Aman Saraf Jain
	 * Created Date: 12-08-2014
	* */

//Way to Call function :  readcellvalue("D:\\testfolder\\test.xlsx","sheet1",52,4);


 	public static String readCellValue(String excelFilepath,String sheetName,int rowNum,int colNum) throws IOException {
		/*	InputStream ExcelFileToRead = new FileInputStream(excelFilepath);
			XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
			XSSFSheet sheet=wb.getSheet(sheetName);
			XSSFCell cell = null;
			String cellvalue=null;
		try{
			cellvalue = sheet.getRow(rowNum-1).getCell(colNum-1).toString();
			LoggerInstance.logger.info("return cell value");
			return cellvalue;
		}
		catch(Exception e){
			LoggerInstance.logger.info("unable to fetch the value for required cell");
			return cellvalue;
	  }*/
		String cellvalue=null;
		return cellvalue;	
}

	/* Method Name: waitTillElementEnable
     * Description: This function will wait for a pre-defined time untill an element is enable on the DOM of a page.
     * Parameters:  
	 *	1. iTimeOut � value in seconds for pre-defined time, function will wait for
	 *	2. byVal: By Type variable
     * Created By: Darwin Bhandari
     * Created Date: 13-08-2014
     * */

public static void waitTillElementEnable(int iTimeOut, By byVal) {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, iTimeOut);
			LoggerInstance.logger.info("Wait for element to enabled.");
			wait.until(ExpectedConditions.elementToBeClickable(byVal));
		    }
		catch (Exception e) {
			LoggerInstance.logger.info("Element is not enabled.");
		}
}
	/* Method Name: waitTillPageLoaded
       * Description: 
        *            This function will wait for a pre-defined time till page is loaded completely
        * Parameters: 
		*	1.	sDriver � variable name used for driver 
		*	2.	iTimeOut � variable for pre-defined time, function will wait for
       * Created By: Darwin Bhandari
       * Created Date: 13-08-2014
       * */

  	public void waitTillPageLoaded(int iTimeOut) {
                ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>(){     
              public Boolean  apply(WebDriver driver){
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
               }
             };
                FluentWait<WebDriver> wait = new WebDriverWait(driver, iTimeOut);
             try {
                wait.until(expectation);
             } catch (Exception e) {
            	LoggerInstance.logger.info("Unable to wait till page load");
          }
        }
  	

	/* Method Name: 
	       * Description: verifyElementColor
	        *            This method will return the color of the element.
	        * Parameters: 
	        *            1. WebElement object identifier  - Get the locator value.
	        *            2. Color code.
	       * Created By: Sunny Jain
	       * Created Date: 14-08-2014
	       * */
	public static boolean verifyElementColor(WebElement webelement, String colorcode) {
		
		try{
			
			String rgb = webelement.getCssValue("color");
			if (rgb==colorcode){
				LoggerInstance.logger.info("Actual color is same as expected color");
				return true;
			}
			else {
				LoggerInstance.logger.info("Actual color is not same as expected color");
				return false;
			}
		} catch(Exception e) {
				LoggerInstance.logger.info("Unable to verify the color");
				return false;
	  }
			
	}			

	/* Method Name: 
	       * Description: navigateToPage
	       *            This method to navigate to page url.
	       * Parameters: 
	       *            1. Url of the page.
	       * Created By: Sunny Jain
	       * Created Date: 14-08-2014
	       * */

	public static void navigateToPage(String url){
			try{
				driver.get(url);
				LoggerInstance.logger.info("Navigate to"+url);
			  
			} catch(Exception e) {
				LoggerInstance.logger.info("Unable to navigate to"+url);
			}
			
		}

	
	/* Method Name: selectItemFromWeblist
	       * Description: This method will select the value from weblist.
	       * Parameters: 
	       *            1. WebElement object identifier  - Get the locator value.
	                    2. TextValue  - to select particular value from weblist
	       * Created By: Sunny Jain
	       * Created Date: 12-08-2014
	       * */

	public static void selectItemFromWeblist(WebElement webelement,String textValue) {
		try{
  		    	Select selectElement = new Select(webelement);
  		    	LoggerInstance.logger.info("select " +textValue+ "value from the dropdown");
  		    	selectElement.selectByVisibleText(textValue);
		        
			} catch(Exception e) {
			  	LoggerInstance.logger.info("unale to select " +textValue+ "value from the dropdown");
			  
		  }
		
	} 

	/* Method Name: getContentFromWebList
	       * Description: This method will select the value from weblist.
	       * Parameters: 
	       *            1. WebElement object identifier  - Get the locator value.
	       * Created By: Sunny Jain
	       * Created Date: 12-08-2014
	       * */

	public static List<String> getContentFromWebList(By ByValue) {
		
		List <String> webList = new ArrayList <String>();
		
		try {
			 WebElement element = driver.findElement(ByValue);
			 Select selectElement = new Select(element);
			 List <WebElement> theseOptions = selectElement.getOptions();
			 int i = selectElement.getOptions().size();
		     
	         for(int k = 1; k<i; k++) {
	        	 webList.add(theseOptions.get(k).getText());
		     }  
	         LoggerInstance.logger.info("return weblist");
	         return  webList;
		} 
		catch(Exception e) {
			LoggerInstance.logger.info("unable to return weblist");
			webList= null;
			return  webList;
		   
	  }
}


	/* Method Name: enterValueInTextBox
	 * Description: This method will select the value from weblist.
	 * Parameters: 
	 *            1. WebElement object 
	 *            2. String 
	 * Created By: 
	 * Created Date: 12-08-2014
	 * */
	public static void enterValueInTextBox(WebElement element,String text){
    
	    try{
	    	element.clear();
	    	LoggerInstance.logger.info("Enter value "+text+" in text box");
	        element.sendKeys(text);
	    }catch(AssertionError ae) {
	        LoggerInstance.logger.info("failed to insert value in TextBox ");
	          
	    }
    
}

	/* Method Name: exampleInputRadio
	 * Description: This method will click on the radio button.
	 * Parameters: 
	 *            1. WebElement List 
	 *            2. index of radio button
	 * Created By: 
	 * Created Date: 12-08-2014
	 * */
 
	public static void selectRadioButton(List<WebElement> elementList, int optionval) {
	    try
			{
	    		List<WebElement> radios = elementList;
				if (optionval > 0 && optionval <= radios.size()) {
				LoggerInstance.logger.info("Select radio Button");
				radios.get(optionval - 1).click();                        
	             } 
			} catch (Exception e) {
				LoggerInstance.logger.info("Unable to select radio Button");
	           }
	}

	/* Method Name: checkingCheckbox
	 * Description: This method will check the check box .
	 * Parameters: 
	 *            1. WebElement object
	 * Created By: 
	 * Created Date: 12-08-2014
	 * */
	public static void checkingCheckbox(WebElement element)
	{  
	      
	      try
	      {
			boolean checkstatus;  
			checkstatus=element.isSelected();  
			if (checkstatus==true){  
			    LoggerInstance.logger.info("Checkbox is already checked");
			   }  
			else {  
			   element.click();  
			   	LoggerInstance.logger.info("Checked the checkbox");
			}  
		} catch(Exception e) {
				LoggerInstance.logger.info("unable to check the check box");
			}
	}

	/* Method Name: unCheckingCheckbox
	 * Description: This method will uncheck the check box .
	 * Parameters: 
	 *            1. WebElement object
	 * Created By: 
	 * Created Date: 12-08-2014
	 * */

	public void unCheckingCheckbox(WebElement element) {  
	    try
	    {
			boolean checkstatus;  
			checkstatus=element.isSelected();  
			if (checkstatus==true){  
			    element.click();  
			    LoggerInstance.logger.info("Checkbox is unchecked");    
			}  
			else  
			{  
			    LoggerInstance.logger.info("Checkbox is already unchecked");
			}  
	    } catch(Exception e) {
	          	LoggerInstance.logger.info("Unable to uncheck the checkbox");
	    }
	}

	/* Method Name: verifyTextWebelement
	 * Description: This method will verify text of webelement
	 * Parameters: 
	 * 				1. String to compare
	 *            	2. WebElement object
	 * Created By: 
	 * Created Date: 12-08-2014
	 * */

	public  static boolean  verifyTextWebelement(String text, WebElement element)
	
	{
		try
		{
			String stringverify=element.getText();
		if (stringverify.equals(text)){
			return true;
			}
		else {
			return false;}
		}catch(Exception e)
		{
			LoggerInstance.logger.info("Unable to verify the text");
			return false;
		}
	}

	/* Method Name: verifyStringsAreSame
	 * Description: This method will verify  two Strings are same or not
	 * Parameters: 
	 * 				1. String 1 to compare
	 *            	2. String 2 to compare
	 * Created By: Rohit Miglani
	 * Created Date: 24-08-2014
	 * */
public  static boolean  verifyStringsAreSame(String text1, String text2)
	
	{
		try
		{
		if (text1.equals(text2)){
			LoggerInstance.logger.info("Strings are same");
			return true;}
		else {
			LoggerInstance.logger.info("Strings are not same");
			return false;}
		}catch(Exception e)
		{
			LoggerInstance.logger.info("Unable to verify String are same or not");
			return false;
		}
	}
	/* Method Name: isTextPresent
	 * Description: This method will check that text is present on the page.
	 * Parameters: 
	 *            1. WebElement object
	 *            2. String
	 * Created By: 
	 * Created Date: 12-08-2014
	 * */


public static boolean isTextPresent(WebDriver driver, String txtValue) {
       
       boolean result = false;
	     try{
	    	 result = driver.getPageSource().contains(txtValue);
	         LoggerInstance.logger.info("Text is present on the page");
	          }
	     catch (Exception e){
	    	 LoggerInstance.logger.info("Unable to find the text on the page");
	     } 
	      return result;
	     
	}

	/* Method Name: clickMenuItem
	 * Description: This function will click on Sub menu item of the main link.
	 * Parameters: Function accepts 3 parameters
	 * 		1. WebDriver Object- Page on which the menu exists
	 * 		2. mainLink: WebElement- This is the main menu link of Web Element type
	 * 		3. subLink: WebElemet- This is the link that exists under the main menu 
	 * Created By: Bal Govind
	 * Created Date: 08-08-2014
	 * */

	public static void clickMenuItem(WebDriver driver, WebElement mainLink, WebElement subLink) {
		try {
			
			Actions actions = new Actions(driver);
						
				if(mainLink !=null && mainLink.isDisplayed()) {
					actions.moveToElement(mainLink).build().perform();
					Thread.sleep(3000);
					if(subLink !=null && mainLink.isDisplayed()) {
						actions.moveToElement(subLink).build().perform();
						actions.moveToElement(subLink).click().build().perform();
					} else {
						LoggerInstance.logger.info("Unable to click on sublink");
					}
				}
	    } catch (Exception e) {
	    	LoggerInstance.logger.info("Unable to navigate to sublink");
	    }
	}

	/* Method Name: webPageName
	 * Description: 
	 * 		This method will return the WebPage name i.e. title
	 * Parameters: 
	 * 		1. WebDriver Object- Page for which we need the name/title
	 * Created By: Bal Govind
	 * Created Date: 08-08-2014
	 * */

	public String webPageName() {
		String pageTitle=null;
		try {
			pageTitle = driver.getTitle();
			LoggerInstance.logger.info("Get the page name");
		} catch (Exception e) {
			LoggerInstance.logger.info("Unable to get the page name");
		}
		return pageTitle;
	}
	
	/* Method Name: scrollPage
	 * Description: 
	 * 		It will scroll down or scroll up the page according to the parameter
	 * Parameters: Function accepts 3 parameters
	 * 		1. WebDriver Object- Page which needs to scroll
	 * 		2. scrollCase- as a String; Accepted values are "UP" and "DOWN"
	 * 		3. pixelToScroll-  as an Integer; Pixels to scroll the web page up/down 
	 * Created By: Bal Govind
	 * Created Date: 08-08-2014
	 * */
	
	public void scrollPage(String scrollCase, int pixelToScroll) {
		try {
				JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
				switch(scrollCase) {
				case "DOWN":
						//Scrolled page down
						jsExecutor.executeScript("scrollBy(0," + pixelToScroll + ")");
						break;
				case "UP":
						//Scrolled page up	
						jsExecutor.executeScript("scrollBy(0," + -pixelToScroll + ")");
						break;
				}
		} 
		catch (Exception e) {
				LoggerInstance.logger.info("Unable to Scroll the page");
		}
		
	}
	
	/* Method Name: verifyImage
	 * Description: 
	 * 		It will verify the logo of application
	 * Parameters: Function accepts 3 parameters
	 * 		1. byVal- this is of By type
	 * 		2. dynamicLogoPath- String: This is the path of logo capture at runtime
	 * 		3. staticLogoPath-  String: This is the path of logo with which we need to compare 
	 * Created By: Bal Govind
	 * Created Date: 08-08-2014
	 * */
	
	public static boolean verifyImage(WebElement imageElement, String staticImagePath) throws IOException {
		try {
		
		Properties prop = new Properties();
		InputStream inputConfig = new FileInputStream(AutomationConstants.PROPERTY_FILE_NAME);
		prop.load(inputConfig);
		
		String folder = prop.getProperty(AutomationConstants.SCREENSHOT_FOLDER);
		
		File directory = new File ("");
		
		String absolutepath	=	directory.getAbsolutePath();
		
		//This is to get location for creating log file. This value is comming from build.xml 
		String snapshotFolder = absolutepath+File.separator+folder;
		
		File f1 = new File(snapshotFolder);
		
		if(!f1.exists())
			f1.mkdir();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String logoDirName = dateFormat.format(date);
		
		File currentDateSnapshot = new File(snapshotFolder + "\\" + logoDirName);
		if(!currentDateSnapshot.exists())
			currentDateSnapshot.mkdir();
		
		
		
		int imageCount = currentDateSnapshot.list().length + 1;
		String imageName = "Logo" + imageCount;
		String imagePath = currentDateSnapshot + "\\" + imageName + ".png";
		
		
		//WebElement appLogo = driver.findElement(By);
		
		String ul =imageElement.getAttribute("src");
		
		URL url = new URL(ul);
		
		BufferedImage bufferedImage = ImageIO.read(url);
		ImageIO.write(bufferedImage, "jpg", new File(imagePath));
		
		Image imgStaticLogo = Toolkit.getDefaultToolkit().getImage(staticImagePath);
		Image imgDownloadedLogo = Toolkit.getDefaultToolkit().getImage(imagePath);
		
		
			PixelGrabber grab11 = new PixelGrabber(imgStaticLogo, 0, 0, -1, -1, false);
			PixelGrabber grab21 = new PixelGrabber(imgDownloadedLogo, 0, 0, -1, -1, false);
					
			int[] array1= null;
	
		    if (grab11.grabPixels()) {
		     int widthPic1 = grab11.getWidth();
		     int heightPic1 = grab11.getHeight();
		     array1= new int[widthPic1 * heightPic1];
		     array1= (int[]) grab11.getPixels();
		    }
		    
		    int[] array2 = null;
	
		    if (grab21.grabPixels()) {
		     int widthPic2 = grab21.getWidth();
		     int heightPic2 = grab21.getHeight();
		     array2 = new int[widthPic2 * heightPic2];
		     array2 = (int[]) grab21.getPixels();
		    }
		    
		    //LoggerInstance.logger.info("Compare Image");
		    
		    System.out.println(java.util.Arrays.equals(array1, array2) ? true : false);
		    return (java.util.Arrays.equals(array1, array2) ? true : false);
			} catch (Exception e) {
				LoggerInstance.logger.info("Unable to compare the img.");
				return false;
			}
		}
	
	
	/* Method Name: getCalendarCurrentMonthAndYear
	 * Description: This method will return current month and year
	 * Parameters: No parameters
	 * Created By: 
	 * Created Date: 08-08-2014
	 * */
	public static String getCalendarCurrentMonthAndYear() {
		String currentMonthAndYear = null;
		try {
			String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
			Calendar cal = Calendar.getInstance();
			String month = monthName[cal.get(Calendar.MONTH)];
			String year = cal.get(Calendar.YEAR) + "";
			currentMonthAndYear = month + " " + year;
			LoggerInstance.logger.info("Get the current month and year");
		} catch (Error e) {
			LoggerInstance.logger.info("Unable to get the current month and year");
		}
		return currentMonthAndYear;
	}
	
	/* Method Name: getrgbaColor
     * Description:This method will return background color .
      * Parameters: 
      *            1. WebElement divColorWebElement
     * Created By: Kuldeep Singh
     * Created Date: 21-08-2014
     * */
	
	public static String getrgbaBackgroundColor(WebElement divColorWebElement) {
		try {
			String text = divColorWebElement.getCssValue("background-color").toString();
			// Split css value of rgb
			String[] numbers = text.replace("rgba(", "").replace(")", "").split(",");
			int number1 = Integer.parseInt(numbers[0]);
			numbers[1] = numbers[1].trim();
			int number2 = Integer.parseInt(numbers[1]);
			numbers[2] = numbers[2].trim();
			int number3 = Integer.parseInt(numbers[2]);
			String hex = String.format("#%02X%02X%02X", number1, number2, number3);
			return hex;
		} catch (Exception e) {
			LoggerInstance.logger.info("Unable to get the back griund colcor");
			return "";
		}
	}
	
	/* Method Name: getrgbaColor
     * Description:This method will return color of the element in hexadecimal value.
      * Parameters: 
      *            1. WebElement divColorWebElement
     * Created By: Kuldeep Singh
     * Created Date: 21-08-2014
     * */
	
	public static String getrgbaColor(WebElement divColorWebElement) {
		try {
			String text = divColorWebElement.getCssValue("color").toString();
			// Split css value of rgb
			String[] numbers = text.replace("rgba(", "").replace(")", "").split(",");
			int number1 = Integer.parseInt(numbers[0]);
			numbers[1] = numbers[1].trim();
			int number2 = Integer.parseInt(numbers[1]);
			numbers[2] = numbers[2].trim();
			int number3 = Integer.parseInt(numbers[2]);
			String hex = String.format("#%02X%02X%02X", number1, number2, number3);
			return hex;
		} catch (Exception e) {
			LoggerInstance.logger.info("Unable to get the back griund colcor");
			return "";
		}
	}
	/* Method Name: getMonthIntValue
     * Description:This method will return month number by passing month name.
      * Parameters: 
      *            1. String month name
     * Created By: 
     * Created Date: 21-08-2014
     * */
	
	public static int getMonthIntValue(String month) {
		int monthIndex = 0;
		try {
			String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
			for (String string : monthName) {
				monthIndex++;
				if (string.equals(month)) {
					LoggerInstance.logger.info("Return Month index");
					return monthIndex;
				}
			}
		} catch (Error e) {
			LoggerInstance.logger.info("Unable to return Month index");
			return monthIndex;
		}
		return monthIndex;
	}
	
	
	
	/* Method Name: 
	       * Description:This method will check list is sorted in ascending or descending order
	       * Parameters: 
	       *            1. String list  - provide list value.
	                    2. sortedBy- True (It will check list provided is in ascending order)
	                                  False(It will check list provided is in descending order)
	       * Created By: Aman Saraf Jain
	       * Created Date: 21-08-2014
	       * */
	 public static Boolean checkSortingOrder(List<String> list,Boolean sortedby){
		           
		        try {
		        	if(list == null || list.isEmpty())
		                {
		        			LoggerInstance.logger.info("Provided list is empty");
		        			return false;
		                }           
		        	if(list.size() == 1)  {
		        			LoggerInstance.logger.info("List is sorted as it has only one element");
		        			return true;
		        		}
		            for(int i=1; i<list.size();i++)
		            {
		                String current = list.get(i).toString();
		                String previous = list.get(i-1).toString();
		                if (sortedby==true){
		                              if(current.compareTo(previous)<0){
		                              LoggerInstance.logger.info("List is not in acsending order");  
		                            return false;
		                              }
		                    }
		                if (sortedby==false) {
		                       if(current.compareTo(previous)>0){
		                            LoggerInstance.logger.info("List is not in desending order"); 
		                            return false;
		                       }
		                }
		               }
		            if (sortedby==true){
		            	LoggerInstance.logger.info("List is in acsending order");  
		            return true;}
		            else {
		            	LoggerInstance.logger.info("List is not in desending order");
		            	return false;
		            }
		            
		  
		        }
		        catch(Exception e){
		        	LoggerInstance.logger.info("Unable to check the acsending/desending ");
		            return null;
		        }
		        
	 	}
	 /* Method Name: getHeaderListOfTable
	     * Description: 
	     *            function to get all List of the table Header by passing Xpath of the table header to it.
	     * Parameters: 
	     *            1. xpath of table header and driver
	     * Created By: Rohit Miglani
	     * Created Date: 08-08-2014
	     * */
		  public static List<String> getHeaderListOfTable(WebDriver driver, String xpathOfTableHeader)
		  {
			  	List<String> List_HeaderOfTable = null;
		    	List<WebElement> List_TableHeaderFields=null;
		    	try
		    	{
		    		
		    		List_TableHeaderFields= driver.findElements(By.xpath(xpathOfTableHeader));
		    		int size= List_TableHeaderFields.size();
		    		for (int i=0; i<size; i++)
		    		{
		    			List_HeaderOfTable.add(List_TableHeaderFields.get(i).getText());
		    		}
		    		LoggerInstance.logger.info("Return List");
		    	    return List_HeaderOfTable;
		    	}
		    	
		    	catch (Exception ex)
		    	{
					LoggerInstance.logger.info("Can not able to Return List of table header");
				    return List_HeaderOfTable;
			    }   	
		    	
		 }	//End of Function
		  
		  /* Method Name: getHeaderListOfTable
		     * Description: 
		     *            function to get all value of the table column by passing Xpath of the table and index of that column.
		     * Parameters: 
		     *            1. xpath of table and driver
		     *            2. index of column
		     * Created By: Rohit Miglani
		     * Created Date: 08-11-2014
		     * */
		
		  public static List<String> getListOfElementForColumn(WebDriver driver, String xpathOfTable, Integer indexOfColumn)
		  {
		    	List<String> List_AllRowsForColumn=null;
		    	List<WebElement> List_ColumnOfTable=null;
		    	try
		    	{
		    		String xpathOFColumn=xpathOfTable+"//tr/td["+indexOfColumn+"]";
		    		List_ColumnOfTable= driver.findElements(By.xpath(xpathOFColumn));
		    		int size= List_ColumnOfTable.size();
		    		for (int i=0; i<size; i++)
		    		{
		    		  		List_AllRowsForColumn.add(List_ColumnOfTable.get(i).getText());
			    	}
		    		LoggerInstance.logger.info("Return List of all the rows for particulat column");
		    		return List_AllRowsForColumn;
		    	}
		    	
		    	catch (Exception ex)
		    	{
					LoggerInstance.logger.info("Can not able to Return List of all the rows for particulat column");
				    return List_AllRowsForColumn;
			    }   	
		    	
		 }	//End of Function
		  
		  /* Method Name: checkDateSortingOrder
	       * Description:This method will check date list is sorted in ascending or descending order
	       * Parameters: 
	       *            1. String list  - provide date list value.
	                    2. sortedBy- True (It will check list provided is in ascending order)
	                                  False(It will check list provided is in descending order)
	       * Created By: Kuldeep Singh
	       * Created Date: 27-08-2014
	       * */
	public static Boolean checkDateSortingOrder(List<String> list, Boolean sortedby) {
		DateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			if (list == null || list.isEmpty()) {
				LoggerInstance.logger.info("Provided list is empty");
				return false;
			}
			if (list.size() == 1) {
				LoggerInstance.logger.info("List is sorted as it has only one element");
				return true;
			}
			for (int i = 1; i < list.size(); i++) {
				String current = list.get(i).toString();
				String previous = list.get(i - 1).toString();
				Date currentDate = format.parse(current);
				Date previousDate = format.parse(previous);
				if (sortedby == true) {
					if (currentDate.compareTo(previousDate) < 0) {
						LoggerInstance.logger.info("List is not in acsending order");
						return false;
					}
				}
				if (sortedby == false) {
					if (currentDate.compareTo(previousDate) > 0) {
						LoggerInstance.logger.info("List is not in desending order");
						return false;
					}
				}
			}
			if (sortedby == true) {
				LoggerInstance.logger.info("List is in acsending order");
				return true;
			} else {
				LoggerInstance.logger.info("List is in desending order");
				return true;
			}

		} catch (Exception e) {
			LoggerInstance.logger.info("Unable to check the acsending/desending");
			return null;
		}

	}
	
	/* Method Name: captureScreenshot
     * Description:This method will capture the screenshot of the screen
     * Parameters: 
     *            
     * Created By: Bal Govind
     * Created Date: 05-09-2014
     * */
	
	public String captureScreenshot() throws AWTException, IOException
	{
		Properties prop = new Properties();
		InputStream inputConfig = new FileInputStream(AutomationConstants.PROPERTY_FILE_NAME);
		prop.load(inputConfig);
		
		String folder = prop.getProperty(AutomationConstants.SCREENSHOT_FOLDER);
		
		File directory = new File ("");
		
		String absolutepath	=	directory.getAbsolutePath();
		
		//This is to get location for creating log file. This value is comming from build.xml 
		String snapshotFolder = absolutepath+File.separator+folder;
		
		System.out.println(snapshotFolder + "Snapshot");	
		File f1 = new File(snapshotFolder);
		
		if(!f1.exists())
			f1.mkdir();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String snapshotDirName = dateFormat.format(date);
		File currentDateSnapshot = new File(snapshotFolder + "\\" + snapshotDirName);
		if(!currentDateSnapshot.exists())
			currentDateSnapshot.mkdir();
		
		
		boolean isSnapshotTaken = false;
		boolean isFileCreated = false;

		int imageCount = currentDateSnapshot.list().length + 1;
		String imageName = "Snapshot" + imageCount;
		String imagePath = currentDateSnapshot + "\\" + imageName + ".png";
		
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect);
		isSnapshotTaken = ImageIO.write(capture, "png", new File(imagePath));
		System.out.println(isSnapshotTaken == true ? "Snapshot is taken." : "Snapshot is not taken.");
		
		return imagePath;
		
	}
	
	
	/* Method Name: 
     * Description: verifyTextColor
      *            This method will return the color of the text.
      * Parameters: 
      *            1. WebElement object identifier  - Get the locator value.
      *            2. Color code.
     * Created By: Darwin
     * Created Date: 14-08-2014
     * */

     public static boolean verifyTextColor(WebElement webelement, String colorcode) {
     
try {
     if (webelement.isDisplayed()){
     String text = webelement.getCssValue("color").toString();
     // Split css value of rgb
     String[] numbers = text.replace("rgba(", "").replace(")", "").split(",");
     int number1 = Integer.parseInt(numbers[0]);
     numbers[1] = numbers[1].trim();
     int number2 = Integer.parseInt(numbers[1]);
     numbers[2] = numbers[2].trim();
     int number3 = Integer.parseInt(numbers[2]);
     String hex = String.format("#%02X%02X%02X", number1, number2, number3);
     if (hex.equals(colorcode)){
            LoggerInstance.logger.info("color verified and found same");
            return true;
     }
     else{
            LoggerInstance.logger.info("color verified and found not same");
            return false;
            }
     }
     else {
            LoggerInstance.logger.info("Element is not displayed");
            return false;
     }
} catch (Exception e) {
     System.out.println(e.getMessage());
     
     LoggerInstance.logger.info("Unable to get the back ground colcor");
     LoggerInstance.logger.info(e.getMessage());
     return false;
     }
}

}