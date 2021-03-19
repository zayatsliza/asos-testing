package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "stepdefinitions"
)
public class RunnerTests {
}
