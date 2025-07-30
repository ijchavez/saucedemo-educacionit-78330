package extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    private static void createInstance() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportDir = System.getProperty("user.dir") + "/reports";
        String reportPath = reportDir + "/ExtentReport_" + timestamp + ".html";

        // Crear carpeta si no existe
        new File(reportDir + "/screenshots").mkdirs();

        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setDocumentTitle("Reporte de Automatización");
        reporter.config().setReportName("Ejecución de Pruebas - QA Team");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Gerardo Chavez");
        extent.setSystemInfo("Sistema Operativo", System.getProperty("os.name"));
        extent.setSystemInfo("Navegador", "Chrome");
        extent.setSystemInfo("Entorno", "QA");
    }

    /**
     * Captura una screenshot del navegador y la guarda en /reports/screenshots
     * @param driver WebDriver activo
     * @param testName nombre del test para el archivo
     * @return ruta del archivo (relativa) y base64 para Extent
     */
    public static ScreenshotResult captureScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";

        String relativePath = "screenshots/" + screenshotName;
        String fullPath = System.getProperty("user.dir") + "/reports/" + relativePath;

        String base64 = "";

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(fullPath));

            FileInputStream fis = new FileInputStream(srcFile);
            byte[] bytes = fis.readAllBytes();
            base64 = Base64.getEncoder().encodeToString(bytes);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ScreenshotResult(relativePath, base64);
    }

    public static class ScreenshotResult {
        public final String path;
        public final String base64;

        public ScreenshotResult(String path, String base64) {
            this.path = path;
            this.base64 = base64;
        }
    }
}
