package ru.gb.hw.tsurupa.lesson6.SwagLabs;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BaseViewSwagLabs{
    public CartPage(WebDriver webDriver) {super(webDriver);}
     SoftAssertions softAssertions;

    @Step("Проверить соответствие заголовка страницы значению \"YOUR CART\"")
    public CartPage assertTitle() {
        Assertions.assertEquals("YOUR CART", pageTitle.getText());
        return this;
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> cartItems;

    @Step("Проверить товары в корзине")
    public CartPage assertCartItems() {
        softAssertions = new SoftAssertions();
        softAssertions.assertThat(cartItems.get(0).getText()).isEqualTo("Sauce Labs Backpack");
        softAssertions.assertThat(cartItems.get(1).getText()).isEqualTo("Sauce Labs Bike Light");
        softAssertions.assertAll();
        return this;
    }

    @FindBy(id = "checkout")
            public WebElement checkoutButton;

    @Step("Нажать на кнопку Checkout")
    public CheckoutYourInformationPage clickCheckout() {
        checkoutButton.click();
        return new CheckoutYourInformationPage(webDriver);
    }
}
