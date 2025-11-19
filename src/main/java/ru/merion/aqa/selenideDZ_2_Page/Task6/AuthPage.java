package ru.merion.aqa.selenideDZ_2_Page.Task6;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    private static final Logger log = LoggerFactory.getLogger(AuthPage.class);
    private final SelenideElement login = $("#user-name");
    private final SelenideElement pass = $("#password");
    private final SelenideElement button = $("#login-button");

    public AuthPage open() {
        Selenide.open("https://www.saucedemo.com/");
        return this;
    }

    public CatalogPage logiAs (String username, String password) {
        login.val(username);
        pass.val(password);
        button.click();
        return new CatalogPage();
    }
}
