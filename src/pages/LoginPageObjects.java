package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	WebDriver driver;

	public LoginPageObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='txtUserName']")
	WebElement usernameTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='txtPassword']")
	WebElement passwordTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='ucLogin_btnLogin']")
	WebElement logInButton;
	
	@FindBy(how = How.XPATH, using = "//span[@id='lblErrorMessages']")
	WebElement loginError;
	
	public String getLoginPageTitle() {

		return driver.getTitle();
	}

	public void typeUsername(String strUsername) {

		usernameTextBox.clear();
		usernameTextBox.sendKeys(strUsername);
	}

	public void typePassword(String strPassword) {

		passwordTextBox.clear();
		passwordTextBox.sendKeys(strPassword);
	}

	public HomePageObjects clickOnLogInButton() {

		logInButton.click();

		return new HomePageObjects(driver);
	}
	
	public String getLoginErrorMessage(){
		return loginError.getText();
	}
}
