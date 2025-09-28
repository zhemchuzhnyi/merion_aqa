package ru.merion.aqa.lesson4;

// Импорт основных классов Selenium для работы с веб-драйвером
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// Импорт собственного класса-фабрики для создания веб-драйвера
import ru.merion.aqa.WebDriverFactory;

/**
 * Класс демонстрирует использование метода click() в Selenium WebDriver
 * Показывает, как найти элемент на странице и выполнить клик по нему
 */
public class Click {
    public static void main(String[] args) {

        // Создание экземпляра веб-драйвера для браузера Chrome
        // WebDriverFactory.create() - фабричный метод для инициализации драйвера
        WebDriver driver = WebDriverFactory.create("chrome");

        // Навигация на главную страницу Habr (популярный IT-портал)
        // get() - метод для перехода по указанному URL
        driver.get("https://habr.com/ru/feed/");

        // Поиск элемента кнопки "Войти" по CSS-селектору
        // ".tm-header-user-menu__login" - CSS-класс кнопки авторизации в шапке сайта
        // findElement() возвращает первый найденный элемент или выбрасывает исключение
        WebElement element = driver.findElement(By.cssSelector(".tm-header-user-menu__login"));

        // Выполнение клика по найденному элементу
        // click() - имитирует клик левой кнопкой мыши по элементу
        // Это действие должно открыть страницу или форму авторизации
        element.click();

        // Закрытие браузера и завершение работы веб-драйвера
        // quit() - полностью закрывает браузер и освобождает системные ресурсы
        driver.quit();
    }
}