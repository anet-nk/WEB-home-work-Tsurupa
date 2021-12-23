package ru.gb.hw.tsurupa.lesson_3.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EnergyEfficiency {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get("https://www.rockwool.com/ru/");
        webDriver.manage().window().setSize(new Dimension(1000, 800));
        new WebDriverWait(webDriver, 10, 500)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"))).click();
        webDriver.findElement(By.xpath("//button[contains(@class, 'header__menu-btn')]")).click();
        webDriver.findElement(By.xpath("//a[contains(@class, 'js-nav') and contains(text(), 'О нас')]"))
                .click();
        webDriver.findElement(By.xpath("//a[contains(@class, 'js-nav') and text()='Наше видение']")).click();
        webDriver.findElement(By.xpath("//li[contains(@class, 'header')]/a[text()='Энергоэффективные проекты']")).click();
        webDriver.findElement(By.xpath("//a[contains(@data-tracking-label, 'rockwool_energyefficiency_projects')]")).click();
        Thread.sleep(3000);
        webDriver.quit();
    }
}
