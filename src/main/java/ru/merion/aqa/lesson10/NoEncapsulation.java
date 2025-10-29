package ru.merion.aqa.lesson10;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import ru.merion.aqa.lesson10.midlevel_page.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class NoEncapsulation {
    public static void main(String[] args) {

        MainPage main = new MainPage();
        main.open();

        open("https://www.labirint.ru/");
        $("#search-field").val("Java").pressEnter();

        ElementsCollection cardsWithBuyButton = $$(".product-card:has(.buy-link)");
        cardsWithBuyButton.forEach(card -> card.find(".buy-link").click());

        $(".j-cart-count").shouldHave(text(String.valueOf(cardsWithBuyButton.size())))
                .shouldHave(text(String.valueOf(cardsWithBuyButton.size())))
                .click();

        String price = $("#basket-default-sumprice-discount").text();
        System.out.println(price);

        Selenide.closeWebDriver();
    }
}
