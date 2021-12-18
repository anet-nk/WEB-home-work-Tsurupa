package ru.gb.hw.tsurupa.lesson_5.RockWool;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CompareMaterialsTest extends BasicTest {
    @Test
    void CompareMaterials() {
        webDriver.manage().window().setSize(new Dimension(1300, 800));
        webDriver.findElement(By.xpath("//li[contains(@class, 'js-top-nav')]/a[contains(text(), 'Продукты и конструкции')]"))
                .click();
        List<WebElement> productsAndDesigns = webDriver.findElements(By.xpath("//ul[contains(@class, 'O1-1-header__nav__list js-nav__list O1-1-header__nav__sub js-nav__sub   is-open')]/*/a"));
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(productsAndDesigns.get(0).getText()).isEqualTo("ПРОДУКТЫ И КОНСТРУКЦИИ");
        softAssertions.assertThat(productsAndDesigns.get(1).getText()).isEqualTo("Продукты и конструкции");
        softAssertions.assertThat(productsAndDesigns.get(2).getText()).isEqualTo("Наши продукты");
        softAssertions.assertThat(productsAndDesigns.get(3).getText()).isEqualTo("Утепление кровель");
        softAssertions.assertThat(productsAndDesigns.get(4).getText()).isEqualTo("Частное домостроение");
        softAssertions.assertThat(productsAndDesigns.get(5).getText()).isEqualTo("Полы и перекрытия");
        softAssertions.assertThat(productsAndDesigns.get(6).getText()).isEqualTo("Изоляция потолка");
        softAssertions.assertThat(productsAndDesigns.get(7).getText()).isEqualTo("Изоляция внутренних стен");
        softAssertions.assertThat(productsAndDesigns.get(8).getText()).isEqualTo("Утепление фасадов");
        softAssertions.assertThat(productsAndDesigns.get(9).getText()).isEqualTo("Изоляция инженерных систем зданий");
        softAssertions.assertThat(productsAndDesigns.get(10).getText()).isEqualTo("Огнезащитные решения ROCKWOOL");
        softAssertions.assertThat(productsAndDesigns.get(11).getText()).isEqualTo("Звукоизоляция");
        softAssertions.assertThat(productsAndDesigns.get(12).getText()).isEqualTo("Промышленная изоляция");
        softAssertions.assertThat(productsAndDesigns.get(13).getText()).isEqualTo("Изоляция для судостроения и морских нефтегазопромысловых сооружений");
        softAssertions.assertThat(productsAndDesigns.get(14).getText()).isEqualTo("Сэндвич-панели");
        softAssertions.assertAll();

        webDriver.findElement(By.xpath("//li[contains(@class, 'header')]/a[text()='Утепление фасадов']")).click();

        List<WebElement> facadeInsulationMenu = webDriver.findElements(By.xpath("//ul[contains(@class, 'O1-1-header__nav__list js-nav__list O1-1-header__nav__sub js-nav__sub   is-open')]/*/a"));
        softAssertions.assertThat(facadeInsulationMenu.get(0).getText()).isEqualTo("УТЕПЛЕНИЕ ФАСАДОВ");
        softAssertions.assertThat(facadeInsulationMenu.get(1).getText()).isEqualTo("Утепление фасадов");
        softAssertions.assertThat(facadeInsulationMenu.get(2).getText()).isEqualTo("Утепление фасадов с отделочным слоем из кирпича");
        softAssertions.assertThat(facadeInsulationMenu.get(3).getText()).isEqualTo("Утепление деревянных каркасных конструкций");
        softAssertions.assertThat(facadeInsulationMenu.get(4).getText()).isEqualTo("Утепление тонкослойного штукатурного фасада");
        softAssertions.assertThat(facadeInsulationMenu.get(5).getText()).isEqualTo("Утепление стеновых сэндвич-панелей");
        softAssertions.assertThat(facadeInsulationMenu.get(6).getText()).isEqualTo("Утепление фасада с облицовкой");
        softAssertions.assertThat(facadeInsulationMenu.get(7).getText()).isEqualTo("Утепление балкона");
        softAssertions.assertThat(facadeInsulationMenu.get(8).getText()).isEqualTo("Утепление фасада с толстым штукатурным слоем");
        softAssertions.assertAll();

        webDriver.findElement(By.xpath("//a[contains(text(),'Утепление тонкослойного штукатурного фасада')]")).click();

        Assertions.assertEquals("Утепление тонкослойного штукатурного фасада", webDriver.findElement(By.xpath("//span[@class='breadcrumb__point']")).getText());

        webDriver.findElement(By.xpath("//a[contains(text(), 'Найти продукт')]")).click();

        Assertions.assertEquals("Фасад", webDriver.findElement(By.xpath("//span[@class='breadcrumb__point']")).getText());

        webDriver.findElement(By.xpath("//div[@data-link-name='ВЕНТИ БАТТС Д ОПТИМА']/span[text()='Сравнить']")).click();
        webDriver.findElement(By.xpath("//div[@data-link-name='ВЕНТИ БАТТС Д']/span[text()='Сравнить']"))
                .click();
        webDriver.findElement(By.xpath("//div[@data-link-name='ВЕНТИ БАТТС Н ОПТИМА']/span[text()='Сравнить']"))
                .click();
        JavascriptExecutor jsExecuter = (JavascriptExecutor) webDriver;
        jsExecuter.executeScript("var elem = document.getElementById(\"jvlabelWrap\");\n" +
                "elem.remove();");
        webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//a[contains(text(), 'Сравнить')]"))).click();
        Assertions.assertEquals("Сравнение продукции из каменной ваты",
                webDriver.findElement(By.xpath("//h1[contains(@class, 'product-comparison-tool')]")).getText());
    }
}
