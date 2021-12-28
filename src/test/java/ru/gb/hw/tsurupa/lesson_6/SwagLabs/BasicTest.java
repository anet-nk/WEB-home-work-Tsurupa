package ru.gb.hw.tsurupa.lesson_6.SwagLabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.gb.hw.tsurupa.lesson_6.EventListener;
import java.util.concurrent.TimeUnit;

@ExtendWith(AllureJunit5.class)
public class BasicTest {
    protected EventFiringWebDriver webDriver;
    protected SoftAssertions softAssertions;
    static String url = "https://www.saucedemo.com/";
    static String urlMainPage = "https://www.saucedemo.com/inventory.html";

    @BeforeEach
    void serUp() {
        webDriver = new EventFiringWebDriver(WebDriverManager.chromedriver().create());
        webDriver.register(new EventListener());
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssertions = new SoftAssertions();

    }

    @AfterEach
    void tearDown() {
        for (LogEntry logEntry : webDriver.manage().logs().get(LogType.BROWSER)) {
            Allure.addAttachment("Console log", logEntry.getMessage());
        }
        webDriver.quit();
    }
}
