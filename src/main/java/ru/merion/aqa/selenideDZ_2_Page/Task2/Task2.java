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
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Task2 {
    public static void main(String[] args) {
        SelenideElement button = $(("#updatingButton"));

        open("http://uitestingplayground.com/textinput");
        $(".form-control").val("Merion");
        button.click();
        String content = $(".form-control").getText();
        System.out.println(content);

        Selenide.closeWebDriver();
    }
}
