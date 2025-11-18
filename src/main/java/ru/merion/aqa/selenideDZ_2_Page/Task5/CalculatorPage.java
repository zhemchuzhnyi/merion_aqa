package ru.merion.aqa.selenideDZ_2_Page.Task5;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CalculatorPage {
    private final SelenideElement keyboard = $(".keys");
    private int delay = 5;

    public CalculatorPage open() {
        Selenide.open("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        return this;
    }

    public void setDelay(int delay) {
        $(("#delay")).val(String.valueOf(delay));
        this.delay = delay;
    }


}
