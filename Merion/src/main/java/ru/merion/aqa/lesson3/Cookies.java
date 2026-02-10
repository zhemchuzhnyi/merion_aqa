package ru.merion.aqa.lesson3;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.util.Date;

public class Cookies {

    public static void main(String[] args) {

        // Создаем экземпляр веб-драйвера для Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переходим на главную страницу сайта Лабиринт
        driver.get("https://www.labirint.ru/");

        // Создаем новую cookie с названием "cookie_policy" и значением "1"
        // Это обычно используется для принятия политики использования cookies
        Cookie cookie = new Cookie("cookie_policy", "1");

        // Добавляем созданную cookie в браузер
        driver.manage().addCookie(cookie);

        // Обновляем страницу, чтобы изменения cookie вступили в силу
        driver.navigate().refresh();

        // Повторно переходим на страницу (альтернативный способ обновления)
        driver.get("https://www.labirint.ru/");

        // Закрываем браузер и завершаем работу драйвера
        driver.quit();

    }
}