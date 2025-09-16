package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.merion.aqa.WebDriverFactory;

public class KeyboardActions {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/textinput");

        Actions act = new Actions(driver);

        By locator = By.cssSelector("#newButtonName");

        act
                .keyDown(Keys.LEFT_SHIFT)
                .sendKeys(driver.findElement(locator),"merion")
                .keyUp(Keys.LEFT_SHIFT)
                .keyDown(Keys.LEFT_SHIFT)
                .sendKeys(Keys.ARROW_UP)
                .perform();

        driver.quit();

    }
}
