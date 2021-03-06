package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
   public  WebDriver driver;
   
	
	@FindBy(xpath="//*[@id='login_Layer']")
	WebElement Login;
	
	@FindBy(css="#root > div.naukri-drawer.right.open > div.drawer-wrapper > div > form > div:nth-child(2) > input")
	WebElement EmailID;
	
	@FindBy(css="#root > div.naukri-drawer.right.open > div.drawer-wrapper > div > form > div:nth-child(3) > input")
	WebElement Password;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement Login_Btn;
	
	@FindBy(css="body > div:nth-child(2) > div > div > ul.midSec.menu > li:nth-child(2) > a > div")
	WebElement Rcrtr;


	public HomePage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void Login_user(String u,String p)
	{
		driver.manage().timeouts().implicitlyWait(610,TimeUnit.SECONDS);
		Login.click();
		EmailID.sendKeys(u);
		Password.sendKeys(p);
		Login_Btn.click();
	}
	
	public void cl()
	{
		String MW=driver.getWindowHandle();
		Set<String> wndw = driver.getWindowHandles();
		@SuppressWarnings("rawtypes")
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
	}
	
	public void cnfrm_HP()
	{
		for(int i=0; i<3;i++)
	      { 
			try{
	    	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70)); 
	  		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='My Naukri']"))));
	          break;
	           }
	          catch(Exception e)
			   {
	          System.out.println(".");
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
	
	public void click_recrtr()
	{
		String MW1=driver.getWindowHandle();
		Set<String> wndw1 = driver.getWindowHandles();
		@SuppressWarnings("rawtypes")
		Iterator itr1 = wndw1.iterator();
		while(itr1.hasNext())
		{
			String cw1 = itr1.next().toString();
			if(!MW1.equalsIgnoreCase(cw1))
			{
				driver.switchTo().window(cw1);
				driver.close();
			}
		}
		driver.switchTo().window(MW1);
		
		String mw = driver.getWindowHandle();
		
	 //	WebElement Rcrtr = driver.findElement(By.cssSelector("body > div:nth-child(2) > div > div > ul.midSec.menu > li:nth-child(2) > a > div"));
	   
	   for(int i=0;i<7;i++)
		{
			try {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(700));
				wait.until(ExpectedConditions.elementToBeClickable(Rcrtr));
		        Rcrtr.click();
		        break;
			    }catch(Exception e)
			    {
			    	System.out.println(e.toString());
			    }
		}	
			
			  Set<String> wndw = driver.getWindowHandles();
			   for(String s:wndw)
			   {
				   if (!s.equalsIgnoreCase(mw))
				   {
					  // System.out.println(s);
					   driver.switchTo().window(s);
				   }
			   }
	}
}
