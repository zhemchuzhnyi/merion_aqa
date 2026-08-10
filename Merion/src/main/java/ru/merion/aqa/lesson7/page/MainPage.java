package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.labirint.ru/");
        // Принимаем политику cookie, иначе баннер перекрывает страницу.
        // Cookie ставится до перезагрузки, т.к. addCookie требует нахождения на домене.
        driver.manage().addCookie(new Cookie("cookie_policy", "1"));
        driver.get("https://www.labirint.ru/");
    }
}