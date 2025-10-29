package ru.merion.aqa.lesson10.midlevel_page;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultPage {

    public void addAllItemsToCart() {
        ElementsCollection cardsWithBuyButton = $$(".product-card:has(.buy-link)");
        cardsWithBuyButton.forEach(card -> card.find(".buy-link").click());

        $(".j-cart-count").shouldHave(text(String.valueOf(cardsWithBuyButton.size())))
                .shouldHave(text(String.valueOf(cardsWithBuyButton.size())))
                .click();


        int counter = 0;
        for (WebElement card : cards) {
            card.findElement(By.cssSelector(".buy-link")).click();
            counter++;
        }

    }

}
