package ru.merion.aqa.selenideDZ_2_Page.Task5;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Page {
    private final SelenideElement keyboard = $(".keys");

    public void open() {
        Selenide.open("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
    }

}
