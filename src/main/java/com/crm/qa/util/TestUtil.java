package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 30;
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static String  TEST_DATA_FILE_PATH = "D:\\Selenium\\HomePractice\\CRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\CRM_TestDataExcel.xlsx";
	
	
	public void switchToFrame() {
		//driver.switchTo().frame(""); 
		
	}
	
	public static Object[][] getTestData(String sheetname) throws Exception
	{
		
		FileInputStream fin = null;
		fin = new FileInputStream(TEST_DATA_FILE_PATH);
		
		wb =  new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetname);
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i< sheet.getLastRowNum(); i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
