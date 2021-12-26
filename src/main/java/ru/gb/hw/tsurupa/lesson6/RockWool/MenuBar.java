package ru.gb.hw.tsurupa.lesson6.RockWool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuBar extends BaseViewRockWool {
    public MenuBar(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='has-sub']")
    public static List<WebElement> menuBarItems;

    @FindBy(xpath = "//ul[contains(@class, 'O1-1-header__nav__list js-nav__list O1-1-header__nav__sub js-nav__sub   is-open')]/*/a")
    public static List<WebElement> menuNextLevel;


    public MenuBar openMenuBarItems(String itemName) {
        getElement(menuBarItems, itemName);
        return this;
    }

    public MenuBar chooseNextMenuItems(String itemName) {
        getElement(menuNextLevel, itemName);
        return this;
    }
    }
