package ru.merion.aqa.Practics.page;

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
}

