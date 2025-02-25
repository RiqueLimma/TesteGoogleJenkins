package Step;

import Page.GooglePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSteps {
    private WebDriver driver;
    private GooglePage googlePage;

    @Dado("que estou na página inicial do Google")
    public void abrirPaginaGoogle() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/driver/chromedriver.exe");
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
        googlePage.abrirGoogle();
    }

    @Quando("eu digitar {string} na barra de pesquisa")
    public void digitarNaBarraDePesquisa(String termo) {
        googlePage.digitarPesquisa(termo);
    }

    @Quando("clicar no botão de busca")
    public void clicarNoBotaoDeBusca() {
        googlePage.clicarPesquisar();
    }

    @Entao("os resultados da pesquisa devem ser exibidos")
    public void verificarResultadosPesquisa() {
        Assert.assertTrue(driver.getTitle().contains("carros"));
        driver.quit();
    }
}
