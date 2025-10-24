package ru.merion.aqa.lesson9;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public class ConfigDemo {

    public static void main(String[] args) {
        Configuration.timeout = 1000*8; // Таймаут ожидания элементов - 8 секунд
        Configuration.headless = true; // Запуск браузера в фоновом режиме (без GUI)
        Configuration.browser = "chrome"; // Использовать Chrome браузер
        Configuration.assertionMode = AssertionMode.SOFT; // Продолжать тест после падения проверок
        Configuration.fastSetValue = true; // Быстрый ввод текста через JavaScript

        open("https://habr.com/ru");
        System.out.println(title());

        Selenide.closeWebDriver();
    }
}
