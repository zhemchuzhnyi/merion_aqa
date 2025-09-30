package ru.merion.aqa.lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;
import ru.merion.aqa.lesson7.page.CartPage;
import ru.merion.aqa.lesson7.page.MainPage;
import ru.merion.aqa.lesson7.page.ResultPage;


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

        CartPage cartPage = new CartPage(driver);
        cartPage.open();
        cartPage.checkCartCounter();
        cartPage.checkCartPrice();

        // Закрываем браузер и завершаем сессию WebDriver
        driver.quit();
    }
}