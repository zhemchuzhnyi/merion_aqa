package ru.merion.aqa.lesson3;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class CookiesV2 {

    public static void main(String[] args) {

        String token = "Z6IlIQEmjm0IX7g2PbaYEpxWoBuZEwMliVFt7zkplHjQG5bbuShUtAazXhXZFMCZyYtAals/Ug==";


        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://stepik.org/learn");

        driver.manage().addCookie(new Cookie("token","token"));

        driver.quit();

    }

}
