package ru.gb.hw.tsurupa.lesson6.SwagLabs;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChechoutOverviewPage extends BaseViewSwagLabs{
    public ChechoutOverviewPage(WebDriver webDriver) {super(webDriver);}

    @Step("Проверить соответствие заголовка страницы значению \"CHECKOUT: OVERVIEW\"")
    public ChechoutOverviewPage assertTitle() {
        Assertions.assertEquals("CHECKOUT: OVERVIEW", pageTitle.getText());
        return this;
    }


    @FindBy(className = "summary_total_label")
    public WebElement totalPrice;

    @Step("Проверит значение итоговой суммы - Total: $43.18")
    public ChechoutOverviewPage assertTotalPrice() {
        Assertions.assertEquals("Total: $43.18", totalPrice.getText());
        return this;
    }

    @FindBy(id = "finish")
    public WebElement finishBatton;

    @Step("Нажать на кнопку Finish")
    public CheckoutCompletePage clickFinish() {
        finishBatton.click();
        return new CheckoutCompletePage(webDriver);
    }

}
