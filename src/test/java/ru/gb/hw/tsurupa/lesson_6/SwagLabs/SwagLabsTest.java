package ru.gb.hw.tsurupa.lesson_6.SwagLabs;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import ru.gb.hw.tsurupa.lesson6.SwagLabs.*;


public class SwagLabsTest extends BasicTest {

    @Test
    void loginTest() {
        webDriver.get(url);
        new LoginPage(webDriver)
                .fillLogon(LoginPage.login)
                .fillPassword(LoginPage.password)
                .submitLogin()
                .assertPageTitle();
    }
    @Test
    void authWithCookies() {
        webDriver.get(url);
        webDriver.manage().addCookie(new Cookie("session-username", "standard_user"));
        webDriver.get(urlMainPage);
        new MainPage(webDriver).assertPageTitle();
    }

    @Test
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
