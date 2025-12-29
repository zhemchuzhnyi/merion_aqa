package ru.merion.aqa.Practics.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task2Page {
    private final WebDriver driver;

    public Task2Page(WebDriver driver) {
        this.driver = driver;
    }

    public Task2Page open() {
        driver.get("https://the-internet.herokuapp.com/login");
        return this;
    }

    public Task2Page enterRegistrationData(String username, String password) {
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector(".fa-sign-in")).click();
        return this;
    }

    public Task2Page getContent(String content, String success) {
        driver.findElement(By.cssSelector(".flash")).getText();
        driver.findElement(By.cssSelector(".subheader")).getText();
        return this;
    }

}

