package ru.merion.aqa.lesson8;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.open;

public class TrySelenide {
    public static void main(String[] args) {

        open("https://habr.com/ru");

        String title = Selenide.title();
        System.out.println(title);

        Selenide.closeWebDriver();


    }
}