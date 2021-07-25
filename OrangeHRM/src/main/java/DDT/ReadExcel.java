package DDT;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(System.getProperty("user.dir", "\\lendings.xlsx"));
		
		FileInputStream  ip = new FileInputStream(file); 
		XSSFWorkbook workbook = new XSSFWorkbook(ip); //load file in workbook class
		
		XSSFSheet sheet = workbook.getSheetAt(0); //load perticular sheet
		 
			String cell =	sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(cell);
		

	}

}
