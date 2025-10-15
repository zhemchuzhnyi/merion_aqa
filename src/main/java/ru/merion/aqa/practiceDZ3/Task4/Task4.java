package ru.merion.aqa.practiceDZ3.Task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Напишите скрипт для работы с интернет-магазином. Шаги
 *
 * Открыть сайт магазина https://www.saucedemo.com/
 * Авторизоваться под пользователем
 * standard_user
 * Добавить в корзину товары:
 * Sauce Labs Backpack
 * Sauce Labs Bolt T-Shirt
 * Sauce Labs Onesie
 * Перейти в корзину
 * Нажать Checkout
 * Заполнить форму данными:
 * Имя
 * Фамиля
 * Почтовый индекс
 * Нажать continue
 * Прочитать со стрницы итоговую стоимость (
 * Total
 *  )
 * Закрыть браузер
 * Вывести в консоль итоговую стоимость
 */

// TODO - переделать в PageObject

public class Task4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#secret_sauce")).sendKeys("secret_sauce");


    }
}
