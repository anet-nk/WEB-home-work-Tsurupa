package ru.gb.hw.tsurupa.lesson_5.RockWool;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class CalculateInsulationTest extends BasicTest {

    @Test
    void calculateInsulation() {
        webDriver.manage().window().setSize(new Dimension(1300, 800));
        List<WebElement> headerMenu = webDriver.findElements(By.xpath("//a[@class='has-sub']"));

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(headerMenu.get(0).getText()).isEqualTo("Продукты и конструкции");
        softAssertions.assertThat(headerMenu.get(1).getText()).isEqualTo("Библиотека");
        softAssertions.assertThat(headerMenu.get(2).getText()).isEqualTo("Вдохновение");
        softAssertions.assertThat(headerMenu.get(3).getText()).isEqualTo("О нас");
        softAssertions.assertThat(headerMenu.get(4).getText()).isEqualTo("Контакты");
        softAssertions.assertAll();

        webDriver.findElement(By.xpath("//li[contains(@class, 'js-top-nav')]/a[contains(text(), 'Библиотека')]"))
                .click();

        List<WebElement> library = webDriver.findElements(By.xpath("//li[@class='O1-1-header__nav__item js-nav__item  ']"));
        softAssertions.assertThat(library.get(0).getText()).isEqualTo("Калькуляторы");
        softAssertions.assertThat(library.get(1).getText()).isEqualTo("Альбомы, каталоги и отчеты");
        softAssertions.assertThat(library.get(2).getText()).isEqualTo("Материалы для проектирования");
        softAssertions.assertThat(library.get(3).getText()).isEqualTo("Сертификаты и декларации");
        softAssertions.assertThat(library.get(4).getText()).isEqualTo("Техническая поддержка");
        softAssertions.assertThat(library.get(5).getText()).isEqualTo("Видео");
        softAssertions.assertThat(library.get(6).getText()).isEqualTo("Технические листы и даташиты");
        softAssertions.assertAll();

        webDriver.findElement(By.xpath("//li[contains(@class, 'header')]/a[text()='Калькуляторы']")).click();
        Assertions.assertEquals("Калькуляторы", webDriver.findElement(By.xpath("//span[@class='breadcrumb__point']")).getText());

        webDriver.findElement(By.xpath("//a[contains(text(),'Начать расчёт')]")).click();

        List<String> tabs = new ArrayList<>(webDriver.getWindowHandles()); //список с вкладками
        webDriver.switchTo().window(tabs.get(1)); //переключение на вторую вкладку.

        List<WebElement> constructions = webDriver.findElements(By.xpath("//div[contains(@class, 'nav-text')]"));
        softAssertions.assertThat(constructions.get(0).getText()).isEqualTo("Кровля");
        softAssertions.assertThat(constructions.get(1).getText()).isEqualTo("Стены");
        softAssertions.assertThat(constructions.get(2).getText()).isEqualTo("Перекрытия");
        softAssertions.assertAll();

        webDriver.findElement(By.xpath("//div[text()='Стены']")).click();
        webDriver.findElement(By.xpath("//span[text()='штукатурный фасад по стенам с несущим монолитным каркасом']"))
                .click();
        webDriver.findElement(By.xpath("//select[contains(@name, 'material_type') and contains(@style, 'pointer')]/.."))
                .click();

        Assertions.assertEquals("Простой расчёт", webDriver.findElement(By.xpath("//li[@class='active']//a"))
                .getText());

        webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Фасадная теплоизоляция']")))
                .click();
        webDriver.findElement(By.xpath("//li[text()='ФАСАД БАТТС ОПТИМА']")).click();
        webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("material_thickness")))
                .sendKeys("100");
        new Select(webDriver.findElement(By.id("heater"))).selectByVisibleText("ФАСАД БАТТС ОПТИМА");
        webDriver.findElement(By.id("btn-calc")).click();

        List<WebElement> finalActions = webDriver.findElements(By.xpath("//div[@class='form-group row controls']//div"));
        softAssertions.assertThat(finalActions.get(0).findElement(By.xpath(".//a")).getText()).isEqualTo("Отправить на почту");
        softAssertions.assertThat(finalActions.get(1).findElement(By.xpath(".//span")).getText()).isEqualTo("Скачать PDF");
        softAssertions.assertThat(finalActions.get(2).findElement(By.xpath(".//a")).getText()).isEqualTo("Печать");
        softAssertions.assertThat(finalActions.get(3).findElement(By.xpath(".//span")).getText()).isEqualTo("Сохранить");
        softAssertions.assertAll();

        webDriver.findElement(By.xpath("//span[text()='Скачать PDF']")).click();
    }
}
