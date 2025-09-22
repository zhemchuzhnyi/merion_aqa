package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import java.time.Duration;

public class ScrollActions {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.apple.com/iphone-17-pro/");

        By iconLocator = By.cssSelector(".ac-gf-breadcrumbs-home-icon");

        new Actions(driver)
                .pause(1000L)
                .scrollFromOrigin(WheelInput.ScrollOrigin.fromElement(driver.findElement(iconLocator)),0,200)
                        .pause(1000L)
                                .perform();

        driver.quit();

    }
}
