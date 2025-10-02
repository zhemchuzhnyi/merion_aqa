package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open () {

        // Устанавливаем неявное ожидание 500 миллисекунд для поиска элементов
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // Открываем главную страницу Лабиринт
        driver.get("https://www.labirint.ru/");

        // Добавляем cookie для принятия политики использования cookies
        Cookie cookie = new Cookie("cookie_policy", "1");
        driver.manage().addCookie(cookie);

        // Разворачиваем окно браузера на весь экран
        driver.manage().window().maximize();

        // Перезагружаем страницу, чтобы применились cookies
        driver.get("https://www.labirint.ru/");
    }

    public void searchFor (String term) {

        // Находим форму поиска на странице
        WebElement form = driver.findElement(By.cssSelector("#searchform"));

        // Находим поле ввода поиска и вводим текст "Java"
        form.findElement(By.cssSelector("#search-field")).sendKeys(term);

        // Отправляем форму поиска
        form.submit();
    }

}
