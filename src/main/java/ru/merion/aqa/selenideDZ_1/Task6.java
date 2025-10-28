package ru.merion.aqa.selenideDZ_1;

/*
Напишите скрипт для работы с интернет-магазином. Шаги

Открыть сайт магазина https://www.saucedemo.com/
Авторизоваться под пользователем
standard_user
Добавить в корзину товары:
Sauce Labs Backpack
Sauce Labs Bolt T-Shirt
Sauce Labs Onesie
Перейти в корзину
Нажать Checkout
Заполнить форму данными:
Имя
Фамиля
Почтовый индекс
Нажать continue
Прочитать со стрницы итоговую стоимость (
Total
 )
Закрыть браузер
Вывести в консоль итоговую стоимость `
 */

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.util.HashSet;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Task6 {
    public static void main(String[] args) {
        Set<String> itemNames = new HashSet<>();
        itemNames.add("Sauce Labs Backpack");
        itemNames.add("Sauce Labs Bolt T-Shirt");
        itemNames.add("Sauce Labs Onesie");

        Configuration.browser = "chrome";
        Configuration.timeout = 40000;

        open("https://www.saucedemo.com/");
        $(By.cssSelector("#user-name")).val("standard_user");
        $(By.cssSelector("#password")).val("secret_sauce");
        $(By.cssSelector("#login-button")).click();

        Selenide.closeWebDriver();
    }
}
