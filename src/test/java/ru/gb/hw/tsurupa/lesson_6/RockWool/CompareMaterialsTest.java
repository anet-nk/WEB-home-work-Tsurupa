package ru.gb.hw.tsurupa.lesson_6.RockWool;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import ru.gb.hw.tsurupa.lesson6.RockWool.ComparPage;
import ru.gb.hw.tsurupa.lesson6.RockWool.FacadePage;
import ru.gb.hw.tsurupa.lesson6.RockWool.MenuBar;
import ru.gb.hw.tsurupa.lesson6.RockWool.ThinLayerPlasterFacadeInsulationPage;

@DisplayName("Раздел \"Продукты и конструкции\"")
public class CompareMaterialsTest extends BasicTest {
    @Test
    @DisplayName("Проверка меню \"Продукты и конструкции\"")
    @Description("Проверяем соответствие содержания меню \"Продукты и конструкции\" требованиям")
    void productsAndDesignsMenuTest() {
        webDriver.manage().window().setSize(new Dimension(1300, 800));
        new MenuBar(webDriver).openMenuBarItems("Продукты и конструкции");

        softAssertions.assertThat(MenuBar.menuNextLevel.get(0).getText()).isEqualTo("ПРОДУКТЫ И КОНСТРУКЦИИ");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(1).getText()).isEqualTo("Продукты и конструкции");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(2).getText()).isEqualTo("Наши продукты");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(3).getText()).isEqualTo("Утепление кровель");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(4).getText()).isEqualTo("Частное домостроение");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(5).getText()).isEqualTo("Полы и перекрытия");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(6).getText()).isEqualTo("Изоляция потолка");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(7).getText()).isEqualTo("Изоляция внутренних стен");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(8).getText()).isEqualTo("Утепление фасадов");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(9).getText()).isEqualTo("Изоляция инженерных систем зданий");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(10).getText()).isEqualTo("Огнезащитные решения ROCKWOOL");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(11).getText()).isEqualTo("Звукоизоляция");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(12).getText()).isEqualTo("Промышленная изоляция");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(13).getText()).isEqualTo("Изоляция для судостроения и морских нефтегазопромысловых сооружений");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(14).getText()).isEqualTo("Сэндвич-панели");
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Сравнение продукции из каменной ваты")
    @Description("Проверяем как работает функция сравнения материалов")
    void compareMaterials() {
        webDriver.manage().window().setSize(new Dimension(1300, 800));
        new MenuBar(webDriver)
                .openMenuBarItems("Продукты и конструкции")
                .chooseNextMenuItems("Утепление фасадов");

        softAssertions.assertThat(MenuBar.menuNextLevel.get(0).getText()).isEqualTo("УТЕПЛЕНИЕ ФАСАДОВ");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(1).getText()).isEqualTo("Утепление фасадов");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(2).getText()).isEqualTo("Утепление фасадов с отделочным слоем из кирпича");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(3).getText()).isEqualTo("Утепление деревянных каркасных конструкций");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(4).getText()).isEqualTo("Утепление тонкослойного штукатурного фасада");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(5).getText()).isEqualTo("Утепление стеновых сэндвич-панелей");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(6).getText()).isEqualTo("Утепление фасада с облицовкой");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(7).getText()).isEqualTo("Утепление балкона");
        softAssertions.assertThat(MenuBar.menuNextLevel.get(8).getText()).isEqualTo("Утепление фасада с толстым штукатурным слоем");
        softAssertions.assertAll();

        new MenuBar(webDriver).chooseNextMenuItems("Утепление тонкослойного штукатурного фасада");
        Assertions.assertEquals("Утепление тонкослойного штукатурного фасада",
                new ThinLayerPlasterFacadeInsulationPage(webDriver).getTextBreadcrumbPoint());

        new ThinLayerPlasterFacadeInsulationPage(webDriver).clickFindProductButton();
        Assertions.assertEquals("Фасад", new FacadePage(webDriver).getTextBreadcrumbPoint());

        new FacadePage(webDriver)
                .compareVentyBatsDOptoma()
                .compareVentyBatsD()
                .compareVentyBatsNOptima()
                .deleteChatWindow().clickCompareButton();

        Assertions.assertEquals("Сравнение продукции из каменной ваты",
                new ComparPage(webDriver).getTextPageTitle());
    }
}
