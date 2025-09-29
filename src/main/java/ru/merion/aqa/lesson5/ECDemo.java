/*
EC - Expected Conditions (Ожидаемые условия)
Набор предопределенных условий для явных ожиданий в Selenium WebDriver
 */

package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Демонстрация использования стандартных Expected Conditions из Selenium.
 * Класс содержит примеры различных условий ожидания для разных сценариев тестирования.
 */
public class ECDemo {

    public static void main(String[] args) {
        // Инициализация WebDriver для браузера Chrome
        WebDriver driver = WebDriverFactory.create("chrome");

        // Создание объекта явного ожидания с таймаутом 30 секунд
        // WebDriverWait будет проверять условие каждые 500 мс (по умолчанию)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // ========== ОЖИДАНИЕ ИСЧЕЗНОВЕНИЯ ЭЛЕМЕНТА ==========
        // stalenessOf - дождаться, пока элемент станет "устаревшим" (stale)
        // Элемент считается stale, когда он удален из DOM или страница обновилась
        // Полезно после действий, которые перерисовывают страницу
        wait.until(stalenessOf(driver.findElement(By.cssSelector(""))));

        // ========== ОЖИДАНИЕ ТОЧНОГО КОЛИЧЕСТВА ЭЛЕМЕНТОВ ==========
        // numberOfElementsToBe - проверяет, что на странице ровно N элементов
        // Возвращает список найденных элементов, если условие выполнено
        // В данном случае ожидаем ровно 7 элементов
        List<WebElement> elements = wait.until(numberOfElementsToBe(By.cssSelector(""), 7));

        // ========== ОЖИДАНИЕ ВИДИМОСТИ ЭЛЕМЕНТА ==========
        // visibilityOf - проверяет, что элемент присутствует в DOM и видим
        // Элемент считается видимым, если его display != none и visibility != hidden
        // После успешного ожидания сразу выполняем клик по элементу
        wait.until(visibilityOf(driver.findElement(By.cssSelector("")))).click();

        // ========== ОЖИДАНИЕ ПОЯВЛЕНИЯ ALERT ==========
        // alertIsPresent - ожидает появления JavaScript alert, confirm или prompt
        // Возвращает объект Alert для дальнейшей работы с всплывающим окном
        // Автоматически переключает фокус на alert
        wait.until(alertIsPresent());

        // ========== ОЖИДАНИЕ ВИДИМОСТИ ЭЛЕМЕНТА (дубликат) ==========
        // Примечание: этот вызов идентичен предыдущему wait.until(visibilityOf(...))
        // Возможно, здесь планировалось использовать invisibilityOf для ожидания скрытия
        wait.until(visibilityOf(driver.findElement(By.cssSelector(""))));

        // ========== ОЖИДАНИЕ ПРИСУТСТВИЯ ЭЛЕМЕНТА В DOM ==========
        // presenceOfElementLocated - проверяет только наличие элемента в DOM
        // НЕ проверяет видимость! Элемент может быть скрыт (display:none)
        // Более "легкое" условие, чем visibilityOf
        wait.until(presenceOfElementLocated(By.cssSelector("")));

        // ========== ОЖИДАНИЕ ЧАСТИЧНОГО СОВПАДЕНИЯ АТРИБУТА ==========
        // attributeContains - проверяет, что атрибут элемента содержит подстроку
        // Полезно для проверки классов, когда их может быть несколько
        // Например, class="btn btn-primary btn-success" содержит "btn-success"
        wait.until(attributeContains(By.cssSelector(""), "class", "btn-success"));

        // ========== ОЖИДАНИЕ ЧАСТИЧНОГО СОВПАДЕНИЯ TITLE ==========
        // titleContains - проверяет, что title страницы содержит указанную подстроку
        // Регистрозависимая проверка
        wait.until(titleContains("Входящие (3)"));

        // ========== ОЖИДАНИЕ ТОЧНОГО СОВПАДЕНИЯ TITLE ==========
        // titleIs - проверяет точное соответствие title страницы
        // Более строгое условие, чем titleContains
        wait.until(titleIs("Входящие (3)"));

        // ========== ОЖИДАНИЕ ЧАСТИЧНОГО СОВПАДЕНИЯ URL ==========
        // urlContains - проверяет, что URL страницы содержит подстроку
        // Полезно для проверки навигации и параметров URL
        wait.until(urlContains("https://"));

        // ========== КОМБИНАЦИЯ УСЛОВИЙ (И) ==========
        // and - объединяет несколько условий логическим И (AND)
        // Все условия должны быть выполнены одновременно
        // В примере: alert должен быть открыт И URL должен быть "/feed"
        wait.until(and(alertIsPresent(), urlToBe("/feed")));

        // ========== ОЖИДАНИЕ СОСТОЯНИЯ ВЫБОРА ЭЛЕМЕНТА ==========
        // elementSelectionStateToBe - проверяет состояние чекбокса/радиокнопки
        // true - элемент должен быть выбран (checked)
        // false - элемент должен быть не выбран
        wait.until(elementSelectionStateToBe(By.cssSelector(""), true));

        // ========== ОЖИДАНИЕ КЛИКАБЕЛЬНОСТИ ЭЛЕМЕНТА ==========
        // elementToBeClickable - проверяет, что элемент видим И доступен для клика
        // Элемент не должен быть перекрыт другими элементами или disabled
        // Одно из самых часто используемых условий
        wait.until(elementToBeClickable(By.cssSelector("")));

        // ========== ОЖИДАНИЕ КОЛИЧЕСТВА ЭЛЕМЕНТОВ БОЛЬШЕ N ==========
        // numberOfElementsToBeMoreThan - проверяет, что элементов строго больше N
        // В данном случае должно быть минимум 8 элементов (больше 7)
        // Полезно для динамических списков
        wait.until(numberOfElementsToBeMoreThan(By.cssSelector(""), 7));

        // ========== КОМБИНАЦИЯ УСЛОВИЙ (ИЛИ) ==========
        // or - объединяет условия логическим ИЛИ (OR)
        // Достаточно выполнения хотя бы одного условия
        // Полезно для альтернативных сценариев
        wait.until(or(urlToBe(""), titleIs("")));

        // ========== ОЖИДАНИЕ ТЕКСТА В ЭЛЕМЕНТЕ ==========
        // textToBePresentInElementLocated - проверяет, что текст элемента содержит подстроку
        // Сначала находит элемент по локатору, затем проверяет его текст
        // Проверяет видимый текст (getText()), не innerHTML
        wait.until(textToBePresentInElementLocated(By.cssSelector(""), "test"));

        // ========== ОЖИДАНИЕ ЗНАЧЕНИЯ В АТРИБУТЕ VALUE ==========
        // textToBePresentInElementValue - проверяет атрибут value у input элементов
        // Используется для полей ввода, проверяет введенное значение
        // Частая проверка для форм и полей автозаполнения
        wait.until(textToBePresentInElementValue(By.cssSelector(""), "test"));

        // Примечание: после всех ожиданий следует закрыть браузер
        // driver.quit();
    }
}