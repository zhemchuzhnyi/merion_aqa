package ru.merion.aqa.selenideDZ_2_Page.Task5;

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

import static com.codeborne.selenide.Selenide.open;

public class Task5 {
    public static void main(String[] args) {
        open("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
    }
}
