package ru.merion.aqa.selenideDZ_2_Page.Task1;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;

public class Page {

    private static final String PAGE_URL = "https://example.com";

    // Локатор для контента, загруженного через AJAX
    private SelenideElement ajaxContent = $("#ajax-content");

    public Page openPage() {
        open(PAGE_URL);
        return this;
    }

    public String getAjaxLoadedText() {
        return ajaxContent.getText();
    }
}