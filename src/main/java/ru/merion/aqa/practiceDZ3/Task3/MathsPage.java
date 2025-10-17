package ru.merion.aqa.practiceDZ3.Task3;

import org.openqa.selenium.By;

import java.sql.Driver;

public class MathsPage {
    private Driver driver;

    // Локаторы
    private By delete = By.cssSelector("#delay");

    private By num7 = By.xpath("//span[text() = '7']");
    private By sign = By.xpath("//span[text() = '+']");
    private By num8 = By.xpath("//span[text() = '8']");
    private By equal = By.xpath("//span[text() = '=']");

    public MathsPage(Driver driver) {
        this.driver = driver;
    }

    // открыть страницу
    public MathsPage open() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        return this;
    }

    // очистка поля
    public void delete() {
        driver.findElement(delete).clear();
    }

    public void Wait() {
        driver.findElement(delete).sendKeys(String.valueOf(timeout));
    }

}
