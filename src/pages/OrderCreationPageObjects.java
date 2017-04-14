package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusable.ResuableFunction;

public class OrderCreationPageObjects {

	WebDriver driver;
	WebDriverWait wait, wait1;
	boolean isDateSelected;

	public OrderCreationPageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 40);
	}

	@FindBy(how = How.LINK_TEXT, using = "Send a Release")
	WebElement SendReleaseLink;

	@FindBy(how = How.ID, using = "ctl00_cphPage_ucReleaseNew_ifrmMaster1")
	WebElement FrameID;

	@FindBy(how = How.XPATH, using = "//input[@id='myfile']")
	WebElement FileUploadTextBox;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Canadian Distribution')]")
	WebElement CanadianDistributionTab;

	@FindBy(how = How.XPATH, using = "//a[@id='aSegmentUS']/span")
	WebElement USDistributionTab;

	@FindBy(how = How.XPATH, using = "//a[@id='ui-id-2']/span")
	WebElement InternationalDistributionTab;

	@FindBy(how = How.XPATH, using = "//a[@id='ui-id-3']/span")
	WebElement WebDistributionTab;

	@FindBy(how = How.XPATH, using = "//div[@id='ctl00_cphPage_Newslines1_ucUSNewsLineCategories_dvNewsLines']/ul/li")
	WebElement CategoriesList;

	@FindBy(how = How.XPATH, using = "//div[@id='ctl00_cphPage_Newslines1_ucDomesticNewsLines_dvNewsLines']//ul/li")
	WebElement NewsLineList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='category_US']//input[contains(@id,'ctl00')]")
	WebElement NewsLineCheckBox;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'As soon as possible')]")
	WebElement ImmediatePRT;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Hold for call')]")
	WebElement HoldForCallPRT;

	@FindBy(how = How.XPATH, using = "//input[@id='txtHours']")
	WebElement HoursTxtBox;

	@FindBy(how = How.XPATH, using = "//input[@id='txtMinutes']")
	WebElement MinutesTxtBox;

	@FindBy(how = How.XPATH, using = "//img[@id='ibtnAM']")
	WebElement AMorPMArrow;
	
	@FindBy(how = How.XPATH, using = "//*[@id='divAM']/span")
	WebElement AMorPM;

	@FindBy(how = How.XPATH, using = "//label[text()='Date:']")
	WebElement DateControl;
	
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker-days']//th[@class='picker-switch']")
	WebElement MonthandYear;
	
	@FindBy(how = How.XPATH, using = "//th[@class='next']")
	WebElement NextBtn;

	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_cphPage_btnProceed']")
	WebElement SaveAndContinueButton;

	@FindBy(how = How.XPATH, using = "//td[@class='Label-Summary']//span")
	WebElement FileUploadedSuccessfully;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Select Files')]")
	WebElement uploadButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='lang-drop']")
	WebElement languageDropDown;
	
	@FindBy(how = How.XPATH, using = "//li/a[text()='French']")
	WebElement French;

	public boolean uploadFile(String filePath){

		wait.until(ExpectedConditions
				.elementToBeClickable(SaveAndContinueButton));
		if(filePath.contains("French")){
			languageDropDown.click();
			French.click();
		}		
		driver.switchTo().frame(FrameID);
		FileUploadTextBox.sendKeys(filePath);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By
				.xpath(".//*[@id='ctl00_cphPage_ucReleaseNew_1']")));
		wait.until(ExpectedConditions.visibilityOf(FileUploadedSuccessfully));
		if (FileUploadedSuccessfully.getText().contains(filePath))
			return true;
			
		else return false; 
	}

	public void clickDistributionTab(String distributionName) {

		if (distributionName.equalsIgnoreCase("US Distribution")) {
			wait.until(ExpectedConditions.elementToBeClickable(USDistributionTab));
			ResuableFunction.scrollIntoView(driver, USDistributionTab);
			USDistributionTab.click();
		}
		else if (distributionName
				.equalsIgnoreCase("Canadian Distribution")) {
			ResuableFunction.scrollIntoView(driver,
					CanadianDistributionTab);
			CanadianDistributionTab.click();
		}
		else if (distributionName
				.equalsIgnoreCase("International Distribution")) {
			ResuableFunction.scrollIntoView(driver,
					InternationalDistributionTab);
			InternationalDistributionTab.click();
		} else {
			ResuableFunction.scrollIntoView(driver, WebDistributionTab);
			WebDistributionTab.click();
		}

	}

	public void selectCategory(String categoryName) {

		List<WebElement> categoriesList = driver
				.findElements(By
						.xpath("//div[@id='ctl00_cphPage_Newslines1_ucUSNewsLineCategories_dvNewsLines']/ul/li"));

		for (WebElement category : categoriesList) {
			if (category.getText().equalsIgnoreCase(categoryName)) {
				ResuableFunction.scrollIntoView(driver, category);
				category.click();
				break;
			}
		}

	}

	public void selectNewsLine(String newsLineName) {
		
		if(newsLineName.contains("Canadian")){
			
			List<WebElement> NewsLineList = driver
					.findElements(By
							.xpath("//*[@id='category_Canadian']/ul/li"));
			List<WebElement> NewsLineCheckBox = driver
					.findElements(By
							.xpath("//*[@id='category_Canadian']//input[@type='checkbox']"));
			for(int index = 0; index<NewsLineList.size();index++){
				if(NewsLineList.get(index).getText().equalsIgnoreCase(newsLineName)){
					NewsLineCheckBox.get(index).click();
					}		
				
				}
			}
		else{

			List<WebElement> NewsLineList = driver
					.findElements(By
							.xpath("//div[@id='ctl00_cphPage_Newslines1_ucDomesticNewsLines_dvNewsLines']//ul/li"));
			List<WebElement> NewsLineCheckBox = driver
					.findElements(By
							.xpath("//*[@id='category_US']//input[@type='checkbox']"));
			for(int index = 0; index<NewsLineList.size();index++){
				if(NewsLineList.get(index).getText().equalsIgnoreCase(newsLineName)){
					NewsLineCheckBox.get(index).click();
					}		
				
				}
			}

	}

	public void selectImmediatePRT() {
			
		ResuableFunction.scrollIntoView(driver, ImmediatePRT);
		if (ImmediatePRT.isDisplayed())
			ImmediatePRT.click();
	}
	
	public void selectHoldForCallPRT(){
		
		ResuableFunction.scrollIntoView(driver, HoldForCallPRT);
		if (HoldForCallPRT.isDisplayed())
			HoldForCallPRT.click();
		
	}
	
	public void selectSchedulePRT(String hours,String minutes,String strAMorPM,String date, String month_year){
		
		HoursTxtBox.sendKeys(hours);
		MinutesTxtBox.sendKeys(minutes);
		
		if(!AMorPM.getText().equals(strAMorPM))
			AMorPMArrow.click();
		
		DateControl.click();
	
		do{
			isDateSelected = false;
			
			String strMonthandYear = MonthandYear.getText();
		
			if(month_year.equals(strMonthandYear))
			{
				List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='datepicker']//td"));
				for (WebElement curDate : allDates){
					if(curDate.getText().equals(date)){
						curDate.click();
						isDateSelected = true;
						break;
					}
				}
			}
			else
			NextBtn.click();		
		}while(!isDateSelected);
		
	}

	public OrderSubmitPageObjects clickOnSaveAndContinueButton() {

		wait.until(ExpectedConditions
				.elementToBeClickable(SaveAndContinueButton));
		ResuableFunction.scrollIntoView(driver, SaveAndContinueButton);
		if (SaveAndContinueButton.isDisplayed())
			SaveAndContinueButton.click();

		return new OrderSubmitPageObjects(driver);
	}

}
