package ru.gb.hw.tsurupa.lesson6.SwagLabs;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends BaseViewSwagLabs{
    public CheckoutYourInformationPage(WebDriver webDriver) {super(webDriver);}
    private final Faker faker = new Faker();

    @FindBy(id = "first-name")
            public WebElement inputFirstName;

    @Step("Заполнить поле \"first-name\" случайным значением")
    public CheckoutYourInformationPage fillFirstName() {
        inputFirstName.sendKeys(faker.funnyName().name());
        return this;
    }

    @FindBy(id = "last-name")
    public WebElement inputLastName;

    @Step("Заполнить поле \"last-name\" случайным значением")
    public CheckoutYourInformationPage fillLastName() {
        inputLastName.sendKeys(faker.funnyName().name());
        return this;
    }

    @FindBy(id = "postal-code")
    public WebElement inputPostalCode;

    @Step("Заполнить поле \"PostalCode\" значением 192012")
    public CheckoutYourInformationPage fillPostalCode() {
        inputPostalCode.sendKeys("192012");
        return this;
    }

    @FindBy(id = "continue")
    public WebElement continueBatton;

    @Step("Нажать на кнопку \"Продолжить\"")
    public ChechoutOverviewPage clickContinue() {
        continueBatton.click();
        return new ChechoutOverviewPage(webDriver);
    }

}
