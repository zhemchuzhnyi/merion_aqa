package ru.merion.aqa.lesson4;

// Импорт основных классов Selenium для работы с веб-элементами
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// Импорт фабрики для создания экземпляров веб-драйвера
import ru.merion.aqa.WebDriverFactory;

/**
 * Класс демонстрирует проверку состояний веб-элементов в Selenium:
 * - isSelected() - для чекбоксов и радиокнопок
 * - isEnabled() - для проверки доступности элементов
 * - isDisplayed() - для проверки видимости элементов
 */
public class EnableSelectedVisible {

    public static void main(String[] args) {

        // Создание экземпляра веб-драйвера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Переход на тестовую страницу с динамическими элементами управления
        // Страница содержит чекбокс и текстовое поле с изменяемыми состояниями
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // === РАБОТА С ЧЕКБОКСОМ ===

        // Проверка начального состояния чекбокса (выбран или нет)
        // isSelected() возвращает true, если чекбокс отмечен, false - если нет
        boolean selected = driver.findElement(By.cssSelector("#checkbox input")).isSelected();

        // Клик по чекбоксу для изменения его состояния
        // После клика состояние должно измениться на противоположное
        driver.findElement(By.cssSelector("#checkbox input")).click();

        // Повторная проверка состояния чекбокса после клика
        // Сохраняем новое состояние в ту же переменную (перезаписываем)
        selected = driver.findElement(By.cssSelector("#checkbox input")).isSelected();

        // === РАБОТА С ТЕКСТОВЫМ ПОЛЕМ ===

        // Проверка доступности текстового поля для взаимодействия
        // isEnabled() возвращает true, если элемент активен и с ним можно взаимодействовать
        // false - если элемент заблокирован (disabled)
        boolean isEnabled = driver.findElement(By.cssSelector("#input-example input")).isEnabled();

        // Условная логика: вводим текст только если поле доступно
        if (isEnabled) {
            // Если поле активно - вводим тестовый текст
            driver.findElement(By.cssSelector("#input-example input")).sendKeys("Testing");
        } else {
            // Если поле заблокировано - выводим сообщение в консоль
            System.out.println("Элемент недоступен");
        }

        // === ПРОВЕРКА ВИДИМОСТИ ЭЛЕМЕНТА ===

        // Проверка видимости контейнера с текстовым полем
        // isDisplayed() возвращает true, если элемент отображается на странице
        // false - если элемент скрыт (display: none, visibility: hidden и т.д.)
        // Примечание: переменная названа с опечаткой "dispplayed" вместо "displayed"
        boolean dispplayed = driver.findElement(By.cssSelector("#input-example")).isDisplayed();

        // Корректное закрытие браузера и освобождение ресурсов
        driver.quit();
    }
}