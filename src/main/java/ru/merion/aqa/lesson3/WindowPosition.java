package ru.merion.aqa.lesson3;

// Импорт необходимых классов Selenium WebDriver
import org.openqa.selenium.Point;       // Класс для представления координат (x, y)
import org.openqa.selenium.WebDriver;   // Основной интерфейс для управления браузером
import ru.merion.aqa.WebDriverFactory;  // Кастомная фабрика для создания WebDriver

public class WindowPosition {

    public static void main(String[] args) {

        // Создание экземпляра WebDriver для Chrome браузера
        WebDriver driver = WebDriverFactory.create("chrome");

        // Получение текущей позиции окна браузера на экране
        // getPosition() возвращает объект Point с координатами левого верхнего угла окна
        // Координаты измеряются в пикселях от левого верхнего угла экрана
        Point position = driver.manage().window().getPosition();

        // Вывод текущей позиции в консоль
        // Point.toString() выводит координаты в формате "(x, y)"
        System.out.println("position: " + position);

        // Установка нового положения окна браузера
        // Создание нового объекта Point с координатами:
        // x = 100 пикселей от левого края экрана
        // y = 200 пикселей от верхнего края экрана
        driver.manage().window().setPosition(new Point(100, 200));

        // Закрытие браузера и завершение сессии WebDriver
        // Освобождение всех ресурсов системы
        driver.quit();
    }
}