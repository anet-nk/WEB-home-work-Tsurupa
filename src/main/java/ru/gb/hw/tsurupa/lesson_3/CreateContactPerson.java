package ru.gb.hw.tsurupa.lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CreateContactPerson {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath
                ("//span[contains(@class, 'title') and text()='Проекты']/.."))).build().perform();
        driver.findElement(By.xpath("//span[text()='Мои проекты']")).click();
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();
        driver.findElement(By.name("crm_project[name]")).sendKeys("crm_project[name]");


        driver.quit();
    }
    static void login(WebDriver driver) {
        WebElement element = driver.findElement(By.name("_username"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.name("name=_password")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

    }
}
