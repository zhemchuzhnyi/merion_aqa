package ru.merion.aqa.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        List<WebElement> buttons = driver.findElements(By.cssSelector("ul li button"));

        buttons.get(0).click();




    }

}
