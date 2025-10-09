package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartCounter () {

        // Находим и выводим счётчик товаров на странице корзины
        return driver.findElement(By.cssSelector("#basket-default-prod-count2")).getText().trim();
    }

    public WebElement getCartPrice () {

        // Находим и выводим общую стоимость товаров в корзине со скидкой
        return driver.findElement(By.cssSelector("#basket-default-sumprice-discount")).getText().trim();

    }
}
