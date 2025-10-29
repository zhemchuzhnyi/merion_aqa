package ru.merion.aqa.lesson10.midlevel_page;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultPage {

    public void addAllItemsToCart() {
        $$(".product-card:has(.buy-link)").forEach(card -> card.find(".buy-link").click());

    }

}
