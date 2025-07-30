package ru.merion.aqa.lesson4;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class SendKeys {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/textinput");

    }
}
