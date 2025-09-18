package ru.merion.aqa.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        WebElement brush = tools.findElement(By.cssSelector("[title='Кисть']"));
        WebElement paint = tools.findElement(By.cssSelector("[title = 'Заливка']"));
        WebElement rect = tools.findElement(By.cssSelector("[title='Прямоугольник']"));
        WebElement color = driver.findElement(By.cssSelector("[data-color = 'rgb(128,128,255)']"));


        long pause = 1000l;
        new Actions(driver)
                .click(brush)
                .clickAndHold(canvas) // зажимает кнопку
                .pause(pause)
                .moveByOffset(0, -150)
                .pause(pause)
                .moveByOffset(150,0)
                .pause(pause)
                .moveByOffset(0,150)
                .pause(pause)
                .moveByOffset(-150,0)
                .release(canvas)
                .perform();

        new Actions(driver)
                .moveByOffset(-100,100)
                .perform(); // перемещаем курсор

        new Actions(driver)
                .click(paint)
                .click(color)
                .moveToElement(canvas, 10,-10)
                .click()
                .perform();

        new Actions(driver)
                .click(rect)
                .moveToElement(canvas)
                .keyDown(Keys.LEFT_SHIFT)
                .clickAndHold()
                .moveByOffset(-300, 150)
                .release()
                .keyUp(Keys.LEFT_SHIFT)
                .perform();

        driver.quit();



    }
}
