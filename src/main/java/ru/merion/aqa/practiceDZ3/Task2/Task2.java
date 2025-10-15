package ru.merion.aqa.practiceDZ3.Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
        WebElement element = driver.findElement(By.cssSelector(""));


        driver.quit();


    }
}
