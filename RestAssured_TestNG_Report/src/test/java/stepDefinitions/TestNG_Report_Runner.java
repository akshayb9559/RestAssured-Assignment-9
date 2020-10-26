package stepDefinitions;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\test\\resources\\Features", 
		glue = { "stepDefinitions" }, 
		plugin= {"pretty","testNG:target/testNG-reports"},
		monochrome = true
		)

public class TestNG_Report_Runner extends TestNG_Report_Step{

}
