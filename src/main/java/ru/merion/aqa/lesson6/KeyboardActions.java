package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.openqa.selenium.Keys.*;

public class KeyboardActions {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://uitestingplayground.com/textinput");

        By locator = By.cssSelector("#newButtonName");

        Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? COMMAND : CONTROL;

        long pause = 1000L;

        new Actions(driver)
                .keyDown(LEFT_SHIFT)
                .sendKeys(driver.findElement(locator), "merion")
                .keyUp(LEFT_SHIFT)
                .pause(pause)
                .keyDown(LEFT_SHIFT)
                .sendKeys(ARROW_UP)
                .keyUp(LEFT_SHIFT)
                .keyDown(cmdCtrl)
                .sendKeys("c")
                .pause(pause)
                .sendKeys("vv")
                .pause(pause)
                .sendKeys("v")
                .keyUp(cmdCtrl)
                .pause(pause)
                .perform();

        driver.quit();
    }
}