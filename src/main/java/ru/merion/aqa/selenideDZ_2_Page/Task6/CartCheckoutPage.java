package ru.merion.aqa.selenideDZ_2_Page.Task6;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartCheckoutPage {
    private final SelenideElement firstNameInput = $("#first-name");
    private final SelenideElement lastNameInput = $("#last-name");
    private final SelenideElement postalCode = $("#postal-code");
    private final SelenideElement continueButton = $("#continue");
    private final SelenideElement pricrText = $("[data-test=total-label]");

}
