package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static void tirarScreenshot(WebDriver driver, String nomeArquivo) {
        // Cria o diretório caso não exista
        File dir = new File("target/screenshots/");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("target/screenshots/" + nomeArquivo + ".png");

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot salva em: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao tirar screenshot: " + e.getMessage());
        }
    }
}
