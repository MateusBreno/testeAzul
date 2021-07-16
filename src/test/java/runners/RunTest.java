package runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/comprar_passagem.feature",
		glue = "steps",
		publish = true,
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true,
		strict = true
		)

public class RunTest {
	
}
