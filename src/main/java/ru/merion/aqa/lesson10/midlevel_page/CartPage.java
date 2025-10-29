package ru.merion.aqa.lesson10.midlevel_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public SelenideElement getCartPrice() {return $("#j-cart-count");}

}
