package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public  class XLUtils {      
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    static XSSFSheet sheet;
    static XSSFWorkbook workbook;

    public XLUtils (String excelPath, String sheetName ) {
    	  try  {
    	    workbook = new XSSFWorkbook(excelPath);
    	    sheet = workbook.getSheet(sheetName);
    	  } catch (Exception e) {
    	   e.printStackTrace();
    	  }
    	}
    
    
    public int getRowCount(String xlfile,String xlsheet) throws IOException {
    	fi=new FileInputStream(xlfile);
    	wb=new XSSFWorkbook(fi);
    	ws=wb.getSheet(xlsheet);
    	int rowcount=ws.getLastRowNum();
    	wb.close();
    	fi.close();
    	return rowcount;
    }
    public int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException {
    	fi=new FileInputStream(xlfile);
    	wb=new XSSFWorkbook(fi);
    	ws=wb.getSheet(xlsheet);
    	row=ws.getRow(rownum);
    	int cellcount=row.getLastCellNum();
    	wb.close();
    	fi.close();
    	return cellcount;
    }
    public static String GetCellDataString(int rowNum, int colNum) {
    	
        String cellData = null;
    	try {
    		 cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
         System.out.println(cellData);
      
       }catch(Exception exp) {
    	System.out.println(exp.getMessage());
    	System.out.println(exp.getCause());
    	exp.printStackTrace();
    	
       }
     return cellData;
    	
    }

    public static double GetCellDataNumber(int rowNum, int colNum) {
      double cellData = 0;
    	try {
    	 cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
        } catch(Exception exp) {
    	System.out.println(exp.getMessage());
    	System.out.println(exp.getCause());
    	exp.printStackTrace();
      }
    	 return cellData;

     }
}