

import Step.GoogleSteps;
import org.testng.annotations.Test;

public class GoogleTeste {

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

