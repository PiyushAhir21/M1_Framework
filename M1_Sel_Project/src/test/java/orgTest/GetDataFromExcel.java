package orgTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		step 1 : get java representation object of the physical file 
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\testData.xlsx");

//		ss.usermodel
		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("org");

		Row row = sh.getRow(1);

		Cell cell = row.getCell(0);

		String value = cell.getStringCellValue() + (int)(Math.random()*1000) ;
		System.out.println(value);
	}

}
