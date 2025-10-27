package ru.merion.aqa.selenideDZ_1;

/*
Дождаться картинки

Напишите скрипт. Шаги:

Перейти на сайт https://bonigarcia.dev/selenium-webdriver-java/loading-images.html
Дождаться загрузки 3й картинки
Получить значение атрибута
src - у 3й картинки
Вывести значение в консоль
 */

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Task3 {
    public static void main(String[] args) {
        open("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        String picture = $(By.cssSelector("#award")).shouldBe(visible, Duration.ofSeconds(15)).getText();
        System.out.println(picture);
        Selenide.closeWebDriver();




    }
}
