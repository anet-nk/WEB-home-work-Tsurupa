package ru.gb.hw.tsurupa.lesson6.SwagLabs;

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

    public void assertPageTitle() {
        Assertions.assertEquals("PRODUCTS", pageTitle.getText());
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addCartBackpackButton;

    public MainPage addCartBackpack() {
        addCartBackpackButton.click();
        return this;
    }

    @FindBy(className = "shopping_cart_badge")
    public WebElement shoppingCartCounter;

    public MainPage assertCounterChanging(String expectedValue) {
        Assertions.assertEquals(expectedValue, shoppingCartCounter.getText());
        return this;
    }

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement addCartBikeLightButton;

    public MainPage addCartBikeLight() {
        addCartBikeLightButton.click();
        return this;
    }

    @FindBy(className = "shopping_cart_link")
    public WebElement cartPageButton;

    public CartPage goToCartPage() {
        cartPageButton.click();
        return new CartPage(webDriver);
    }
}

