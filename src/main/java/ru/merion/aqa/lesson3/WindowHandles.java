package ru.merion.aqa.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.util.Set;

public class WindowHandles {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector("#content a")).click();
        
        String windowHandle = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

    }
}
