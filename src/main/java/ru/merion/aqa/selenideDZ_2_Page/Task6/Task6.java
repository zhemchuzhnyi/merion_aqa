package ru.merion.aqa.selenideDZ_2_Page.Task6;

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
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

import static com.codeborne.selenide.Selenide.*;

public class Task6 {
    public static void main(String[] args) {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--guest");

        AuthPage auth;
        CatalogPage catalog;

        Set<String> itemNames = Set.of("Sauce Labs Backpac", "Sauce Labs Bolt T-Shirt", "Sauce Labs Onesie");

        auth = new AuthPage().open();
        catalog = auth.logiAs("standard_user", "secret_sauce");
        catalog.addItems(itemNames);


        Selenide.closeWebDriver();
    }
}
