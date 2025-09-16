package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.merion.aqa.WebDriverFactory;

import java.security.Key;

import static org.openqa.selenium.Keys.*;

public class KeyboardActions {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/textinput");

        Actions act = new Actions(driver);

        By locator = By.cssSelector("#newButtonName");

        Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? COMMAND : CONTROL;

        new Actions(driver)
                .keyDown(LEFT_SHIFT)
                .sendKeys(driver.findElement(locator),"merion")
                .keyUp(LEFT_SHIFT)
                .pause(1000L)
                .keyDown(LEFT_SHIFT)
                .sendKeys(ARROW_UP)
                .keyUp(LEFT_SHIFT)
                .keyDown(cmdCtrl)
                .sendKeys("c")
                .pause(1000L)
                .sendKeys("vv")
                .pause(1000L)
                .sendKeys("v")
                .keyUp(cmdCtrl)
                .pause(1000L)
                .perform();

        driver.quit();

    }
}
