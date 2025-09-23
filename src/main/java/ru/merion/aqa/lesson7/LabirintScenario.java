package ru.merion.aqa.lesson7;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LabirintScenario {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.labirint.ru/");
        Cookie cookie = new Cookie("cookie_policy", "1");
        driver.manage().addCookie(cookie);
    }
}
