package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

public class LoadAjaxData {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");

        driver.get("http://uitestingplayground.com/ajax");
        driver.findElement(By.cssSelector("#ajax-button")).click();
        driver.findElement(By.cssSelector("#content p")).getText();
        String content = driver.findElement(By.cssSelector("#content p")).getText();

        System.out.println(content);




    }
}
