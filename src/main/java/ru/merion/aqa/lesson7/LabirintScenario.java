package ru.merion.aqa.lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;

import java.time.Duration;
import java.util.List;


public class LabirintScenario {

    public static WebDriver driver;
    private static By cartIconLocator = (By.cssSelector(".j-cart-count"));

    public static void main(String[] args) {

        // Создаём экземпляр Chrome драйвера через фабрику
        WebDriver driver = WebDriverFactory.create("chrome");

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.searchFor("Java");

        ResultPage resultPage = new ResultPage(driver);
        resultPage.addAllItemsToCart();
        resultPage.checkIconText();

        openCart();
        checkCartCounter();
        checkCartPrice();

        // Закрываем браузер и завершаем сессию WebDriver
        driver.close();
    }

    public static void openCart() {

        // Кликаем по иконке корзины для перехода на страницу корзины
        driver.findElement(cartIconLocator).click();
    }
    public static void checkCartCounter () {

        // Находим и выводим счётчик товаров на странице корзины
        String cartCounter = driver.findElement(By.cssSelector("#basket-default-prod-count2")).getText().trim();
        System.out.println("Счетчик товаров в корзине = " + cartCounter);
    }

    public static void checkCartPrice () {

        // Находим и выводим общую стоимость товаров в корзине со скидкой
        String price = driver.findElement(By.cssSelector("#basket-default-sumprice-discount")).getText().trim();
        System.out.println("Цена = " + price);
    }
}