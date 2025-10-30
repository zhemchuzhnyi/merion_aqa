package ru.merion.aqa.lesson10.higherlevel_page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public String totalPrice() {
        return $("#basket-default-sumprice-discount").text();
    }

    public CartPage open() {
        Selenide.open("/cart/");
        return this;
    }

    public getCartPrice open() {
        return getCartPrice;
    }

    public getTotalPrice open() {
        return totalPrice.text();
    }
}