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
        WebElement tools = driver.findElement(By.cssSelector(".tools"));
        WebElement brush = driver.findElement(By.cssSelector("[title='Кисть']"));

        long pause = 1000l;
        new Actions(driver)
                .click(brush)
                .clickAndHold(canvas)
                .pause(pause)
                .moveByOffset(0, -150)
                .pause(pause)
                .moveByOffset(150,0)
                .pause(pause)
                .moveByOffset(0,150)
                .pause(pause)
                .moveByOffset(-150,0)
                .perform();

        driver.quit();



    }
}
