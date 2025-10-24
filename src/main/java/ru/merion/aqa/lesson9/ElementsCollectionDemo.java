package ru.merion.aqa.lesson9;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ElementsCollectionDemo {
    public static void main(String[] args) {
        open("https://www.labirint.ru/");
        Cookie cookie = new Cookie("cookie_policy", "1");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

        open("https://www.labirint.ru/");
        $("#search-field").val("Java").pressEnter();

        ElementsCollection cardsWithBuyButton = $$(".product-card:has(.buy-link)");
        cardsWithBuyButton.forEach(card -> card.find(".buy-link").click());

        $(".j-cart-count").shouldHave(text(String.valueOf(cardsWithBuyButton.size())))
                .shouldHave(text(String.valueOf(cardsWithBuyButton.size())));


        Selenide.closeWebDriver();
    }
}
