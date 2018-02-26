package functions;

import org.openqa.selenium.WebDriver;

import steps.Browser;

public class caller {
	public static void main (String args[]) throws InterruptedException
	{
		
		WebDriver driver ;
        driver = Browser.browser();
       // excelreadsteps.excelinterpret("TC1");
        try
        {
            excelreadsteps.excelinterpret("TC"); // all for all the sheets

        }
        catch (Exception e)
        {
        	System.out.println(e);
        }
		
		  //close Fire fox
		finally
		{
			System.out.println("-----------Closing-----------------");
			Thread.sleep(5000);
			driver.close(); 
		}
	}

}
