package ru.merion.aqa.selenideDZ_2_Page.Task5;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Page {
    private final SelenideElement keyboard = $(".keys");
    private final SelenideElement deelay = $(("#delay")).val(Integer.toString(timeout));
    private final SelenideElement spinner = $(("#spinner")).shouldNotBe(visible, Duration.ofSeconds(timeout+1));

    public void open() {
        Selenide.open("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
    }

}
