package ru.merion.aqa.practiceDZ3_1.Task6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task6 {
    public static void main(String[] args) {
        AuthPage auth;
        CatalogPage catalog;
        CartCheckoutPage cartCheckout;

        Set<String> itemNames = new HashSet<>();
        itemNames.add("Sauce Labs Backpack");
        itemNames.add("Sauce Labs Bolt T-Shirt");
        itemNames.add("Sauce Labs Onesie");

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        auth = new AuthPage(driver).open();
        catalog = auth.loginAs("standart_user","secret_sauce");
        catalog.addItems(itemNames);

        cartCheckout = new CartCheckoutPage(driver).open();
        cartCheckout.clickChekout();
        cartCheckout.setContactData("Иван","Иванов","1234567");



        System.out.println("Результат: " + total);




    }
}
