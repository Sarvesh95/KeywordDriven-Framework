package casestudy3a;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;







public class ExcelReader{

   XSSFWorkbook book;
   XSSFSheet sheet;
	

	
	public XSSFSheet getWorksheet(String pathname, String sheetname)  {
		try {
			book = new XSSFWorkbook(pathname);
			sheet = book.getSheet(sheetname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sheet;
		
		
	
	}
	
	public void closeWorkbook() throws IOException {
		
		book.close();
	}
	
	public int getRowCount() {
		
		return sheet.getPhysicalNumberOfRows();
	}
	
	 public int getColCount() {
		 
		 return sheet.getRow(0).getPhysicalNumberOfCells();
	 }
	 
	 
	 
	 public CellType readCellType(XSSFSheet worksheet, int row, int col) {
		 
		 CellType celltype = worksheet.getRow(row).getCell(col).getCellType();
		 
		 return celltype;
	 }
	 
	 public String readStringCell(XSSFSheet worksheet, int row, int col) {
		 
		 String celldata = worksheet.getRow(row).getCell(col).getStringCellValue();
		 
		 return celldata;
	 }
	 
	 public int readNumericCell(XSSFSheet worksheet, int row, int col) {
		 
		 
		int celldata = (int) worksheet.getRow(row).getCell(col).getNumericCellValue();
		
		return celldata;
	 }
}