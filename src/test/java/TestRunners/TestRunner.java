package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/FeatureFiles",
        glue = "StepDefinitions",
        plugin = "json:target/jsonReports/cucumber-report.json",
        tags = "@All")
public class TestRunner {
}
