package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import steps.classifyactions;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelreadsteps {
	
	
	
	/*
	 * Read all the Sheets and values and run them step wise
	 */
	
	@SuppressWarnings("unchecked")
	public static void excelinterpret(String sheetname) throws InterruptedException
	{
		 HashMap<String, LinkedHashMap<Integer, List>> outerMap;
		 
		 outerMap = loadExcelLines();
		 System.out.println("Do");
		 
		 LinkedHashMap<Integer, List> hashMap ;
		 List<XSSFCell> data;
		 Iterator<?> it = outerMap.entrySet().iterator();
		 while (it.hasNext()) 
		 {
			        @SuppressWarnings("rawtypes")
					Map.Entry pair = (Map.Entry)it.next();
			        System.out.println(pair.getKey() + " = " + pair.getValue() + "SHeetname in variable is "+sheetname); // sheet name
			        if ((pair.getKey().toString().equalsIgnoreCase(sheetname)) || (sheetname.equalsIgnoreCase("all"))) // let 'all' or only specify sheet name go through
			        {
			        			System.out.println("\n\n Entered IF with sheet name as "+pair.getKey().toString());
			        			hashMap = (LinkedHashMap<Integer, List>) pair.getValue();
			        			Iterator<?> it1 = hashMap.entrySet().iterator();
								while (it1.hasNext())
								{
									  @SuppressWarnings("rawtypes")
									  Map.Entry pair1 = (Map.Entry)it1.next();
								       System.out.println(pair1.getKey() + " = " + pair1.getValue()); // row number and list
								       //classifyactions.takeactiononexcelvalues(pair1.getValue());
								       					data = (List<XSSFCell>) pair1.getValue();
								       					Iterator<XSSFCell> it2 = data.iterator();
								       					
								       					classifyactions.takeactiononexcelvalues(data);
														while (it2.hasNext()) 
														{
															System.out.println(it2.next()); // values of the list
															 
														}
														
								 }
								 it.remove(); // avoids a ConcurrentModificationException
			    }
			        else
			        {
			        	System.out.println("\n\n------------------------\n\n sheet name Notfound \n\n---------------------------");
			        }
		 }
		 
	}
	
	
	
	
	public static HashMap<String, LinkedHashMap<Integer, List>> loadExcelLines (){
		
	
	 File fileName = new File("c:\\John\\testexcel.xlsx");
	
	
/*
 * Will fetch all sheets and values in hash<String, LinkedHashmap<Integer, List>>
 * 
 */
   
       // Used the LinkedHashMap and LikedList to maintain the order
       HashMap<String, LinkedHashMap<Integer, List>> outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List>>();

       LinkedHashMap<Integer, List> hashMap = new LinkedHashMap<Integer, List>();

       String sheetName = null;
       // Create an ArrayList to store the data read from excel sheet.
       // List sheetData = new ArrayList();
       FileInputStream fis = null;
       try
       {
           fis = new FileInputStream(fileName);
           // Create an excel workbook from the file system
           XSSFWorkbook workBook = new XSSFWorkbook(fis);
           // Get the first sheet on the workbook.
           for (int i = 0; i < workBook.getNumberOfSheets(); i++)
           {
               XSSFSheet sheet = workBook.getSheetAt(i);
               // XSSFSheet sheet = workBook.getSheetAt(0);
               sheetName = workBook.getSheetName(i);

               Iterator rows = sheet.rowIterator();
               while (rows.hasNext())
               {
                   XSSFRow row = (XSSFRow) rows.next();
                   Iterator cells = row.cellIterator();

                   List<XSSFCell> data = new LinkedList<XSSFCell>();
                   while (cells.hasNext())
                   {
                       XSSFCell cell = (XSSFCell) cells.next();
                       cell.setCellType(Cell.CELL_TYPE_STRING);
                       data.add(cell);
                   }
                   hashMap.put(row.getRowNum(), data);

                   // sheetData.add(data);
               }
               outerMap.put(sheetName, hashMap);
               hashMap = new LinkedHashMap<Integer, List>();
           }

       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
       finally
       {
           if (fis != null)
           {
               try
               {
                   fis.close();
               }
               catch (IOException e)
               {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
               }
           }
       }

     return outerMap;
	}
   
}