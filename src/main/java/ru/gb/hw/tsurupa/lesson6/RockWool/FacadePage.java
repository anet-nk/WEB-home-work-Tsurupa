package ru.gb.hw.tsurupa.lesson6.RockWool;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacadePage extends BaseViewRockWool {
    public FacadePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@data-link-name='ВЕНТИ БАТТС Д ОПТИМА']/span[text()='Сравнить']")
            public WebElement compareCheckboxVentyBatsDOptoma;

    @Step("Выбрать чекбокс \"Сравнить\" для материала ВЕНТИ БАТТС Д ОПТИМА")
   public FacadePage compareVentyBatsDOptoma() {
       compareCheckboxVentyBatsDOptoma.click();
       return this;
   }

    @FindBy(xpath = "//div[@data-link-name='ВЕНТИ БАТТС Д']/span[text()='Сравнить']")
    public WebElement compareCheckboxVentyBatsD;

    @Step("Выбрать чекбокс \"Сравнить\" для материала ВЕНТИ БАТТС Д")
    public FacadePage compareVentyBatsD() {
        compareCheckboxVentyBatsD.click();
        return this;
    }

    @FindBy(xpath = "//div[@data-link-name='ВЕНТИ БАТТС Н ОПТИМА']/span[text()='Сравнить']")
    public WebElement compareCheckboxVentyBatsNOptima;

    @Step("Выбрать чекбокс \"Сравнить\" для материала ВЕНТИ БАТТС Н ОПТИМА")
    public FacadePage compareVentyBatsNOptima() {
        compareCheckboxVentyBatsNOptima.click();
        return this;
    }

    @Step("Убрать мешающее диалоговое окно")
    public FacadePage deleteChatWindow() {
        JavascriptExecutor jsExecuter = (JavascriptExecutor) webDriver;
        jsExecuter.executeScript("var elem = document.getElementById(\"jvlabelWrap\");\n" +
                "elem.remove();");
        return this;
    }

    @FindBy(xpath = "//a[contains(text(), 'Сравнить')]")
    public WebElement compareButton;

    @Step("Нажать кнопку \"Сравнить\"")
    public void clickCompareButton() {
        compareButton.click();
    }


}
