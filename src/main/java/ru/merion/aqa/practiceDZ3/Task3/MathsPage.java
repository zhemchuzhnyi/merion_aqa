package ru.merion.aqa.practiceDZ3.Task3;

import org.openqa.selenium.By;

import java.sql.Driver;

public class MathsPage {
    private Driver driver;

    // Локаторы
    private By del = By.cssSelector("#delay");

    private By num7 = By.xpath("//span[text() = '7']");
    private By sign = By.xpath("//span[text() = '+']");
    private By num8 = By.xpath("//span[text() = '8']");
    private By equal = By.xpath("//span[text() = '=']");

    public MathsPage(Driver driver) {
        this.driver = driver;
    }

}
