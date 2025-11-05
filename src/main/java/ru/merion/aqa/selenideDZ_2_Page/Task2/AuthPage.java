package ru.merion.aqa.selenideDZ_2_Page.Task2;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    private final SelenideElement button = $(("#updatingButton"));
    private final SelenideElement form = $(".form-control");

    public void open() {
        Selenide.open("http://uitestingplayground.com/textinput");
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
