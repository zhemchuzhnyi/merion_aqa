package ru.merion.aqa.practice;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class ClickWithoutID {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://uitestingplayground.com/dynamicid");

    }
}
