package Step;

import Page.GooglePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ScreenshotUtils;

public class GoogleSteps {
    private WebDriver driver;
    private GooglePage googlePage;

    @Dado("que estou na página inicial do Google")
    public GoogleSteps abrirPaginaGoogle() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless"); // Modo sem interface
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        googlePage = new GooglePage(driver);
        googlePage.abrirGoogle();

        // Tirar screenshot da página inicial
        ScreenshotUtils.tirarScreenshot(driver, "pagina_inicial_google");
        return this;
    }

    @Quando("eu digitar {string} na barra de pesquisa")
    public GoogleSteps digitarNaBarraDePesquisa(String termo) {
        googlePage.digitarPesquisa(termo);
        System.out.println("Digitou na barra de pesquisa");

        // Tirar screenshot após digitar o termo
        ScreenshotUtils.tirarScreenshot(driver, "termo_digitado_" + termo);
        return this;
    }

    @Quando("clicar no botão de busca")
    public GoogleSteps clicarNoBotaoDeBusca() {
        googlePage.clicarPesquisar();
        System.out.println("Clicando no botão pesquisa");
        try{
            Thread.sleep(3000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        // Tirar screenshot após clicar no botão
        ScreenshotUtils.tirarScreenshot(driver, "botao_busca_clicado");
        return this;
    }

    @Entao("os resultados da pesquisa devem ser exibidos")
    public GoogleSteps verificarResultadosPesquisa() {
        System.out.println("Validando a pagina");
        Assert.assertTrue(driver.getTitle().contains("carros"));

        // Tirar screenshot dos resultados
        ScreenshotUtils.tirarScreenshot(driver, "resultados_pesquisa");

        driver.quit();
        return this;
    }
}
