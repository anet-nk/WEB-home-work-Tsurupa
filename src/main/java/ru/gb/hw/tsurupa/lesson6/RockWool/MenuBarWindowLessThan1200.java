package ru.gb.hw.tsurupa.lesson6.RockWool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuBarWindowLessThan1200 extends BaseViewRockWool {
    public MenuBarWindowLessThan1200(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[contains(@class, 'header__menu-btn')]")
    public WebElement openMenuButton;

    @FindBy(xpath = "//a[@class='js-nav__sub-open']")
    public static List<WebElement> menuBarItems;

    @FindBy(xpath = "//ul[contains(@class, 'O1-1-header__nav__list js-nav__list O1-1-header__nav__sub js-nav__sub   is-open')]/*/a")
    public static List<WebElement> menuBarNextLevel;

    public MenuBarWindowLessThan1200 openMenu() {
        openMenuButton.click();
        return this;
    }

    public MenuBarWindowLessThan1200 chooseMenuBarItem(String itemName) {
        getElement(menuBarItems, itemName);
        return this;
    }

    public MenuBarWindowLessThan1200 chooseNextMenuItems(String itemName) {
        getElement(menuBarNextLevel, itemName);
        return this;
    }
}
