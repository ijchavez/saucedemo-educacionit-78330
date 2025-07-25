package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"src/test/java/stepsdefinitions"},
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
