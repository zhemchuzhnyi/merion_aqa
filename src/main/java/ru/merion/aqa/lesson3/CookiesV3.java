package ru.merion.aqa.lesson3;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.util.Set;

public class CookiesV3 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");

            // Открываем начальную страницу
        driver.get("https://lms.merionet.ru");

            // Добавляем куки
        Cookie cookie = new Cookie("MoodleSession", "da8k3stv0052052efj1p4t0pn4");
        driver.manage().addCookie(cookie);

            // Обновляем страницу, чтобы куки применились
        driver.navigate().refresh();

            // Переходим на страницу личного кабинета
        driver.get("https://lms.merionet.ru/my/");

        Set<Cookie> cookies = driver.manage().getCookies();
        Cookie MoodleSession = driver.manage().getCookieNamed("MoodleSession");

        driver.quit();
    }
}
