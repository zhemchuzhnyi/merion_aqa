package ru.merion.aqa.Practics.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPageTask2 {
    private final WebDriver driver;

    public AuthPageTask2(WebDriver driver) {
        this.driver = driver;
    }

    public AuthPageTask2 open() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    public MainPageOpen login(String username, String password) {
        driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#login-button")).click();
        return new MainPageOpen(driver);
    }

    public TryOpenBurger burger() {
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
        driver.findElement(By.cssSelector("#about_sidebar_link")).click();
        return TryOpenBurger;
    }

    public TryToGoBack goBack() {
        driver.navigate().back();
        return this;
    }

    public String getMainLogo() {
        return driver.findElement(By.cssSelector(".app_logo")).getText();
    }
}