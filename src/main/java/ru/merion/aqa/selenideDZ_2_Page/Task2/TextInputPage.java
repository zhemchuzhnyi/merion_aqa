package ru.merion.aqa.selenideDZ_2_Page.Task2;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TextInputPage {
    private final SelenideElement button = $(("#updatingButton"));
    private final SelenideElement form = $(".form-control");

    public TextInputPage open() {
        Selenide.open("http://uitestingplayground.com/textinput");
        return this;
    }

    public void setForm() {
        form.val("Merion");
    }

    public void clickButton() {
        button.click();
    }

    public String getText() {
        return button.getText();
    }
}
