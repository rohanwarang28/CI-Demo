package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {

	 public static long pageLoadTime = 20 ; 
	 public static long implicitWait=10;
	
	 
	 
	 public static Object[][] getTestData(String filePath,String fileName,String sheetName) throws IOException{

		    //Create an object of File class to open xlsx file

		    File file =    new File(filePath+"\\"+fileName);

		    //Create an object of FileInputStream class to read excel file

		    FileInputStream inputStream = new FileInputStream(file);

		    Workbook guru99Workbook = null;

		    //Find the file extension by splitting file name in substring  and getting only extension name

		    String fileExtensionName = fileName.substring(fileName.indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class

		    guru99Workbook = new XSSFWorkbook(inputStream);

		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of XSSFWorkbook class

		        guru99Workbook = new HSSFWorkbook(inputStream);

		    }

		    //Read sheet inside the workbook by its name

		    Sheet sheet = guru99Workbook.getSheet(sheetName);

		    //Find number of rows in excel file

		   // int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

		    //Create a loop over all the rows of excel file to read it

		    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					// System.out.println(data[i][k]);
				}
			}
			return data;
		}
	
}
