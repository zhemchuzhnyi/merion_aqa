package ru.merion.aqa.lesson3;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Navigation {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");

        driver.get("https://habr.com/ru"); // == driver.navigate().to("https://habr.com/ru");

        driver.quit();

    }

}
