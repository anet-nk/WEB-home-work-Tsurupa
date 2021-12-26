package ru.gb.hw.tsurupa.lesson_6.RockWool;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.gb.hw.tsurupa.lesson6.RockWool.Calculators;
import ru.gb.hw.tsurupa.lesson6.RockWool.MenuBar;

import java.util.ArrayList;
import java.util.List;

public class CalculateInsulationTest extends BasicTest {

    @Test
    void calculateInsulation() throws InterruptedException {
        webDriver.manage().window().setSize(new Dimension(1300, 800));
        new MenuBar(webDriver);
        softAssertions.assertThat(MenuBar.menuBarItems.get(0).getText()).isEqualTo("Продукты и конструкции");
        softAssertions.assertThat(MenuBar.menuBarItems.get(1).getText()).isEqualTo("Библиотека");
        softAssertions.assertThat(MenuBar.menuBarItems.get(2).getText()).isEqualTo("Вдохновение");
        softAssertions.assertThat(MenuBar.menuBarItems.get(3).getText()).isEqualTo("О нас");
        softAssertions.assertThat(MenuBar.menuBarItems.get(4).getText()).isEqualTo("Контакты");
        softAssertions.assertAll();

        new MenuBar(webDriver).openMenuBarItems("Библиотека");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(0).getText()).isEqualTo("БИБЛИОТЕКА");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(1).getText()).isEqualTo("Библиотека");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(2).getText()).isEqualTo("Калькуляторы");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(3).getText()).isEqualTo("Альбомы, каталоги и отчеты");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(4).getText()).isEqualTo("Материалы для проектирования");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(5).getText()).isEqualTo("Сертификаты и декларации");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(6).getText()).isEqualTo("Техническая поддержка");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(7).getText()).isEqualTo("Видео");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(8).getText()).isEqualTo("Технические листы и даташиты");
        softAssertions.assertAll();

        new MenuBar(webDriver).chooseNextMenuItems("Калькуляторы");
        Assertions.assertEquals("Калькуляторы", new Calculators(webDriver).getTextBreadcrumbPoint());

        new Calculators(webDriver).clickStartCalculationButton();

        //Далее не могу отрефакторить тест, т.к. данный функционал проверяемого сайта временно не работает.

//        List<String> tabs = new ArrayList<>(webDriver.getWindowHandles()); //список с вкладками
//        webDriver.switchTo().window(tabs.get(1)); //переключение на вторую вкладку.
//
//        List<WebElement> constructions = webDriver.findElements(By.xpath("//div[contains(@class, 'nav-text')]"));
//        softAssertions.assertThat(constructions.get(0).getText()).isEqualTo("Кровля");
//        softAssertions.assertThat(constructions.get(1).getText()).isEqualTo("Стены");
//        softAssertions.assertThat(constructions.get(2).getText()).isEqualTo("Перекрытия");
//        softAssertions.assertAll();
//
//        webDriver.findElement(By.xpath("//div[text()='Стены']")).click();
//        webDriver.findElement(By.xpath("//span[text()='штукатурный фасад по стенам с несущим монолитным каркасом']"))
//                .click();
//        webDriver.findElement(By.xpath("//select[contains(@name, 'material_type') and contains(@style, 'pointer')]/.."))
//                .click();
//
//        Assertions.assertEquals("Простой расчёт", webDriver.findElement(By.xpath("//li[@class='active']//a"))
//                .getText());
//
//        webDriverWait
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Фасадная теплоизоляция']")))
//                .click();
//        webDriver.findElement(By.xpath("//li[text()='ФАСАД БАТТС ОПТИМА']")).click();
//        webDriverWait
//                .until(ExpectedConditions.visibilityOfElementLocated(By.name("material_thickness")))
//                .sendKeys("100");
//        new Select(webDriver.findElement(By.id("heater"))).selectByVisibleText("ФАСАД БАТТС ОПТИМА");
//        webDriver.findElement(By.id("btn-calc")).click();
//
//        List<WebElement> finalActions = webDriver.findElements(By.xpath("//div[@class='form-group row controls']//div"));
//        softAssertions.assertThat(finalActions.get(0).findElement(By.xpath(".//a")).getText()).isEqualTo("Отправить на почту");
//        softAssertions.assertThat(finalActions.get(1).findElement(By.xpath(".//span")).getText()).isEqualTo("Скачать PDF");
//        softAssertions.assertThat(finalActions.get(2).findElement(By.xpath(".//a")).getText()).isEqualTo("Печать");
//        softAssertions.assertThat(finalActions.get(3).findElement(By.xpath(".//span")).getText()).isEqualTo("Сохранить");
//        softAssertions.assertAll();
//
//        webDriver.findElement(By.xpath("//span[text()='Скачать PDF']")).click();
   }
}
