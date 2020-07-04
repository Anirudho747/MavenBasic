package Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.*;

public class Profile_Details {
	
	WebDriver driver ;
	
	@FindBy(xpath="//div[text()='UPDATE PROFILE']")
	WebElement Updt_prfl;
	
	@FindBy(xpath="//em[text()='Edit']")
	WebElement Edit_prfl;
	
	@FindBy(id="name")
	WebElement Name;
	
	@FindBy(id="mob_number")
	WebElement Mobile_Nmbr;
	
	@FindBy(id="saveBasicDetailsBtn")
	WebElement saveBtn;
	
	@FindBy(xpath="//button[text()='GOT IT']")
	WebElement Cookies_Bar;
	
	@FindBy(id="attachCV")
	WebElement Resume;
	
	@FindBy(xpath="//span[text()='Resume Headline']//following::span[text()='Edit'][1]")
	WebElement Resume_HL;
	
	@FindBy(id="resumeHeadlineTxt")
	WebElement Resume_HL_Text;
	
	@FindBy(xpath="//textarea[@id='resumeHeadlineTxt']//following::button[text()='Save']")
	WebElement Save_HL_Text;
	
	@FindBy(xpath="//span[@class='fullname']")
	WebElement sysname;
	
	@FindBy(xpath="//span[@name='Mobile']")
	WebElement sysnumber;
	
	public Profile_Details(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void edit_Profile()
	{
		Updt_prfl.click();
		Edit_prfl.click();
	}
	
	public void updt_name_and_number(String name,String number)
	{
		Name.clear();
		Name.sendKeys(name);
		Mobile_Nmbr.clear();
		Mobile_Nmbr.sendKeys(number);
		saveBtn.click();
	}
	
	public void remove_strip()
	{
		for(int i=0;i<7;i++)
		{
			try {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70));
				wait.until(ExpectedConditions.elementToBeClickable(Cookies_Bar));
		        Cookies_Bar.click();
		        break;
			    }catch(Exception e)
			    {
			    	System.out.println(e.toString());
			    }
			
		}
		
	}

	public void Updt_Resume_And_ResumeHeadline()
	{
		remove_strip();
	//	Resume.sendKeys("D:\\Progs\\Resume\\Resume7.pdf");
	//	driver.manage().timeouts().implicitlyWait(160,TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true)", Resume_HL);
    	Resume_HL.click();
    	Resume_HL_Text.clear();
    	Resume_HL_Text.sendKeys("Uploaded via Eclipse ");
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(160));
    	wait.until(ExpectedConditions.elementToBeClickable(Save_HL_Text));
    	Save_HL_Text.click();
	}
	
	public void verification(String name, String number)
	{
		System.out.println("Mission Accomplished");	
		Assert.assertEquals(name, sysname.getText());
		System.out.println("Name Matched");
		Assert.assertEquals(number,sysnumber.getText());
		System.out.println("Number Matched");
	}
}
