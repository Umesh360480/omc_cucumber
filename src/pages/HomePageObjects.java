package pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class HomePageObjects {

	WebDriver driver;

	public HomePageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[@id='ctl00_lblWelcome']")
	WebElement loginUsername;

	@FindBy(how = How.LINK_TEXT, using = "Logout")
	WebElement LogoutLink;
	
	@FindBy(how = How.LINK_TEXT, using = "Send a Release")
	WebElement sendAReleaseLink;
	
	@FindBy(how = How.LINK_TEXT, using = "Send a News Release")
	WebElement sendANewsReleaseLink;

	public String getHomePageTitle() {

		WebDriverWait waitForPageToLoad = new WebDriverWait(driver, 80);
		waitForPageToLoad.until(ExpectedConditions.elementToBeClickable(loginUsername));

		return driver.getTitle();
	}

	public String getLoginUsername() {

		return loginUsername.getText();
	}

	public void clickOnLogoutLink() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement LogOutLink = wait
				.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return LogoutLink;
					}

				});

		LogOutLink.click();
	}
	
	public OrderCreationPageObjects clickOnSendAReleaseLink() {
		
		if(driver.getCurrentUrl().contains("qav2")){
			if(sendAReleaseLink.isDisplayed())
				sendAReleaseLink.click();
		}		
		else{
			if(sendANewsReleaseLink.isDisplayed())
				sendANewsReleaseLink.click();
		}
		
		return new OrderCreationPageObjects(driver);
	}

}
