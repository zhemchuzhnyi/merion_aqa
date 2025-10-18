package ru.merion.aqa.practiceDZ3.Task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By checkoutButton = By.cssSelector("#checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}