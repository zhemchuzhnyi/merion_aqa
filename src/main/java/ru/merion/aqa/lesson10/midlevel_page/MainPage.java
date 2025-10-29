package ru.merion.aqa.lesson10.midlevel_page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public void open() {
        Selenide.open("https://www.labirint.ru/");
        Cookie cookie = new Cookie("cookie_policy", "1");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

        Selenide.open("/");
    }

    public void search(String term) {
        $("#search-field").val(term).pressEnter();
    }
}
