package ru.gb.hw.tsurupa.lesson_6.RockWool;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import ru.gb.hw.tsurupa.lesson6.RockWool.Inspiration.AtticReconstruction;
import ru.gb.hw.tsurupa.lesson6.RockWool.Inspiration.MajorRenovationOfResidentialBuilding;
import ru.gb.hw.tsurupa.lesson6.RockWool.Inspiration.MajorRepairsAndReconstruction;
import ru.gb.hw.tsurupa.lesson6.RockWool.MenuBar;

@DisplayName("Раздел Вдохновение и скачивание каталога с сайта RockWool")
public class DownloadCatalogTest extends BasicTest {
    @Test
    @DisplayName("Проверка меню \"Вдохновение\"")
    @Description("Проверяем соответствие содержания меню требованиям")
    void menuInspirationTest() {
        webDriver.manage().window().setSize(new Dimension(1300, 800));

        new MenuBar(webDriver).openMenuBarItems("Вдохновение");

        softAssertions.assertThat(MenuBar.menuNextLevel.get(0).getText()).isEqualTo("ВДОХНОВЕНИЕ");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(1).getText()).isEqualTo("Вдохновение");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(2).getText()).isEqualTo("Капитальный ремонт и реконструкция");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(3).getText()).isEqualTo("Виды изоляционных материалов");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(4).getText()).isEqualTo("Объекты");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(5).getText()).isEqualTo("Программа развития сотрудников");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(6).getText()).isEqualTo("Часто задаваемые вопросы");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(7).getText()).isEqualTo("Преимущества ROCKWOOL");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(8).getText()).isEqualTo("Факты о каменной вате");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(9).getText()).isEqualTo("Практические советы");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(10).getText()).isEqualTo("Тренинги");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(11).getText()).isEqualTo("Технологии");
        softAssertions.assertAll();
    }
    @Test
    @DisplayName("Проверка пути до страницы \"Реконструкция мансарды и чердака\"")
    void pathToPageAtticReconstruction() {
        webDriver.manage().window().setSize(new Dimension(1300, 800));

        new MenuBar(webDriver)
                .openMenuBarItems("Вдохновение")
                .chooseNextMenuItems("Капитальный ремонт и реконструкция");
        Assertions.assertEquals("Капитальный ремонт и реконструкция",
                new MajorRepairsAndReconstruction(webDriver).getTextBreadcrumbPoint());

        new MajorRepairsAndReconstruction(webDriver).clickToPageMajorRenovationOfResidentialBuilding();
        Assertions.assertEquals("Капитальный ремонт жилого дома",
                new MajorRenovationOfResidentialBuilding(webDriver).getTextBreadcrumbPoint());

        new MajorRenovationOfResidentialBuilding(webDriver).clickToPageAtticReconstruction();

        Assertions.assertEquals("Реконструкция мансарды и чердака",
                new AtticReconstruction(webDriver).getTextBreadcrumbPoint());
        Assertions.assertEquals("Реконструкция мансарды и чердака",
                new AtticReconstruction(webDriver).getTextPageTitle());
    }
    @Test
    @DisplayName("Скачивание каталога")
    @Description("Проверка скачивания каталога по монтажу скатной кровли")
    void downloadCatalog() {
        webDriver.manage().window().setSize(new Dimension(1300, 800));

        new MenuBar(webDriver)
                .openMenuBarItems("Вдохновение")
                .chooseNextMenuItems("Капитальный ремонт и реконструкция");
        new MajorRepairsAndReconstruction(webDriver)
                .clickToPageMajorRenovationOfResidentialBuilding()
                .clickToPageAtticReconstruction()
                .downloadCatalog();
        Assertions.assertEquals(AtticReconstruction.pitchedRoofCatalogUrl, webDriver.getCurrentUrl());
    }
}
