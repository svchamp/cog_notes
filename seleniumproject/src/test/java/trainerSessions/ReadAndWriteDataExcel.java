package trainerSessions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteDataExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file=new FileInputStream("C:\\Users\\2318403\\OneDrive - Cognizant\\Desktop\\Trainer Sessions\\ReadAndWriteData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		int row=sheet.getLastRowNum();
		int col=sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<row;i++) {
			XSSFRow row1=sheet.getRow(i);
			for(int j=0;j<col;j++) {
				XSSFCell cell=row1.getCell(j);
				String val=cell.toString();
				System.out.print(val + "\t");
			}
			System.out.println();
		}
	}

}
