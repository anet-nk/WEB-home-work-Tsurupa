package ru.gb.hw.tsurupa.lesson6.RockWool;

import com.sun.deploy.security.WIExplorerBrowserAuthenticator14;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Calculators extends BaseViewRockWool{
    public Calculators(WebDriver webDriver) {super(webDriver);}

    @FindBy(xpath = "//a[contains(text(),'Начать расчёт')]")
    public WebElement startCalculationButton;

    public void clickStartCalculationButton() {
        startCalculationButton.click();
    }
}
