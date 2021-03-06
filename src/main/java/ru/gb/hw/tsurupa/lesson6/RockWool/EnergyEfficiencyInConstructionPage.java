package ru.gb.hw.tsurupa.lesson6.RockWool;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnergyEfficiencyInConstructionPage extends BaseViewRockWool {
    public EnergyEfficiencyInConstructionPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[contains(@data-tracking-label, 'rockwool_energyefficiency_projects')]")
    public WebElement downloadCatalog;

    @Step("Скачать каталог эффективных проектов")
    public void downloadCatalog() {
        downloadCatalog.click();
    }


}
