package ru.merion.aqa.practiceDZ2;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Task5NewSolution {

    public static void main(String[] args) {
        int timeout = 7;

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

    }
}
