package ru.merion.aqa.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.util.List;

/**
 * Класс для демонстрации работы с фреймами в Selenium WebDriver.
 * Показывает, как переключаться между вложенными фреймами и возвращаться к основному содержимому.
 */
public class FramesV2 {

    public static void main(String[] args) {

        // Создание экземпляра WebDriver для браузера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на страницу с вложенными фреймами
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Попытка найти элементы body на основной странице
        // Список должен быть пустым, так как на главной странице нет body элементов
        List<WebElement> shouldBeEmpty = driver.findElements(By.cssSelector("body"));

        // Переключение на верхний фрейм (frame-top)
        driver.switchTo().frame("frame-top");

        // Переключение на средний фрейм внутри верхнего фрейма (frame-middle)
        driver.switchTo().frame("frame-middle");

        // Поиск элементов body внутри среднего фрейма
        // Здесь должны быть найдены элементы body
        List<WebElement> shouldHaveBody = driver.findElements(By.cssSelector("body"));

        // Вывод текста из первого найденного элемента body
        System.out.println(shouldHaveBody.get(0).getText());

        // Возврат к родительскому фрейму (frame-top)
        driver.switchTo().parentFrame(); // --> возврат к frame-top

        // Возврат к основному содержимому страницы (корневой HTML документ)
        driver.switchTo().defaultContent(); // --> переход к основному html документу

        // Закрытие браузера и завершение сессии WebDriver
        driver.quit();
    }
}