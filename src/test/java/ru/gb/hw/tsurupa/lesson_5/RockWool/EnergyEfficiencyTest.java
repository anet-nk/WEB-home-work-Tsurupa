package ru.gb.hw.tsurupa.lesson_5.RockWool;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EnergyEfficiencyTest extends BasicTest{
    @Test
    void energyEfficiency() {
        webDriver.manage().window().setSize(new Dimension(1000, 800));
        webDriver.findElement(By.xpath("//button[contains(@class, 'header__menu-btn')]")).click();

        List<WebElement> headerMenu = webDriver.findElements(By.xpath("//a[@class='js-nav__sub-open']"));

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(headerMenu.get(0).getText()).isEqualTo("Продукты и конструкции");
        softAssertions.assertThat(headerMenu.get(1).getText()).isEqualTo("Библиотека");
        softAssertions.assertThat(headerMenu.get(2).getText()).isEqualTo("Вдохновение");
        softAssertions.assertThat(headerMenu.get(3).getText()).isEqualTo("О нас");
        softAssertions.assertThat(headerMenu.get(4).getText()).isEqualTo("Контакты");
        softAssertions.assertAll();

        webDriver.findElement(By.xpath("//a[contains(@class, 'js-nav') and contains(text(), 'О нас')]"))
                .click();

        List<WebElement> aboutUsMenu = webDriver.findElements
                (By.xpath("//ul[contains(@class, 'O1-1-header__nav__list js-nav__list O1-1-header__nav__sub js-nav__sub   is-open')]/*/a"));
        softAssertions.assertThat(aboutUsMenu.get(0).getText()).isEqualTo("О НАС");
        softAssertions.assertThat(aboutUsMenu.get(1).getText()).isEqualTo("О нас");
        softAssertions.assertThat(aboutUsMenu.get(2).getText()).isEqualTo("Деловая этика");
        softAssertions.assertThat(aboutUsMenu.get(3).getText()).isEqualTo("Новости");
        softAssertions.assertThat(aboutUsMenu.get(4).getText()).isEqualTo("Корпоративная ответственность");
        softAssertions.assertThat(aboutUsMenu.get(5).getText()).isEqualTo("Наше видение");
        softAssertions.assertThat(aboutUsMenu.get(6).getText()).isEqualTo("Политика информирования");
        softAssertions.assertThat(aboutUsMenu.get(7).getText()).isEqualTo("Устойчивое развитие");
        softAssertions.assertAll();

        webDriver.findElement(By.xpath("//a[contains(@class, 'js-nav') and text()='Наше видение']")).click();

        List<WebElement> ourVisionMenu = webDriver.findElements
                (By.xpath("//ul[contains(@class, 'O1-1-header__nav__list js-nav__list O1-1-header__nav__sub js-nav__sub   is-open')]/*/a"));
        softAssertions.assertThat(ourVisionMenu.get(0).getText()).isEqualTo("НАШЕ ВИДЕНИЕ");
        softAssertions.assertThat(ourVisionMenu.get(1).getText()).isEqualTo("Наше видение");
        softAssertions.assertThat(ourVisionMenu.get(2).getText()).isEqualTo("Энергоэффективные проекты");
        softAssertions.assertAll();

        webDriver.findElement(By.xpath("//li[contains(@class, 'header')]/a[text()='Энергоэффективные проекты']")).click();

        Assertions.assertEquals("Энергоэффективность в строительстве",
                webDriver.findElement(By.xpath("//div[@class='O3-hero-main-image-section-text-section-inner gated-link-container']/h1"))
                        .getText());

        webDriver.findElement(By.xpath("//a[contains(@data-tracking-label, 'rockwool_energyefficiency_projects')]")).click();
    }
}
