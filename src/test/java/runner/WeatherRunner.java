package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Specify the location of your feature files
        glue = "stepdefinitions",
        tags = "@bdd",
        // Specify the package where your step definitions are
        plugin = {"pretty", "html:target/cucumber-reports"} // Specify plugins (optional)
)
public class WeatherRunner {
}
