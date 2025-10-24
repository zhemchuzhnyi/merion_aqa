package ru.merion.aqa.lesson9;

import com.codeborne.selenide.*;
import org.openqa.selenium.Cookie;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeLessThanOrEqual;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ElementsCollectionDemo {
    public static void main(String[] args) {

        open("https://www.labirint.ru/");
        Cookie cookie = new Cookie("cookie_policy", "1");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

        open("https://www.labirint.ru/");
        $("#search-field").val("Java").pressEnter();

        ElementsCollection cards = $$(".product-card")
                .shouldHave(sizeLessThanOrEqual(60));

        List<String> attributeValues = cards.attributes("data-product-id");

        List<String> jsBooks = cards.filter(Condition.text("JavaScript")).texts();

        List<String> javaBooks = cards.exclude(Condition.text("JavaScript")).texts();
        System.out.println(javaBooks.size());

        long start = System.currentTimeMillis();
        List<String> names = $$(".product-card .product-card__name").texts();
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        List<String> strings = cards.asDynamicIterable().stream()
                .map(card -> card.find(".product-card__name"))
                .filter(element -> element.exists())
                .map(element -> element.text())
                .toList();
        System.out.println(System.currentTimeMillis() - start);


        Selenide.closeWebDriver();
    }
}
