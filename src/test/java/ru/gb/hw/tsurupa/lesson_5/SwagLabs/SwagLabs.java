package ru.gb.hw.tsurupa.lesson_5.SwagLabs;

import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SwagLabs extends BasicTest {
    static final String username = "standard_user";
    static final String password = "secret_sauce";
    private final Faker faker = new Faker();
    SoftAssertions softAssertions = new SoftAssertions();

    @Test
    void authorization() {
        webDriver.get(url);
        webDriver.findElement(By.name("user-name")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.id("login-button")).click();
        assertThat(webDriver.findElement(By.xpath("//span[.='Products']")).getText()).isEqualTo("PRODUCTS");


    }

    @Test
    void authWithCookies() {
        webDriver.get("https://www.saucedemo.com/");
        webDriver.manage().addCookie(new Cookie("session-username", "standard_user"));
        webDriver.get("https://www.saucedemo.com/inventory.html");
        assertThat(webDriver.findElement(By.xpath("//span[.='Products']")).getText()).isEqualTo("PRODUCTS");
    }

@Test
    void addItemsToCart() throws InterruptedException {
    webDriver.get("https://www.saucedemo.com/");
    webDriver.manage().addCookie(new Cookie("session-username", "standard_user"));
    webDriver.get("https://www.saucedemo.com/inventory.html");
    webDriver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    Assertions.assertEquals("1", webDriver.findElement(By.className("shopping_cart_badge")).getText());
    webDriver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    Assertions.assertEquals("2", webDriver.findElement(By.className("shopping_cart_badge")).getText());
    webDriver.findElement(By.className("shopping_cart_link")).click();
    Assertions.assertEquals("YOUR CART", webDriver.findElement(By.className("title")).getText());

    List<WebElement> items = webDriver.findElements(By.xpath("//div[@class='inventory_item_name']"));

    softAssertions.assertThat(items.get(0).getText()).isEqualTo("Sauce Labs Backpack");
    softAssertions.assertThat(items.get(1).getText()).isEqualTo("Sauce Labs Bike Light");
    softAssertions.assertAll();

    webDriver.findElement(By.id("checkout")).click();
    webDriver.findElement(By.id("first-name")).sendKeys(faker.funnyName().name());
    webDriver.findElement(By.id("last-name")).sendKeys(faker.funnyName().name());
    webDriver.findElement(By.id("postal-code")).sendKeys("192012");
    webDriver.findElement(By.id("continue")).click();

    Assertions.assertEquals("CHECKOUT: OVERVIEW", webDriver.findElement(By.className("title")).getText());
    Assertions.assertEquals("Total: $43.18", webDriver.findElement(By.className("summary_total_label")).getText());
    webDriver.findElement(By.id("finish")).click();

    Assertions.assertEquals("CHECKOUT: COMPLETE!", webDriver.findElement(By.className("title")).getText());

}

}
