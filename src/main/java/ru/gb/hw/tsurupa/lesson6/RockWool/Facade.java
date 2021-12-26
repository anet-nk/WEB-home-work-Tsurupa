package ru.gb.hw.tsurupa.lesson6.RockWool;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Facade extends BaseViewRockWool {
    public Facade(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@data-link-name='ВЕНТИ БАТТС Д ОПТИМА']/span[text()='Сравнить']")
            public WebElement compareCheckboxVentyBatsDOptoma;

   public Facade compareVentyBatsDOptoma() {
       compareCheckboxVentyBatsDOptoma.click();
       return this;
   }

    @FindBy(xpath = "//div[@data-link-name='ВЕНТИ БАТТС Д']/span[text()='Сравнить']")
    public WebElement compareCheckboxVentyBatsD;

    public Facade compareVentyBatsD() {
        compareCheckboxVentyBatsD.click();
        return this;
    }

    @FindBy(xpath = "//div[@data-link-name='ВЕНТИ БАТТС Н ОПТИМА']/span[text()='Сравнить']")
    public WebElement compareCheckboxVentyBatsNOptima;

    public Facade compareVentyBatsNOptima() {
        compareCheckboxVentyBatsNOptima.click();
        return this;
    }

    public Facade deleteChatWindow() {
        JavascriptExecutor jsExecuter = (JavascriptExecutor) webDriver;
        jsExecuter.executeScript("var elem = document.getElementById(\"jvlabelWrap\");\n" +
                "elem.remove();");
        return this;
    }

    @FindBy(xpath = "//a[contains(text(), 'Сравнить')]")
    public WebElement compareButton;

    public void clickCompareButton() {
        compareButton.click();
    }


}
