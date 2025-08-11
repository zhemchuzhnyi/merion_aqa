package ru.merion.aqa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

public class ClickWithoutID {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/dynamicid");
        WebElement element = driver.findElement(By.id("08ed7121-b197-2334-149e-7e6f6f5ab439"));
        element.click();

        driver.quit();

    }
}
