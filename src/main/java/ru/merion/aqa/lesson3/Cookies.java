package ru.merion.aqa.lesson3;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.util.Date;

public class Cookies {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");

        Cookie cookie = new Cookie("cookie_policy", "1", "labirint.ru", "/", new Date(2025, 07, 15));
        driver.manage().addCookie(cookie);
        driver.get("http://www.labirint.ru/");



        driver.quit();

    }

}
