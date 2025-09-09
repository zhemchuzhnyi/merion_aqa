/*
Скрипт на калькулятор
Напишите скрипт. Шаги:

Открыть страницу https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html
В поле ввода по локатору
#delay
 ввести значение 45
Нажать на кнопки
7
+(плюс)
8
=
Дождаться результата. Вывести его в консоль.
 */
package ru.merion.aqa.practiceDZ2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Task5 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        driver.findElement(By.cssSelector("#delay")).sendKeys("45");

        driver.quit();
    }
}
