package ru.gb.hw.tsurupa.lesson6.SwagLabs;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseViewSwagLabs {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[.='Products']")
    public WebElement pageTitle;

    @Step("Проверить соответствие заголовка страницы значению \"PRODUCTS\"")
    public void assertPageTitle() {
        Assertions.assertEquals("PRODUCTS", pageTitle.getText());
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addCartBackpackButton;

    @Step("Добавить в корзину рюкзак")
    public MainPage addCartBackpack() {
        addCartBackpackButton.click();
        return this;
    }

    @FindBy(className = "shopping_cart_badge")
    public WebElement shoppingCartCounter;

    @Step("Проверить, что счетчик товаров в корзине равен значению {0}")
    public MainPage assertCounterChanging(String expectedValue) {
        Assertions.assertEquals(expectedValue, shoppingCartCounter.getText());
        return this;
    }

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement addCartBikeLightButton;

    @Step("Добавить в корзину велосипедный фонарь")
    public MainPage addCartBikeLight() {
        addCartBikeLightButton.click();
        return this;
    }

    @FindBy(className = "shopping_cart_link")
    public WebElement cartPageButton;

    @Step("Перейти в корзину")
    public CartPage goToCartPage() {
        cartPageButton.click();
        return new CartPage(webDriver);
    }
}

