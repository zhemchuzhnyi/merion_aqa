package ru.merion.aqa.Practics.page;

import org.openqa.selenium.By;
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

    public MainPageOpen login() {
        driver.findElement(By.cssSelector("#user-name")).sendKeys("visual_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        return new MainPageOpen(driver);
    }

    public TryToClickBurger burger() {
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
        driver.findElement(By.cssSelector("#about_sidebar_link")).click();
        return this;
    }

}
