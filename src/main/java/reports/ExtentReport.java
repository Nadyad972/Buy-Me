package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport {
    // creates a toggle for the given test, adds all log events under it
//    private static ExtentTest test ;

    public static ExtentReports getReportInstance(){
    String cwd = System.getProperty("user.dir");
    ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
    // attach reporter
        // create ExtentReports and attach reporter(s)
        ExtentReports extentReport = new ExtentReports();
        extentReport.attachReporter(htmlReporter);
    return extentReport;
//    // name your test and add description
//    test = extent.createTest("MyFirstTest", "Sample description");
//    // add custom system info
//        extent.setSystemInfo("Environment", "Production");
//        extent.setSystemInfo("Tester", "Daniel");
//    // log results
//        test.log(Status.INFO, "@Before class");
}
}
