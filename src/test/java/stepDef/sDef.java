package stepDef;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Base;
import Pages.HomePage;
import Pages.Hover_over_Naukri;
import Pages.JobAlert;
import Pages.Lgout_Cnfrm;
import Pages.Load_HP;
import Pages.Profile_Details;
import Pages.Rcrtr;
import Pages.Set_Exprnc;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class sDef  {
	
	public static WebDriver driver;
	Logger log = Logger.getLogger(sDef.class);
	
	@Before
	public void before() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
 	   log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
		driver.manage().window().maximize();
		
		
		//driver=Base.driverInit();
	}

     @Given("User is on homepage")
    public void user_is_on_homepage() throws IOException {
    	 
    	   Load_HP lhp = new Load_HP(driver);
    	   lhp.load_HomePage();

	}

	@When("User clicks on Login Button")
	public void user_clicks_on_Login_Button() {
		
		HomePage clicker = new HomePage(driver); 
		clicker.cl();
	}
		
	@When("User enters {string} and {string}")
	public void user_enters_and(String uname, String psswrd) {
		
	  HomePage hp = new HomePage(driver); 
	  hp.Login_user(uname,psswrd);
	}
	
	@Then("User should be able to Login to his\\/her Naukri Account")
	public void user_should_be_able_to_Login_to_his_her_Naukri_Account() {
			
		HomePage lc = new HomePage(driver);
		lc.cnfrm_HP();	
	}
	
	@When("User's mouse hovers over My Naukri Option")
	public void user_s_mouse_hovers_over_My_Naukri_Option() { 
	 
		Hover_over_Naukri hon = new Hover_over_Naukri(driver); 
	    hon.hover();
	}
	
	@When("User clicks on Logout Option")
    public void user_clicks_on_Logout_Option() {

		Hover_over_Naukri hon = new Hover_over_Naukri(driver);
		hon.click_logout();
	}
	
	@Then("User should be logged out of Naukri portal")
	public void user_should_be_logged_out_of_Naukri_portal() {
		
		Lgout_Cnfrm lc = new Lgout_Cnfrm(driver);
		lc.cnfrm();
	}
	
	@When("User searches for {string} in {string}")
	public void user_searches_for_in(String skill, String locn) {
	
	Set_Exprnc s = new Set_Exprnc(driver);	
	s.Srch_jbs(skill, locn);
	
	}
	
	@When("user sets his experience range")
	public void user_sets_his_experience_range() {
     Set_Exprnc se = new Set_Exprnc(driver);
     se.Slct_Exprnc(); 
	}
	
	@When("user selects {string}")
	public void user_selects_type(String city) {
		Set_Exprnc sc = new Set_Exprnc(driver);
		sc.Slct_City(city);
	}
	
	@Then("User should be able to get the count of requirements")
	public void user_should_be_able_to_get_the_count_of_requirements() {
		
		Set_Exprnc rc = new Set_Exprnc(driver);
		rc.getcount();
		}

	@When("User clicks on Edit personal details")
	public void user_clicks_on_Edit_personal_details() {
	   
		Profile_Details pd = new Profile_Details(driver);
		pd.edit_Profile();
	}

	@When("User updated {string} and {string}")
	public void user_updated_Name_and_number(String Name,  String Nmbr) {
	 
		Profile_Details  updt = new Profile_Details(driver);
		updt.updt_name_and_number(Name, Nmbr);
	}
	
    @When("upload Resume and Resume Headline")
	public void upload_Resume_and_Picture() {
    	
    	Profile_Details  updt_Resume = new Profile_Details(driver);
    	updt_Resume.Updt_Resume_And_ResumeHeadline();
    }
		
	@Then("User should be able to verify {string} and {string}")
	public void user_should_be_able_to_verify_and(String name, String nmber) {
	
		Profile_Details  vrfy = new Profile_Details(driver);
		vrfy.verification(name, nmber);
	}
	
	@When("User clicks on Recruiter Tab")
	public void user_clicks_on_Recruiter_Tab() {
		
		HomePage hp = new HomePage(driver);
		hp.click_recrtr();
		
		}
	
	@When("User searches for Recuiter {string} in {string}")
	public void user_searches_for_Recuiter_in(String skill, String city) {
		
		Rcrtr r = new Rcrtr(driver);
		r.srch_rcrtr(skill, city);
	}

	@When("user selects Recruiter {string}")
	public void user_selects_Recruiter(String city) {
	
		Rcrtr r = new Rcrtr(driver);
		r.Slct_City(city);
	}
	
	@When("clicks on Manage and Modify Alert")
	public void clicks_on_Manage_and_Modify_Alert() {
	  //driver.manage().timeouts().implicitlyWait(160,TimeUnit.SECONDS);	
	 /* WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(250)); 
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Manage Alerts']"))));
	  driver.findElement(By.xpath("//a[text()='Manage Alerts']")).click();
	  driver.findElement(By.xpath("//th[text()='Alert Name']//following::a[text()='Modify Alert'][1]")).click();
	  */
		JobAlert ja = new JobAlert(driver);
		ja.Navigate_to_Modify();
		
	}

	@When("updates {string} and {string} and clicks on Update Alert")
	public void updates_and_and_clicks_on_Update_Alert(String skill, String location) {
	   
		JobAlert ja = new JobAlert(driver);
		ja.updt_kwd_and_lcn(skill, location);
	/*
		driver.manage().timeouts().implicitlyWait(250,TimeUnit.SECONDS);
		driver.findElement(By.id("Sug_kwdsugg")).clear();
		driver.findElement(By.id("Sug_kwdsugg")).sendKeys(skill);
		
		driver.manage().timeouts().implicitlyWait(250,TimeUnit.SECONDS);
		driver.findElement(By.id("Sug_locsugg")).clear();
		driver.findElement(By.id("Sug_locsugg")).sendKeys(location);
		
		driver.findElement(By.id("cjaSubmit")).click();
	*/	
	}
	
	@Then("user should verify {string} and {string}")
	public void user_should_verify_and(String skill, String location) {
	   
		JobAlert ja = new JobAlert(driver);
		ja.vrfctn(skill, location);
		/*
		String skll = driver.findElement(By.xpath("//div[@id='cjaConfMsg']//following::span[1]")).getText();
	    System.out.println(skll);
	    String locn = driver.findElement(By.xpath("//div[@id='cjaConfMsg']//following::span[4]")).getText();
	    System.out.println(locn);
	    Assert.assertEquals(skill,skll);
	    Assert.assertEquals(location,locn);
	    */
	}
	
	@After
	public void after()
	{
		driver.quit();
	}


}
