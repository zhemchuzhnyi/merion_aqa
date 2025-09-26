package ru.merion.aqa.lesson3;

// Импорт необходимых классов Selenium WebDriver
import org.openqa.selenium.Dimension;   // Класс для представления размеров (ширина x высота)
import org.openqa.selenium.WebDriver;   // Основной интерфейс для управления браузером
import ru.merion.aqa.WebDriverFactory;  // Кастомная фабрика для создания WebDriver

public class WindowSize {

    public static void main(String[] args) {

        // Создание экземпляра WebDriver для Chrome браузера
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на сайт Habr для демонстрации изменения размера окна
        // Загрузка реальной страницы позволяет визуально оценить эффект изменения размера
        driver.get("https://habr.com/ru");

        // Получение текущего размера окна браузера
        // getSize() возвращает объект Dimension с шириной и высотой окна в пикселях
        // Размер включает только область отображения контента (viewport)
        Dimension size = driver.manage().window().getSize();

        // Вывод текущего размера в консоль
        // Dimension.toString() выводит размеры в формате "(width, height)"
        System.out.println("size = " + size);

        // Установка нового размера окна браузера
        // Создание объекта Dimension с новыми параметрами:
        // ширина = 550 пикселей (довольно узкое окно)
        // высота = 900 пикселей (высокое окно - подходит для мобильной имитации)
        driver.manage().window().setSize(new Dimension(550, 900));

        // Закрытие браузера и завершение сессии WebDriver
        // Освобождение всех ресурсов системы
        driver.quit();
    }
}