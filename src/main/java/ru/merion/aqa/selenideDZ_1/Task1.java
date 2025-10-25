package ru.merion.aqa.selenideDZ_1;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/*
Нажатие на кнопку

Напишите скрипт. Шаги:

Перейти на страницу http://uitestingplayground.com/ajax
Нажать на синюю кнопку
Получить текст из зеленой плашки
Вывести его в консоль (”Data loaded with AJAX get request.”)
Переименовать кнопку
 */

public class Task1 {
    public static void main(String[] args) {

        Configuration.timeout = 15000;

        open("http://uitestingplayground.com/ajax");
        $(By.cssSelector("#ajaxButton")).click();
        String text = $(By.cssSelector(".bg-success")).text();
        System.out.println(text);

        Selenide.closeWebDriver();



    }
}
