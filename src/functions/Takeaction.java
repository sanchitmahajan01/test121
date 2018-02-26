package functions;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class Takeaction {
	
	
	
		
	
	static WebDriver driver ;
	

		
	
	 public void initiatedrive(WebDriver driver) 
	 {
		 	Takeaction.driver = driver;
			
	 }
	
	
	public static void clickelement(By xpath)
	{
		waitforelement(xpath);
		driver.findElement(xpath).click();
	}

	public static void urlopen(String url)
	{
				driver.get(url);
	}
	
	public static void entertext(String text,By xpath)
	{
		waitforelement(xpath);
		driver.findElement(xpath).sendKeys(text);
	}
	
	public static void selectdropdownviaxpaths(By xpath_dropdown,By xpath_value)
	{
		waitforelement(xpath_dropdown);
		driver.findElement(xpath_dropdown).click();
		waitforelement(xpath_value);
		driver.findElement(xpath_value).click();

	}
	
	
	public static void waitforelement(By valuexpathExpression)
	{
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.elementToBeClickable(valuexpathExpression));
	}
	
}
