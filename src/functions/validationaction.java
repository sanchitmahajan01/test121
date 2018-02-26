package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class validationaction {

	static WebDriver driver ;

	 public void initiatedrive(WebDriver driver)
	 {
		 validationaction.driver = driver;
	 }
	
	 public static boolean textmatchsimple(By xpath,String text)
		{
			System.out.println("Xpath string text is : "+driver.findElement(xpath).getText().trim()+" and text to be validate is : "+text);

		 		if (text.equalsIgnoreCase( driver.findElement(xpath).getText().trim()))
				 {
		 			System.out.println("Matched for textmatchsimple function !!");
		 			return true;
				 }
	 			System.out.println("not Matched for textmatchsimple function !!");

		 		return false;
		}
	 public static boolean iselementpresent(By xpath)
	 {
		 
		 if(driver.findElement(xpath).isDisplayed())
		 {
			 	return true;
		 }
		 return false;
	 }
	 
}
