package ru.merion.aqa.lesson4;

// Импорт необходимых классов Selenium для работы с веб-драйвером
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// Импорт собственного класса для создания экземпляров веб-драйвера
import ru.merion.aqa.WebDriverFactory;

/**
 * Класс демонстрирует работу с методом clear() в Selenium WebDriver
 * Показывает, как очистить содержимое поля ввода
 */
public class Clear {

    public static void main(String[] args) {

        // Создание экземпляра веб-драйвера Chrome через фабричный метод
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на страницу с полем ввода для демонстрации
        // the-internet.herokuapp.com - популярный сайт для тестирования автоматизации
        driver.get("https://the-internet.herokuapp.com/inputs");

        // Поиск поля ввода по CSS-селектору "input" и ввод текста "9969"
        // sendKeys() - метод для имитации ввода текста с клавиатуры
        driver.findElement(By.cssSelector("input")).sendKeys("9969");

        // Очистка содержимого того же поля ввода
        // clear() - метод для полной очистки текстового поля
        // Эквивалентно выделению всего текста и нажатию Delete/Backspace
        driver.findElement(By.cssSelector("input")).clear();

        // Закрытие браузера и завершение сессии веб-драйвера
        // Освобождение системных ресурсов
        driver.quit();
    }
}