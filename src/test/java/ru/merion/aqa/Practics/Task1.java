package ru.merion.aqa.Practics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.cssSelector(".username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector(".password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector(".fa-fa-2x-fa-sign-in")).click();

        driver.findElement(By.cssSelector(".subheader")).getText();


    }
}
