package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public  static ExtentReports report;
	public static ExtentReports getReporter()
	{
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Framework results");
		reporter.config().setDocumentTitle("Results");
		
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Bindu");
		return report;
		
		
	}
	
}
