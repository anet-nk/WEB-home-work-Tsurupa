package ru.gb.hw.tsurupa.lesson_6.SwagLabs;


import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import ru.gb.hw.tsurupa.lesson6.SwagLabs.*;

@DisplayName("Тестирование сайта SwagLabs")
public class SwagLabsTest extends BasicTest {

    @Test
    @DisplayName("Авторизация по логину и паролю")
    @Description("Проверяем процесс авторизации с использованием логина и пароля")
    @Severity(SeverityLevel.BLOCKER)
    void loginTest() {
        webDriver.get(url);
        new LoginPage(webDriver)
                .fillLogon(LoginPage.login)
                .fillPassword(LoginPage.password)
                .submitLogin()
                .assertPageTitle();
    }
    @Test
    @DisplayName("Авторизация через cookies")
    @Description("Проверяем процесс авторизации с подстановкой cookies")
    @Severity(SeverityLevel.CRITICAL)
    void authWithCookies() {
        webDriver.get(url);
        webDriver.manage().addCookie(new Cookie("session-username", "standard_user"));
        webDriver.get(urlMainPage);
        new MainPage(webDriver).assertPageTitle();
    }

    @Test
    @DisplayName("Процесс покупки")
    @Description("Добавляем в корзину рюкзак и велосипедный фонарь и проходим все шаги покупки товара")
    @Severity(SeverityLevel.BLOCKER)
    void addItemsToCart() throws InterruptedException {
    webDriver.get(url);
    webDriver.manage().addCookie(new Cookie("session-username", "standard_user"));
    webDriver.get(urlMainPage);

    new MainPage(webDriver)
            .addCartBackpack()
            .assertCounterChanging("1")
            .addCartBikeLight()
            .assertCounterChanging("2")
            .goToCartPage()
            .assertTitle()
            .assertCartItems()
            .clickCheckout()
            .fillFirstName()
            .fillLastName()
            .fillPostalCode()
            .clickContinue()
            .assertTitle()
            .assertTotalPrice()
            .clickFinish()
            .assertTitle();





}

}
