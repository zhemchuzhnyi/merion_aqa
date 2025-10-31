package ru.merion.aqa.practiceDZ3_1_WebDriver_Page.Task5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class CalculatorPage {
    private final WebDriver driver;
    private WebElement keyboard;
    private int delay = 5;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public CalculatorPage open() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        this.keyboard = driver.findElement(By.cssSelector(".keys"));
        return this;
    }

    public void setDelay(int delay) {
        driver.findElement(By.cssSelector("#delay")).clear();
        driver.findElement(By.cssSelector("#delay")).sendKeys(String.valueOf(delay));
        this.delay = delay;
    }

    public void press_7() {
        keyboard.findElement(By.xpath("//*[text() = '7']")).click();
    }

    public void press_plus() {
        keyboard.findElement(By.xpath("//*[text() = '+']")).click();
    }

    public void press_8() {
        keyboard.findElement(By.xpath("//*[text() = '8']")).click();
    }

    public void press_eq() { // Добавлены скобки!
        keyboard.findElement(By.xpath("//*[text() = '=']")).click();
    }

    public String getResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delay));
        wait.until(invisibilityOfElementLocated(By.cssSelector("#spinner")));
        return driver.findElement(By.cssSelector(".screen")).getText();
    }
}