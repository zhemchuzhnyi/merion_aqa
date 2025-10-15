package ru.merion.aqa.practiceDZ3.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task1 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("http://uitestingplayground.com/textinput");
        driver.findElement(By.cssSelector(".form-control")).sendKeys("Merion");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        String btn = driver.findElement(By.cssSelector(".btn-primary")).getText();

        System.out.println(btn);

        driver.quit();


    }
}
