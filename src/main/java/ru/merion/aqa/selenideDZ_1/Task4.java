package ru.merion.aqa.selenideDZ_1;

/*
Скрипт заполнения формы

Напишите скрипт. Шаги:

Открыть страницу https://bonigarcia.dev/selenium-webdriver-java/data-types.html

Заполнить форму значениями

Поле	Значение
First name	Иван
Last name	Петров
Address	Ленина, 55-3
Zip code	*оставить пустым
City	Москва
Country	Россия
E-mail	*оставить пустым
Phone number	*оставить пустым
Job position	QA
Company	Merion
Нажать кнопку Submit

Вывести в консоль цвет полей
Zip code
,
E-mail
 и
Phone
 (background-color)
 */

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Task4 {
    public static void main(String[] args) {

        open("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
        $(By.cssSelector("[name = 'first-name']")).val("Иван");
        $(By.cssSelector("[]")).val("");
        $(By.cssSelector("[]")).val("");
        $(By.cssSelector("[]")).val("");
        $(By.cssSelector("[]")).val("");
        $(By.cssSelector("[]")).val("");
        $(By.cssSelector("[]")).val("");
        $(By.cssSelector("[]")).val("");

    }
}
