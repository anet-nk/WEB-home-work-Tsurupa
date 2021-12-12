package ru.gb.hw.tsurupa.lesson_3.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DownloadСatalog {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized"); //todo или передать нужные размеры через webDriver.manage().window().setSize();
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://www.rockwool.com/ru/");
        new WebDriverWait(webDriver, 10, 500)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"))).click();
        webDriver.findElement(By.xpath("//li[contains(@class, 'js-top-nav')]/a[contains(text(), 'Вдохновение')]"))
                .click();
        webDriver.findElement(By.xpath("//li[contains(@class, 'header')]/a[text()='Капитальный ремонт и реконструкция']")).click();

        webDriver.findElement(By.xpath("//a[contains(text(), 'Капитальный ремонт жилого дома')]/../../../../../a")).click();
        webDriver.findElement(By.xpath("//a[contains(text(), 'Реконструкция мансарды и чердака')]/../../../../../a")).click();
        webDriver.findElement(By.xpath("//h6[contains(text(), 'Каталог по монтажу скатной кровли')]/../div/a")).click();
        Thread.sleep(30000);
        webDriver.quit();
    }
}
