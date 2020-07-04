package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rcrtr {

	public WebDriver driver;
	
	@FindBy(css="#skill > div.sWrap.lftBrd > div.inpWrap > input")
	WebElement skl ;

	@FindBy(css="#location > div.sWrap > div.inpWrap > input")
	WebElement lcn;
	
	@FindBy(id="qsbFormBtn")
	WebElement Sbmt;
	
	@FindBy(xpath="//div[@id='acord']//following::em[text()='Chennai']//preceding::b")
	WebElement Chennai;
	
	@FindBy(xpath="//div[@id='acord']//following::em[text()='Hyderabad']//preceding::b")
	WebElement Hyd;
	
	@FindBy(xpath="//div[@id='acord']//following::em[text()='Mumbai']//preceding::b")
	WebElement Mumbai;
	
	public Rcrtr(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void srch_rcrtr(String S, String L)
	{
		skl.sendKeys(S);
		lcn.sendKeys(L);
		Sbmt.click();
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
