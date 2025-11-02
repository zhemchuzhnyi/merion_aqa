package ru.merion.aqa.selenideDZ_2_Page.Task2;

/*
Переименовать кнопку

Напишите скрипт. Шаги:

Перейти на сайт http://uitestingplayground.com/textinput
Указать в поле ввода текст "Merion"
Нажать на синюю кнопку
Получить текст кнопки и вывести в консоль (Merion)
 */

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Task2 {
    public static void main(String[] args) {
        open("http://uitestingplayground.com/textinput");
        $(".form-control").val("Merion");
        $(".form-control").click();
    }
}
