package ru.merion.aqa.lesson10;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class NoEncapsulation {
    public static void main(String[] args) {
        open("https://www.labirint.ru/");
        Cookie cookie = new Cookie("cookie_policy", "1");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

        open("https://www.labirint.ru/");
        $("#search-field").val("Java").pressEnter();

        ElementsCollection cards = $$(".product-card:has(.buy-link)").shouldHave(size(50));
        cards.forEach(card -> card.find(".buy-link").click());


    }

}
