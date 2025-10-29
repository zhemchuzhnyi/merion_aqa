package ru.merion.aqa.lesson10.midlevel_page;

import com.codeborne.selenide.Selenide;

public class MainPage {

    public void open() {
        Selenide.open("/");
    }
}
