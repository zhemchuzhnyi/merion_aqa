package ru.merion.aqa.practiceDZ3.Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MathsPage {
    private WebDriver driver;

    // Локаторы
    private By delay = By.cssSelector("#delay");

    private By number7 = By.xpath("//span[text() = '7']");
    private By sign = By.xpath("//span[text() = '+']");
    private By number8 = By.xpath("//span[text() = '8']");
    private By equal = By.xpath("//span[text() = '=']");

    public MathsPage(WebDriver driver) {
        this.driver = driver;
    }

    // открыть страницу
    public MathsPage open() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        return this;
    }

    // очистка поля
    public MathsPage clearDelay() {
        driver.findElement(delay).clear();
        return this;
    }

    // ожидание
    public MathsPage Wait(int timeout) {
        WebElement delayElement = driver.findElement(delay);
        delayField.clear();
        delayField.sendKeys(String.valueOf(timeout));
        return this;
    }

    // клики
    public MathsPage clickNumber7() {
        driver.findElement(number7).click();
        return this;
    }
    public MathsPage clickSign() {
        driver.findElement(sign).click();
        return this;
    }
    public MathsPage clickNumber8() {
        driver.findElement(number8).click();
        return this;
    }
    public MathsPage clickEqual() {
        driver.findElement(equal).click();
        return this;
    }

}
