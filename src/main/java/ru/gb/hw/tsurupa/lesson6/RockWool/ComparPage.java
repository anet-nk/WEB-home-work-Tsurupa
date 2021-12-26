package ru.gb.hw.tsurupa.lesson6.RockWool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparPage extends BaseViewRockWool{
    public ComparPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//h1[contains(@class, 'product-comparison-tool')]")
    public WebElement pageTitle;

    @Override
    public String getTextPageTitle() {
        return pageTitle.getText();
    }
}
