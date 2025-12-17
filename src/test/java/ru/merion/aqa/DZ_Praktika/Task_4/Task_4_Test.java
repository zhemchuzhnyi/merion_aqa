package ru.merion.aqa.DZ_Praktika.Task_4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.merion.aqa.DZ_Praktika.Task_3.page.CalculatorPage;
import ru.merion.aqa.selenideDZ_2_Page.Task6.AuthPage;

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
 * Фамилия
 * Почтовый индекс
 * Нажать continue
 * Прочитать со стрницы итоговую стоимость (
 * Total
 *  )
 * Закрыть браузер
 * Провеьте, что итоговая стоимость равна 55.28
 */

public class Task_4_Test {
    private WebDriver driver;

    @BeforeEach
    public void open() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void happyPath() {
        AuthPage auth;
        CalculatorPage catalog;

    }
}
