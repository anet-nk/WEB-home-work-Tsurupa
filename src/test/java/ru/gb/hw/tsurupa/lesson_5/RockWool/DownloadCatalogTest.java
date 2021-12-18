package ru.gb.hw.tsurupa.lesson_5.RockWool;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import java.util.List;


public class DownloadCatalogTest extends BasicTest {
    @Test
    void DownloadCatalog() {
        webDriver.manage().window().setSize(new Dimension(1300, 800));
        webDriver.findElement(By.xpath("//li[contains(@class, 'js-top-nav')]/a[contains(text(), 'Вдохновение')]"))
                .click();

        List<WebElement> facadeInsulationMenu = webDriver.findElements(By.xpath("//ul[contains(@class, 'O1-1-header__nav__list js-nav__list O1-1-header__nav__sub js-nav__sub   is-open')]/*/a"));
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(facadeInsulationMenu.get(0).getText()).isEqualTo("ВДОХНОВЕНИЕ");
        softAssertions.assertThat(facadeInsulationMenu.get(1).getText()).isEqualTo("Вдохновение");
        softAssertions.assertThat(facadeInsulationMenu.get(2).getText()).isEqualTo("Капитальный ремонт и реконструкция");
        softAssertions.assertThat(facadeInsulationMenu.get(3).getText()).isEqualTo("Виды изоляционных материалов");
        softAssertions.assertThat(facadeInsulationMenu.get(4).getText()).isEqualTo("Объекты");
        softAssertions.assertThat(facadeInsulationMenu.get(5).getText()).isEqualTo("Программа развития сотрудников");
        softAssertions.assertThat(facadeInsulationMenu.get(6).getText()).isEqualTo("Часто задаваемые вопросы");
        softAssertions.assertThat(facadeInsulationMenu.get(7).getText()).isEqualTo("Преимущества ROCKWOOL");
        softAssertions.assertThat(facadeInsulationMenu.get(8).getText()).isEqualTo("Факты о каменной вате");
        softAssertions.assertThat(facadeInsulationMenu.get(9).getText()).isEqualTo("Практические советы");
        softAssertions.assertThat(facadeInsulationMenu.get(10).getText()).isEqualTo("Тренинги");
        softAssertions.assertThat(facadeInsulationMenu.get(11).getText()).isEqualTo("Технологии");
        softAssertions.assertAll();

        webDriver.findElement(By.xpath("//li[contains(@class, 'header')]/a[text()='Капитальный ремонт и реконструкция']")).click();

        Assertions.assertEquals("Капитальный ремонт и реконструкция",
                webDriver.findElement(By.xpath("//span[@class='breadcrumb__point']")).getText());

        webDriver.findElement(By.xpath("//a[contains(text(), 'Капитальный ремонт жилого дома')]/../../../../../a")).click();

        Assertions.assertEquals("Капитальный ремонт жилого дома",
                webDriver.findElement(By.xpath("//span[@class='breadcrumb__point']")).getText());

        webDriver.findElement(By.xpath("//a[contains(text(), 'Реконструкция мансарды и чердака')]/../../../../../a")).click();

        Assertions.assertEquals("Реконструкция мансарды и чердака",
                webDriver.findElement(By.xpath("//span[@class='breadcrumb__point']")).getText());
        Assertions.assertEquals("Реконструкция мансарды и чердака",
                webDriver.findElement(By.xpath("//div[@class='O3-hero-main-image-section-text-section-inner gated-link-container']/h1")).getText());

        webDriver.findElement(By.xpath("//h6[contains(text(), 'Каталог по монтажу скатной кровли')]/../div/a")).click();
    }
}
