package ru.merion.aqa.practiceDZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

public class Task2 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/dynamicid");
        WebElement element = driver.findElement(By.cssSelector(".btn-primary"));
        element.click();

        driver.quit();

    }
}
