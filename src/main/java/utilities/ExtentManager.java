package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentReports extent;
	
	public static ExtentReports getReport() {
		
		
		if(extent == null) {
			
			
			ExtentSparkReporter spark = new ExtentSparkReporter("./reports/TestReport.html");
			
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Alma Shine Automation");
			spark.config().setReportName("Test Execution Report");
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
			
			
			extent.setSystemInfo("Tester", "Satyam Sahu");
            extent.setSystemInfo("Environment", "QA");
		}
		
		
		return extent;
	}

	
}
