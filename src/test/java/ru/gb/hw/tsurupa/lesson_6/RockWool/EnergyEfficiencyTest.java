package ru.gb.hw.tsurupa.lesson_6.RockWool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import ru.gb.hw.tsurupa.lesson6.RockWool.EnergyEfficiencyInConstructionPage;
import ru.gb.hw.tsurupa.lesson6.RockWool.MenuBarWindowLessThan1200;


public class EnergyEfficiencyTest extends BasicTest {
    @Test
    @DisplayName("Проверка стартового меню ")
    void menuWindowLessThan1200Test() {
        webDriver.manage().window().setSize(new Dimension(1000, 800));
        new MenuBarWindowLessThan1200(webDriver).openMenu();

        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarItems.get(0).getText()).isEqualTo("Продукты и конструкции");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarItems.get(1).getText()).isEqualTo("Библиотека");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarItems.get(2).getText()).isEqualTo("Вдохновение");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarItems.get(3).getText()).isEqualTo("О нас");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarItems.get(4).getText()).isEqualTo("Контакты");
        softAssertions.assertAll();

    }
    @Test
    @DisplayName("Проверка меню \"О нас\"")
    void menuAboutUsWindowLessThan1200Test() {
        webDriver.manage().window().setSize(new Dimension(1000, 800));
        new MenuBarWindowLessThan1200(webDriver)
                .openMenu()
                .chooseMenuBarItem("О нас");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarNextLevel.get(0).getText()).isEqualTo("О НАС");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarNextLevel.get(1).getText()).isEqualTo("О нас");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarNextLevel.get(2).getText()).isEqualTo("Деловая этика");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarNextLevel.get(3).getText()).isEqualTo("Новости");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarNextLevel.get(4).getText()).isEqualTo("Корпоративная ответственность");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarNextLevel.get(5).getText()).isEqualTo("Наше видение");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarNextLevel.get(6).getText()).isEqualTo("Политика информирования");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarNextLevel.get(7).getText()).isEqualTo("Устойчивое развитие");
        softAssertions.assertAll();
    }
    @Test
    @DisplayName("Проверка меню \"Наше видение\"")
    void menuOurVisionWindowLessThan1200Test() {
        webDriver.manage().window().setSize(new Dimension(1000, 800));
        new MenuBarWindowLessThan1200(webDriver)
                .openMenu()
                .chooseMenuBarItem("О нас")
                .chooseNextMenuItems("Наше видение");

        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarNextLevel.get(0).getText()).isEqualTo("НАШЕ ВИДЕНИЕ");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarNextLevel.get(1).getText()).isEqualTo("Наше видение");
        softAssertions.assertThat(MenuBarWindowLessThan1200.menuBarNextLevel.get(2).getText()).isEqualTo("Энергоэффективные проекты");
        softAssertions.assertAll();
    }
    @Test
    @DisplayName("Проверка возможности скачать каталог на странице \"Энергоэффективные проекты\"")
    void downloadCatalog() {
        webDriver.manage().window().setSize(new Dimension(1000, 800));
        new MenuBarWindowLessThan1200(webDriver)
                .openMenu()
                .chooseMenuBarItem("О нас")
                .chooseNextMenuItems("Наше видение")
                .chooseNextMenuItems("Энергоэффективные проекты");

        Assertions.assertEquals("Энергоэффективность в строительстве", new EnergyEfficiencyInConstructionPage(webDriver).getTextPageTitle());

        new EnergyEfficiencyInConstructionPage(webDriver).downloadCatalog();
    }
}
