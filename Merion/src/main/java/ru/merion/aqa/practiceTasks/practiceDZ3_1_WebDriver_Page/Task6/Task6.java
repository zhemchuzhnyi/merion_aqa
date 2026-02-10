package ru.merion.aqa.practiceTasks.practiceDZ3_1_WebDriver_Page.Task6;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class Task6 {
    public static void main(String[] args) {
        AuthPage auth;
        CatalogPage catalog;

        Set<String> itemNames = new HashSet<>();
        itemNames.add("Sauce Labs Backpack");
        itemNames.add("Sauce Labs Bolt T-Shirt");
        itemNames.add("Sauce Labs Onesie");

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        auth = new AuthPage(driver).open();
        catalog = auth.loginAs("standard_user","secret_sauce");
        catalog.addItems(itemNames);

        String total = new CartCheckoutPage(driver)
                .open()
                .clickCheckout()
                .setContactData("Иван","Иванов","1234567")
                .getTotalPrice();

        driver.quit();

        System.out.println("Результат: " + total);

    }
}