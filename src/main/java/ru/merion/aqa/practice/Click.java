package ru.merion.aqa.practice;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Click {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

    }
}
