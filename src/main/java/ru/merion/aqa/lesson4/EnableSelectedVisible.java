package ru.merion.aqa.lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class EnableSelectedVisible {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        boolean selected = driver.findElement(By.cssSelector("#checkbox input")).isSelected();
        driver.findElement(By.cssSelector("#checkbox input")).click();
        selected = driver.findElement(By.cssSelector("#checkbox input")).isSelected();

        boolean isEnabled = driver.findElement(By.cssSelector("#input-example input")).isEnabled();

        if (isEnabled) {
            driver.findElement(By.cssSelector("#input-example input")).sendKeys("Testing");
        } else {
            System.out.println("Элемент недоступен");
        }

        driver.quit();
    }
}
