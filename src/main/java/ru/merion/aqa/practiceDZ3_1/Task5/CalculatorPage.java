package ru.merion.aqa.practiceDZ3_1.Task5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class CalculatorPage {
    private final WebDriver driver;

    private WebElement keyboard;

    private int delay = 0;

    public CalculatorPage(WebDriver driver) {this.driver = driver;}

    public CalculatorPage open() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        WebElement keyboard = driver.findElement(By.cssSelector(".keys"));
        return this;
    }

    public void setDelay(int delay) {
        driver.findElement(By.cssSelector("#delay")).clear();
        driver.findElement(By.cssSelector("#delay")).sendKeys(String.valueOf(delay));
        this.delay = delay;
    }

    public String getResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delay));
        wait.until(invisibilityOfElementLocated(By.cssSelector("#spinner")));
        return driver.findElement(By.cssSelector("#screen")).getText();
    }
}
