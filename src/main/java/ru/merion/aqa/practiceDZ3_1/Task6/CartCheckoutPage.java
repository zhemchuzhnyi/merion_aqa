package ru.merion.aqa.practiceDZ3_1.Task6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartCheckoutPage {
    private final WebDriver driver;
    public CartCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public CartCheckoutPage open() {
        driver.get("https://www.saucedemo.com/cart.html");
        return this;
    }
}

