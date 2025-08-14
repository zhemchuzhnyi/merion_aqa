package ru.merion.aqa.practiceDZ;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Task6 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://the-internet.herokuapp.com/login");


    }
}
