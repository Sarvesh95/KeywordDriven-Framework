package casestudy3a;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MobileskeywordDrivenTest extends DriverManager {

	Properties prop = new Properties();
	InputStream inputConfig = null;
	static String inputpath = "C:\\Users\\sarve\\eclipse-workspace\\Endureka\\src\\test\\resources\\Config.properties";
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		loadproperties();
		setDriver(prop.getProperty("browser"));
	}
	
	@Test
	public void TestExecution()  {
		
	   
		
		ExcelReader es = new ExcelReader();
		CommonUtilities util = new CommonUtilities(driver);
		XSSFSheet sh = es.getWorksheet(prop.getProperty("excelpath"), prop.getProperty("Sheetname"));
		 int rowC = es.getRowCount();
		 int colC = es.getColCount();
		
		 Object TestData = null;

		for(int j = 1 ; j<rowC ; j++) {
			
			double Tcd = es.readNumericCell(sh, j, 0);
			String Description = es.readStringCell(sh, j, 1);
			String locatorType = es.readStringCell(sh, j, 2);
			String locatorValue = es.readStringCell(sh, j, 3);
			CellType DataType = es.readCellType(sh, j, 4);
			switch(DataType) {
			
			case STRING :
				
				 TestData = es.readStringCell(sh, j, 4);
				
				break;
			
			case NUMERIC :
				
				 TestData = es.readNumericCell(sh, j, 4);
				
				break;
			}
			String Action = es.readStringCell(sh, j, 5);
			
			try {
				util.performActions(Action, locatorType, locatorValue, TestData);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			 
			try {
				es.closeWorkbook();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	public void loadproperties() throws IOException {
		

		try {
			inputConfig = new FileInputStream(inputpath);
			prop.load(inputConfig);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
}
