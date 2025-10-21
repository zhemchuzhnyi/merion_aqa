package ru.merion.aqa.practiceDZ3_1.Task5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private f
}

public CalculatoPage open() {
    driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
    WebElement keyboard = driver.findElement(By.cssSelector(".keys"));
    return this;
}

public void setDelay(int delay) {
    river.findElement(By.cssSelector("#delay")).clear();
    driver.findElement(By.cssSelector("#delay")).sendKeys(String.valueOf(delay));
    this.delay = delay;
}

public String getResult() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delay));
    wait.until(invisibilityOfElementLocated(By.cssSelector("#spinner")));
    return driver.findElement(By.ByCssSelector("#screen")).getText();
}