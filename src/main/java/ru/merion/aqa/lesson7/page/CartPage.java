package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(css = "#basket-default-sumprice-discount")
    private WebElement productCounter;

    @FindBy(css = "#basket-default-prod-count2")
    private WebElement totalPrice;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartCounter () {

        // Находим и выводим счётчик товаров на странице корзины
        return productCounter.getText().trim();
    }

    public String getCartPrice () {

        // Находим и выводим общую стоимость товаров в корзине со скидкой
        return totalPrice.getText().trim();

    }
}
