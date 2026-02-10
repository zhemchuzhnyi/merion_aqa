package ru.merion.aqa.lesson10.midlevel_page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage {
    private final SelenideElement totalPrice = $("#basket-default-sumprice-discount");

    public CartPage open() {
        Selenide.open("/cart/");
        return this;
    }

    public SelenideElement getCartPrice() {
        return totalPrice;
    }

    public String getTotalPrice() {
        return totalPrice.text();
    }
}