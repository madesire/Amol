package listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	static ExtentReports reportx ;
	public static ExtentReports extentreportgenerator() {
		ExtentHtmlReporter report = new ExtentHtmlReporter(("user.dir")+"\\reports\\kitezerodhareport.html");
		report.config().setTheme(Theme.DARK);
		report.config().setReportName("First_Extent_report");
		ExtentReports reportx =new ExtentReports();
		reportx.attachReporter(report);
		reportx.setSystemInfo("This is my first extent report", "Reported by RUSHI PAWAR");
		reportx.setSystemInfo("Executed On Date :-", "03/08/2022");
		reportx.setSystemInfo("Environment used for Executing  = ", "QA Environment");
		return reportx;

}
}
