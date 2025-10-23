package ru.merion.aqa.lesson8;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LabirintScenarioSelenide {
    public static void main(String[] args) {
        open("https://www.labirint.ru/");
        Cookie cookie = new Cookie("cookie_policy", "1");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

        open("https://www.labirint.ru/");
        $("#search-field").val("Java").pressEnter();






    }
}
