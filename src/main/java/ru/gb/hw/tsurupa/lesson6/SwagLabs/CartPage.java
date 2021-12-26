package ru.gb.hw.tsurupa.lesson6.SwagLabs;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BaseViewSwagLabs{
    public CartPage(WebDriver webDriver) {super(webDriver);}
     SoftAssertions softAssertions;


    public CartPage assertTitle() {
        Assertions.assertEquals("YOUR CART", pageTitle.getText());
        return this;
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> cartItems;

    public CartPage assertCartItems() {
        softAssertions = new SoftAssertions();
        softAssertions.assertThat(cartItems.get(0).getText()).isEqualTo("Sauce Labs Backpack");
        softAssertions.assertThat(cartItems.get(1).getText()).isEqualTo("Sauce Labs Bike Light");
        softAssertions.assertAll();
        return this;
    }

    @FindBy(id = "checkout")
            public WebElement checkoutButton;

    public CheckoutYourInformation clickCheckout() {
        checkoutButton.click();
        return new CheckoutYourInformation(webDriver);
    }
}
