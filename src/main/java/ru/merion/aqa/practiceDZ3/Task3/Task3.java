package ru.merion.aqa.practiceDZ3.Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Скрипт на калькулятор
 *
 * Напишите скрипт. Шаги:
 *
 * Открыть страницу https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html
 * В поле ввода по локатору
 * #delay
 *  ввести значение 45
 * Нажать на кнопки
 * 7
 * +(плюс)
 * 8
 * =
 */

// TODO - переделать в PageObject

public class Task3 {
    public static void main(String[] args) {

        int timeout = 45;
        WebDriver driver = new ChromeDriver();

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        driver.findElement(By.cssSelector("#delay")).clear();

        driver.findElement(By.cssSelector("#delay")).sendKeys(String.valueOf(timeout));

        driver.findElement(By.xpath("//span[text() = '7']")).click();
        driver.findElement(By.xpath("//span[text() = '+']")).click();
        driver.findElement(By.xpath("//span[text() = '8']")).click();
        driver.findElement(By.xpath("//span[text() = '=']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#spinner")));

        String result = driver.findElement(By.cssSelector(".screen")).getText();
        System.out.println("Result: " + result);

        driver.quit();
    }
}
