package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {
    private WebDriver driver;

    // Localizadores
    private By barraPesquisa = By.name("q");
    private By botaoPesquisa = By.name("btnK");

    // Construtor
    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirGoogle() {
        driver.get("https://www.google.com");
    }

    public void digitarPesquisa(String termo) {
        WebElement campo = driver.findElement(barraPesquisa);
        campo.sendKeys(termo);
    }

    public void clicarPesquisar() {
        WebElement botao = driver.findElement(botaoPesquisa);
        botao.submit();
    }

}
