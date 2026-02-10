package ru.merion.aqa.lesson3;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

/**
 * Класс для демонстрации получения информации о текущей веб-странице
 * с помощью методов WebDriver.
 */
public class GetCurrentInfo {

    public static void main(String[] args) {

        // Создание экземпляра WebDriver для браузера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на веб-страницу Habr
        // Примечание: этот метод эквивалентен driver.navigate().to("https://habr.com/ru")
        driver.get("https://habr.com/ru");

        // Получение текущего URL страницы
        // Может отличаться от изначально запрошенного URL из-за редиректов
        String currentUrl = driver.getCurrentUrl();

        // Получение заголовка страницы (содержимое тега <title>)
        String title = driver.getTitle();

        // Получение полного HTML-кода страницы
        // Возвращает исходный код всей страницы в виде строки
        String pageSource = driver.getPageSource();

        // Закрытие браузера и завершение сессии WebDriver
        driver.quit();

        // Примечание: в данном коде полученная информация не выводится и не используется
        // Для проверки работы можно добавить вывод:
        // System.out.println("URL: " + currentUrl);
        // System.out.println("Title: " + title);
        // System.out.println("Page source length: " + pageSource.length());
    }
}