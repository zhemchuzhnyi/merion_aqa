package ru.merion.aqa.selenideDZ_2_Page.Task2;

/*
Переименовать кнопку

Напишите скрипт. Шаги:

Перейти на сайт http://uitestingplayground.com/textinput
Указать в поле ввода текст "Merion"
Нажать на синюю кнопку
Получить текст кнопки и вывести в консоль (Merion)
 */

import com.codeborne.selenide.Selenide;

public class Task2 {
    public static void main(String[] args) {

        AuthPage authPage = new AuthPage();
        authPage.open();
        authPage.setForm();
        authPage.clickButton();
        System.out.println("content = " + authPage.getText());

        Selenide.closeWebDriver();
    }
}
