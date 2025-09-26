package ru.merion.aqa.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

/**
 * Класс для демонстрации разницы между методами quit() и close() в Selenium WebDriver.
 * Показывает работу с множественными окнами браузера.
 */
public class QuitClose {

    public static void main(String[] args) {
        // Создание экземпляра WebDriver для браузера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на тестовую страницу с примером открытия нового окна
        driver.get("https://the-internet.herokuapp.com/windows");

        // Клик по ссылке, которая открывает новое окно браузера
        // CSS селектор находит первую ссылку в блоке с id="content"
        driver.findElement(By.cssSelector("#content a")).click();
        // После этого клика будет открыто второе окно браузера

        // ЗАВЕРШЕНИЕ РАБОТЫ С БРАУЗЕРОМ:

        // quit() - закрывает ВСЕ окна браузера и завершает сессию WebDriver
        // После вызова quit() драйвер становится неактивным
        driver.quit();

        // close() - закрывает ТОЛЬКО текущее активное окно браузера
        driver.close(); // Этот код вызовет исключение!

        // ПРАВИЛЬНОЕ ИСПОЛЬЗОВАНИЕ:
        // Если нужно закрыть только одно окно из нескольких:
        // driver.close(); - закрывает текущее окно
        // Если нужно закрыть все окна и завершить сессию:
        // driver.quit(); - завершает всю сессию WebDriver
    }
}