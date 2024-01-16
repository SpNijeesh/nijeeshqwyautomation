package qwy.automationqwy.resources;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter htmlReporter;

    public static ExtentReports createInstance() {
    	String reportFilePath = System.getProperty("user.dir") + "//reports//index.html";
        htmlReporter = new ExtentSparkReporter(reportFilePath);
        try {
            File reportDir = new File(System.getProperty("user.dir") + "//reports");
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            htmlReporter = new ExtentSparkReporter(reportFilePath);
            htmlReporter.config().setDocumentTitle("Extent Report Demo");
            htmlReporter.config().setReportName("Test Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            System.out.println("ExtentReports instance created successfully.");
        } catch (Exception e) {
            System.err.println("Error creating ExtentReports instance: " + e.getMessage());
            e.printStackTrace();
        }

        return extent;
    }

//        htmlReporter.config().setDocumentTitle("Extent Report Demo");
//        htmlReporter.config().setReportName("Test Automation Report");
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);

//        return extent;
//    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
