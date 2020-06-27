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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import junit.framework.Assert;

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
	
	@Given("User is logged into his Naukri Account")
	public void user_is_logged_into_his_Naukri_Account() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream("src/main/resources/Helper/Datafile.properties");
	    prop.load(fis);
	    driver.navigate().to(prop.getProperty("URL"));
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
	    driver.findElement(By.xpath("//label[contains(text(),'Email')]//following::input[@type='text'][1]")).sendKeys("anirudho747@gmail.com");
		driver.findElement(By.xpath("//label[contains(text(),'Password')]//following::input[@type='password']")).sendKeys("Gmail@2020");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	@When("User's mouse hovers over My Naukri Option")
	public void user_s_mouse_hovers_over_My_Naukri_Option() { 
	 Actions act = new Actions(driver);
	 WebElement My_Acc = driver.findElement(By.cssSelector("body > div:nth-child(2) > div > div > ul.rghtSec.fr.menu.logged > li:nth-child(2) > a > div.mTxt"));
	 act.moveToElement(My_Acc).perform();
	 
	}
	
	@When("User clicks on Logout Option")
	
    public void user_clicks_on_Logout_Option() {
	    driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	
	@Then("User should be logged out of Naukri portal")
	public void user_should_be_logged_out_of_Naukri_portal() {
		for(int i=0; i<3;i++)
	      { 
			try{
	    	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70)); 
	  		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='Login']"))));
	          break;
	           }
	          catch(Exception e)
			   {
	          System.out.println(e.getMessage());
             }
		   }
		String curl = "https://www.naukri.com/";
		if (driver.getCurrentUrl().equalsIgnoreCase(curl))	
		{
		System.out.println("Successfull Logout");
		}
		else
		{
			System.out.println("Unable to Logout");
			System.out.println(driver.getCurrentUrl());
		}
	}
	
	@Given("User is on home page")
	public void user_is_on_home_page() throws FileNotFoundException,IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources/Helper/Datafile.properties"); 
		prop.load(fis);
	    driver.navigate().to(prop.getProperty("URL"));
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

	@Given("User enter his credentials and Logs in his account")
	public void user_enter_his_credentials_and_Logs_in_his_account() {
		driver.findElement(By.xpath("//label[contains(text(),'Email')]//following::input[@type='text'][1]")).sendKeys("anirudho747@gmail.com");
		driver.findElement(By.xpath("//label[contains(text(),'Password')]//following::input[@type='password']")).sendKeys("Gmail@2020");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}
	
	@When("User searches for {string} in {string}")
	public void user_searches_for_in(String skill, String locn) {
	  driver.findElement(By.id("qsb-keyskill-sugg")).sendKeys(skill);
	  driver.findElement(By.id("qsb-location-sugg")).sendKeys(locn);
	  driver.findElement(By.xpath("//button[text()='SEARCH']")).click();
	}
	
	@When("user sets his experience range")
	public void user_sets_his_experience_range() {
	for(int i=0;i<7;i++)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70));
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='GOT IT']"))));
	        driver.findElement(By.xpath("//button[text()='GOT IT']")).click();
	        break;
		    }catch(Exception e)
		    {
		    	System.out.println(e.toString());
		    }
		
	}
	WebElement exp = driver.findElement(By.xpath("//span[text()='Experience']//following::span[text()='Any'][1]//following::div[1]"));
	JavascriptExecutor js = (JavascriptExecutor)driver; 
	js.executeScript("arguments[0].scrollIntoView()", exp);
	
	Actions actn = new Actions(driver);
	actn.dragAndDropBy(exp,-210, 0).perform();
	}
	
	@When("user selects {string}")
	public void user_selects_type(String city) {
	if(city.equalsIgnoreCase("Chennai"))
	{
		WebElement tCity = driver.findElement(By.xpath("//span[text()='Location']//following::label[@for='chk-Chennai-cityType-']//child::i[@class='fleft naukicon naukicon-checkbox']"));
		tCity.click();
	}
	else if(city.equalsIgnoreCase("Hyderabad"))
	{
		WebElement tCity = driver.findElement(By.xpath("//span[text()='Location']//following::label[@for='chk-Hyderabad / Secunderabad-cityType-']//child::i[@class='fleft naukicon naukicon-checkbox']"));
		tCity.click();
	}
	else if(city.equalsIgnoreCase("Mumbai"))
	{
		WebElement tCity = driver.findElement(By.xpath("//span[text()='Location']//following::label[@for='chk-Mumbai-cityType-']//child::i[@class='fleft naukicon naukicon-checkbox']"));
		tCity.click();
	} 
	}
	
	@Then("User should be able to get the count of requirements")
	public void user_should_be_able_to_get_the_count_of_requirements() {
		String first = driver.findElement(By.xpath("//span[@class='fleft grey-text mr-5 fs12']")).getAttribute("title");
		String second = driver.findElement(By.xpath("//h1[@class='fleft grey-text h1-content fs12']")).getAttribute("title");
		String count = first.substring(first.lastIndexOf('f')+2);
		String prfl = second.substring(0,second.lastIndexOf(" In ")-1);
		String cty = second.substring(second.lastIndexOf(" ")+1);
		String combo ="There are "+count+"jobs for "+prfl+" profile in "+cty; 
		System.out.println(combo);
		}

	@When("User clicks on Edit personal details")
	public void user_clicks_on_Edit_personal_details() {
	    driver.findElement(By.xpath("//div[text()='UPDATE PROFILE']")).click();
	    driver.findElement(By.xpath("//em[text()='Edit']")).click();
	}

	@When("User updated {string} and {string}")
	public void user_updated_Name_and_number(String Name,  String Nmbr) {
	   final String n = Name;	
	   driver.findElement(By.id("name")).clear();
	   driver.findElement(By.id("name")).clear();
	   driver.findElement(By.id("name")).sendKeys(Name);
	   
	   driver.findElement(By.id("mob_number")).clear();
	   driver.findElement(By.id("mob_number")).clear();
	   driver.findElement(By.id("mob_number")).sendKeys(Nmbr);
	   
	   driver.findElement(By.id("saveBasicDetailsBtn")).click();
	}
	
    @When("upload Resume and Resume Headline")
	public void upload_Resume_and_Picture() {
    	
    	for(int i=0;i<7;i++)
    	{
    		try {
    			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70));
    			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='GOT IT']"))));
    	        driver.findElement(By.xpath("//button[text()='GOT IT']")).click();
    	        break;
    		    }catch(Exception e)
    		    {
    		    	System.out.println(e.toString());
    		    }
    	}
	
    	driver.findElement(By.id("attachCV")).sendKeys("D:\\Progs\\Resume\\Resume7.pdf");
    //	driver.findElement(By.xpath("//span[text()='Missing Profile Details']//following::a[text()='CANCEL'][1]")).click();
    
    	driver.manage().timeouts().implicitlyWait(160,TimeUnit.SECONDS);   	
    	WebElement Resume_Headline = driver.findElement(By.xpath("//span[text()='Resume Headline']//following::span[text()='Edit'][1]"));
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true)", Resume_Headline);
    	Resume_Headline.click();
    	driver.findElement(By.id("resumeHeadlineTxt")).clear();
    	driver.findElement(By.id("resumeHeadlineTxt")).sendKeys("Uploaded via Eclipse ");
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70));
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']//following::button[text()='Save']"))));
    	driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']//following::button[text()='Save']")).click();
    	
    }
	
	
	@Then("User should be able to verify {string} and {string}")
	public void user_should_be_able_to_verify_and(String name, String nmber) {
		System.out.println("Mission Accomplished");	
	//	Assert.assertEquals(name, driver.findElement(By.xpath("//span[@class='fullname']")).getText());
	//	Assert.assertEquals(name, driver.findElement(By.xpath("//span[@name='Mobile']")).getText());
	
		String namesystem = driver.findElement(By.xpath("//span[@class='fullname']")).getText();
	    String nmbersystem = driver.findElement(By.xpath("//span[@name='Mobile']")).getText();
	
	if(name.equalsIgnoreCase(namesystem))
	{
		System.out.println("Name Verified");
	}else
	{
		System.out.println(name+"name value");
		System.out.println(driver.findElement(By.xpath("//span[@class='fullname']")).getText()+"name system");
	}
	
	if(nmber.equalsIgnoreCase(nmbersystem))
	{
		System.out.println("Nmber Verified");
	}else
	{
		System.out.println(nmber+"number value");
        System.out.println(driver.findElement(By.xpath("//span[@name='Mobile']")).getText()+"number system");

	}
	
	}
	
	@After
	public void after()
	{
		driver.close();
	}


}
