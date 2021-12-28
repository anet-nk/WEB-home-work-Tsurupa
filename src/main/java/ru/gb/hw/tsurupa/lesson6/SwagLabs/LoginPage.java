package ru.gb.hw.tsurupa.lesson6.SwagLabs;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseViewSwagLabs {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    public static final String login = "standard_user";
    public static final String password = "secret_sauce";

    @FindBy(name = "user-name")
    public WebElement inputLogin;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "login-button")
    public WebElement buttonLogin;

    @Step("Ввести логин")
    public LoginPage fillLogon(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Нажать кнопку \"Login\"")
    public MainPage submitLogin() {
        buttonLogin.click();
        return new MainPage(webDriver);
    }
}
