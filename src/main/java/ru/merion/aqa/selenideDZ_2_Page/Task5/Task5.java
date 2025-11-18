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

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Task5 {
    public static void main(String[] args) {
        int timeout = 10;
        open("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        $(("#delay")).val(Integer.toString(timeout));

        SelenideElement keyboard = $(".keys");

        keyboard.$x(("*[text() = '7']")).click();
        keyboard.$x(("*[text() = '+']")).click();
        keyboard.$x(("*[text() = '8']")).click();
        keyboard.$x(("*[text() = '=']")).click();

        $(("#spinner")).shouldNotBe(visible, Duration.ofSeconds(timeout+1));
        String result = $((".screen")).text();
        System.out.println("Результат: " + result);

        Selenide.closeWebDriver();



    }
}
