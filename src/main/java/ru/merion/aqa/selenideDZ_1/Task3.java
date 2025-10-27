package ru.merion.aqa.selenideDZ_1;

/*
Дождаться картинки

Напишите скрипт. Шаги:

Перейти на сайт https://bonigarcia.dev/selenium-webdriver-java/loading-images.html
Дождаться загрузки 3й картинки
Получить значение атрибута
src
 у 3й картинки
Вывести значение в консоль
 */

import static com.codeborne.selenide.Selenide.open;

public class Task3 {
    public static void main(String[] args) {
        open("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

    }
}
