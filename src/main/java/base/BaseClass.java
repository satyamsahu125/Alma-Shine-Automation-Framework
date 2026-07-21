package base;

import java.io.IOException;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import utilities.PropertiesUtility;

public class BaseClass {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected static PropertiesUtility propertiesFile;
	protected static utilities.ExcelUtility excel;
	
	
	
	@BeforeSuite
	public void setUp(){
		excel = new utilities.ExcelUtility("./src/test/resources/TestData/testCaseData.xlsx");
		propertiesFile = new PropertiesUtility("./src/test/resources/Config/config.properties");
		

	}
	@BeforeMethod
	public void openBrowser() throws IOException{

		String browserName = propertiesFile.getData("browser");
		
		driver = factory.DriverFactory.initializeDriver(browserName);

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String url = propertiesFile.getData("url");
		driver.get(url);
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		
	}
	
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
	//excel data provider 
	@DataProvider(name = "testData")
	public Object[][] excelDataProvider(Method testMethodName) {

		String sheetName = testMethodName.getName();
		
		int rowLength = excel.getRowLength(sheetName);
		int colLength = excel.getColLength(sheetName);
		

		Object[][] table = new Object[rowLength-1][colLength];
		
		for(int i = 1 ; i < rowLength ; i++) {
			for(int j = 0 ; j < colLength ; j++) {
				table[i - 1][j] = excel.getData(sheetName, i, j);
			}
		}
		return table;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
