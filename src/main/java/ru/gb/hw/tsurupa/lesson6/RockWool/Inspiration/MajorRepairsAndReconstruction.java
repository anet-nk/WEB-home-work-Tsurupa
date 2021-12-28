package ru.gb.hw.tsurupa.lesson6.RockWool.Inspiration;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.hw.tsurupa.lesson6.RockWool.BaseViewRockWool;

public class MajorRepairsAndReconstruction extends BaseViewRockWool {
    public MajorRepairsAndReconstruction(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@href='/ru/advice-and-inspiration/renovation/homeowner-renovation/' and @class='card-stretched-link']")
    public WebElement majorResidentialBuildingRenovation;

    @Step("Перейти на страницу \"Капитальный ремонт жилого дома\"")
    public MajorRenovationOfResidentialBuilding clickToPageMajorRenovationOfResidentialBuilding() {
        majorResidentialBuildingRenovation.click();
        return new MajorRenovationOfResidentialBuilding(webDriver);
    }
}
