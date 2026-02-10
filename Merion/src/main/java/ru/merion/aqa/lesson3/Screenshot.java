package ru.merion.aqa.lesson3;

// Импорт необходимых классов Selenium WebDriver
import org.openqa.selenium.OutputType;        // Перечисление для типов вывода скриншота
import org.openqa.selenium.TakesScreenshot;   // Интерфейс для создания скриншотов
import org.openqa.selenium.WebDriver;         // Основной интерфейс для управления браузером
import org.openqa.selenium.chrome.ChromeDriver; // Драйвер для Chrome (не используется напрямую)
import ru.merion.aqa.WebDriverFactory;        // Кастомная фабрика для создания WebDriver

import java.io.File; // Класс для работы с файлами

public class Screenshot {

    public static void main(String[] args) {

        // Создание экземпляра WebDriver с помощью фабрики
        // Передается параметр "chrome" для создания Chrome драйвера
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на указанную веб-страницу (игра 2048)
        driver.get("http://play2048.co/");

        // Создание скриншота текущего состояния браузера:
        // 1. Приведение driver к интерфейсу TakesScreenshot
        // 2. Вызов getScreenshotAs() с параметром OutputType.FILE - получение скриншота как файла
        // 3. Переименование временного файла в "res.png" в корневой директории проекта
        ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE).renameTo(new File("res.png"));

        // Закрытие браузера и завершение сессии WebDriver
        // Освобождение ресурсов системы
        driver.quit();
    }
}