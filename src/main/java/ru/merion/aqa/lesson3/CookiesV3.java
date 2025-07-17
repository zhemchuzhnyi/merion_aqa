package ru.merion.aqa.lesson3;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class CookiesV3 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");

            // Открываем начальную страницу
        driver.get("https://lms.merionet.ru");

            // Добавляем куки
        Cookie cookie = new Cookie("MoodleSession", "");
        driver.manage().addCookie(cookie);

            // Обновляем страницу, чтобы куки применились
        driver.navigate().refresh();

            // Переходим на страницу личного кабинета
        driver.get("https://lms.merionet.ru/my/");

        driver.quit();
    }
}
