package ru.merion.aqa.lesson3;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class WindowPosition {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");

        Point position = driver.manage().window().getPosition();
        System.out.println("position: " + position);

        driver.quit();


    }

}
