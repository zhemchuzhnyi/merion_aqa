package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MouseActions {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jspaint.app/#local:f027a292cdf1");

        WebElement canvas = driver.findElement(By.cssSelector(".main-canvas"));
        canvas.click();

        driver.quit();



    }
}
