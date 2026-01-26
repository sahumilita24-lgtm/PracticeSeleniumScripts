package ex17_DataDrivenTesting_POI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilExcel {
	
	//get the path of the sheet placed
	//Open the sheet using FileInoutStream
	//Load the file by converting to right format i.e XSSF or HSSF using WorkBookfactory class
	//get the spreadhsheet which you want to use using getsheet method
	//put the data in Object[][] 2D array i.e row- getLastRownum column getrow.getlastcellnum()
	//using fro loop read the data from the excel sheet
	//return the 2d array
	
	public static String sheet_path = System.getProperty("user.dir")+ "/src/test/java/resources/TESTDATA.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static Object[][] getTestDataFromExcel(String sheetname) 
	{
		FileInputStream fis = null;
		try {
			
			fis = new FileInputStream(sheet_path);
			book= WorkbookFactory.create(fis);
			sheet = book.getSheet(sheetname);
			
			} catch (FileNotFoundException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; //loading the size here to tha 2d array
		
		for (int i =0 ; i< sheet.getLastRowNum();i++) //iterate through row
		{
			for (int j=0; j < sheet.getRow(0).getLastCellNum(); j++)
			{
				data[i][j] =  sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
		
	}
	

}
