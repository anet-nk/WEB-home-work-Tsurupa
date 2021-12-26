package ru.gb.hw.tsurupa.lesson6.SwagLabs;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BaseViewSwagLabs{
    public CheckoutCompletePage(WebDriver webDriver) {super(webDriver);}
    public CheckoutCompletePage assertTitle() {
        Assertions.assertEquals("CHECKOUT: COMPLETE!", pageTitle.getText());
        return this;
    }
}
