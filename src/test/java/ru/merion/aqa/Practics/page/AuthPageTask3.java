package ru.merion.aqa.Practics.page;

import org.openqa.selenium.WebDriver;

public class AuthPageTask3 {
    private final WebDriver driver;

    public AuthPageTask3(WebDriver driver) {
        this.driver = driver;
    }

    public AuthPageTask3 open() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

}
