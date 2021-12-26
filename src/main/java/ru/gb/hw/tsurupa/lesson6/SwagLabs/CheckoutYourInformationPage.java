package ru.gb.hw.tsurupa.lesson6.SwagLabs;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends BaseViewSwagLabs{
    public CheckoutYourInformationPage(WebDriver webDriver) {super(webDriver);}
    private final Faker faker = new Faker();

    @FindBy(id = "first-name")
            public WebElement inputFirstName;

    public CheckoutYourInformationPage fillFirstName() {
        inputFirstName.sendKeys(faker.funnyName().name());
        return this;
    }

    @FindBy(id = "last-name")
    public WebElement inputLastName;

    public CheckoutYourInformationPage fillLastName() {
        inputLastName.sendKeys(faker.funnyName().name());
        return this;
    }

    @FindBy(id = "postal-code")
    public WebElement inputPostalCode;

    public CheckoutYourInformationPage fillPostalCode() {
        inputPostalCode.sendKeys("192012");
        return this;
    }

    @FindBy(id = "continue")
    public WebElement continueBatton;

    public ChechoutOverviewPage clickContinue() {
        continueBatton.click();
        return new ChechoutOverviewPage(webDriver);
    }

}
