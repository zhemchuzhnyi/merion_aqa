package ru.merion.aqa.practiceDZ3.Task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    private WebElement wait;

    @FindBy(css = ".inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(css = ".inventory_item")
    private WebElement itemName;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart (Set<String> itemNames) {
        List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item"));
        for (WebElement item : items) {
            String productName = item.findElement(By.cssSelector(".inventory_item_name")).getText();
            if (itemNames.contains(productName)) {
                item.findElement(By.cssSelector("button")).click();
            }
        }
    }
    public void goToCArt() {
        driver.get("https://www.saucedemo.com/cart.html");
    }
}
