package ru.merion.aqa.practiceDZ3.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object для страницы Text Input
 */
public class Page {

    private WebDriver driver;

    // Локаторы
    private By inputField = By.cssSelector(".form-control");
    private By primaryButton = By.cssSelector(".btn-primary");

    // Конструктор
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для взаимодействия со страницей
    public Page open() {
        driver.get("http://uitestingplayground.com/textinput");
        return this;
    }

    public Page enterText(String text) {
        driver.findElement(inputField).sendKeys(text);
        return this;
    }

    public Page clickButton() {
        driver.findElement(primaryButton).click();
        return this;
    }

    public String getButtonText() {
        return driver.findElement(primaryButton).getText();
    }
}