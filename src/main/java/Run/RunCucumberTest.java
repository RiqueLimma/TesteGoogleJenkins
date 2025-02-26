package Run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/feature",  // Caminho onde o arquivo .feature está localizado
        glue = "Step",  // Pacote onde os steps estão localizados
        plugin = {"pretty", "html:target/cucumber-reports"}  // Plugins para gerar relatórios
)
public class RunCucumberTest {
    // Não precisa de código dentro dessa classe, pois ela serve apenas para rodar os testes do Cucumber.
}
