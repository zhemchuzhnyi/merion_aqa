package ru.merion.aqa.selenideDZ_2_Page.Task6;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartCheckoutPage {
    private final SelenideElement firstNameInput = $("#first-name");
    private final SelenideElement lastNameInput = $("#last-name");
    private final SelenideElement postalCode = $("#postal-code");
    private final SelenideElement continueButton = $("#continue");
    private final SelenideElement priceText = $("[data-test=total-label]");

    public CartCheckoutPage open() {
       Selenide.open("https://www.saucedemo.com/cart.html");
       return this;
    }



}
