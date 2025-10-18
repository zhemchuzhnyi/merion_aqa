package ru.merion.aqa.practiceDZ3.Task4;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class Task4 {

    public static void main(String[] args) {
        Set<String> itemNames = new HashSet<>();
        itemNames.add("Sauce Labs Backpack");
        itemNames.add("Sauce Labs Bolt T-Shirt");
        itemNames.add("Sauce Labs Onesie");

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addItemsToCart(itemNames);

        cartPage.open();
        cartPage.clickCheckout();

        checkoutPage.fillPersonalInfo("Alex", "Smith", "12345");
        checkoutPage.clickContinue();

        String total = checkoutPage.getTotalAmount();
        driver.quit();

        System.out.println("Результат: " + total);
    }
}