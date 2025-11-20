package ru.merion.aqa.selenideDZ_2_Page.Task1;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class AjaxPage {
    private final SelenideElement button = $("#ajaxButton");
    private final SelenideElement content = $("#content p");

    public void open() {
        Selenide.open("http://uitestingplayground.com/ajax");
    }
    public void clickTheButton() {
        button.click();
    }

    public String getContent() {
        return content.text();
    }
}