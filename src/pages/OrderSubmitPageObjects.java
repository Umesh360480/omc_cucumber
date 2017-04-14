package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusable.ResuableFunction;

public class OrderSubmitPageObjects {

	WebDriver driver;
	WebDriverWait wait;

	public OrderSubmitPageObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,40);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_cphPage_chkTermsAndConditions']")
	WebElement TermsAndConditionCheckBox;

	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_cphPage_btnConfirm']")
	WebElement SubmitButton;
	
	public String getLoginPageTitle() {

		return driver.getTitle();
	}

	public void selectTermsAndConditionCheckBox() {
		
		wait.until(ExpectedConditions.elementToBeClickable(TermsAndConditionCheckBox));
		ResuableFunction.scrollIntoView(driver,TermsAndConditionCheckBox);
		if(TermsAndConditionCheckBox.isEnabled())
			TermsAndConditionCheckBox.click();
		
	}

	public OrderConfirmPageObjects clickOnSubmitOrderButton() {

		wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
		ResuableFunction.scrollIntoView(driver,SubmitButton);
		if(SubmitButton.isEnabled())
		SubmitButton.click();

		return new OrderConfirmPageObjects(driver);
	}
	

}
