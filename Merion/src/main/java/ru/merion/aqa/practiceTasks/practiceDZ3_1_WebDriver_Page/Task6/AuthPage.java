package ru.merion.aqa.practiceTasks.practiceDZ3_1_WebDriver_Page.Task6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage {
    private final WebDriver driver;

    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthPage open() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    public CatalogPage loginAs(String username, String password) {
        driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#login-button")).click();
        return new CatalogPage(driver);
    }
}