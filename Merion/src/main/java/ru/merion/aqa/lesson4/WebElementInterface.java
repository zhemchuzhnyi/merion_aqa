package ru.merion.aqa.lesson4;

// Импорт основных классов Selenium для работы с веб-элементами
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// Импорт фабрики для создания экземпляров веб-драйвера
import ru.merion.aqa.WebDriverFactory;

// Импорт классов для работы с файловой системой
import java.io.File;
import java.util.List;

/**
 * Класс демонстрирует расширенные возможности интерфейса WebElement:
 * - Поиск дочерних элементов внутри родительского элемента
 * - Создание скриншотов отдельных элементов
 * - Работа с коллекциями веб-элементов
 */
public class WebElementInterface {
    public static void main(String[] args) {
        // Создание экземпляра веб-драйвера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на страницу статей Habr
        driver.get("https://habr.com/ru/articles");

        // === ПОИСК ОТДЕЛЬНЫХ ЭЛЕМЕНТОВ ===

        // Поиск кнопки "Войти" в шапке сайта и сохранение в переменную
        // Это позволяет работать с элементом многократно без повторного поиска
        WebElement login = driver.findElement(By.cssSelector(".tm-header-user-menu__login"));

        // === ПОИСК ДОЧЕРНИХ ЭЛЕМЕНТОВ ===

        // Поиск навигационного блока с вкладками на странице
        // Это будет родительский контейнер для поиска вложенных ссылок
        WebElement nav = driver.findElement(By.cssSelector(".tm-tabs__scroll-area"));

        // Поиск всех ссылок (тегов <a>) ВНУТРИ найденного навигационного блока
        // findElements() на WebElement ищет только среди дочерних элементов
        // Это более точный и быстрый способ, чем поиск по всей странице
        List<WebElement> links = nav.findElements(By.cssSelector("a"));

        // Вывод количества найденных ссылок в навигации
        // Покажет количество разделов/категорий в навигационном меню Habr
        System.out.println(links.size());

        // === СОЗДАНИЕ СКРИНШОТА ЭЛЕМЕНТА ===

        // Создание скриншота только кнопки "Войти" (не всей страницы)
        // getScreenshotAs(OutputType.FILE) - возвращает временный файл со скриншотом
        // renameTo() - перемещает временный файл в указанное место с нужным именем
        // Результат: файл "btn.png" в корне проекта со скриншотом кнопки
        login.getScreenshotAs(OutputType.FILE).renameTo(new File("btn.png"));

        // Корректное закрытие браузера и освобождение ресурсов
        driver.quit();
    }
}