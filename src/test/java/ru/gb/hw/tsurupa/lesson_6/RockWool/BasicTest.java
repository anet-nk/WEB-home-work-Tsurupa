package ru.gb.hw.tsurupa.lesson_6.RockWool;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.hw.tsurupa.lesson_6.EventListener;

import java.util.concurrent.TimeUnit;

public class BasicTest {
    protected EventFiringWebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected SoftAssertions softAssertions;
    String url = "https://www.rockwool.com/ru/";

    @BeforeEach
        void serUp() {
        webDriver = new EventFiringWebDriver(WebDriverManager.chromedriver().create());
        webDriver.register(new EventListener());
        webDriverWait = new WebDriverWait(webDriver, 5,500);
        webDriver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        softAssertions = new SoftAssertions();
        webDriver.get(url);
        webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"))).click();
    }

    @AfterEach
    void tearDown() {
        for (LogEntry logEntry : webDriver.manage().logs().get(LogType.BROWSER)) {
            Allure.addAttachment("Console log", logEntry.getMessage());
        }
        webDriver.quit();
    }
}
