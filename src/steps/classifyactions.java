package steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import functions.Takeaction;
import functions.excelreadsteps;
import functions.validationaction;
import steps.Browser;;

public class classifyactions {
	
	public static void takeactiononexcelvalues(List<XSSFCell> data) throws InterruptedException
	{
		
		/*System.setProperty("webdriver.firefox.marionette","C:\\Sanchit Data\\Work\\automaiton\\gecko64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		*/
		
		
        //Takeaction takeaction = new Takeaction();
        // takeaction.initiatedrive(driver);

		boolean matchresult = false;
		
		
		System.out.println("--------------------------------- \n\n Inside take excel actions and on key word "+data.get(0));


		switch(data.get(0).toString())
		{
		   
				case "Action" :
							switch(data.get(1).toString())
							{
							   
									case "url" :
										Takeaction.urlopen(data.get(2).toString());
										Thread.sleep(2000);
									break; // break 
									case "click" :
										Takeaction.clickelement(By.xpath(data.get(2).toString()));
										
									break; // break 
									case "text" :
										Takeaction.entertext(data.get(3).toString(),By.xpath(data.get(2).toString()));
										
									break; // break 
									case "select" :
										Takeaction.selectdropdownviaxpaths(By.xpath(data.get(2).toString()), By.xpath(data.get(3).toString()));
										
									break; // break 
									 
							}
					
				break; // break 
				case "Module" :
					System.out.println("\n\n ------------------ Entered Module \n\n ----------------- \n");
					System.out.println(" and data is " +data.get(1).toString());
					excelreadsteps.excelinterpret(data.get(1).toString());
										
				break;
				case "Validate" :
					switch(data.get(1).toString())
					{
					   
							case "textmatch" :
								matchresult = validationaction.textmatchsimple(By.xpath(data.get(2).toString()), data.get(3).toString());
								System.out.println("Match results for : "+data.get(2).toString()+" and : "+data.get(3).toString() + " is : "+matchresult);
							break; // break 
							case "iselementpresent" :
								matchresult = validationaction.iselementpresent(By.xpath(data.get(2).toString()));
								System.out.println("\n -------------------------------- \nMatch results for : "+data.get(2).toString()+" and : "+data.get(3).toString() + " is : "+matchresult+"\n -------------------------------- \n");
							break; // break 
							
					}
										
				break;
		   
		}

	

	
		
	}

}
