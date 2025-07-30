package com.advancedseleniumfunctions;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ReportExample {
	public static void main(String[] args) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("report.html"); 
		ExtentReports extent = new ExtentReports(); extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Prueba de Reporte"); 
		test.pass("La prueba se ejecutó correctamente"); 
		extent.flush();
		
	}
}
