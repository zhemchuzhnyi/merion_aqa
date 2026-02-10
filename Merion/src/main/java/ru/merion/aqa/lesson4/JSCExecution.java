package ru.merion.aqa.lesson4;

// Импорт классов для выполнения JavaScript кода в браузере
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// Импорт фабрики для создания экземпляров веб-драйвера
import ru.merion.aqa.WebDriverFactory;

/**
 * Класс демонстрирует выполнение JavaScript кода в браузере через Selenium
 * Показывает два сценария: удаление элементов DOM и работу с localStorage
 */
public class JSCExecution {

    public static void main(String[] args) {

        // Подготовка JavaScript кода для выполнения в браузере

        // JavaScript для удаления рекламного баннера или контентного блока
        // document.querySelector() - поиск элемента по CSS-селектору
        // .remove() - удаление найденного элемента из DOM дерева
        String jsRemoveBanner = "document.querySelector(\".tabs-content\").remove()";

        // JavaScript для установки значения в локальное хранилище браузера
        // localStorage.setItem() - сохранение пары ключ-значение
        // Устанавливает рекордный счет в игре "999999999"
        String jsSetLocalStorage = "localStorage.setItem(\"bestScore\", \"999999999\");";

        // Создание экземпляра веб-драйвера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // === СЦЕНАРИЙ 1: УДАЛЕНИЕ ЭЛЕМЕНТОВ НА MAIL.RU ===

        // Переход на главную страницу Mail.ru
        driver.get("https://mail.ru/");

        // Приведение WebDriver к типу JavascriptExecutor для выполнения JS
        // executeScript() - выполняет переданный JavaScript код в контексте текущей страницы
        // Удаляет элемент с классом "tabs-content" (возможно, рекламный блок или меню)
        ((JavascriptExecutor)driver).executeScript(jsRemoveBanner);

        // === СЦЕНАРИЙ 2: МАНИПУЛЯЦИЯ С ЛОКАЛЬНЫМ ХРАНИЛИЩЕМ ===

        // Переход на сайт игры 2048 (русская версия)
        driver.get("https://2048game.com/ru/");

        // Выполнение JavaScript для установки рекордного счета в localStorage
        // Это позволяет "взломать" игру, установив нереально высокий рекорд
        ((JavascriptExecutor)driver).executeScript(jsSetLocalStorage);

        // Обновление страницы для применения изменений из localStorage
        // После refresh игра должна показать новый "рекордный" счет
        driver.navigate().refresh();

        // Вывод выполненного JavaScript кода в консоль для отладки
        // Примечание: лучше выводить подтверждение успешного выполнения
        System.out.println(jsSetLocalStorage);

        // Корректное закрытие браузера и освобождение ресурсов
        driver.quit();
    }
}