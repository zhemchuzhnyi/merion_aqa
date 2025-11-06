package ru.merion.aqa.selenideDZ_2_Page.Task4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Page {
    private final SelenideElement first = $(("[name = 'first-name']"));
    private final SelenideElement last = $(("[name = 'last-name']"));
    private final SelenideElement address = $(("[name = 'address']"));
    private final SelenideElement city = $(("[name = 'city']"));
    private final SelenideElement country = $(("[name = 'country']"));
    private final SelenideElement job = $(("[name = 'job-position']"));
    private final SelenideElement company = $(("[name = 'company']"));
    private final SelenideElement button = $((".btn-outline-primary"));
    private final SelenideElement zip = $(("#zip-code"));
    private final SelenideElement mail = $(("#e-mail"));
    private final SelenideElement phone = $(("#phone"));


    public void open(){
        Selenide.open("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
    }

    public void setForm(){
        first.val("Иван");
        last.val("Петров");
        address.val("Ленина, 55-3");
        city.val("Москва");
        country.val("Россия");
        job.val("QA");
        company.val("Merion");
    }

    public void clickButton(){
        button.click();
    }

    public String getCss(){
        return zip.getCssValue("background-color");
        return mail.getCssValue("background-color");

    }
}
