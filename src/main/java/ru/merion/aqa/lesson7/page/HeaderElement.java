package ru.merion.aqa.lesson7.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderElement {
    private final WebDriver driver;

    @FindBy(css = "#searchform")
    private WebElement form;

    @FindBy(css = "#search-field")
    private WebElement seachField;

    @FindBy(css = ".j-cart-count")
    private WebElement cartIcon;


    public HeaderElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, HeaderElement.class);
    }

    public ResultPage searchFor (String term) {
        // Находим форму поиска на странице
        // Находим поле ввода поиска и вводим текст (например "Java")
        seachField.sendKeys(term);
        // Отправляем форму поиска
        form.submit();
        return new ResultPage(driver);
    }

    public String getIconText() {

        // Получаем и выводим количество товаров из счётчика на иконке корзины
        return cartIcon.getText();
    }

    public CartPage clickCartIcon() {
        // Кликаем по иконке корзины для перехода на страницу корзины
        cartIcon.click();
        return new CartPage(driver);
    }

}
