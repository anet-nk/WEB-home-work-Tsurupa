package ru.gb.hw.tsurupa.lesson_3.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CompareMaterials {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.rockwool.com/ru/");
        webDriver.manage().window().setSize(new Dimension(1600, 800));
        //при меньшем размере окна кнопка "Сравнить" закрывается вкладкой обратной связи, которую нельзя убрать
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
        webDriver.findElement(By.xpath("//div[@data-link-name='ВЕНТИ БАТТС Н ОПТИМА']/span[text()='Сравнить']"))
                .click();
        new WebDriverWait(webDriver, 10, 500)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//a[contains(text(), 'Сравнить')]"))).click();
        Thread.sleep(3000);
        webDriver.quit();
    }
}
