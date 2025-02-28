import Step.GoogleSteps;
import org.testng.annotations.Test;

public class GoogleTest {

    @Test
    public void digitarEBusca() {
        GoogleSteps stepGoogle = new GoogleSteps();
        System.out.println("Executando teste...");
        stepGoogle.abrirPaginaGoogle()
                .digitarNaBarraDePesquisa("carros")
                .clicarNoBotaoDeBusca()
                .verificarResultadosPesquisa();
    }
}

