/*
Напишите скрипт. Шаги:

Перейти на сайт https://bonigarcia.dev/selenium-webdriver-java/loading-images.html
Дождаться загрузки 3й картинки
Получить значение атрибута
src
 у 3й картинки
Вывести значение в консоль
 */
package ru.merion.aqa.practiceDZ2;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Task3 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");


    }
}
