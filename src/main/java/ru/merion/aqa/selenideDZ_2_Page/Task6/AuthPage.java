package ru.merion.aqa.selenideDZ_2_Page.Task6;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    private final SelenideElement login = $("#user-name");
    private final SelenideElement password = $("#password");
    private final SelenideElement button = $("#login-button");

    public AuthPage open() {
        Selenide.open("https://www.saucedemo.com/");
        return this;
    }
}
