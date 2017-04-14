package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"D:/MavenProject/Cucumber_OMC_Automation/target/rerun.txt"}
		,glue={"stepDefinitions"}
		,plugin={"rerun:target/rerun.txt"}
		)

public class ReRunFailedTestCases {

}