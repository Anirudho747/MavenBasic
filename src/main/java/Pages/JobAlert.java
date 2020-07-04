package Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobAlert {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Manage Alerts']")
	WebElement manage ;

	@FindBy(xpath="//th[text()='Alert Name']//following::a[text()='Modify Alert'][1]")
	WebElement modify;
	
	@FindBy(xpath="//div[@id='cjaConfMsg']//following::span[1]")
	WebElement skill;
	
	@FindBy(xpath="//div[@id='cjaConfMsg']//following::span[4]")
	WebElement location2;
	
	@FindBy(id="Sug_kwdsugg")
	WebElement Keyword;
	
	@FindBy(id="Sug_locsugg")
	WebElement Location;
	
	@FindBy(id="cjaSubmit")
	WebElement submit;
	
	public JobAlert(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Navigate_to_Modify()
	{
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(250)); 
		  wait.until(ExpectedConditions.elementToBeClickable(manage));
		  manage.click();
		  modify.click();
	}
	
	public void updt_kwd_and_lcn(String kwd,String lcn)
	{
		driver.manage().timeouts().implicitlyWait(250,TimeUnit.SECONDS);
		Keyword.clear();
		Keyword.sendKeys(kwd);
		
		driver.manage().timeouts().implicitlyWait(250,TimeUnit.SECONDS);
		Location.clear();
		Location.sendKeys(lcn);
		
		submit.click();
	}

    public void vrfctn(String kwd,String lcn)
    {
    	String skll = skill.getText();
	    System.out.println(skll);
	    String locn = location2.getText();
	    System.out.println(locn);
	    Assert.assertEquals(kwd,skll);
	    Assert.assertEquals(lcn,locn);
	    
    }
}
