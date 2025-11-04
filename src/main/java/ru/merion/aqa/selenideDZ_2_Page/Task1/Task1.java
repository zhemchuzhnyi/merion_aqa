package ru.merion.aqa.selenideDZ_2_Page.Task1;

/*
Нажатие на кнопку

Напишите скрипт. Шаги:

Перейти на страницу http://uitestingplayground.com/ajax
Нажать на синюю кнопку
Получить текст из зеленой плашки
Вывести его в консоль (”Data loaded with AJAX get request.”)
 */

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Task1 {
    public static void main(String[] args) {

        open("http://uitestingplayground.com/ajax");
        $(By.cssSelector("#ajaxButton")).click();
        String content = $(By.cssSelector("#content p")).shouldBe(visible, Duration.ofSeconds(16)).getText();
        System.out.println(content);

    }
}
