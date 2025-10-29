package ru.merion.aqa.lesson10;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import ru.merion.aqa.lesson10.midlevel_page.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class NoEncapsulation {
    public static void main(String[] args) {

        MainPage main = new MainPage();
        main.open();
        main.searchFor("Java");

        String price = $("#basket-default-sumprice-discount").text();
        System.out.println(price);

        Selenide.closeWebDriver();
    }
}
