package ru.merion.aqa.lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.merion.aqa.WebDriverFactory;

import java.io.File;

public class FirstScript {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("/Users/a0000/IdeaProjects/merion_aqa/src/main/resources/User-Agent-Switcher-for-Chrome-Chrome.crx"));

        WebDriver driver1 = WebDriverFactory.create(options);
        driver1.get("https://ya.ru");



    }
}
