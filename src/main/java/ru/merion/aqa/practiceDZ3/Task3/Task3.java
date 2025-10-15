package ru.merion.aqa.practiceDZ3.Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
 */

// TODO - переделать в PageObject

public class Task3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        WebElement element = driver.findElement(By.cssSelector(""));



        driver.quit();


    }
}
