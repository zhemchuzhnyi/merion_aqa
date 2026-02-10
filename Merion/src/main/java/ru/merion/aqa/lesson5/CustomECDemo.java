package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

/**
 * Демонстрация использования кастомного Expected Condition в Selenium WebDriver.
 * Класс показывает, как работать с локальными HTML-файлами и использовать
 * пользовательские условия ожидания для проверки динамического контента.
 */
public class CustomECDemo {

    public static void main(String[] args) {
        // Создаем относительный путь к тестовому HTML-файлу
        // Файл находится в директории resources проекта
        Path relativePath = Path.of("src/main/resources/dummu_pages/old_vk.html");

        // Преобразуем относительный путь в абсолютный путь файловой системы
        // Это необходимо для корректного открытия локального файла в браузере
        String filePath = Paths.get("").toAbsolutePath().resolve(relativePath).toString();

        // Создаем экземпляр WebDriver для браузера Chrome
        // WebDriverFactory - это вспомогательный класс для инициализации драйвера
        WebDriver driver = WebDriverFactory.create("chrome");

        // Открываем локальный HTML-файл в браузере
        // Используем протокол file:// для доступа к локальным файлам
        driver.get("file://" + filePath);

        // Создаем объект WebDriverWait для явного ожидания
        // Первый параметр (20 секунд) - максимальное время ожидания
        // Второй параметр (1 секунда) - интервал опроса (polling interval)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(1));

        // Ожидаем, пока элемент с селектором #msg_counter не будет содержать текст "(1)"
        // CustomEC.textContainsAfterRefresh - кастомное условие ожидания,
        // которое проверяет текст элемента после обновления страницы
        WebElement counter = wait.until(CustomEC.textContainsAfterRefresh(By.cssSelector("#msg_counter"), "(1)"));

        // Получаем текст из первого параграфа на странице
        String txt = driver.findElement(By.cssSelector("p")).getText();

        // Выводим полученный текст в консоль
        // Ожидаемый результат: "Входящие (1)"
        System.out.println(txt); // Входящие (1)

        // Закрываем браузер и освобождаем ресурсы WebDriver
        driver.quit();
    }
}