package com.evaa.vtiger.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataPractise {
// remember both XSSFWorkbook and HSSFWorkbook have same object and same parent return type 
	// so we used only make the object on the basis of workbook if we have 
	// .xlsx file then male object of XSSFWorkbook and if we have .xls file extension then 
	// make object of HSSFWorkbook 
public static void main(String[] args) throws IOException {
	
	
	readFile("C:\\Users\\HP\\Desktop\\verify_product.xlsx");
	
}
public static void readFile(String filePath) throws IOException {
	
InputStream	fis=new FileInputStream(filePath);
Workbook wbook=null;
if(filePath.contains(".xlsx")) {
	
 wbook = new XSSFWorkbook(fis);
}else {
	  wbook = new HSSFWorkbook(fis);
}
	Sheet sheet=wbook.getSheet("ProductTestCases"); //Sheet is parent of XSSFSheet
int rowCount=	sheet.getLastRowNum();
for(int i=0; i<=rowCount; i++) {
	Row row= sheet.getRow(i);  //Row is parent of XSSFRow
	if (row==null) {
		continue;
	}
int cellCount=	row.getLastCellNum();
for (int j=0; j<=cellCount; j++) {
	Cell cell= row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);    //Cell is parent XSSFCell
if(cell.getCellType()==CellType.NUMERIC) {
	Double dblCellData= cell.getNumericCellValue();
	Integer intCellData= dblCellData.intValue();
    String cellData=	intCellData.toString();
    System.out.println(cellData);
}else {
    String cellData=	cell.getStringCellValue();
    System.out.println(cellData);
}
	
	System.out.println();
}
}
	
	
	
}


}


