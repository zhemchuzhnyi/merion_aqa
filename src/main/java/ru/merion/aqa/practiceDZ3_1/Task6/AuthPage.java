package ru.merion.aqa.practiceDZ3_1.Task6;

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
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#login-button")).click();
        return new CatalogPage(driver);
    }
}
