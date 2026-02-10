package ru.merion.aqa.lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.merion.aqa.WebDriverFactory;

import java.io.File;

/**
 * Первый скрипт для демонстрации запуска Chrome с расширением
 * Показывает базовую настройку браузера с дополнительными опциями
 */
public class FirstScript {

    public static void main(String[] args) {

        // Создание объекта ChromeOptions для настройки параметров запуска Chrome
        ChromeOptions options = new ChromeOptions();

        // Добавление расширения User-Agent Switcher в браузер
        // Расширение загружается из .crx файла по указанному пути
        // Позволяет изменять User-Agent браузера для имитации других устройств/браузеров
        options.addExtensions(new File("/Users/a0000/IdeaProjects/merion_aqa/src/main/resources/User-Agent-Switcher-for-Chrome-Chrome.crx"));

        // Создание экземпляра WebDriver через фабричный метод
        // Передаем настроенные опции для инициализации браузера с расширением
        WebDriver driver1 = WebDriverFactory.create(options);

        // Открытие главной страницы Яндекса
        driver1.get("https://ya.ru");

        // ВНИМАНИЕ: В коде отсутствует driver1.quit() - браузер останется открытым
        // Рекомендуется добавить закрытие браузера для освобождения ресурсов

    }
}