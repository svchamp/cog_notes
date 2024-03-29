package trainerSessions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DeleteLastRow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Create an object of File class to open xlsx file
        File file =    new File("C:\\Users\\2318403\\OneDrive - Cognizant\\Desktop\\ReadAndWriteData.xlsx");
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        //creating workbook instance that refers to .xls file
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        //creating a Sheet object using the sheet Name
        XSSFSheet sheet=wb.getSheet("Sheet1");
        //Create a row object to retrieve row at index 3
        XSSFRow row2=sheet.createRow(3);
        //create a cell object to enter value in it using cell Index
        row2.createCell(0).setCellValue("Diana");
        row2.createCell(1).setCellValue("Jane");
        row2.createCell(2).setCellValue("djanes@gmail.com");
        row2.createCell(3).setCellValue("Female");
        row2.createCell(4).setCellValue("8786858432");
        row2.createCell(5).setCellValue("Park Lane, Flat C1 , New Jersey");
        //write the data in excel using output stream
        FileOutputStream outputStream = new FileOutputStream("C:\\\\Users\\\\2318403\\\\OneDrive - Cognizant\\\\Desktop\\\\ReadAndWriteData.xlsx");
        wb.write(outputStream);
        wb.close();
	}

}

/*
import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	public class Pom3 {
	    public static  void main(String args[]) throws IOException {
	    	//Create an object of File class to open xlsx file
	        File file =    new File("/Users/poojadesai/Documents/Testdata.xlsx");
	        //Create an object of FileInputStream class to read excel file
	        FileInputStream inputStream = new FileInputStream(file);
	        //creating workbook instance that refers to .xls file
	        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
	        //creating a Sheet object using the sheet Name
	        XSSFSheet sheet=wb.getSheet("Sheet1");
	        //Create a row object to retrieve row at index 3
	        XSSFRow row2=sheet.createRow(3);
	        //create a cell object to enter value in it using cell Index
	        row2.createCell(0).setCellValue("Diana");
	        row2.createCell(1).setCellValue("Jane");
	        row2.createCell(2).setCellValue("djanes@gmail.com");
	        row2.createCell(3).setCellValue("Female");
	        row2.createCell(4).setCellValue("8786858432");
	        row2.createCell(5).setCellValue("Park Lane, Flat C1 , New Jersey");
	        //write the data in excel using output stream
	        FileOutputStream outputStream = new FileOutputStream("/Users/poojadesai/Documents/Testdata.xlsx");
	        wb.write(outputStream);
	        wb.close();
 
	    }
	}
*/
