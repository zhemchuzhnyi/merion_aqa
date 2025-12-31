package ru.merion.aqa.Practics.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task1Page {
    private final WebDriver driver;

    public Task1Page(WebDriver driver) {
        this.driver = driver;
    }

    public Task1Page open() {
        driver.get("https://the-internet.herokuapp.com/login");
        return this;
    }

    public Task1Page enterRegistrationData(String username, String password) {
        driver.findElement(By.cssSelector("#username")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector(".fa-sign-in")).click();
        return this;
    }

    public String getContent() {
        return driver.findElement(By.cssSelector(".flash")).getText();
    }
}

