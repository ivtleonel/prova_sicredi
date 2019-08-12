package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/feature",
		glue= {"stepDefinitions"},
		tags= {"@Create, @SearchDelete"}
)
public class UpdateFormRunner {

}
