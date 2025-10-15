package ru.merion.aqa.practiceDZ3.Task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Напишите скрипт для работы с интернет-магазином. Шаги
 *
 * Открыть сайт магазина https://www.saucedemo.com/
 * Авторизоваться под пользователем
 * standard_user
 * Добавить в корзину товары:
 * Sauce Labs Backpack
 * Sauce Labs Bolt T-Shirt
 * Sauce Labs Onesie
 * Перейти в корзину
 * Нажать Checkout
 * Заполнить форму данными:
 * Имя
 * Фамиля
 * Почтовый индекс
 * Нажать continue
 * Прочитать со стрницы итоговую стоимость (
 * Total
 *  )
 * Закрыть браузер
 * Вывести в консоль итоговую стоимость
 */

// TODO - переделать в PageObject

public class Task4 {
    public static void main(String[] args) {

        Set<String> itemNames = new HashSet<>();
        itemNames.add("Sauce Labs Backpack");
        itemNames.add("Sauce Labs Bolt T-Shirt");
        itemNames.add("Sauce Labs Onesie");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item"));
        for (WebElement item : items) {
            String productName = item.findElement(By.cssSelector(".inventory_item_name")).getText();
            if (itemNames.contains(productName)) {
                item.findElement(By.cssSelector("button")).click();
            }
        }

        driver.get("https://www.saucedemo.com/cart.html");
        driver.findElement(By.cssSelector("#checkout")).click();

        driver.findElement(By.cssSelector("#first-name")).sendKeys("Alex");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Smith");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("404546");

        driver.findElement(By.cssSelector("#continue")).click();
        String total = driver.findElement(By.cssSelector(".summary_total_label")).getText();

        driver.close();

        System.out.println("Итоговая стоимость: " + total);

    }
}
