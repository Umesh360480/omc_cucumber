package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseUtil {
	
	private BaseUtil base;
	
	public Hooks(BaseUtil base){
		
		this.base = base;
	}
	
	@Before()
	public void startDefaultBrowser() {
			
		base.driver = new FirefoxDriver();
		base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		base.driver.manage().window().maximize();
		
	}
	
	@After()
	public void closeDefaultBrowser(Scenario scenario) {
		if(scenario.isFailed()){
			scenario.write("Scenario: Method "+scenario.getName()+"is failed");
		}
		else{
			
			scenario.write("Method "+scenario.getName()+" is passed");
		}
		base.driver.close();
		System.out.println("Browser is closed");
	}
	
	@Before("@firefox")
	public void startFirefoxBrowser() {
			
		base.driver = new FirefoxDriver();
		base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		base.driver.manage().window().maximize();
		
	}
	
	@After("@firefox")
	public void closeFirefoxBrowser(Scenario scenario) {
		if(scenario.isFailed()){
			scenario.write("Scenario: Method "+scenario.getName()+"is failed");
		}
		else{
			
			scenario.write("Method "+scenario.getName()+" is passed");
		}
		base.driver.close();
		System.out.println("Browser is closed");
	}
	@Before("@chrome")
	public void startChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		base.driver = new ChromeDriver();
		base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		base.driver.manage().window().maximize();
	}
	
	@After("@chrome")
	public void closeChromeBrowser(Scenario scenario) {
		if(scenario.isFailed()){
			scenario.write("Scenario: Method "+scenario.getName()+"is failed");
		}
		else{
			
			scenario.write("Method "+scenario.getName()+" is passed");
		}
		base.driver.close();
		System.out.println("Browser is closed");
	}

}
