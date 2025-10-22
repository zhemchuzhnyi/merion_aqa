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

    public void clickChekout() {
        driver.findElement(By.cssSelector("#checkout")).click();
    }

    public void setContactData(String firstName,String lastName, String zip) {
        driver.findElement(By.cssSelector("#first-name")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#last-name")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#postal-code")).sendKeys(zip);
    }

}

