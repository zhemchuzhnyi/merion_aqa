package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderElement {
    private final WebDriver driver;

    private static By cartIconLocator = (By.cssSelector(".j-cart-count"));

    public HeaderElement(WebDriver driver) {
        this.driver = driver;
    }

    public ResultPage searchFor (String term) {
        // Находим форму поиска на странице
        WebElement form = driver.findElement(By.cssSelector("#searchform"));
        // Находим поле ввода поиска и вводим текст (например "Java")
        form.findElement(By.cssSelector("#search-field")).sendKeys(term);
        // Отправляем форму поиска
        form.submit();
        return new ResultPage(driver);
    }

    public String getIconText() {

        // Получаем и выводим количество товаров из счётчика на иконке корзины
        return driver.findElement(cartIconLocator).getText();
    }

    public CartPage clickCartIcon() {
        // Кликаем по иконке корзины для перехода на страницу корзины
        driver.findElement(cartIconLocator).click();
        return new CartPage(driver);
    }

}
