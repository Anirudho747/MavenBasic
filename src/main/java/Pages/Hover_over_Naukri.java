package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hover_over_Naukri {
	
 public WebDriver driver;	

public Hover_over_Naukri(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver,this);
}

  @FindBy(css="body > div:nth-child(2) > div > div > ul.rghtSec.fr.menu.logged > li:nth-child(2) > a > div.mTxt")
  WebElement My_Acc;
  
  @FindBy(xpath="//a[text()='Logout']")
  WebElement Logout;
  
  public void hover()
  {
	     Actions act = new Actions(driver);
		 act.moveToElement(My_Acc).perform();
  }
  
  public void click_logout()
  {
	      Logout.click();
  }
  
  
	
}
