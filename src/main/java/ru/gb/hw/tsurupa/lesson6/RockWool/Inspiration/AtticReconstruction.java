package ru.gb.hw.tsurupa.lesson6.RockWool.Inspiration;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.hw.tsurupa.lesson6.RockWool.BaseViewRockWool;

public class AtticReconstruction extends BaseViewRockWool {
    public AtticReconstruction(WebDriver webDriver) {
        super(webDriver);
    }
    public static String pitchedRoofCatalogUrl = "https://p-cdn.rockwool.com/siteassets/rw-ru/inspiration/renovation/ROCKWOOL_DIY_Solutions-for-roof_2021.pdf?f=20210311054412";

    @FindBy(xpath = "//a[contains(@href, 'https://p-cdn.rockwool.com/siteassets/rw-ru/inspiration/renovation/ROCKWOOL_DIY_Solutions-for-roof')]")
    public WebElement downloadCatalog;


    @Step("Скачать каталог по монтажу скатной кровли ")
    public void downloadCatalog() {
        downloadCatalog.click();
    }
}
