package ru.merion.aqa.practiceTasks.selenideDZ_2_Page.Task5;

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

public class Task5 {
    public static void main(String[] args) {
        CalculatorPage calculator = new CalculatorPage().open();

        calculator.setDelay(10);
        calculator.press_7();
        calculator.press_plus();
        calculator.press_8();
        calculator.press_eq();

        String result = calculator.getResult();
        System.out.println(result);

        Selenide.closeWebDriver();



    }
}
