package ru.gb.hw.tsurupa.lesson_3.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class CompareMaterials {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get("https://www.rockwool.com/ru/");
        webDriver.manage().window().setSize(new Dimension(1300, 800));
        new WebDriverWait(webDriver, 10, 500)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"))).click();
        webDriver.findElement(By.xpath("//li[contains(@class, 'js-top-nav')]/a[contains(text(), 'Продукты и конструкции')]"))
                .click();
        webDriver.findElement(By.xpath("//li[contains(@class, 'header')]/a[text()='Утепление фасадов']")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Утепление тонкослойного штукатурного фасада')]")).click();
        webDriver.findElement(By.xpath("//a[contains(text(), 'Найти продукт')]")).click();
        new WebDriverWait(webDriver, 10, 1000)
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//div[@data-link-name='ВЕНТИ БАТТС Д ОПТИМА']/span[text()='Сравнить']"))).click();
        webDriver.findElement(By.xpath("//div[@data-link-name='ВЕНТИ БАТТС Д']/span[text()='Сравнить']"))
                .click();
        JavascriptExecutor jsExecuter = (JavascriptExecutor) webDriver;
        jsExecuter.executeScript("var elem = document.getElementById(\"jvlabelWrap\");\n" +
                "elem.parentNode.removeChild(elem);");
        webDriver.findElement(By.xpath("//div[@data-link-name='ВЕНТИ БАТТС Н ОПТИМА']/span[text()='Сравнить']"))
                .click();
        new WebDriverWait(webDriver, 10, 500)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//a[contains(text(), 'Сравнить')]"))).click();
        webDriver.quit();
    }
}
