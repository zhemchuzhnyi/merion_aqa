package ru.merion.aqa.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.util.List;

public class Frames {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        List<WebElement> shouldBeEmpty = driver.findElements(By.cssSelector("body"));

        driver.switchTo().frame("frame-bottom");
        List<WebElement> shouldHaveBody = driver.findElements(By.cssSelector("body"));
        System.out.println(shouldHaveBody.get(0).getText());

        driver.quit();

    }
}
