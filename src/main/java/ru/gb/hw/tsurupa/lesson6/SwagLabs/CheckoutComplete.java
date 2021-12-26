package ru.gb.hw.tsurupa.lesson6.SwagLabs;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete extends BaseViewSwagLabs{
    public CheckoutComplete(WebDriver webDriver) {super(webDriver);}
    public CheckoutComplete assertTitle() {
        Assertions.assertEquals("CHECKOUT: COMPLETE!", pageTitle.getText());
        return this;
    }
}
