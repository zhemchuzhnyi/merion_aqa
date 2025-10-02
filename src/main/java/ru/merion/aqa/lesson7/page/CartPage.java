package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkCartCounter () {

        // Находим и выводим счётчик товаров на странице корзины
        String cartCounter = driver.findElement(By.cssSelector("#basket-default-prod-count2")).getText().trim();
        System.out.println("Счетчик товаров в корзине = " + cartCounter);
    }

    public void checkCartPrice () {

        // Находим и выводим общую стоимость товаров в корзине со скидкой
        String price = driver.findElement(By.cssSelector("#basket-default-sumprice-discount")).getText().trim();
        System.out.println("Цена = " + price);
    }
}
