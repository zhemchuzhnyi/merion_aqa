package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import java.time.Duration;

/**
 * Класс для демонстрации работы с прокруткой страницы в Selenium WebDriver
 * Использует Actions API для выполнения скролла относительно элемента на странице
 */
public class ScrollActions {

    public static void main(String[] args) {
        // Создание экземпляра ChromeDriver для управления браузером Chrome
        WebDriver driver = new ChromeDriver();

        // Установка неявного ожидания - драйвер будет ждать до 10 секунд
        // перед тем как выбросить исключение, если элемент не найден
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Открытие страницы iPhone 17 Pro на сайте Apple
        driver.get("https://www.apple.com/iphone-17-pro/");

        // Определение локатора для иконки домашней страницы в хлебных крошках
        // Использует CSS селектор для поиска элемента по классу
        By iconLocator = By.cssSelector(".ac-gf-breadcrumbs-home-icon");

        // Создание цепочки действий для выполнения прокрутки страницы
        new Actions(driver)
                // Пауза на 1 секунду перед началом прокрутки
                .pause(1000L)
                // Прокрутка от найденного элемента (иконки) на 200 пикселей вниз
                // Параметры: scrollFromOrigin(откуда скроллить, смещение по X, смещение по Y)
                .scrollFromOrigin(WheelInput.ScrollOrigin.fromElement(driver.findElement(iconLocator)),0,200)
                // Пауза на 1 секунду после прокрутки
                .pause(1000L)
                // Выполнение всех накопленных действий
                .perform();

        // Закрытие браузера и освобождение ресурсов
        driver.quit();

    }
}