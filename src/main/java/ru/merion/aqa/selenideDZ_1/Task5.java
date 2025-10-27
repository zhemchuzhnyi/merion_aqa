package ru.merion.aqa.selenideDZ_1;

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

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Task5 {
    public static void main(String[] args) {
        open("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        $(By.cssSelector("#delay")).clear();
        $(By.cssSelector("#delay")).val("10");

        Selenide.closeWebDriver();



    }
}
