package ru.gb.hw.tsurupa.lesson6.RockWool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BaseViewRockWool {
    protected WebDriver webDriver;

    public BaseViewRockWool(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void getElement(List<WebElement> menuBarItems, String itemName) {
        WebElement item = menuBarItems.stream().filter(element -> element.getText().equals(itemName)).findFirst().get();
        item.click();
    }

    @FindBy(xpath = "//span[@class='breadcrumb__point']")
    public WebElement pageBreadcrumbPoint;

    public String getTextBreadcrumbPoint() {
        return pageBreadcrumbPoint.getText();
    }

    @FindBy(xpath = "//div[@class='O3-hero-main-image-section-text-section-inner gated-link-container']/h1")
    public static WebElement pageTitle;

    public String getTextPageTitle() {
        return pageTitle.getText();
    }

}
