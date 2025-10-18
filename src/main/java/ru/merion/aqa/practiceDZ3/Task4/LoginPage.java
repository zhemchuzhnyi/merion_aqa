package ru.merion.aqa.practiceDZ3.Task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.cssSelector("#user-name");
    private By passwordField = By.cssSelector("#password");
    public By loginButton = By.cssSelector("#login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username) {
        driver.findElement(usernameField).sendKeys("standard_user");
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys("secret_sauce");
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
    }
}
