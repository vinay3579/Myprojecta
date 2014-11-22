package PageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import FunctionLibraries.FunctionLibrary;
import Logger.LoggerInstance;

public class ResourcesPage {

	private final String XPath_ResourceTab = "//*[@id='menu-wrapper']/ul/li[7]/a";
	private final String csspath_GeneralEconomicIndicators = "#aspnetForm>div>div>div>div>div>div>h2";
	private final String csspath_CCilIndicatorsIndices = "#aspnetForm>div>div>div>div>div>div>h2";
	private final String csspath_NSEFIMMDAIndicators = "#aspnetForm>div>div>div>div>div>div>h2";
	private final String csspath_IndicatorName = ".bordered>thead>tr>th";
	private final String csspath_RBIPolicyIndicators = ".bordered>thead>tr>th";
	private final String csspath_RBIReferExchRates = ".bordered>thead>tr>th";

	private final String csspath_Key_Economic_Indicators = ".DashboardTitle";
	@FindBy(xpath = XPath_ResourceTab)
	public WebElement we_ResourceTab;
	@FindBy(css = csspath_Key_Economic_Indicators)
	public WebElement we_Key_Economic;
	@FindBy(css = csspath_GeneralEconomicIndicators)
	public WebElement we_GeneralEconomicIndicators;
	@FindBy(css = csspath_CCilIndicatorsIndices)
	public WebElement we_CCilIndicatorsIndices;
	@FindBy(css = csspath_NSEFIMMDAIndicators)
	public WebElement we_NSEFIMMDAIndicators;
	@FindBy(css = csspath_IndicatorName)
	public WebElement we_IndicatorName;
	@FindBy(css = csspath_RBIPolicyIndicators)
	public WebElement we_RBIPolicyIndicators;
	@FindBy(css = csspath_RBIReferExchRates)
	public WebElement we_RBIReferExchRates;

	
	/* Method Name: Function to click on Resource Tab
     * Description: 
     * Created By: Mohd Suhail
     * Created Date: 13-08-2014
     * */
	public void clickOnResourceTab() {
		try {

			LoggerInstance.logger.info("click on Resource Tab");
			FunctionLibrary.clickWebLink(we_ResourceTab);

		} catch (Exception e) {
			LoggerInstance.logger.info("Not able to click on Resource Tab");
		}
	}

	
	/* Method Name: KeyEconomic Indicators Page is Displayed
     * Description: Verify SubTab KeyEconomic Indicators Page is Displayed
     * Created By: Mohd Suhail
     * Created Date: 13-08-2014
     * */
	public Boolean verify_KeyEconomic() {
		boolean result = false;
		try {
			result = we_Key_Economic.isDisplayed();
			if (result == true)
				LoggerInstance.logger.info("Key_Economic is displayed.");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("Key_Economic is not displayed.");
			return result;
		}
	}

	

	/* Method Name: GeneralEconomicIndicators is displayed
     * Description: Verify  GeneralEconomicIndicators is displayed
     * Created By: Mohd Suhail
     * Created Date: 13-08-2014
     * */

	public Boolean verify_GeneralEconomicIndicatorsIsDisplayed() {
		boolean result = false;
		try {
			result = we_GeneralEconomicIndicators.isDisplayed();
			if (result == true)
				LoggerInstance.logger
						.info("GeneralEconomicIndicators is displayed.");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger
					.info("GeneralEconomicIndicators is not displayed.");
			return result;
		}
	}

	
	/* Method Name: Verify CCilIndicatorsIndices is displayed
     * Description: Verify  CCilIndicatorsIndices is displayed
     * Created By: Mohd Suhail
     * Created Date: 13-08-2014
     * */
	public Boolean verify_CCilIndicatorsIndicesIsDisplayed() {
		boolean result = false;
		try {
			result = we_CCilIndicatorsIndices.isDisplayed();
			if (result == true)
				LoggerInstance.logger
						.info("CCilIndicatorsIndices is displayed.");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger
					.info("CCilIndicatorsIndices is not displayed.");
			return result;
		}
	}

	
	
		/* Method Name:  NSE FIMMDA Indicators is displayed 
	     * Description: Verify  NSE FIMMDA Indicators is displayed 
	     * Created By: Mohd Suhail
	     * Created Date: 13-08-2014
	     * */
	public Boolean verify_NSEFIMMDAIndicatorsIsDisplayed() {
		boolean result = false;
		try {
			result = we_NSEFIMMDAIndicators.isDisplayed();
			if (result == true)
				LoggerInstance.logger.info("NSEFIMMDAIndicators is displayed.");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger.info("NSEFIMMDAIndicators is not displayed.");
			return result;
		}
	}
	

	/* Method Name: General Economic Contains Indicator Name Column
     * Description: Verify General Economic Contains Indicator Name
     * Created By: Mohd Suhail
     * Created Date: 13-08-2014
     * */

	public Boolean verify_GeneralEconomicContainsIndicator() {

		boolean result = false;

		result = we_IndicatorName.isDisplayed();
		try {
			if (result == true)

				LoggerInstance.logger
						.info("General Economic Contains IndicatorName Column.");
			return result;

		} catch (Exception e) {
			LoggerInstance.logger
					.info("GeneralEconomicIndicators does not contains IndicatorName Column.");
			return result;
		}
	}

	
	/* Method Name: General Economic Contains RBI Policy Indicator Column.
     * Description: General Economic Contains RBI Policy Indicator.
     * Created By: Mohd Suhail
     * Created Date: 13-08-2014
     * */

	public Boolean verify_GeneralEconomicContainsRBIPolicyIndicator() {

		boolean result = false;

		result = we_RBIPolicyIndicators.isDisplayed();
		try {
			if (result == true)
				LoggerInstance.logger
						.info("General Economic Contains RBI Policy Indicator Column.");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger
					.info("GeneralEconomicIndicators does not contains RBI Policy Indicator Column.");
			return result;
		}
	}

	
	/* Method Name: General Economic Contains RBI Reference Exchange Rates Column.
     * Description: General Economic Contains RBI Reference Exchange Rates.
     * Created By: Mohd Suhail
     * Created Date: 13-08-2014
     * */

	public Boolean verify_GeneralEconomicContainsRBIReferenceExchange() {

		boolean result = false;
		try {
			result = we_RBIReferExchRates.isDisplayed();
			if (result == true)

				LoggerInstance.logger
						.info("General Economic Contains RBI Reference Exchange Rates Column.");
			return result;
		} catch (Exception e) {
			LoggerInstance.logger
					.info("GeneralEconomicIndicators does not contains RBI Reference Exchange Rates Column.");
			return result;
		}

	}

}
