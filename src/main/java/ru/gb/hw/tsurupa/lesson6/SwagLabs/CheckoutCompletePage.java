package ru.gb.hw.tsurupa.lesson6.SwagLabs;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BaseViewSwagLabs{
    public CheckoutCompletePage(WebDriver webDriver) {super(webDriver);}

    @Step("Проверить соответствие заголовка страницы значению \"CHECKOUT: COMPLETE!\"")
    public CheckoutCompletePage assertTitle() {
        Assertions.assertEquals("CHECKOUT: COMPLETE!", pageTitle.getText());
        return this;
    }
}
