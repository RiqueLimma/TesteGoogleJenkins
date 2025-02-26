package Step;

import Page.GooglePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSteps {
    private WebDriver driver;
    private GooglePage googlePage;

    @Dado("que estou na página inicial do Google")
    public void abrirPaginaGoogle() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Modo sem interface
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
        googlePage.abrirGoogle();
    }

    @Quando("eu digitar {string} na barra de pesquisa")
    public void digitarNaBarraDePesquisa(String termo) {
        googlePage.digitarPesquisa(termo);
        System.out.println("Digitou na barra de pesquisa");
    }

    @Quando("clicar no botão de busca")
    public void clicarNoBotaoDeBusca() {
        googlePage.clicarPesquisar();
        System.out.println("Clicando no botão pesquisa");
    }

    @Entao("os resultados da pesquisa devem ser exibidos")
    public void verificarResultadosPesquisa() {
        System.out.println("Validando a pagina");
        Assert.assertTrue(driver.getTitle().contains("carros"));
        driver.quit();
    }
}
