package ru.gb.hw.tsurupa.lesson_6.SwagLabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BasicTest {
    protected WebDriver webDriver;
    protected SoftAssertions softAssertions;
    static String url = "https://www.saucedemo.com/";
    static String urlMainPage = "https://www.saucedemo.com/inventory.html";

    @BeforeEach
    void serUp() {
        webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssertions = new SoftAssertions();

    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}
