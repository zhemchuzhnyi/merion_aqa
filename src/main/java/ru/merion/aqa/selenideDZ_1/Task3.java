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

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Task3 {
    public static void main(String[] args) {

        open("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        ElementsCollection images = $$("#image-container img").shouldHave(sizeGreaterThan(2), Duration.ofSeconds(10));
        String src = images.get(2).attr("src");

        System.out.println("Атрибут картинки: " + src);

        Selenide.closeWebDriver();




    }
}
