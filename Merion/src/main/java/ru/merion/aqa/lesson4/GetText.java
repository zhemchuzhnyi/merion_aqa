package ru.merion.aqa.lesson4;

// Импорт основных классов Selenium для работы с веб-элементами
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// Импорт фабрики для создания экземпляров веб-драйвера
import ru.merion.aqa.WebDriverFactory;

/**
 * Класс демонстрирует извлечение текстового содержимого веб-элементов
 * с помощью метода getText() в Selenium WebDriver
 */
public class GetText {

    public static void main(String[] args) {

        // Создание экземпляра веб-драйвера Chrome через фабричный метод
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на главную страницу "The Internet" - популярного ресурса для тестирования
        // На этой странице содержится список (ul) со ссылками на различные тестовые примеры
        driver.get("https://the-internet.herokuapp.com");

        // Поиск первого элемента <ul> (неупорядоченный список) на странице
        // и извлечение всего его текстового содержимого
        // getText() возвращает весь видимый текст элемента и его дочерних элементов
        String text = driver.findElement(By.cssSelector("ul")).getText();

        // Вывод полученного текста в консоль
        // Это будет список всех доступных примеров тестирования:
        // A/B Testing, Add/Remove Elements, Basic Auth, Broken Images и т.д.
        System.out.println(text);

        // Корректное закрытие браузера и освобождение системных ресурсов
        driver.quit();
    }
}