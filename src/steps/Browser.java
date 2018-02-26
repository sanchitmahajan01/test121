package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

import functions.Takeaction;
import functions.validationaction;

public class Browser {
	
	
	static WebDriver driver ;
	
	 // public static void main(String[] args) {
	  
	public static WebDriver browser()
	{
	    	System.setProperty("webdriver.firefox.marionette","C:\\Sanchit Data\\Work\\automaiton\\gecko64\\geckodriver.exe");
			 driver = new FirefoxDriver();
	        Takeaction takeaction = new Takeaction();
	        validationaction validationaction = new validationaction();
	        takeaction.initiatedrive(driver);
	        validationaction.initiatedrive(driver);
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      /*  String baseUrl = "http://demo.guru99.com/selenium/newtours/";
	        String expectedTitle = "Welcome: Mercury Tours";
	       
	        
	        final By homexpath = By.xpath("html/body/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/font/a");
	        final By usernamexpath = By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input");

	        
	        takeaction.initiatedrive(driver);
	        Takeaction.urlopen(baseUrl);
	        Takeaction.clickelement(homexpath);
	        Takeaction.entertext("hello", usernamexpath);
	        
	        String actualTitle = "";
	        actualTitle = driver.getTitle();
	        if (actualTitle.contentEquals(expectedTitle)){
	            System.out.println("Test Passed!");
	        } else {
	            System.out.println("Test Failed");
	        }
	       
	        //close Fire fox
	        driver.close(); 
	        */
			return driver;
	  }

	public static WebDriver getthisdriver()
	{
		return driver;
	}
}
