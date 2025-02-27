package Run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",  // Caminho correto do arquivo de features
        glue = "Step",  // Pacote onde os steps estão localizados
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunCucumberTest {
}
