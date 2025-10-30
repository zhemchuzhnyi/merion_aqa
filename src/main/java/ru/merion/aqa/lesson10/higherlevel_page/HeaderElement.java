package ru.merion.aqa.lesson10.higherlevel_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderElement {
    private final SelenideElement searchInput = $("#search-field");

    public ResultPage searchFor(String term) {
        searchInput.val(term).pressEnter();
        return new ResultPage();
    }
}