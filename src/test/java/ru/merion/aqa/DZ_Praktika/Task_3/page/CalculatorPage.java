package ru.merion.aqa.DZ_Praktika.Task_3.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage {
    private final WebDriver driver;
    public WebElement keyboard;
    private int delay = 5;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public CalculatorPage open() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        keyboard = driver.findElement(By.cssSelector(".keys"));
        return this;
    }

}
