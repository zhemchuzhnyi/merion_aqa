package ru.merion.aqa.lesson10.midlevel_page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultPage {
    private final ElementsCollection cardsWithBuyButton = $$(".product-card:has(.buy-link)");
    private final SelenideElement cartCount = $(".j-cart-count");

    public ResultPage addAllItemsToCart() {
        cardsWithBuyButton.forEach(card -> card.find(".buy-link").click());
        return this;
    }

    public int getAddedProductsCount() {
        return cardsWithBuyButton.size();
    }

    public CartPage openCart() {
        cartCount.click();
        return new CartPage();
    }

    public ResultPage verifyCartCount(int expectedCount) {
        cartCount.shouldHave(text(String.valueOf(expectedCount)));
        return this;
    }
}