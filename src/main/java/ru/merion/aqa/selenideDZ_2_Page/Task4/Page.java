package ru.merion.aqa.selenideDZ_2_Page.Task4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Page {
    private final SelenideElement first = $(("[name = 'first-name']")).val("Иван");
    private final SelenideElement last = $(("[name = 'last-name']")).val("Петров");
    private final SelenideElement address = $(("[name = 'address']")).val("Ленина, 55-3");
    private final SelenideElement city = $(("[name = 'city']")).val("Москва");
    private final SelenideElement country = $(("[name = 'country']")).val("Россия");
    private final SelenideElement job = $(("[name = 'job-position']")).val("QA");
    private final SelenideElement company = $(("[name = 'company']")).val("Merion");
    private final SelenideElement button = $((".btn-outline-primary"));

    public void open(){
        Selenide.open("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
    }

    public void clickButton(){
        button.click();
    }
}
