package ru.gb.hw.tsurupa.lesson_5.RockWool;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasicTest {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    String url = "https://www.rockwool.com/ru/";

    @BeforeEach
            void serUp() {
        webDriver = WebDriverManager.chromedriver().create();
        webDriverWait = new WebDriverWait(webDriver, 5,500);
        webDriver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        webDriver.get(url);
        webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"))).click();
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}
