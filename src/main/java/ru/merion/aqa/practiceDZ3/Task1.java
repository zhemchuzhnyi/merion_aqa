package ru.merion.aqa.practiceDZ3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestingplayground.com/textinput");
        WebElement element = driver.findElement(By.cssSelector());

        driver.quit();


    }
}
