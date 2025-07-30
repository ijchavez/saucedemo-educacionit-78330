package extentreports;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("=== INICIO DE SUITE ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
        System.out.println("=== FIN DE SUITE ===");
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentTestManager.startTest(testName);
        ExtentTestManager.getTest().log(Status.INFO, "🔄 Iniciando test: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logWithScreenshot(result, Status.PASS, "✅ Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().log(Status.FAIL, "❌ Test Failed: " + result.getMethod().getMethodName());
        ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
        logWithScreenshot(result, Status.FAIL, "📸 Captura al fallar el test");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, "⏭ Test Skipped: " + result.getMethod().getMethodName());
    }

    // Método privado para evitar repetición en success/failure
    private void logWithScreenshot(ITestResult result, Status status, String message) {
        String testName = result.getMethod().getMethodName();
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");

        if (driver != null) {
            ExtentManager.ScreenshotResult screenshot = ExtentManager.captureScreenshot(driver, testName);
            ExtentTestManager.getTest().log(status, message);
            ExtentTestManager.getTest().addScreenCaptureFromBase64String(screenshot.base64, "Screenshot - " + testName);
        } else {
            ExtentTestManager.getTest().log(Status.WARNING, "⚠ No se encontró WebDriver para capturar screenshot.");
        }
    }
}
