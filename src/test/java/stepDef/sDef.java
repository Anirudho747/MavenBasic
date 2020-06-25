package stepDef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class sDef {
	
public static WebDriver driver;
	
       @Given("User is on homepage")
       public void user_is_on_homepage() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources/Helper/Datafile.properties"); 
		prop.load(fis);
	    driver.navigate().to(prop.getProperty("URL"));
	}

	
	@When("User clicks on Login Button")
	public void user_clicks_on_Login_Button() {
		String MW=driver.getWindowHandle();
		Set<String> wndw = driver.getWindowHandles();
		Iterator itr = wndw.iterator();
		while(itr.hasNext())
		{
			String cw = itr.next().toString();
			if(!MW.equalsIgnoreCase(cw))
			{
				driver.switchTo().window(cw);
				driver.close();
			}
		}
		driver.switchTo().window(MW);
	    driver.findElement(By.xpath("//*[@id='login_Layer']")).click();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

		
	@When("User enters {string} and {string}")
	public void user_enters_and(String uname, String psswrd) {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.xpath("//label[contains(text(),'Email')]//following::input[@type='text'][1]")).sendKeys(uname);
	   driver.findElement(By.xpath("//label[contains(text(),'Password')]//following::input[@type='password']")).sendKeys(psswrd);
	   driver.findElement(By.xpath("//button[text()='Login']")).click();
	}
	
	@Then("User should be able to Login to his\\/her Naukri Account")
	public void user_should_be_able_to_Login_to_his_her_Naukri_Account() {
		
		for(int i=0; i<3;i++)
	      { 
			try{
	    	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70)); 
	  		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='My Naukri']"))));
	          break;
	           }
	          catch(Exception e)
			   {
	          System.out.println(e.getMessage());
               }
		   }
		String curl = "https://www.naukri.com/mnjuser/homepage";
		if (driver.getCurrentUrl().equalsIgnoreCase(curl))	
		{
		System.out.println("Successfull Login");
		}
		else
		{
			System.out.println("Unable to Login");
			System.out.println(driver.getCurrentUrl());
		}
		
	}
	
	@After
	public void after()
	{
		driver.close();
	}


}
