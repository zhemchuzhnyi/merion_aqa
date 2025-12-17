package ru.merion.aqa.DZ_Praktika.Task_4.page;

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
