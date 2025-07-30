package extentreports;

import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    private static Map<Integer, ExtentTest> testMap = new HashMap<>();

    public static synchronized ExtentTest getTest() {
        return testMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized void startTest(String testName) {
        ExtentTest test = ExtentManager.getInstance().createTest(testName);
        testMap.put((int) Thread.currentThread().getId(), test);
    }
}
