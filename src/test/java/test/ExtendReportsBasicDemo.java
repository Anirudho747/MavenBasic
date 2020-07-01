package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReportsBasicDemo {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("MyFirstTest", "Sample description");
		test1.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test1.info("This step shows usage of info(details)");
        
        // log with snapshot
        test1.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test1.addScreenCaptureFromPath("screenshot.png");
        
        // calling flush writes everything to the log file
        extent.flush();
	}

}
