package ru.merion.aqa.lesson3;

// Импорт необходимых классов Selenium WebDriver
import org.openqa.selenium.By;         // Класс для поиска элементов на странице
import org.openqa.selenium.WebDriver;  // Основной интерфейс для управления браузером
import ru.merion.aqa.WebDriverFactory; // Кастомная фабрика для создания WebDriver

// Импорт Java коллекций для работы с идентификаторами вкладок
import java.util.ArrayList; // Динамический массив для хранения элементов
import java.util.Set;       // Интерфейс для коллекции уникальных элементов

public class SwitchTabs {

    public static void main(String[] args) {

        // Создание экземпляра WebDriver для Chrome браузера
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на тестовую страницу с демонстрацией работы с окнами
        driver.get("https://the-internet.herokuapp.com/windows");

        // Поиск ссылки по CSS селектору (#content a) и клик по ней
        // Это действие откроет новую вкладку/окно
        driver.findElement(By.cssSelector("#content a")).click();

        // Получение идентификатора первой (текущей) вкладки
        // getWindowHandle() возвращает уникальный ID активного окна
        String firstTabId = driver.getWindowHandle();

        // Получение множества всех идентификаторов открытых вкладок/окон
        // getWindowHandles() возвращает Set со всеми ID окон
        Set<String> tabIds = driver.getWindowHandles();

        // Удаление ID первой вкладки из множества
        // После этого в tabIds останутся только ID новых вкладок
        tabIds.remove(firstTabId);

        // Получение ID второй вкладки:
        // 1. Преобразование Set в ArrayList для доступа по индексу
        // 2. Получение первого элемента (индекс 0) - это ID новой вкладки
        String sendTabId = new ArrayList<>(tabIds).get(0);

        // Переключение драйвера на новую вкладку по её ID
        driver.switchTo().window(sendTabId);

        // Получение URL текущей страницы (теперь это новая вкладка)
        String url = driver.getCurrentUrl();

        // Вывод URL в консоль
        System.out.println("url = " + url);

        // Повторное получение и вывод того же URL
        // (дублированный код - возможно, ошибка или для демонстрации)
        url = driver.getCurrentUrl();
        System.out.println("url = " + url);

        // Закрытие браузера и завершение сессии WebDriver
        // Освобождение ресурсов системы
        driver.quit();
    }
}