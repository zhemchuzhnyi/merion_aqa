package ru.merion.aqa.DZ_Praktika.Task_3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.selenideDZ_2_Page.Task5.CalculatorPage;
import ru.merion.aqa.selenideDZ_2_Page.Task6.CatalogPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void checkSlowCalculator() {
        CalculatorPage page = new CalculatorPage().open();

        calculator.setDelay(10);
        calculator.press_7();
        calculator.press_plus();
        calculator.press_8();
        calculator.press_eq();

        assertEquals("15", calculator.getResult());
    }
}
