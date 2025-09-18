package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jspaint.app/#local:f027a292cdf1");

        WebElement canvas = driver.findElement(By.cssSelector(".main-canvas"));

        new Actions(driver)
                .clickAndHold(canvas)
                        .moveByOffset(100, -50)
                                .perform();

        driver.quit();



    }
}
