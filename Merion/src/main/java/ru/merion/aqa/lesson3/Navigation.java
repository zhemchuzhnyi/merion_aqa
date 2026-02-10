package ru.merion.aqa.lesson3;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

/**
 * Класс для демонстрации методов навигации в Selenium WebDriver.
 * Показывает различные способы перемещения по веб-страницам и управления историей браузера.
 */
public class Navigation {
    public static void main(String[] args) {

        // Создание экземпляра WebDriver для браузера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на сайт Habr
        // Примечание: driver.get() эквивалентен driver.navigate().to()
        driver.get("https://habr.com/ru");

        // Обновление текущей страницы (аналог нажатия F5 или Ctrl+R)
        driver.navigate().refresh();

        // Переход на новую страницу - сайт РЖД
        // После этого в истории браузера будет: habr.com -> rzd.ru
        driver.navigate().to("https://rzd.ru");

        // Возврат на предыдущую страницу в истории браузера (аналог кнопки "Назад")
        // Вернемся на habr.com
        driver.navigate().back();

        // Переход вперед по истории браузера (аналог кнопки "Вперед")
        // Вернемся на rzd.ru
        driver.navigate().forward();

        // Закрытие браузера и завершение сессии WebDriver
        driver.quit();
    }
}