package ru.merion.aqa.lesson3;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class CookiesV3 {

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            // Используем статический метод create из WebDriverFactory
            driver = WebDriverFactory.create("chrome");

            // Открываем начальную страницу
            driver.get("https://lms.merionet.ru");

            // Добавляем куки
            Cookie cookie = new Cookie("MoodleSession", "");
            driver.manage().addCookie(cookie);

            // Обновляем страницу, чтобы куки применились
            driver.navigate().refresh();

            // Переходим на страницу личного кабинета
            driver.get("https://lms.merionet.ru/my/");

        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Убедимся, что браузер закроется, даже если произойдет ошибка
            if (driver != null) {
                driver.quit();
            }
        }
    }
}