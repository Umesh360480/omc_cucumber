package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusable.ResuableFunction;

public class OrderConfirmPageObjects {
	
	WebDriver driver;
	WebDriverWait wait;

	public OrderConfirmPageObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,40);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_cphPage_ctl00_OrderNo']")
	WebElement OrderNo;
	
	public String getOrderConfirmationNo() {
		wait.until(ExpectedConditions.elementToBeClickable(OrderNo));
		ResuableFunction.scrollIntoView(driver,OrderNo);
		return OrderNo.getText();
	}

}
