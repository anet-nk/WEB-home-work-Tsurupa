package ru.gb.hw.tsurupa.lesson6.RockWool;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThinLayerPlasterFacadeInsulationPage extends BaseViewRockWool {
    public ThinLayerPlasterFacadeInsulationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Найти продукт')]")
    public WebElement findProduct;

    @Step("Нажать на кнопку \"Найти продукт\"")
    public void clickFindProductButton() {
        findProduct.click();
    }
}
