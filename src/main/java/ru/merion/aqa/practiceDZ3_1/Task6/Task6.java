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
        Set<String> itemNames = new HashSet<>();
        itemNames.add("Sauce Labs Backpack");
        itemNames.add("Sauce Labs Bolt T-Shirt");
        itemNames.add("Sauce Labs Onesie");

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        AuthPage auth = new AuthPage(driver).open();
        auth.loginAs("standart_user","secret_sauce");

        List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item"));

        for (WebElement item : items) {
            String productName =item.findElement(By.cssSelector(".inventory_item_name")).getText();
            if (itemNames.contains(productName)) {
                item.findElement(By.cssSelector("button")).click();
            }
        }

        driver.get("https://www.saucedemo.com/cart.html");
        driver.findElement(By.cssSelector("#checkout")).click();

        driver.findElement(By.cssSelector("#first-name")).sendKeys("Alex");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Smith");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("12345");

        driver.findElement(By.cssSelector("#continue")).click();

        String total = driver.findElement(By.cssSelector(".summary_total_label")).getText();
        driver.quit();

        System.out.println("Результат: " + total);




    }
}
