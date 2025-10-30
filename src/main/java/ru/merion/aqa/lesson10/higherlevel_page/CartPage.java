package ru.merion.aqa.lesson10.higherlevel_page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

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