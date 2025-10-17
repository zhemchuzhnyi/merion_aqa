package ru.merion.aqa.practiceDZ3.Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class Task3 {
    private static final Logger log = LoggerFactory.getLogger(Task3.class);

    public static void main(String[] args) {

        int timeout = 45;
        WebDriver driver = new ChromeDriver();

        MathsPage page = new MathsPage(driver);

        page.open()
                .clearDelay()
                .setDelay(timeout)
                .clickNumber7()
                .clickSign()
                .clickNumber8()
                .clickEqual();

        String result = page.getResult(timeout);
        System.out.println("Result: " + result);


        driver.quit();
    }
}
