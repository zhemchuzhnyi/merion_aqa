package ru.merion.aqa.lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class SendKeys {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("http://uitestingplayground.com/textinput");
        driver.findElement(By.cssSelector("#newButtonName")).sendKeys("Welcome!");
        driver.findElement(By.cssSelector("#newButtonName")).sendKeys(" To site!");
        driver.findElement(By.cssSelector("#newButtonName")).sendKeys(Keys.chord(Keys.LEFT_SHIFT, Keys.ARROW_UP)); // выделяем текс
        driver.findElement(By.cssSelector("#newButtonName")).sendKeys(Keys.BACK_SPACE); // убирает последний символ (восклицательный знак уберет) если все выделено - удалит
        driver.findElement(By.cssSelector("#updatingButton")).click();

        driver.quit();




    }
}
