package ru.gb.hw.tsurupa.lesson6.SwagLabs;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseViewSwagLabs {
    WebDriver webDriver;


    public BaseViewSwagLabs(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(className = "title")
    public WebElement pageTitle;

}
