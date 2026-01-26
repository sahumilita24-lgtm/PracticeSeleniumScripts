package ex17_DataDrivenTesting_POI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class pr {
	

	
	public static FileInputStream fis;
	public static Workbook book;
	public static Sheet sheet;
	@Test
	public static Object[][] readexcel(String sheet1) 
	{
	FileInputStream fis= null;
	String filepath = System.getProperty("user.dir")+ "/src/test/java/resources/TESTDATA.xlsx";
	try {
		fis = new FileInputStream(filepath);
		book = WorkbookFactory.create(fis);
		sheet= book.getSheet(sheet1);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	 
	
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	
	
	for(int i = 0; i< sheet.getLastRowNum(); i++)
	{
		for(int j =0; j< sheet.getRow(i).getLastCellNum();j++)
			
		{
			data [i][j] = sheet.getRow(i+1).getCell(j).toString();
		}
	}
	return data;
	
	}
}
