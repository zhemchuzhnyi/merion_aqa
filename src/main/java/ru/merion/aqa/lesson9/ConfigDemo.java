package ru.merion.aqa.lesson9;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public class ConfigDemo {

    public static void main(String[] args) {
        Configuration.timeout = 1000*8; // настройка ожидания (по умолчанию 4 сек)
        Configuration.headless = true; // - не показывает интерфейс
        Configuration.browser = "chrome"; // - настройка браузера
        Configuration.assertionMode = AssertionMode.SOFT; // -

        open("https://habr.com/ru");
        System.out.println(title());

        Selenide.closeWebDriver();
    }
}
