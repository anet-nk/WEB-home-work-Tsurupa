package ru.gb.hw.tsurupa.lesson_3.HW3;

import com.sun.org.apache.bcel.internal.ExceptionConstants;
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
import java.util.concurrent.TimeUnit;

public class CalculateInsulation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized"); //todo или передать нужные размеры через webDriver.manage().window().setSize();
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://www.rockwool.com/ru/");
        new WebDriverWait(webDriver, 10, 500)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"))).click();
        webDriver.findElement(By.xpath("//li[contains(@class, 'js-top-nav')]/a[contains(text(), 'Библиотека')]"))
                .click();
        webDriver.findElement(By.xpath("//li[contains(@class, 'header')]/a[text()='Калькуляторы']")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Начать расчёт')]")).click();
//      После нажатия на кнопку начать расчет открывается вкладка и она уже активна, но все падает,
//      поэтому говорю явно нажать на вторую вкладку и тогда все работает.
//      Больше ничего в голову не пришло для решения данной проблемы
        List<String> tabs = new ArrayList<>(webDriver.getWindowHandles()); //список с вкладками
        webDriver.switchTo().window(tabs.get(1)); //переключение на вторую вкладку.

        webDriver.findElement(By.xpath("//div[text()='Стены']")).click();
        webDriver.findElement(By.xpath("//span[text()='штукатурный фасад по стенам с несущим монолитным каркасом']"))
                .click();
        webDriver.findElement(By.xpath("//select[contains(@name, 'material_type') and contains(@style, 'pointer')]/.."))
                .click();
        new WebDriverWait(webDriver, 10, 500)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Фасадная теплоизоляция']")))
                .click();
        webDriver.findElement(By.xpath("//li[text()='ФАСАД БАТТС ОПТИМА']")).click();
        new WebDriverWait(webDriver, 10, 500)
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("material_thickness")))
                .sendKeys("100");
        new Select(webDriver.findElement(By.id("heater"))).selectByVisibleText("ФАСАД БАТТС ОПТИМА");
        webDriver.findElement(By.id("btn-calc")).click();
        webDriver.findElement(By.xpath("//span[text()='Скачать PDF']")).click();
        Thread.sleep(3000);
        webDriver.quit();
    }
}
