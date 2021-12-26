package ru.gb.hw.tsurupa.lesson6.SwagLabs;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChechoutOverview extends BaseViewSwagLabs{
    public ChechoutOverview(WebDriver webDriver) {super(webDriver);}

    public ChechoutOverview assertTitle() {
        Assertions.assertEquals("CHECKOUT: OVERVIEW", pageTitle.getText());
        return this;
    }


    @FindBy(className = "summary_total_label")
    public WebElement totalPrice;

    public ChechoutOverview assertTotalPrice() {
        Assertions.assertEquals("Total: $43.18", totalPrice.getText());
        return this;
    }

    @FindBy(id = "finish")
    public WebElement finishBatton;

    public CheckoutComplete clickFinish() {
        finishBatton.click();
        return new CheckoutComplete(webDriver);
    }

}
