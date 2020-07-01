package Pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class click_Login {
	
	public WebDriver driver;
	
	
	public click_Login(WebDriver driver) {
		this.driver=driver;
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

}
