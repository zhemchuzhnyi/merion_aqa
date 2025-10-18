package ru.merion.aqa.practiceDZ3.Task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

class InventoryPage {
    private WebDriver driver;
    private By inventoryItems = By.cssSelector(".inventory_item");
    private By itemName = By.cssSelector(".inventory_item_name");
    private By addButton = By.cssSelector("button");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addItemsToCart() {
        List<WebElement> items = driver.findElements(inventoryItems);
        for (WebElement item : items) {
            String productName = item.findElement(itemName).getText();
            if (itemNames.contains(productName)) {
                item.findElement(addButton).click();
            }
        }
    }

    public void goToCart() {
        driver.get("https://www.saucedemo.com/cart.html");
    }
}