package Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lgout_Cnfrm {
	
	public WebDriver driver;
	
	
	public Lgout_Cnfrm(WebDriver driver)
	{
		this.driver = driver;
	    PageFactory.initElements(driver,this);
	}
	
	public void cnfrm()
	{
		for(int i=0; i<3;i++)
	      { 
			try{
	    	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70)); 
	  		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='Login']"))));
	          break;
	           }
	          catch(Exception e)
			   {
	          System.out.println(".");
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

}
