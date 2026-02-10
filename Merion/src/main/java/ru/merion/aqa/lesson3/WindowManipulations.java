package ru.merion.aqa.lesson3;

// Импорт необходимых классов Selenium WebDriver
import org.openqa.selenium.WebDriver;  // Основной интерфейс для управления браузером
import ru.merion.aqa.WebDriverFactory; // Кастомная фабрика для создания WebDriver

public class WindowManipulations {
    public static void main(String[] args) {

        // Создание экземпляра WebDriver для Chrome браузера
        WebDriver driver = WebDriverFactory.create("chrome");

        // Управление размером и состоянием окна браузера:

        // 1. Минимизация окна браузера (сворачивание в панель задач)
        // После выполнения окно браузера будет свернуто
        driver.manage().window().minimize();

        // 2. Максимизация окна браузера (развертывание на весь экран с панелью задач)
        // Окно займет всю доступную область экрана, но панель задач останется видимой
        driver.manage().window().maximize();

        // 3. Переключение в полноэкранный режим (истинный fullscreen)
        // Окно займет весь экран, скрывая панель задач и другие элементы ОС
        // Аналогично нажатию F11 в большинстве браузеров
        driver.manage().window().fullscreen();

        // Закрытие браузера и завершение сессии WebDriver
        // Освобождение всех ресурсов системы
        driver.quit();
    }
}