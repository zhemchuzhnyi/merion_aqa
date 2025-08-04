package ru.merion.aqa.lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

public class Rect {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://habr.com/ru/feed/");

        WebElement el = driver.findElement(By.cssSelector(".tm-article-title__link"));

        el.getRect().getDimension();
        el.getRect().getWidth();
        el.getRect().getHeight();
        el.getLocation().getX();
        el.getSize().getWidth();

        driver.close();



    }
}
