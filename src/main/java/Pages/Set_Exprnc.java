package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Set_Exprnc {

	WebDriver driver;
	
	@FindBy(xpath="//button[text()='GOT IT']")
	WebElement Cookies_Bar;
	
	@FindBy(xpath="//span[text()='Experience']//following::span[text()='Any'][1]//following::div[1]")
	WebElement exp;
	
	@FindBy(xpath="//span[text()='Location']//following::label[@for='chk-Chennai-cityType-']//child::i[@class='fleft naukicon naukicon-checkbox']")
	WebElement Chennai;
	
	@FindBy(xpath="//span[text()='Location']//following::label[@for='chk-Hyderabad / Secunderabad-cityType-']//child::i[@class='fleft naukicon naukicon-checkbox']")
	WebElement Hyd;
	
	@FindBy(xpath="//span[text()='Location']//following::label[@for='chk-Mumbai-cityType-']//child::i[@class='fleft naukicon naukicon-checkbox']")
	WebElement Mumbai;
	
	@FindBy(id="qsb-keyskill-sugg")
	WebElement Skill;
	
	@FindBy(id="qsb-location-sugg")
	WebElement Location;
	
	@FindBy(xpath="//button[text()='SEARCH']")
	WebElement Srch_Btn;
	
	@FindBy(xpath="//span[@class='fleft grey-text mr-5 fs12']")
	WebElement frst;
	
	@FindBy(xpath="//h1[@class='fleft grey-text h1-content fs12']")
	WebElement sec;
	
	public void getcount()
	{
		String first  = frst.getAttribute("title");
		String second = sec.getAttribute("title");
		String count = first.substring(first.lastIndexOf('f')+2);
		String prfl = second.substring(0,second.lastIndexOf(" In ")-1);
		String cty = second.substring(second.lastIndexOf(" ")+1);
		String combo ="There are "+count+"jobs for "+prfl+" profile in "+cty; 
		System.out.println(combo);
		
	}
	
	public void Srch_jbs(String Skll, String Locn)
	{
		Skill.sendKeys(Skll);
		Location.sendKeys(Locn);
		Srch_Btn.click();
	}
	
	public Set_Exprnc(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
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
	
	public void Slct_Exprnc()
	{
		remove_strip();
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].scrollIntoView()", exp);
		
		Actions actn = new Actions(driver);
		actn.dragAndDropBy(exp,-210, 0).perform();
	}
	
	public void Slct_City(String city)
	{
		if(city.equalsIgnoreCase("Chennai"))
		{
			Chennai.click();
		}
		else if(city.equalsIgnoreCase("Hyderabad"))
		{
			Hyd.click();
		}
		else if(city.equalsIgnoreCase("Mumbai"))
		{
			Mumbai.click();
		}
	}
	
}
