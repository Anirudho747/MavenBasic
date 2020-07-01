package trunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		         features= {"classpath:Login/Lgn2.feature"},
		         glue= {"stepDef"},
		         dryRun=false,
		         tags="@Updt"
		)
   
public class TestRunner {

}
 