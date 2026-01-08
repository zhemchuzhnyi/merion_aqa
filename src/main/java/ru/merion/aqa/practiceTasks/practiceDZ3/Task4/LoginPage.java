// LoginPage.java
package ru.merion.aqa.practiceTasks.practiceDZ3.Task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.cssSelector("#user-name");
    private By passwordField = By.cssSelector("#password");
    private By loginButton = By.cssSelector("#login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}