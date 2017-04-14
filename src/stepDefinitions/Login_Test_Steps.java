package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import pages.HomePageObjects;
import pages.LoginPageObjects;
import pages.OrderConfirmPageObjects;
import pages.OrderCreationPageObjects;
import pages.OrderSubmitPageObjects;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import datatables.ReadDataFromExcel;

public class Login_Test_Steps extends BaseUtil{

	ReadDataFromExcel read;
	LoginPageObjects login_page;
	HomePageObjects home_page;
	OrderCreationPageObjects order_creation_page;
	OrderSubmitPageObjects order_submit_page;
	OrderConfirmPageObjects order_confirm_page;
	private BaseUtil base;
	public String SheetName;
	
	public Login_Test_Steps(BaseUtil base){
		this.base = base;
		login_page = new LoginPageObjects(this.base.driver);
		read = new ReadDataFromExcel("D:\\Data Controller.xlsx"); 
	}
	
	@Given("^Navigate to OMC PRN Website$")
	public void navigate_to_OMC_PRN_Website() throws Throwable {
		base.driver.get("https://portalqav2.prnewswire.com/");
		SheetName = read.getData("Common_Data","Refer_PRN_Sheet");
	
	}

	@Given("^Navigate to OMC CNW Website$")
	public void navigate_to_OMC_CNW_Website() throws Throwable {
		base.driver.get("https://cnwportalqa.prnewswire.com/");
		SheetName = read.getData("Common_Data","Refer_CNW_Sheet");
	}
	

	@Given("^User is on Login Page$")
	public void user_is_on_Login_Page() throws Throwable {
		
		String expectedLoginPageTitle = read.getData(SheetName,"LoginPageTitle");
		String actualLoginPageTitle = login_page.getLoginPageTitle();

		if (actualLoginPageTitle.equalsIgnoreCase(expectedLoginPageTitle))
			System.out.println("User is on OMC Login Page");
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password(DataTable table) throws Throwable {

		//String strUsername = read.getData("username");
		//String strPassword = read.getData("password");
		
		/*List<List<String>> data = table.raw();		
		String strUsername = data.get(1).get(0);
		String strPassword = data.get(1).get(1);*/
		
		List<User> users = new ArrayList<User>();
		users = table.asList(User.class);
		
		for(User user: users){
		
		String strUsername = user.username;
		System.out.println("Username entered: "+strUsername);
		login_page.typeUsername(strUsername);
		
		String strPassword = user.password;
		System.out.println("Password entered: "+strPassword);
		login_page.typePassword(strPassword);

		}
		home_page = login_page.clickOnLogInButton();
		
		
	}
	
	public class User 
	{
		public String username;
		public String password;
		
		public User(String UserName, String PassWord){
			username = UserName;
			password = PassWord;
		}
	}

	@Then("^User should be Logged In Successfully$")
	public void user_should_be_Logged_In_Successfully() throws Throwable {

		String expectedHomePageTitle = read.getData(SheetName,"LoginPageTitle");
		String actualHomePageTitle = home_page.getHomePageTitle();

		if (actualHomePageTitle.equalsIgnoreCase(expectedHomePageTitle))
			System.out.println("User is on OMC Home Page");

		String expectedUsername = read.getData(SheetName,"loginuser");
		String actualUsername = home_page.getLoginUsername();

		if (actualUsername.contains(expectedUsername))
			System.out.println("User is logged in as: "+actualUsername);
		
		
	}
	
	
	@Then("^User should be alerted for valid credentials$")
	public void user_should_be_alerted_for_valid_credentials() throws Throwable {
		if(login_page.getLoginErrorMessage().contains("invalid username and password")){
		System.out.println("Alert displayed to User for invalid credentials");
		}
	}

	@And("^User should be logged out succesfully$")
	public void user_should_be_logged_out_succesfully() throws Throwable {

		String expectedULoginPageTitle = read.getData(SheetName,"LoginPageTitle");
		String actualULoginPageTitle = login_page.getLoginPageTitle();

		if (actualULoginPageTitle.equalsIgnoreCase(expectedULoginPageTitle)){
			System.out.println("User is logged out successfully");
		}
			
	}

	@When("^Navigate to Send a Release page$")
	public void navigate_to_Send_a_Release_page() throws Throwable {
		order_creation_page = home_page.clickOnSendAReleaseLink();
	}

	@Then("^User uploads primary content document$")
	public void user_uploads_primary_content_document() throws Throwable {
		
		String englishFilePath = read.getData(SheetName,"EnglishFilePath");
		if(order_creation_page.uploadFile(englishFilePath));
		System.out.println("English File is uploaded successfully");
		
		if(SheetName.contains("CNW")){
			
			String frenchFilePath = read.getData(SheetName,"FrenchFilePath");
			if(order_creation_page.uploadFile(frenchFilePath));
			System.out.println("French File is uploaded successfully");
			
		}
	}
	
	@And("^User clicks on Distribution Tab$")
	public void user_clicks_on_Distribution_Tab() throws Throwable {
		String distributionName = read.getData(SheetName,"distributionName");
		System.out.println("Name: "+distributionName);
		order_creation_page.clickDistributionTab(distributionName);
	}

	@And("^User selects Category$")
	public void user_selects_Category() throws Throwable {
	String categoryName = read.getData(SheetName,"distributionName");
		order_creation_page.selectCategory(categoryName);
	}
	
	@And("^User selects News Line$")
	public void user_selects_News_Line() throws Throwable {
		
		String newsLineName = read.getData(SheetName,"newsLineName");
		order_creation_page.selectNewsLine(newsLineName);
		
		if(SheetName.contains("CNW")){
			
			String newsLineName1 = read.getData(SheetName,"newsLineName1");
			order_creation_page.selectNewsLine(newsLineName1);
			
		}
	}
	
	@And("^User selects Public Release Time as ([^\"]*)$")
	public void user_selects_Public_Release_Time_as(String PRT) throws Throwable {
		//String PublicReleaseTime = read.getData("selectPRT");
		
		if(PRT.equalsIgnoreCase("As soon as possible"))
		order_creation_page.selectImmediatePRT();
		else if(PRT.equalsIgnoreCase("Hold For Call"))
		order_creation_page.selectHoldForCallPRT();
		else if(PRT.equalsIgnoreCase("Scheduled")){
			
			String hours = read.getData(SheetName,"hours");
			String minutes = read.getData(SheetName,"minutes");
			String date = read.getData(SheetName,"date");
			String month_year = read.getData(SheetName,"month_year");
			String AMorPM = read.getData(SheetName,"AMorPM");

			order_creation_page.selectSchedulePRT(hours,minutes,AMorPM,date,month_year);
		}
	}
		
	@And("^User selects on Save and Continue Button$")
	public void user_selects_on_Save_and_Continue_Button() throws Throwable {
		order_submit_page = order_creation_page.clickOnSaveAndContinueButton();
	}
	
	@And("^User selects Terms and Condition Check Box$")
	public void user_selects_Terms_and_Condition_Check_Box() throws Throwable {
		order_submit_page.selectTermsAndConditionCheckBox();
	}
	
	@And("^User clicks on Submit Button$")
	public void user_clicks_on_Submit_Button() throws Throwable {
		order_confirm_page = order_submit_page.clickOnSubmitOrderButton();
	}
	
	@And("^User fetch the Order No$")
	public void user_fetch_the_Order_No() throws Throwable {
		String OrderNo = order_confirm_page.getOrderConfirmationNo();
		System.out.println("Portal id is: "+OrderNo);
	}

}
