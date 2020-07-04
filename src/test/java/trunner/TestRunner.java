package trunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		         features= {"classpath:Login/Lgn3.feature"},
		         glue= {"stepDef"},
		         dryRun=false,
		         monochrome=true,
		         tags="@Alrt"
		)
   
public class TestRunner {

}	
 