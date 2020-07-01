package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Load_HP {
	
	public static WebDriver driver;	
	
	
	public Load_HP(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void load_HomePage() throws FileNotFoundException,IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources/Helper/Datafile.properties"); 
		prop.load(fis);
 	    driver.navigate().to(prop.getProperty("URL"));
	}

}
