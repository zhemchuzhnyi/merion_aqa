package ru.merion.aqa.lesson10.midlevel_page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement searchField = $("#search-field");

    public MainPage open() {
        Selenide.open("/");
        return this;
    }

    public ResultPage searchFor(String query) {
        searchField.val(query).pressEnter();
        return new ResultPage();
    }
}