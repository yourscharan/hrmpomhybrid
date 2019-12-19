package com.hrm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.hrm.qa.Base.TestBase;

public class TestUtil extends TestBase {
       
      public TestUtil() throws Exception {
	super();
    }

    public   static long PAGE_LOAD_TIMEOUT=20;
      public  static long IMPLICIT_WAIT=10;
      
      public static String TESTDATA_SHEET_PATH="D:\\nagneon\\HRMPOMHYBRID\\src"
      	+ "\\main\\java\\com\\hrm\\qa\\TestData\\hrmpomhybrid.xlsx";
      
      static Workbook book;
      static Sheet sheet;
      
      public void switchToFrame(){
	  driver.switchTo().frame("rightMenu");
      }
      
     
      
      
      public static Object[][] getTestData(String sheetname) throws EncryptedDocumentException, IOException, InvalidFormatException{
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		book = WorkbookFactory.create(file);
		
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;  		
	}

      public static void takeScreenshotAtEndOfTest() throws IOException {
	  String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File("D:\\qaplanet"+timestamp+".png"));
	}
	
      
}
