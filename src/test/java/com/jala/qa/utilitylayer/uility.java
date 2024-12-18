package com.jala.qa.utilitylayer;

import java.io.File;
import java.io.IOException;
import java.security.cert.Extension;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.jala.qa.testbase.testBase;

public class uility extends testBase {

	public uility() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	// this is extent report
	public static ExtentReports getExtentReport() {
			
			ExtentReports report = new ExtentReports();
			
			File extentReportFile = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
			
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
			
			report.attachReporter(sparkReporter);
			
			return report;
			
		}

	//screenshot
	public static String takeScreenshot(String testName) {
		
		File sourceScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationScreenshotFile = new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");
		try {
//			FileUtils.copyFile(sourceScreenshotFile, destinationScreenshotFile);
			FileHandler.copy(sourceScreenshotFile, destinationScreenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destinationScreenshotFile.getAbsolutePath();

	}
	}


