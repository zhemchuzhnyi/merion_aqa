package ru.merion.aqa.selenideDZ_2_Page.Task1;

/*
Нажатие на кнопку

Напишите скрипт. Шаги:

Перейти на страницу http://uitestingplayground.com/ajax
Нажать на синюю кнопку
Получить текст из зеленой плашки
Вывести его в консоль (”Data loaded with AJAX get request.”)
 */

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Task1 {
    public static void main(String[] args) {
        Configuration.timeout = 16 * 1000;

        AjaxPage page = new AjaxPage();
        page.open();
        page.clickTheButton();


        System.out.println("content = " + page.getContent());
        Selenide.closeWebDriver();

    }
}
