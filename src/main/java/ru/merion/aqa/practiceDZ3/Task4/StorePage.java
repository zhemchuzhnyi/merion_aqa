package ru.merion.aqa.practiceDZ3.Task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StorePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#user-name")
    private WebElement username;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "#login-button")
    private WebElement loginButton;

}
