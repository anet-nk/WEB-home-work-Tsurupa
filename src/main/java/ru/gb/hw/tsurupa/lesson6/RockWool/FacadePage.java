package ru.gb.hw.tsurupa.lesson6.RockWool;

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

   public FacadePage compareVentyBatsDOptoma() {
       compareCheckboxVentyBatsDOptoma.click();
       return this;
   }

    @FindBy(xpath = "//div[@data-link-name='ВЕНТИ БАТТС Д']/span[text()='Сравнить']")
    public WebElement compareCheckboxVentyBatsD;

    public FacadePage compareVentyBatsD() {
        compareCheckboxVentyBatsD.click();
        return this;
    }

    @FindBy(xpath = "//div[@data-link-name='ВЕНТИ БАТТС Н ОПТИМА']/span[text()='Сравнить']")
    public WebElement compareCheckboxVentyBatsNOptima;

    public FacadePage compareVentyBatsNOptima() {
        compareCheckboxVentyBatsNOptima.click();
        return this;
    }

    public FacadePage deleteChatWindow() {
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
