package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
		,glue={"stepDefinitions"}
		,format = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber.json"}
		,tags = {"@CNWOrderCreation"}
		//,plugin={"rerun:target/rerun.txt"}
		)
 
public class TestRunner {
 
}