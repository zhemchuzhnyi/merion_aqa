package ru.merion.aqa.DZ_Praktika.Task_3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
 * Проверьте, что результат = 15
 */

public class Task_3_Test {
    private WebDriver driver;

    @BeforeEach
    public void open() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test

}
