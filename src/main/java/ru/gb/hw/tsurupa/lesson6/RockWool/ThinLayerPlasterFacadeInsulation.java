package ru.gb.hw.tsurupa.lesson6.RockWool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThinLayerPlasterFacadeInsulation extends BaseViewRockWool {
    public ThinLayerPlasterFacadeInsulation(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Найти продукт')]")
    public WebElement findProduct;

    public void clickFindProductButton() {
        findProduct.click();
    }
}
