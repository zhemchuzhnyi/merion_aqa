package ru.merion.aqa.selenideDZ_2_Page.Task1;

/*
Нажатие на кнопку

Напишите скрипт. Шаги:

Перейти на страницу http://uitestingplayground.com/ajax
Нажать на синюю кнопку
Получить текст из зеленой плашки
Вывести его в консоль (”Data loaded with AJAX get request.”)
 */

import static com.codeborne.selenide.Selenide.open;

public class Task1 {
    public static void main(String[] args) {
        open("http://uitestingplayground.com/ajax");

    }
}
